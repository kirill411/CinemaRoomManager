package cinema;

class Seat {
    private boolean available = true;

    boolean isAvailable() {
        return available;
    }

    void setAvailable(boolean available) {
        this.available = available;
    }

    private int price;

    int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

    Seat(int price) {
        this.price = price;

    }

    @Override
    public String toString() {
        return available ? "S" : "B";
    }
}
