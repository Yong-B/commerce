package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandle {
    public static int inputNum(Scanner scanner, int min, int max) {
        while (true) {
            try {
                System.out.print("번호를 입력해주세요: ");
                int input = scanner.nextInt();

                if (input < min || input > max) {
                    System.out.println("올바른 번호를 입력해주세요. (" + min + "~" + max + ")");
                    continue;
                }
                return input;

            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                scanner.next(); // 버퍼 비우기
            }
        }
    }
}
