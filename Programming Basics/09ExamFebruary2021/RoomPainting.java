package ExamFebruary2021;

import java.util.Scanner;

public class RoomPainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int paintBoxes = Integer.parseInt(scan.nextLine());
        int wallpapers = Integer.parseInt(scan.nextLine());
        double priceGloves = Double.parseDouble(scan.nextLine());
        double priceBrushes = Double.parseDouble(scan.nextLine());

        double pricePaintBoxes = paintBoxes * 21.50;
        double priceWallpapers = wallpapers * 5.20;
        double gloves = Math.ceil(wallpapers * 0.35);
        priceGloves *= gloves;
        double brushes = Math.floor(paintBoxes * 0.48);
        priceBrushes *= brushes;

        double totalPrice = pricePaintBoxes + priceWallpapers + priceGloves + priceBrushes;

        double delivery = totalPrice / 15;

        System.out.printf("This delivery will cost %.2f lv.", delivery);
    }
}
