package InterfacesAndAbstraction.Exercise.collectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {


    @Override
    public String remove() {
        int lastIndex = super.getItems().size();
        return super.getItems().remove(lastIndex - 1);
    }

    @Override
    public int add(String item) {
        super.getItems().add(0, item);
        return 0;
    }
}
