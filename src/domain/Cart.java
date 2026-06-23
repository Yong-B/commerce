package domain;

public class Cart {

    private final String name;
    private int quantity;
    private final long price;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getPrice() {
        return price;
    }

    public Cart(String name, int quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // 수량 증가
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    // 수량 감소
    public void subtractQuantity(int quantity) {
        if (this.quantity - quantity < 0) {
            throw new IllegalArgumentException("수량은 0보다 작을 수 없습니다.");
        }
        this.quantity -= quantity;
    }
}
