package org.example;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JavaStreams {

    static void NormalFirsLetter() {
        List<String> names = new ArrayList<String>();
        names.add("Aravind");
        names.add("Deebhan");
        names.add("Alexa");
        names.add("Rama");
        names.add("Adam");
//        int count = 0;
//        for (int i = 0; i < names.size(); i++) {
//            String name = names.get(i);
//            if (name.startsWith("A")) {
//                count++;
            }
        }
//        System.out.println(count);

//    static void FirstLetter(){
//        List<String> names = new ArrayList<>();
//        names.add("Aravind");
//        names.add("Deebhan");
//        names.add("Rama");
//        names.add("Alexa");
//        names.add("Adam");
//List<String> name1 = Arrays.asList("David", "Arun", "Site");
//        Long c =names.stream().filter(s->s.startsWith("A")).count();
//        System.out.println(c);
        // Count of the List
//        Long d = Stream.of("Aravind", "Deebhan", "Alexa", "Adam", "Rama").filter(s -> s.length() > 4).count();
//        System.out.println(d);
        //Name starts with "A" name list
//        names.stream().filter(g->g.startsWith("A")).forEach(g->System.out.println(g));
        //Greater than the 4 Letters
//        names.stream().filter(g->g.length()>4).forEach(g->System.out.println(g));
        //The letters Ends with "a"
//        names.stream().filter(g->g.endsWith("a")).sorted().forEach(g->System.out.println(g));
        //Greater than 4 letters and Print first name
//        names.stream().filter(g->g.length()>4).limit(1).forEach(g->System.out.println(g));
//        The Letters Ends with "a" and it should display in Upper case
  //      names.stream().filter(g->g.endsWith("a")).sorted().map(g->g.toUpperCase()).forEach(g->System.out.println(g));
        //Combain the Two Array of strings in the single variable
//        Stream<String>
        //Get the First Elements of the List
//        List<String> ls= Stream.of("Aravind", "Deebhan", "Alexa", "Adam", "Rama").filter(g->g.startsWith("A")).map(g->g.toUpperCase()).collect(Collectors.toList());
//        System.out.println(ls);
//        System.out.println("NA");
//        System.out.println("NA");



