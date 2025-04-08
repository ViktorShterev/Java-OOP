import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private ProductStock stock;

    @Before
    public void setUp() {
        this.stock = new Instock();
    }

    @Test
    public void testContainsReturnFalseWhenAbsentAndThenTrueWhenAddedCorrectly() {

        Product product = new Product("test", 9.99, 1);

        assertFalse(stock.contains(product));

        stock.add(product);
        assertTrue(stock.contains(product));
    }

    @Test
    public void testCountReturnZeroWhenEmptyAndNonZeroWhenProductsAreAdded() {

        assertEquals(0, this.stock.getCount());

        createAndAddProducts(this.stock);

        assertEquals(4, this.stock.getCount());
    }

    @Test
    public void testFindReturnCorrectElement() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        int index = addedProducts.length - 2;

        assertEquals(addedProducts[index].getLabel(), this.stock.find(index).getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindFailWhenIndexIsGreater() {
        int greaterIndex = createAndAddProducts(this.stock).length;
        this.stock.find(greaterIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindFailWhenIndexIsNegative() {
        createAndAddProducts(this.stock);
        this.stock.find(-1);
    }

    @Test
    public void testChangeQuantityUpdateCorrectly() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        Product product = addedProducts[1];

        int newQuantity = product.getQuantity() + 10;

        this.stock.changeQuantity(product.getLabel(), newQuantity);

        assertEquals(newQuantity, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityFailsWhenNoSuchProduct() {
        createAndAddProducts(this.stock);

        Product notAddedProduct = new Product("not_added", 9.99, 1);

        this.stock.changeQuantity(notAddedProduct.getLabel(), notAddedProduct.getQuantity() + 10);
    }

    @Test
    public void testFindByLabelReturnCorrectProduct() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        String expected = addedProducts[2].getLabel();

        Product product = this.stock.findByLabel(expected);
        assertNotNull(product);

        String actual = product.getLabel();

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelFailWhenNoSuchProduct() {
        createAndAddProducts(this.stock);

        Product notAddedProduct = new Product("not_added", 9.99, 1);

        this.stock.findByLabel(notAddedProduct.getLabel());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnCorrectCount() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        this.stock.add(new Product("not_returned", 5.55, 5));

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(addedProducts.length);

        int count = assertAndExtract(iterable, p -> p).size();

        assertEquals(addedProducts.length, count);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnInCorrectOrder() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(addedProducts.length);

        List<String> actualProducts = assertAndExtract(iterable, Product::getLabel);

        List<String> expectedProducts = Arrays.stream(addedProducts)
                        .map(Product::getLabel)
                        .sorted()
                        .collect(Collectors.toList());

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnEmptyCollectionWhenOutOfRange() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(addedProducts.length + 1);

        List<Product> actualProducts = assertAndExtract(iterable);

        assertTrue(actualProducts.isEmpty());
    }

    @Test
    public void testFindAllInRangeReturnCorrectRange() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        Double low = addedProducts[0].getPrice();
        Double high = addedProducts[3].getPrice();

        Iterable<Product> iterable = this.stock.findAllInRange(low, high);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        assertEquals(1, returnedPrices.size());
        assertEquals(high, returnedPrices.get(0));
    }

    @Test
    public void testFindAllInRangeReturnCorrectRangeAndInCorrectOrder() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        Double low = addedProducts[1].getPrice();
        Double high = addedProducts[2].getPrice();

        Iterable<Product> iterable = this.stock.findAllInRange(low, high);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        List<Double> expected = Arrays.stream(addedProducts)
                .map(Product::getPrice)
                .filter(p -> p > low && p <= high)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertEquals(expected, returnedPrices);
    }

    @Test
    public void testFindAllInRangeReturnEmptyCollectionWhenNoMatch() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        double low = -10;
        double high = -5;

        Iterable<Product> iterable = this.stock.findAllInRange(low, high);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        assertTrue(returnedPrices.isEmpty());
    }

    @Test
    public void testFindAllByPriceReturnCorrectElements() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        double price = addedProducts[1].getPrice();

        Iterable<Product> iterable = this.stock.findAllByPrice(price);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        List<Double> expected = Arrays.stream(addedProducts)
                .map(Product::getPrice)
                .filter(p -> p == price)
                .collect(Collectors.toList());

        assertEquals(expected.size(), returnedPrices.size());

        assertEquals(price, returnedPrices.get(0), 0.00);
    }

    @Test
    public void testFindAllByPriceReturnEmptyCollectionWhenNoMatch() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        double price = -10;

        Iterable<Product> iterable = this.stock.findAllByPrice(price);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        assertTrue(returnedPrices.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsReturnFirstThree() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        int count = 3;

        Iterable<Product> iterable = this.stock.findFirstMostExpensiveProducts(count);

        List<Double> actualProducts = assertAndExtract(iterable, Product::getPrice);

        List<Double> expectedProducts = Arrays.stream(addedProducts)
                .map(Product::getPrice)
                .sorted(Comparator.reverseOrder())
                .limit(count)
                .collect(Collectors.toList());

        assertEquals(expectedProducts, actualProducts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsFailsWhenLessProductsInStock() {
        int count = 10;

        Iterable<Product> iterable = this.stock.findFirstMostExpensiveProducts(count);
    }

    @Test
    public void testFindAllByQuantityReturnsCorrectly() {
        createAndAddProducts(this.stock);

        Iterable<Product> iterable = this.stock.findAllByQuantity(1);

        List<Integer> actualProducts = assertAndExtract(iterable, Product::getQuantity);

        assertTrue(actualProducts.stream().allMatch(q -> q == 1));
    }

    @Test
    public void testFindAllByQuantityReturnsEmptyCollectionWhenNoMatch() {
        createAndAddProducts(this.stock);
        Iterable<Product> iterable = this.stock.findAllByQuantity(10);

        List<Integer> actualProducts = assertAndExtract(iterable, Product::getQuantity);

        assertTrue(actualProducts.isEmpty());
    }

    @Test
    public void testGetIteratorReturnsAllProducts() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        Iterator<Product> iterator = this.stock.iterator();
        assertNotNull(iterator);

        List<Product> actualProducts = new ArrayList<>();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            actualProducts.add(product);
        }

        List<Product> expectedProducts = Arrays.asList(addedProducts);

        assertEquals(expectedProducts, actualProducts);
    }




    private static Product[] createAndAddProducts(ProductStock stock) {
        Product[] products = createProducts();

        for (Product product : products) {
            stock.add(product);
        }

        return products;
    }

    private static Product[] createProducts() {
        return new Product[]{
                new Product("test2", 10.00, 1),
                new Product("test1", 9.99, 3),
                new Product("test4", 9.99, 5),
                new Product("test3", 50.00, 1)
        };
    }

    private static List<Product> assertAndExtract(Iterable<Product> iterable) {
        return assertAndExtract(iterable, p -> p);
    }

    private static <T> List<T> assertAndExtract(Iterable<Product> iterable, Function<Product, T> mapper) {
        assertNotNull(iterable);

        List<T> result = new ArrayList<>();

        for (Product product : iterable) {
            result.add(mapper.apply(product));
        }

        return result;
    }


}