package com.dimastik.server.exception;

public class TaskNotFound extends RuntimeException {

    public TaskNotFound(String message) {
        super(message);
    }
}
