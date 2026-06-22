package domain;

import java.util.List;

public class Category {
    
    // 카테고리 이름
    private final String categoryName;

    // 해당 카테고리에 속한 상품 목록
    private final List<Product> products;
    
    // 생성자
    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    // Getter
    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }
}
