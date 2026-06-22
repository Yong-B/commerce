import domain.Category;
import domain.Product;
import service.CommerceSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        List<Product> electronicsProducts = new ArrayList<>();
        electronicsProducts.add(new Product("Galaxy S24", 1200000L, "최신 안드로이드 스마트폰", 50));
        electronicsProducts.add(new Product("iPhone 15", 1350000L, "Apple의 최신 스마트폰", 30));
        electronicsProducts.add(new Product("MacBook Pro", 2400000L, "M3 칩셋이 탑재된 노트북", 15));
        electronicsProducts.add(new Product("AirPods Pro", 350000L, "노이즈 캔슬링 무선 이어폰", 50));

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("전자제품", electronicsProducts));
        categories.add(new Category("의류", new ArrayList<>()));
        categories.add(new Category("식품", new ArrayList<>()));

        // CommerceSystem 내 시작하는 함수 호출
        CommerceSystem system = new CommerceSystem(categories);
        system.start();
    }
}