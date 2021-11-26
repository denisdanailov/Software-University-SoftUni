package interfacesAndAbstraction.exercises.collectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{

    @Override
    public String remove() {
        int indexLastItem = super.getItems().size() - 1;
        return super.getItems().remove(indexLastItem);
    }

    @Override
    public int add(String element) {
        super.getItems().add(0, element);
        return 0;
    }
}
