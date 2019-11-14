package com.nareshak.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Developer {
    private String name;
    private int age;
    private List<String> languages;

}
