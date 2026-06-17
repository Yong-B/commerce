import domain.Product;

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

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 상품 목록 출력
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
            System.out.println("0. 종료 | 프로그램 종료");

            // 입력받기
            int input = scanner.nextInt();

            // 0이면 종료
            if (input == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
        }
    }
}