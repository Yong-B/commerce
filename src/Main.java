import domain.Product;
import service.CommerceSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Galaxy S25", 1200000L, "최신 안드로이드 스마트폰", 50));
        products.add(new Product("iPhone 16", 1350000L, "Apple의 최신 스마트폰", 30));
        products.add(new Product("MacBook Pro", 2400000L, "M3 칩셋이 탑재된 노트북", 15));
        products.add(new Product("AirPods Pro", 350000L, "노이즈 캔슬링 무선 이어폰", 50));

        CommerceSystem commerceSystem = new CommerceSystem(products);
        commerceSystem.start();
    }
}