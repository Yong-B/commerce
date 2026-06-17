package domain;

public class Product {
    
    // 객체 선언
    private String name;
    private long price;
    private String description;
    private int stock;

    // ========== Getter / Setter ==========
    public long getPrice() {
        return price;
    }
    
    public void setPrice(long price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    // 생성자
    public Product(String name, long price, String description, int stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    // 상품명을 고정 너비로 정렬하도록 포맷팅
    @Override
    public String toString() {
        return String.format("%-15s | %10s | %s",
                name,
                String.format("%,d원", price),
                description);
    }
}
