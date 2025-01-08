package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("계산기 전원On, 종료하려면 'exit'를 입력하세요.");

            System.out.print("첫번째 숫자를 입력하세요: ");
            if (sc.hasNext("exit")) {
                System.out.println("계산 종료");
                break;
            }

            int num1 = sc.nextInt();
            System.out.print("두번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            if (operator == '/') {
                while (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다. 두번째 숫자를 다시 입력해주세요: ");
                    num2 = sc.nextInt();
                }
                double result = num1 / num2;
                System.out.println("계산 결과: " + result);
            } else {
                int result = 0;
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        while (num2 == 0) {
                            System.out.println("0으로 나눌 수 없습니다. 두번째 숫자를 다시 입력해주세요: ");
                            num2 = sc.nextInt();
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("올바른 연산 기호가 아닙니다.");
                        return;
                }

                System.out.println("계산 결과: " + result);
            }
        }

        sc.close();
    }
}
