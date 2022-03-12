package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String htmlFile = parseFile("C:\\Users\\aleks\\html");
        Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.select("a.menu_link");
        elements.forEach(System.out::println);
        elements.forEach(element -> elements.toString());
        System.out.println(htmlFile);
    }

    public static String parseFile (String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
