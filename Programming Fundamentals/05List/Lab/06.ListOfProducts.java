package Lists.Labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<String> productList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            productList.add(input);
        }

        Collections.sort(productList);

        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + "." + productList.get(i));
        }
    }
}
