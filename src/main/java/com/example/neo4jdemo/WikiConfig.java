package com.example.neo4jdemo;

import com.example.neo4jdemo.Repository.Neo4jWikiRepository;
import com.example.neo4jdemo.Repository.WikiRepository;
import com.example.neo4jdemo.Service.WikiService;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WikiConfig {
    @Bean
    public Driver driver(){
        String url = "bolt://localhost:7687";
        String user = "neo4j";
        String password = "abcd1234";
        return  GraphDatabase.driver(url, AuthTokens.basic(user, password));
    }
    @Bean
    public Session session(){
        return driver().session();
    }
    @Bean
    public WikiService wikiService(){
        return new WikiService(session(), wikiRepository());
    }
    @Bean
    public WikiRepository wikiRepository(){
        return new Neo4jWikiRepository(session());
    }
}
