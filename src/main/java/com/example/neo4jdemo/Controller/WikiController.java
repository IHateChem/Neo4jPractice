package com.example.neo4jdemo.Controller;

import com.example.neo4jdemo.Repository.WikiRepository;
import com.example.neo4jdemo.Service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WikiController {
    @Autowired
    private WikiRepository wikiRepository;
    @Autowired
    private WikiService wikiService;
    @GetMapping("/hi")
    public String hi(){
        System.out.println("hi");
        return "hi";
    }
    @GetMapping("/search")
    public String Search(@RequestParam("query") String query, Model model){
        wikiService.MakeMap("https://en.wikipedia.org/wiki/"+query);
        System.out.println("query = " + query);
        return "search";
    }
}
