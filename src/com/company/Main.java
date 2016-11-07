package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static Hashtable<String, Vector<String>> markovChain = new Hashtable<String, Vector<String>>();
    static Random rnd = new Random();


    public static void main(String[] args) throws IOException {

        System.out.println("Hello ready for shitposting\n");

        markovChain.put("_start", new Vector<String>());
        markovChain.put("_end", new Vector<String>());


        ///get these here words
        String inputString = "Buffalo bar is the venue run and tell this. Where the buffalo roam.";

        //add to hashtable
        addPost(inputString);

        System.out.println("\ntesting hashtable input...");
        Vector<String> test = markovChain.get("buffalo");
        for(String string:test){
            System.out.println(string);
        }

    }

    public static void addPost(String inputString){
        //split into sentences
        String[] sentences = inputString.split("\\p{Punct}");

        for(String sentence: sentences){
            System.out.print("\nSentence:");
            System.out.println(sentence);
            addSentence(sentence);
        }
    } //end addPost

    public static void addSentence(String inputString) {
        //split into words
        String[] words = inputString.split(" ");
        System.out.print("\nbreaking into words:");

        //for each word
        //if already added, get the suffix vector and add the word
        //if not, add it to the word
        //if its the first | last word chuck it in _start | _end key

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            System.out.println(words[i]);
            //first and last words fisrt
            if (i == 0) {
                Vector<String> startWords = markovChain.get("_start");
                startWords.add(words[i]);

                Vector<String> suffix = markovChain.get(words[i]);
                if (suffix == null) {
                    suffix = new Vector<String>();
                    suffix.add(words[i+1]);
                    markovChain.put(words[i], suffix);
                }
            } else if (i == words.length - 1) {
                Vector<String> endWords = markovChain.get("_end");
                endWords.add(words[i]);

            } else {
                Vector<String> suffix = markovChain.get(words[i]);
                if (suffix == null) {
                    suffix = new Vector<String>();
                    suffix.add(words[i+1]);
                    markovChain.put(words[i], suffix);
                } else {
                    suffix.add(words[i+1]);
                    markovChain.put(words[i], suffix);
                }
            }

        }
    } // end addSentece

}