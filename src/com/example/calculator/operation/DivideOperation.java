package com.example.calculator.operation;

public class DivideOperation extends AbstractOperation {
    @Override
    public double operate(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return (double) num1 / num2;
    }
}
