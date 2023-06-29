package com.example.neo4jdemo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Word {
    private String word;
    public Word(String word) {
        this.word = word;
    }
}
