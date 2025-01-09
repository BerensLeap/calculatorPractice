package com.example.calculator;

import com.example.calculator.operation.AbstractOperation;

import java.util.ArrayDeque;
import java.util.Queue;

public class CalculatorV2 {

    private int num1;
    private int num2;
    private OperatorType type;
    private Queue<String> records;

    public CalculatorV2() {
        // 계산 기록을 저장할 Queue 초기화
         this.records = new ArrayDeque<>(); // ArrayList, LinkedList, ArrayDeque 비교
    }

    public void calculate(int num1, int num2, OperatorType type) {

        AbstractOperation operation = type.getOperation(); // Enum에서 연산자 읽고 연산 개별 클래스 매핑, 이 부분 자연스러운가?

        double result = operation.operate(num1, num2); // 연산

        String resultRecord = String.valueOf(result);
        records.add(resultRecord);

        System.out.println("계산 완료, 결과값이 저장되었습니다.");
        System.out.println();
    }

    public void getRecords() {
        if (!records.isEmpty()) {
            int size = records.size();
            int count = 0;

            for (String record : records) {
                count++;
                System.out.print(record);
                if (count < size) { //마지막 기록이 아니면 쉼표
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("저장된 연산 결과값이 없습니다.");
        }
    }

    public void setRecords(int index, String newRecord) {

    }

    public void removeResult() {
        if (!records.isEmpty()) {
            String removedValue = records.poll();
            System.out.println("가장 오래된 결과값을 삭제했습니다, 삭제된 값: " + "[" + removedValue + "]");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
    }
}
