package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<String> list = Arrays.stream(input.split(" ")).collect(Collectors.toList());

        input = scan.nextLine();
        while (!input.equals("3:1")) {
            String[] tokens = input.split(" ");
            String action = tokens[0];
            switch (action) {
                case "merge":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex <= list.size()) {
                        if (endIndex >= 0 && endIndex <= list.size()) {
                            StringBuilder concatenateValue = new StringBuilder();
                            for (int i = startIndex; i <= endIndex; i++) {
                                concatenateValue.append(list.get(startIndex));
                                list.remove(startIndex);
                            }
                            list.add(startIndex, concatenateValue.toString());
                        } else {
                            StringBuilder concatenateValue = new StringBuilder();
                            for (int i = startIndex; i < list.size(); i++) {
                                concatenateValue.append(list.get(i));
                            }
                            list.add(startIndex, concatenateValue.toString());
                            for (int i = list.size() - 1; i > startIndex; i--) {
                                list.remove(i);
                            }
                        }
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(tokens[1]);
                    int partitions = Integer.parseInt(tokens[2]);
                    String text = list.get(index);
                    list.remove(index);
                    int partSize = text.length() / partitions;
                    int begin = 0;

                    for (int part = 1; part < partitions; part++) {
                        list.add(index, text.substring(begin, begin + partSize));
                        index += 1;
                        begin += partSize;
                    }
                    list.add(index,text.substring(begin));
                    break;
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + " ");
            } else {
                System.out.print(list.get(i));
            }
        }
    }
}
