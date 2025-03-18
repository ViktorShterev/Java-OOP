package InterfacesAndAbstraction.Exercise.collectionHierarchy;

public class MyListImpl extends Collection implements MyList {


    @Override
    public int getUsed() {
        return super.getItems().size();
    }

    @Override
    public String remove() {
        return super.getItems().remove(0);
    }

    @Override
    public int add(String item) {
        super.getItems().add(0, item);
        return 0;
    }
}
