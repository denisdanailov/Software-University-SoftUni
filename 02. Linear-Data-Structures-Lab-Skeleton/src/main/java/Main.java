import implementations.ArrayList;
import implementations.Queue;
import implementations.Stack;

public class Main {
    public static void main(String[] args) {

//        ArrayList<String> list = new ArrayList<>();
//        list.add("Pesho");
//        list.add("Misho");
//        list.add("Gosho");
//        list.add("Joro");
//        list.add("Gena");
//
//        list.add(10, "Misha");

//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);
//        list2.add(4);
//        list2.add(5);
//
//        list2.remove(10);

//        Stack<String> stack = new Stack<>();
//
//        stack.push("Joro");
//        stack.push("Gena");
//        stack.push("Marko");
//
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();

        Queue<String> queue = new Queue<>();

        queue.offer("Sasho");
        queue.offer("Desi");
        queue.offer("Cvetomir");

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
    }
}
