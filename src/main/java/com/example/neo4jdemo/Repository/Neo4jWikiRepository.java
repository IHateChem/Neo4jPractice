package com.example.neo4jdemo.Repository;

import com.example.neo4jdemo.entity.Wiki;
import com.example.neo4jdemo.entity.Word;
import org.neo4j.driver.*;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class Neo4jWikiRepository implements WikiRepository{
    private final Session session;
    public Neo4jWikiRepository(Session session){
        this.session = session;
    }
    @Override
    public Wiki findByName(String name) {
        String query = String.format("MATCH (wiki:Wiki {name: \"%s\"}) Return wiki LIMIT 1", name);
        Result result = session.run(query);
        Record record = result.next();
        Node wikiNode = record.get("wiki").asNode();
        String nodeName = wikiNode.get("name").asString();
        String nodeUrl = wikiNode.get("url").asString();
        Wiki wiki = new Wiki(nodeName, nodeUrl);
        return wiki;
    }

    @Override
    public List<Wiki> findAll() {
        String query = "MATCH (wiki:Wiki) RETURN wiki";
        Result result = session.run(query);
        List<Wiki> wikis = new ArrayList<>();
        while(result.hasNext()){
            Record record = result.next();
            Node wikiNode = record.get("wiki").asNode();
            String nodeName = wikiNode.get("name").asString();
            String nodeUrl = wikiNode.get("url").asString();
            wikis.add(new Wiki(nodeName, nodeUrl));
        }
        return wikis;
    }
    @Override
    public List<Word> findByLinksFromName(String name) {
        return null;
    }
    @Override
    public Wiki saveWiki(Wiki wiki){
        String query = String.format("create (w: Wiki {name: '%s', url:'%s'}) return w", wiki.getName(), wiki.getUrl());
        session.run(query);
        return wiki;
    }
    @Override
    public Word saveWord(Word word){
        String query = String.format("create (w: Word {word: '%s'}) return w", word.getWord());
        session.run(query);
        return word;
    }
    @Override
    public void saveRelation(Wiki wiki, Word word, long num){
        String query = String.format("MATCH (wiki:Wiki {name: '%s'}), (word:Word {word: '%s'}) CREATE (wiki)-[:LINKS{num:%d}]->(word)", wiki.getName(), word.getWord(),num);
        session.run(query);
    }
}
