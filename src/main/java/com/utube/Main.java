package com.utube;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    final static DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

    public static void main(String[] args) {

        boolean methodeMap = false;
        boolean methodeFilter = false;
        boolean methodeForeach = false;
        boolean formatDate = true;
        List<Integer> listeAStreamer = Arrays.asList(1, 23, 54, 87, 96, 499, 71);

        // Opération intermédiaire map
        if (methodeMap) {
            List<Integer> listeStreamee = listeAStreamer.stream()
                    .map(nombreAModifier -> nombreAModifier * 3)
                    .collect(Collectors.toList());
            System.out.println(listeStreamee);
        }

        // Opération intermédiaire filter
        if (methodeFilter) {
            List<Integer> listeStreamee = listeAStreamer.stream()
                    .filter(nombreARetenir -> nombreARetenir % 2 == 0)
                    .collect(Collectors.toList());
            System.out.println(listeStreamee);
        }

        // Opération intermédiaire foreach
        if (methodeForeach) {
            listeAStreamer.stream().forEach(System.out::println);
        }

        /*SELECT date FROM table_date WHERE date <= 2005-01-01

        Je suppose que ton champs date est en format datetime ou equivalent:
        alors ce que je te conseille c'est d'essayer :

        SELECT date FROM table_date WHERE date <= to_date("20050101", "YYYYMMDD");

        WHERE datetime_column >= '20081220 00:00:00.000'
    AND datetime_column < '20081221 00:00:00.000'
    */

        if(formatDate){
            LocalDateTime ldt = LocalDateTime.now();
            System.out.println("ldt : " + ldt);
            String formattedString = ldt.format(CUSTOM_FORMATTER);  //2022-12-09 18:25:58
            System.out.println("formattedString : " + formattedString);
        }

    }
}