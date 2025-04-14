import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainBlockImplTest {
    private Chainblock chainBlock;
    private List<Transaction> transactions;

    @Before
    public void setUp() {
        this.chainBlock = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        prepareTransactions();
    }

    private void prepareTransactions() {

        Transaction transaction1 = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 10.20);
        Transaction transaction2 = new TransactionImpl(1, TransactionStatus.FAILED, "Misho", "Pesho", 55.25);
        Transaction transaction3 = new TransactionImpl(2, TransactionStatus.ABORTED, "Gosho", "Misho", 9.99);
        Transaction transaction4 = new TransactionImpl(3, TransactionStatus.UNAUTHORIZED, "Pesho", "Misho", 1.60);

        this.transactions.add(transaction1);
        this.transactions.add(transaction2);
        this.transactions.add(transaction3);
        this.transactions.add(transaction4);
    }

    private void fillChainBlockWithTransactions() {
        this.transactions.forEach(transaction -> this.chainBlock.add(transaction));
    }

    @Test
    public void testContainsTransactionReturnsTrue() {
        Transaction transaction = this.transactions.get(0);

        this.chainBlock.add(transaction);

        Assert.assertTrue(this.chainBlock.contains(transaction));
    }

    @Test
    public void testContainsTransactionReturnsFalse() {
        Transaction transaction = this.transactions.get(0);

        Assert.assertFalse(this.chainBlock.contains(transaction));
    }

    @Test
    public void testContainsIdReturnsTrue() {
        Transaction transaction = this.transactions.get(0);

        this.chainBlock.add(transaction);

        Assert.assertTrue(this.chainBlock.contains(0));
    }

    @Test
    public void testContainsIdReturnsFalse() {
        Assert.assertFalse(this.chainBlock.contains(-1));
    }

    @Test
    public void testAddCorrectly() {
        this.chainBlock.add(this.transactions.get(0));

        Assert.assertEquals(1, this.chainBlock.getCount());

        this.chainBlock.add(this.transactions.get(1));

        Assert.assertEquals(2, this.chainBlock.getCount());
    }

    @Test
    public void testAddFaulty() {
        this.chainBlock.add(this.transactions.get(0));

        Assert.assertEquals(1, this.chainBlock.getCount());

        this.chainBlock.add(this.transactions.get(0));

        Assert.assertEquals(1, this.chainBlock.getCount());
    }

    @Test
    public void testChangeTransactionStatusReturnsCorrectly() {
        Transaction transaction = this.transactions.get(0);

        this.chainBlock.add(transaction);

        this.chainBlock.changeTransactionStatus(transaction.getId(), TransactionStatus.FAILED);

        Assert.assertEquals(TransactionStatus.FAILED, this.chainBlock.getById(transaction.getId()).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrows() {
        this.chainBlock.changeTransactionStatus(100, TransactionStatus.FAILED);
    }

    @Test
    public void testGetByIdReturnsCorrectly() {
        fillChainBlockWithTransactions();

        Transaction actual = this.chainBlock.getById(0);

        Assert.assertEquals(0, actual.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdThrows() {
        this.chainBlock.getById(100);
    }

    @Test
    public void testRemoveTransactionByIdRemovesCorrectly() {
        fillChainBlockWithTransactions();

        this.chainBlock.removeTransactionById(0);

        Assert.assertFalse(this.chainBlock.contains(0));
        Assert.assertEquals(3, this.chainBlock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrows() {
        fillChainBlockWithTransactions();
        this.chainBlock.removeTransactionById(100);
    }

    @Test
    public void testGetByTransactionStatusReturnsCorrectly() {
        fillChainBlockWithTransactions();

        List<Transaction> expected = this.transactions
                .stream()
                .filter(transaction -> transaction.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = this.chainBlock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        List<Transaction> actual = new ArrayList<>();

        for (Transaction transaction : iterable) {
            actual.add(transaction);
        }

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusThrows() {
        this.chainBlock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetAllInAmountRangeCorrectly() {
        fillChainBlockWithTransactions();

        double low = 9.99;
        double high = 60;

        List<Transaction> expected = this.transactions
                .stream()
                .filter(transaction -> transaction.getAmount() >= low && transaction.getAmount() <= high)
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = this.chainBlock.getAllInAmountRange(low, high);

        List<Transaction> actual = new ArrayList<>();

        iterable.forEach(actual::add);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllInAmountRangeNoMatch() {
        fillChainBlockWithTransactions();

        double low = 0;
        double high = 1;

        Iterable<Transaction> iterable = this.chainBlock.getAllInAmountRange(low, high);

        List<Transaction> actual = new ArrayList<>();

        iterable.forEach(actual::add);

        Assert.assertEquals(0, actual.size());
    }
}
