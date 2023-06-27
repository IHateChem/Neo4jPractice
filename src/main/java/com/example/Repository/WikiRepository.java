package com.example.Repository;

import com.example.entity.Wiki;
import com.example.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
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
