/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sm6668
 */
public class ThreadWorkers {

    private String source;

    public ThreadWorkers() {
    }

    public ThreadWorkers(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public class ChapterFinder implements Callable {

        @Override
        public String call() {

            Matcher chapMatch;
            Pattern chapPatt = Pattern.compile("Chapter\\s([0-9]+)");
            String chapterNo = null;

            Scanner scan = new Scanner(source);
            if (scan.hasNextLine()) {
                chapMatch = chapPatt.matcher(scan.nextLine());
                if (chapMatch.lookingAt()) {
                    chapterNo = chapMatch.group(1);
                }
            }

            return chapterNo;
        }

    }

    public class QuestionFinder implements Callable {

        @Override
        public ArrayList<String> call() {

            Matcher questMatch;
            Pattern questPatt = Pattern.compile("(\\d+)\\.((.*))");
            ArrayList<String> questions = new ArrayList();

            Scanner scan = new Scanner(source);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                questMatch = questPatt.matcher(line);
                StringBuilder questBuilder;
                if (questMatch.lookingAt()) {
                    questBuilder = new StringBuilder(line);
                    questBuilder.append("\n");
                    if (scan.hasNextLine()) {
                        String nextLine = scan.nextLine();
                        while (!nextLine.startsWith("a.")) {
                            questBuilder.append(nextLine);
                            questBuilder.append("\n");
                            nextLine = scan.nextLine();
                        }
                        questions.add(questBuilder.toString());
                    }

                }
            }

            return questions;
        }
    }

    public class ChoiceFinder implements Callable {

        @Override
        public ArrayList<LinkedHashMap<String, String>> call() {

            Matcher choiceMatch;
            Pattern choicePatt = Pattern.compile("([a]{1,1})\\.(.*)");
            ArrayList<LinkedHashMap<String, String>> choices = new ArrayList();

            Scanner scan = new Scanner(source);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                choiceMatch = choicePatt.matcher(line);
                LinkedHashMap<String, String> choice;
                if (choiceMatch.lookingAt()) {
                    choice = new LinkedHashMap(5);
                    String charac = choiceMatch.group(1);
                    String text = choiceMatch.group(2);
                    choice.put(charac, text);
                    if (scan.hasNextLine()) {
                        String nextLine = scan.nextLine();
                        while (!nextLine.startsWith("Key:")) {
                            int index = nextLine.indexOf(" ");
                            if (index != -1) {
                                String key = String.valueOf(nextLine.charAt(0));
                                String val = nextLine.substring(index);
                                choice.put(key, val);
                            }
                            nextLine = scan.nextLine();
                        }
                        choices.add(choice);
                    }
                }
            }

            return choices;
        }
    }

    public class KeyHintFinder implements Callable {

        @Override
        public ArrayList<String[]> call() {

            Matcher keyHintMatch;
            Pattern keyHintPatt = Pattern.compile("Key:([a-e]*)");
            ArrayList<String[]> keyHints = new ArrayList();

            Scanner scan = new Scanner(source);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                keyHintMatch = keyHintPatt.matcher(line);
                if (keyHintMatch.lookingAt()) {
                    String[] groups;
                    int index = line.indexOf(" ");
                    if (index != -1) {
                        groups = new String[2];
                        groups[0] = keyHintMatch.group(1);
                        groups[1] = line.substring(index);//hint
                    } else {
                        groups = new String[1];
                        groups[0] = keyHintMatch.group(1);
                    }
                    keyHints.add(groups);
                }
            }

            return keyHints;
        }
    }
}
