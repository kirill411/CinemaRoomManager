package cinema;

class ScreenRoom {
    private static final int LOW_PRICE = 8;
    private static final int HIGH_PRICE = 10;

    private final Seat[][] seatsInRoom;
    private final int seatsTotal;

    private int purchasedTickets = 0;
    private int incomeTotal = 0;
    private int incomeCurrent = 0;

    ScreenRoom(int rows, int seats) {
        seatsTotal = rows * seats;
        this.seatsInRoom = new Seat[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if ((seatsTotal > 60) && (i >= rows / 2)) {
                    this.seatsInRoom[i][j] = new Seat(LOW_PRICE);
                    incomeTotal += LOW_PRICE;
                } else {
                    this.seatsInRoom[i][j] = new Seat(HIGH_PRICE);
                    incomeTotal += HIGH_PRICE;
                }
            }
        }
    }

    boolean seatBooking(int row, int seatNumber) {
        Seat seat;
        try {
            seat = seatsInRoom[row - 1][seatNumber - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong input!\n");
            return false;
        }

        if (seat.isAvailable()) {
            seat.setAvailable(false);
            printSeatPrice(row, seatNumber);
            purchasedTickets++;
            incomeCurrent += seat.getPrice();
        } else {
            System.out.println("\nThat ticket has already been purchased!\n");
            return false;
        }
        return true;
    }

    void printSeatPrice(int row, int seat) {
        System.out.println("\nTicket price: $" + seatsInRoom[row - 1][seat - 1].getPrice());
    }

    void printLayout() {
        System.out.print("\n" + "Cinema:" + "\n ");
        for (int i = 1; i <= seatsInRoom[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < seatsInRoom.length; i++) {
            for (int j = 0; j <= seatsInRoom[i].length; j++) {
                System.out.print(j == 0 ? i + 1 : " " + seatsInRoom[i][j - 1]);
            }
            System.out.println();
        }
        System.out.println();
    }

    void printStatistics() {
        float ticketPercentage = (float) purchasedTickets / seatsTotal * 100;
        System.out.println();
        System.out.printf("Number of purchased tickets: %d\n" +
                          "Percentage: %.2f%%\n" +
                          "Current income: $%d\n" +
                          "Total income: $%d\n"
                , purchasedTickets, ticketPercentage, incomeCurrent, incomeTotal);
    }
}
