package service;

import domain.Cart;
import domain.Category;
import domain.Product;
import util.InputHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    //필드 선언
    private final List<Category> categories;
    private final List<Cart> carts = new ArrayList<>();

    //생성자
    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    // start 함수
    public void start() {
        try (Scanner scanner = new Scanner(System.in)){ // 특강에서 배운 try-with-resources
            while (true) {
                printCategory();
                int max = carts.isEmpty() ? categories.size() : 5;
                int input = InputHandle.inputNum(scanner, 0, max);
           
                // 0이면 종료
                if (input == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                } else if (input == 4 && !carts.isEmpty()) {
                    printCart();
                } else if (input == 5 && !carts.isEmpty()) {
                    carts.clear();
                    System.out.println("주문이 취소되었습니다.");
                }else {  
                    enterCategory(scanner, input);}
            }
        }
    }

    private void printCategory() {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName());
        }
        System.out.println("0. 종료 | 프로그램 종료");

        if (!carts.isEmpty()) {
            System.out.println("\n[ 주문 관리 ]");
            System.out.println("4. 장바구니 확인    | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. 주문 취소       | 진행중인 주문을 취소합니다.");
        }
    }

    private void enterCategory(Scanner scanner, int input) {
        // 카테고리 찾기
        Category selected = categories.get(input - 1);
        printProducts(selected);

        int productInput = InputHandle.inputNum(scanner, 0, selected.getProducts().size());

        if (productInput == 0) {
            return;
        }
        Product product = selected.getProducts().get(productInput - 1);
        printSelectedProduct(product);
        
        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        
        int cartInput = InputHandle.inputNum(scanner, 1, 2);

        if (cartInput == 1) {
            addToCart(product); // ← 여기서 호출
        } else {
            System.out.println("취소되었습니다.");
        }
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
    private void printSelectedProduct(Product product) {
        System.out.println("선택한 상품: " + product.getName() + " | "
                + String.format("%,d원", product.getPrice()) + " | "
                + product.getDescription() + " | 재고: "
                + product.getStock() + "개");
    }

    private void addToCart(Product product) {
        if (product.getStock() <= 0) {
            System.out.println("재고가 부족하여 장바구니에 담을 수 없습니다.");
            return;
        }

        for (Cart cart : carts) {
            if (cart.getName().equals(product.getName())) {
                
                if (cart.getQuantity() + 1 > product.getStock()) {
                    System.out.println("재고가 부족합니다.");
                    return;
                }
                
                cart.addQuantity(1);
                return; 
            }
        }
        
        carts.add(new Cart(product.getName(), 1, product.getPrice()));
        System.out.println(product.getName() + "이 장바구니에 추가되었습니다.");
    }

    private void printCart() {
        
        System.out.println("[ 장바구니 내역 ]");
        for (Cart cart : carts) {
            System.out.println(cart.getName() + "|"  + String.format("%,d원", cart.getPrice()) + " | " + "수량: " + cart.getQuantity() + "개");
        }
        
        System.out.println("[ 총 주문 금액 ]");
        long totalPrice = 0;
        for (Cart cart : carts) {
            totalPrice += cart.getPrice() * cart.getQuantity();
        }
        System.out.println(String.format("%,d원", totalPrice));
    }
}
