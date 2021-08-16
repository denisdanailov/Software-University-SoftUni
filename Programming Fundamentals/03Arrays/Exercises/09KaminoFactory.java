package Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();

        int [] bestDna = new int[n];
        int longestSubsequence = 0;
        int sampleCount = 0;
        int betterSum = 0;
        int leftMostIndex = 0;
        int winnerSample = 0;

        while (!input.equals("Clone them!")) {
            sampleCount += 1;

            int [] dna = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt).limit(n).toArray();

            int count = 0; int longestCount = 0; int firstIndex = 0; int sum = 0;
            for (int i = 0; i < dna.length ; i++) {
                sum += dna[i];

                if (dna[i] == 1) {
                    count += 1;
                } else if(dna[i] == 0) {
                    count = 0;
                }

                if (count > longestCount) {
                    longestCount = count;
                    firstIndex = i - count + 1;
                }
            }

            if ((longestCount > longestSubsequence)
                    ||(longestCount == longestSubsequence && firstIndex < leftMostIndex)
                    ||(firstIndex == leftMostIndex && sum > betterSum)) {
                longestSubsequence = longestCount;
                bestDna = dna;
                winnerSample = sampleCount;
                betterSum = sum;
                leftMostIndex = firstIndex;
            }
            input = scan.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", winnerSample, betterSum);
        Arrays.stream(bestDna).forEach(a -> System.out.print(a + " "));

    }
}
