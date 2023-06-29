package com.example.neo4jdemo.relationship;

import com.example.neo4jdemo.entity.Wiki;
import com.example.neo4jdemo.entity.Word;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Link {
    private Long id;
    private Wiki wiki;
    private Word word;
    private long num;
}
