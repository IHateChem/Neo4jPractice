package com.example;
import com.example.neo4jdemo.entity.Word;
import com.example.neo4jdemo.utils.GetJsonFromUrl;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

public class HtmlParsingTest {
    @Test
    public void test(){
        JSONObject wikiMap = GetJsonFromUrl.getJson("https://en.wikipedia.org/wiki/F");
        for (Object o : wikiMap.keySet()) {
            String word = (String) o;
            long num = (long) wikiMap.get(word);
            Word wordNode = new Word(word);
            System.out.println("num = " + num);
            System.out.println("word = " + word);
        }
    }

}
