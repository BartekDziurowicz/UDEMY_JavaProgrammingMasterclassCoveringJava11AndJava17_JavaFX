package com.example.javafx.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TodoItem {

    private String shortDescription;
    private String details;
    private LocalDate deadLine;

    @Override
    public String toString() {
        return shortDescription;
    }

}