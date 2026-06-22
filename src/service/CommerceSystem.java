package service;

import domain.Category;
import domain.Product;
import util.InputHandle;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    //필드 선언
    private final List<Category> categories;

    //생성자
    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    // 생성자 - Main에서 products 넘겨받아 초기화
    
    // start 함수
    public void start() {
        try (Scanner scanner = new Scanner(System.in)){ // 특강에서 배운 try-with-resources
            while (true) {
                printCategory();
                int input = InputHandle.inputNum(scanner, 0, categories.size());
           
                // 0이면 종료
                if (input == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                }

                enterCategory(scanner, input);
            }
        }
    }

    private void printCategory() {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
        System.out.println("0. 종료 | 프로그램 종료");
    }

    private void enterCategory(Scanner scanner, int input) {
        // 카테고리 찾기
        Category selected = categories.get(input - 1);
        printProducts(selected);

        int productInput = InputHandle.inputNum(scanner, 0, selected.getProducts().size());

        if (productInput == 0) {
            return;
        }

        printSelectedProduct(selected, productInput);
        // 카테고리 반복
    }
    private void printProducts(Category category) {
        System.out.println("[ " + category.getCategoryName() + " 카테고리 ]");
        List<Product> products = category.getProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.println("0. 뒤로가기");
    }

    // 선택한 상품 출력만 담당
    private void printSelectedProduct(Category category, int productInput) {
        Product selected = category.getProducts().get(productInput - 1);
        System.out.println("선택한 상품: " + selected.getName() + " | "
                + String.format("%,d원", selected.getPrice()) + " | "
                + selected.getDescription() + " | 재고: "
                + selected.getStock() + "개");
    }
}
