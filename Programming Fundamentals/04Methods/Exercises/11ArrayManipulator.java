package Methods.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scan.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "exchange":
                    int[] testArr  = exchangeArr(inputArr, Integer.parseInt(tokens[1]));
                    if (testArr == null) {
                        System.out.println("Invalid index");
                    } else {
                        inputArr = testArr;
                    }
                    break;
                case "max":
                    switch (tokens[1]) {
                        case "odd":
                            int oddIndex = maxOddIndex(inputArr);
                            if (oddIndex == -1) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(oddIndex);
                            }
                            break;
                        case "even":
                            int evenIndex = maxEvenIndex(inputArr);
                            if (evenIndex == -1) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(evenIndex);
                            }
                            break;
                    }
                    break;
                case "min":
                    switch (tokens[1]) {
                        case "odd":
                            int minOddIndex = minOddIndex(inputArr);
                            if (minOddIndex == -1) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(minOddIndex);
                            }
                            break;
                        case "even":
                            int minEvenIndex = minEvenIndex(inputArr);
                            if (minEvenIndex == -1) {
                                System.out.println("No matches");
                            } else {
                                System.out.println(minEvenIndex);
                            }
                            break;
                    }
                    break;
                case "first":
                    switch (tokens[2]){
                        case "odd":
                            firstOddElements(inputArr, Integer.parseInt(tokens[1]));
                            break;
                        case "even":
                            firstEvenElements(inputArr, Integer.parseInt(tokens[1]));
                            break;
                    }
                    break;
                case "last":
                    switch (tokens[2]){
                        case "odd":
                            lastOddElements(inputArr, Integer.parseInt(tokens[1]));
                            break;
                        case "even":
                            lastEvenElements(inputArr, Integer.parseInt(tokens[1]));
                            break;
                    }
                    break;
            }
            input = scan.nextLine();
        }

        System.out.print("[");
        for (int i = 0; i < inputArr.length; i++) {
            if (i != inputArr.length - 1) {
                System.out.print(inputArr[i] + ", ");
            } else {
                System.out.print(inputArr[i]);
            }
        }
        System.out.print("]");
    }

    public static void lastEvenElements(int[] arr, int count) {
        if (count >= 0 && count <= arr.length) {
            int[] EvenElements = new int[arr.length];
            int index = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] % 2 == 0) {
                    EvenElements[index] = arr[i];
                    index += 1;
                }
                if (index == count) {
                    System.out.print('[');
                    for (int j = index - 1; j >= 0; j--) {
                        if (j != 0) {
                            System.out.print(EvenElements[j] + ", ");
                        } else {
                            System.out.print(EvenElements[j]);
                        }

                    }
                    System.out.print(']');
                    System.out.println();
                    break;
                }
            }
            if (index < count) {
                System.out.print('[');
                for (int j = index - 1; j >= 0; j--) {
                    if (j != 0) {
                        System.out.print(EvenElements[j] + ", ");
                    } else {
                        System.out.print(EvenElements[j]);
                    }

                }
                System.out.print(']');
                System.out.println();
            } else if (index == 0){
                System.out.println("[]");
            }
        } else {
            System.out.println("Invalid count");
        }
    }

    public static void lastOddElements(int[] arr, int count) {
        if (count >= 0 && count <= arr.length) {
            int[] oddElements = new int[arr.length];
            int index = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] % 2 != 0) {
                    oddElements[index] = arr[i];
                    index += 1;
                }
                if (index == count) {
                    System.out.print('[');
                    for (int j = index - 1; j >= 0; j--) {
                        if (j != 0) {
                            System.out.print(oddElements[j] + ", ");
                        } else {
                            System.out.print(oddElements[j]);
                        }

                    }
                    System.out.print(']');
                    System.out.println();
                    break;
                }
            }
            if (index < count) {
                System.out.print('[');
                for (int j = index - 1; j >= 0; j--) {
                    if (j != 0) {
                        System.out.print(oddElements[j] + ", ");
                    } else {
                        System.out.print(oddElements[j]);
                    }

                }
                System.out.print(']');
                System.out.println();
            } else if (index == 0){
                System.out.println("[]");
            }
        } else {
            System.out.println("Invalid count");
        }
    }

    public static void firstEvenElements(int[] arr, int count) {
        if (count >= 0 && count <= arr.length) {
            int[] EvenElements = new int[arr.length];
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    EvenElements[index] = arr[i];
                    index += 1;
                }
                if (index == count) {
                    System.out.print('[');
                    for (int j = 0; j < index; j++) {
                        if (j != index - 1) {
                            System.out.print(EvenElements[j] + ", ");
                        } else {
                            System.out.print(EvenElements[j]);
                        }

                    }
                    System.out.print(']');
                    System.out.println();
                    break;
                }
            }
            if (index < count) {
                System.out.print('[');
                for (int j = 0; j < index; j++) {
                    if (j != index - 1) {
                        System.out.print(EvenElements[j] + ", ");
                    } else {
                        System.out.print(EvenElements[j]);
                    }

                }
                System.out.print(']');
                System.out.println();
            } else if (index == 0){
                System.out.println("[]");
            }
        } else {
            System.out.println("Invalid count");
        }
    }

    public static void firstOddElements(int[] arr, int count) {
        if (count >= 0 && count <= arr.length) {
            int[] oddElements = new int[arr.length];
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 != 0) {
                    oddElements[index] = arr[i];
                    index += 1;
                }
                if (index == count) {
                    System.out.print('[');
                    for (int j = 0; j < index; j++) {
                        if (j != index - 1) {
                            System.out.print(oddElements[j] + ", ");
                        } else {
                            System.out.print(oddElements[j]);
                        }

                    }
                    System.out.print(']');
                    System.out.println();
                    break;
                }
            }
            if (index < count) {
                System.out.print('[');
                for (int j = 0; j < index; j++) {
                    if (j != index - 1) {
                        System.out.print(oddElements[j] + ", ");
                    } else {
                        System.out.print(oddElements[j]);
                    }

                }
                System.out.print(']');
                System.out.println();
            } else if (index == 0){
                System.out.println("[]");
            }
        } else {
            System.out.println("Invalid count");
        }
    }

    public static int minEvenIndex(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] <= minValue) {
                    minValue = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    public static int minOddIndex(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                if (arr[i] <= minValue) {
                    minValue = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    public static int maxEvenIndex(int[] arr) {
        int maxEven = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] >= maxEven) {
                    maxEven = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }

    public static int maxOddIndex(int[] arr) {
        int maxOdd = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
              if (arr[i] >= maxOdd) {
                  maxOdd = arr[i];
                  index = i;
              }
            }
        }
        return index;
    }

    public static int[] exchangeArr(int[] arr, int index) {
        if (index >= 0 && index <= arr.length - 1) {
            int[] newArr = new int[arr.length];
            int count = 0;
            for (int i = index + 1; i < arr.length ; i++) {
                newArr[count] = arr[i];
                count += 1;
            }
            for (int i = 0; i <= index; i++) {
                newArr[count] = arr[i];
                count += 1;
            }
            return newArr;
        } else {
            return null;
        }
    }
}
