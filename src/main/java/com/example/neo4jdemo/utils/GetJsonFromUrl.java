package com.example.neo4jdemo.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetJsonFromUrl {
    private String url;
    public static JSONObject getJson(String url){
        try {
            // Python 파일 실행 명령어
            String command = String.format("python \"C:\\Users\\이석우\\OneDrive\\바탕 화면\\Study\\Neo4jPractice\\src\\main\\Python\\parsingURL.py\" %s", url);
            // 프로세스 빌더 생성 및 실행
            ProcessBuilder pb = new ProcessBuilder(command.split(" "));
            Process process = pb.start();
            // 표준 출력 가져오기
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            JSONParser jsonParser = new JSONParser();
            JSONObject json = (JSONObject) jsonParser.parse(line);
            // 프로세스 종료 대기
            int exitCode = process.waitFor();
            return json;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
