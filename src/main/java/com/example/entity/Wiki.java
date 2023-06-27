package com.example.entity;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Wiki {
    private String name;
    private String url;
    public Wiki(String name, String url){
        this.name=name;
        this.url = url;
    }
}
