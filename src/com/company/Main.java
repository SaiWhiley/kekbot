package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static Hashtable<String, Vector<String>> markovChain = new Hashtable<String, Vector<String>>();
    static Random rnd = new Random();



    public static void main(String[] args) throws IOException {

        System.out.println("Hello etc ready for shitposting\n");

        markovChain.put("_start", new Vector<String>());
        markovChain.put("_end", new Vector<String>());
        ArrayList<List> dictionary = getDictionary();
    }

    public static ArrayList<List> getDictionary(){

        ArrayList<List> dictionary = new ArrayList<List>();

        //split input into words
        String testString = "Buffalo bar is the venue run and tell this. Where the buffalo roam.";
        String[] splitString = testString.split(" ");
        //for every word
        for (String currentWord:splitString) {
            System.out.println(currentWord);
            //if word is not already in the dictionary
            if(!dictionary.contains(currentWord)){
                //create a new array with key equal to word
            }

        }
        return dictionary;

    }
}