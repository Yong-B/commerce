package service;

import domain.Product;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    //필드 선언
    private final List<Product> products;

    // 생성자 - Main에서 products 넘겨받아 초기화
    public CommerceSystem(List<Product> products) {
        this.products = products;
    }
    
    // start 함수
    public void start() {
        try (Scanner scanner = new Scanner(System.in)){ // 특강에서 배운 try-with-resources
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
}
