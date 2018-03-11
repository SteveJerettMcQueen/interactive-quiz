/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci5520.mcqueen;

import com.csci5520.mcqueen.ThreadWorkers.ChapterFinder;
import com.csci5520.mcqueen.ThreadWorkers.ChoiceFinder;
import com.csci5520.mcqueen.ThreadWorkers.KeyHintFinder;
import com.csci5520.mcqueen.ThreadWorkers.QuestionFinder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Steve
 */
public class ChaptersContent {

    private final ExecutorService exec;
    private final ThreadWorkers workers;
    private final Chapters ch;
    private final ArrayList<Intro11EditionQuiz> intro11EQs;

    public ChaptersContent() {
        exec = Executors.newSingleThreadExecutor();
        workers = new ThreadWorkers();
        ch = new Chapters();
        intro11EQs = new ArrayList();
    }

    public ArrayList<Intro11EditionQuiz> getChaptersContent() {

        ChapterFinder chFin;
        QuestionFinder questFin;
        ChoiceFinder choiceFin;
        KeyHintFinder khFin;

        Future<String> fut;
        Future<ArrayList<String>> fut2;
        Future<ArrayList<LinkedHashMap<String, String>>> fut3;
        Future<ArrayList<String[]>> fut4;

        ArrayList<String> chapters = ch.getChapters();
        for (int i = 0; i < chapters.size(); i++) {
            workers.setSource(chapters.get(i));
            chFin = workers.new ChapterFinder();
            questFin = workers.new QuestionFinder();
            choiceFin = workers.new ChoiceFinder();
            khFin = workers.new KeyHintFinder();

            fut = exec.submit(chFin);
            fut2 = exec.submit(questFin);
            fut3 = exec.submit(choiceFin);
            fut4 = exec.submit(khFin);

            try {

                String chapterNo = fut.get();
                ArrayList<String> questions = fut2.get();
                ArrayList<LinkedHashMap<String, String>> choices = fut3.get();
                ArrayList<String[]> keyHints = fut4.get();

                int qs = questions.size();
                int cs = choices.size();
                int ks = keyHints.size();
                if (qs == cs && cs == ks) {
                    Intro11EditionQuiz intro11EQ;
                    for (int j = 0; j < qs; j++) {
                        intro11EQ = new Intro11EditionQuiz();
                        intro11EQ.setChapterNo(chapterNo);
                        intro11EQ.setQuestionNo(Integer.toString((j + 1)));
                        intro11EQ.setQuestion(questions.get(j));
                        intro11EQ.setChoices(choices.get(j));
                        intro11EQ.setAnswerKey(keyHints.get(j)[0]);
                        if (keyHints.get(j).length == 2) {
                            intro11EQ.setHint(keyHints.get(j)[1]);
                        }
                        intro11EQs.add(intro11EQ);
                    }
                }

            } catch (InterruptedException | ExecutionException ex) {
                System.out.println(ex);
            }

        }

        exec.shutdown();
        return intro11EQs;
    }

    public static void main(String[] args) {
        ChaptersContent cc = new ChaptersContent();
        ArrayList<Intro11EditionQuiz> intro11EQs = cc.getChaptersContent();

        for (int i = 0; i < intro11EQs.size(); i++) {
            System.out.println(intro11EQs.get(i).getQuestion());
            System.out.println("-------------------------------------------");
        }

    }
}
