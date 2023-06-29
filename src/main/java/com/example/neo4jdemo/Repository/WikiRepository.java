package com.example.neo4jdemo.Repository;

import com.example.neo4jdemo.entity.Wiki;
import com.example.neo4jdemo.entity.Word;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WikiRepository {
    Wiki findByName(String name);
    List<Wiki> findAll();
    List<Word> findByLinksFromName(String name);
    Wiki saveWiki(Wiki wiki);
    Word saveWord(Word word);
    void saveRelation(Wiki wiki, Word word, long num);

}
