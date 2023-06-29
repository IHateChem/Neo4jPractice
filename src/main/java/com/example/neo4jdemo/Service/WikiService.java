package com.example.neo4jdemo.Service;

import com.example.neo4jdemo.Repository.WikiRepository;
import com.example.neo4jdemo.entity.Wiki;
import com.example.neo4jdemo.entity.Word;
import com.example.neo4jdemo.utils.GetJsonFromUrl;
import org.json.simple.JSONObject;
import org.neo4j.driver.*;

import java.util.StringTokenizer;

public class WikiService {
    private final Session session;
    private final WikiRepository wikiRepository;
    public WikiService(Session session, WikiRepository wikiRepository){
        this.session = session;
        this.wikiRepository = wikiRepository;
    }
    public Wiki CreateWiki(Wiki wiki){
        wikiRepository.saveWiki(wiki);
        return wiki;
    }
    public Word CreateWord(Word word){
        wikiRepository.saveWord(word);
        return word;
    }
    public void SetRelation(Wiki wiki, Word word, long num){
        wikiRepository.saveRelation(wiki, word, num);
    }
    public void MakeMap(String url){
        StringTokenizer st = new StringTokenizer(url, "/");
        String name = null;
        while(st.hasMoreTokens()){
            name = st.nextToken();
        }
        Wiki wiki = new Wiki(name, url);
        System.out.println("---Create Wiki Node ----");
        CreateWiki(wiki);
        JSONObject wikiMap = GetJsonFromUrl.getJson(url);
        System.out.println("---Create word Node and Relationship ----");
        for (Object o : wikiMap.keySet()) {
            String word = (String) o;
            long num = (long) wikiMap.get(word);
            Word wordNode = new Word(word);
            CreateWord(wordNode);
            SetRelation(wiki, wordNode, num);
        }
    }
}
