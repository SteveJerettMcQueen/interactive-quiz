/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Steve
 */
public class Chapters {

    private final String directory;
    private final ArrayList<String> chapters;
    private final BufferedReader br;

    public Chapters() {
        directory = "/chapters/";
        chapters = new ArrayList();
        br = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream(directory),
                StandardCharsets.UTF_8));

        try {
            String chapter;
            URL url;
            Path source;
            String fileName = null;
            while ((fileName = br.readLine()) != null) {
                url = this.getClass().getResource(directory + fileName);
                source = Paths.get(url.toURI());
                chapter = new String(Files.readAllBytes(source));
                chapters.add(chapter);
            }
        } catch (IOException | URISyntaxException ex) {
            System.out.println(ex);
        }

    }

    public ArrayList<String> getChapters() {
        return chapters;
    }

    public static void main(String[] args) {
        Chapters chapters = new Chapters();
        System.out.println(chapters.getChapters().size());
    }
}
