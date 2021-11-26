package interfacesAndAbstraction.exercises.collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int removeOps = Integer.parseInt(scan.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListImpl = new MyListImpl();

        iterateArrayAndFillCollection(input, addCollection);
        iterateArrayAndFillCollection(input, addRemoveCollection);
        iterateArrayAndFillCollection(input, myListImpl);

        removeFromCollection(removeOps, addRemoveCollection);
        removeFromCollection(removeOps, myListImpl);
    }

    private static void removeFromCollection(int removeOps, AddRemovable collection) {
        for (int i = 0; i < removeOps; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void iterateArrayAndFillCollection(String[] input, Addable collection) {
        for (String element : input) {
            System.out.print(collection.add(element) + " ");
        }
        System.out.println();
    }
}
