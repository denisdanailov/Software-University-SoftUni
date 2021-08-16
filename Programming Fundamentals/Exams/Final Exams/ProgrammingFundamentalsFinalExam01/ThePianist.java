package Exams.FinalExams.ProgrammingFundamentalsFinalExam01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static class Piece {
        String name;
        String composer;
        String key;
        public Piece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Piece> pieceMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\|");
            String pieceName = tokens[0];
            if (!pieceMap.containsKey (tokens[0])) {
                Piece newPiece = new Piece(pieceName, tokens[1], tokens[2]);
                pieceMap.put(pieceName, newPiece);
            }
        }

        String input = scan.nextLine();
        while (!input.equals("Stop")) {
            String[] tokens = input.split("\\|");
            String action = tokens[0];
            String piece = tokens[1];
            switch (action) {
                case "Add":
                    if (!pieceMap.containsKey (piece)) {
                        Piece newPiece = new Piece(piece, tokens[2], tokens[3]);
                        pieceMap.put(piece, newPiece);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, tokens[2], tokens[3]);
                    } else {
                        System.out.printf("%s is already in the collection!%n", piece);
                    }
                    break;
                case "Remove":
                    if (pieceMap.containsKey (piece)) {
                        pieceMap.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    if (pieceMap.containsKey (piece)) {
                        pieceMap.get(piece).key = tokens[2];
                        System.out.printf("Changed the key of %s to %s!%n", piece, tokens[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        pieceMap.entrySet().stream()
                .sorted((a,b) -> {
                    if (a.getValue().name.compareTo(b.getValue().name) == 0) {
                        return a.getValue().composer.compareTo(b.getValue().composer);
                    }
                    return a.getValue().name.compareTo(b.getValue().name);
                })
                .forEach(entrySet -> System.out.printf("%s -> Composer: %s, Key: %s%n",entrySet.getValue().name, entrySet.getValue().composer, entrySet.getValue().key));
    }
}
