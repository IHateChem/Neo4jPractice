package com.example.relationship;

import com.example.entity.Wiki;
import com.example.entity.Word;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Link {
    private Long id;
    private Wiki wiki;
    private Word word;
    private long num;
}
