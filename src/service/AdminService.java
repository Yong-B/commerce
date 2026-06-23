package service;

import domain.Category;
import util.InputHandle;

import java.util.List;
import java.util.Scanner;

public class AdminService {

    // 비밀번호 상수
    private static final String PASSWORD = "admin123";

    // 카테고리 목록
    private final List<Category> categories;

    // 생성자
    public AdminService(List<Category> categories) {
        this.categories = categories;
    }

    // 관리자 모드 시작 (인증 포함)
    public void startAdmin() {
        Scanner adminScanner = new Scanner(System.in);
        
        int total = 0;
        while (total < 3){
            System.out.println("관리자 비밀번호를 입력해주세요: ");
            String password = adminScanner.next();

            if (password.equals(PASSWORD)) {
                runAdminMenu(adminScanner);
                return;
            } else {
                total++; // 틀렸으니 실패 횟수 증가
                System.out.printf("비밀번호가 틀렸습니다. (%d/3회 실패)\n", total);
            }
        }
        System.out.println("3회 실패했습니다. 메인으로 돌아갑니다.");
    }

    // 관리자 메뉴 출력
    private void printAdminMenu() {
        System.out.println("[ 관리자 모드 ]");
        System.out.println("1. 상품 추가");
        System.out.println("2. 상품 수정");
        System.out.println("3. 상품 삭제");
        System.out.println("4. 전체 상품 현황");
        System.out.println("0. 메인으로 돌아가기");
    }

    private void runAdminMenu(Scanner scanner) {
        while (true) {
            printAdminMenu();
            int input = InputHandle.inputNum(scanner, 0, 4);

            if (input == 0) {
                System.out.println("메인으로 돌아갑니다.");
                return;
            } else if (input == 1) {
                addProduct(scanner);
            } else if (input == 2) {
                updateProduct(scanner);
            } else if (input == 3) {
                deleteProduct(scanner);
            } else if (input == 4) {
                printAllProducts();
            }
        }
    }

    private void addProduct(Scanner scanner) { }
    private void updateProduct(Scanner scanner) { }
    private void deleteProduct(Scanner scanner) { }
    private void printAllProducts() { }
}
