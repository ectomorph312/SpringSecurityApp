package org.example.spring_security_app.entity;

public enum TodoStatus {
    NEW("Новый"),
    PERFORMANCE("На исполнении"),
    DONE("Готово");

    private final String status;

    TodoStatus(String s) {
        status = s;
    }

    public  String getStatus() {
        return status;
    }
}
