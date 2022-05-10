package com.springdb.demo.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderStatus {

    NEW("New"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private final String name;

}
