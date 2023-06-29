package com.example.Repository;

import com.example.neo4jdemo.Repository.Neo4jWikiRepository;
import com.example.neo4jdemo.Repository.WikiRepository;
import com.example.neo4jdemo.Service.WikiService;
import com.example.neo4jdemo.entity.Wiki;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.*;

class Neo4jWikiRepositoryTest {

    String url = "bolt://localhost:7687";
    String user = "neo4j";
    String password = "abcd1234";
    Driver driver = GraphDatabase.driver(url, AuthTokens.basic(user, password));
    Session session = driver.session();
    WikiRepository wikiRepository = new Neo4jWikiRepository(session);
    WikiService wikiService = new WikiService(session, wikiRepository);

    @Test
    void findByName() {
        wikiRepository.findByName("A");
    }
    @Test
    void findAll(){
        wikiRepository.findAll();
    }
    @Test
    void save(){
        Wiki wiki = new Wiki("C", "https://en.wikipedia.org/wiki/C");
        wikiRepository.saveWiki(wiki);
    }
    @Test
    void MakeMapTest(){
        wikiService.MakeMap("https://en.wikipedia.org/wiki/E");
    }
}