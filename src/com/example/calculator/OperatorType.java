package com.example.calculator;

import com.example.calculator.operation.*;

import java.util.Arrays;

public enum OperatorType {
    ADD("+", new AddOperation()),
    SUBTRACT("-",new SubtractOperation()),
    MULTIPLY("*",new MultiplyOperation()),
    DIVIDE("/", new DivideOperation());

    private final String type;
    private final AbstractOperation operation;

    OperatorType(String type, AbstractOperation operation) {
        this.type = type;
        this.operation = operation;
    }

    public String getType() {
        return type;
    }

    public AbstractOperation getOperation() {
        return operation;
    }

    public static OperatorType findType(String type) {
        return Arrays.stream(values()) // 열거형의 모든 값(ADD, SUBTRACT, MULTIPLY, DIVIDE)
                .filter(enumValue -> enumValue.getType().equals(type)) // 이중 type과 같은 값
                .findFirst() // 조건에 맞는 첫 번째 값
                .orElse(null); // 없으면 null 반환
    }
}
