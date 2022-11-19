package ru.geekbrains.autumnmarket.exeption;

import java.util.List;

public class DataValidationExeption extends RuntimeException {
    private List<String> messages;

    public List<String> getMessages() {
        return messages;
    }

    public DataValidationExeption(List<String> messages) {
        this.messages = messages;
    }
}
