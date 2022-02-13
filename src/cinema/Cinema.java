package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        ScreenRoom screenRoom = new ScreenRoom(rows, seats);

        while(true) {
            printMenu();
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 0 :
                    scanner.close();
                    return;
                case 1 :
                    screenRoom.printLayout();
                    break;
                case 2 :
                    boolean valid;
                    do {
                        System.out.println("Enter a row number:");
                        int row = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seat = scanner.nextInt();
                        valid = screenRoom.seatBooking(row, seat);
                    } while (!valid);
                    break;
                case 3 :
                    screenRoom.printStatistics();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Show the seats\n" +
                           "2. Buy a ticket\n" +
                           "3. Statistics\n" +
                           "0. Exit");
    }
}