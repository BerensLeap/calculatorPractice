package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CalculatorV2 calculator = new CalculatorV2();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("계산기 실행 중, 종료하려면 'exit'를 입력하세요.");
            System.out.println();


            //첫번째 숫자 입력
            int num1 = 0;
            while (true) {
                System.out.print("첫번째 숫자를 입력하세요: ");
                if (sc.hasNext("exit")) {
                    System.out.println("계산 종료");
                    sc.close();
                    return;
                } else if (sc.hasNextInt()) {
                    num1 = sc.nextInt();
                    break;
                } else {
                    System.out.println("잘못된 입력입니다, 숫자를 입력해주세요.");
                    sc.next();
                }
            }
            System.out.println();

            //두번째 숫자 입력

            int num2 = 0;
            while (true) {
                System.out.print("두번째 숫자를 입력하세요: ");
               if (sc.hasNextInt()) {
                    num2 = sc.nextInt();
                    break;
                } else {
                    System.out.println("잘못된 입력입니다, 숫자를 입력해주세요.");
                    sc.next();
                }
            }
            System.out.println();


            //연산 기호 입력
            OperatorType type = null;
            while (type == null) {
                System.out.print("연산 기호를 입력하세요 (+,-,*,/): ");
                String operator = sc.next();    // sc.next(); : 잘못된 입력 소비
                type = OperatorType.findType(operator);

                if (type == null) {
                    System.out.println("잘못된 연산 기호입니다, 다시 입력해주세요.");
                }
            }
            System.out.println();


            // 계산
            try {
                calculator.calculate(num1, num2, type);
            } catch (ArithmeticException e) {  // 두번째 숫자값이 0일때 예외 처리
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }


            // 기록 출력
            System.out.print("계산 기록: ");
            calculator.getRecords();
            System.out.println();
        }
    }
}
