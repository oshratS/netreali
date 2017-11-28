/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netreali;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author oshrat
 */
public class DateTimeExtractor implements EntityExtractorInterface {

    @Override
    public ArrayList<String> extract(String txt) {
        ArrayList<String> extracted = new ArrayList<>();
        Matcher m = Pattern
                .compile("[^a-zA-Z' :-_]*(([1-9]|0[0-9]|1[0-9]|2[0-4])[:]([0-5][0-9])|(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](\\d\\d)(\\d\\d)?)[^a-z' :-_]*")
                .matcher(txt);
       
        // TODO: think about adding these formats
        // X o'clock
        // days of the week, i.e: sunday monday etc.
        // month names, i.e: september etc.
        
        while (m.find()) {
            extracted.add(m.group());
        }

        return extracted;
    }

    public static void main(String args[]) {
        DateTimeExtractor extractor = new DateTimeExtractor();

        String txt = "i was going to ARI'EL when i found out mamki around 16:43 and it was the 23-11-17";

        ArrayList<String> extracted = extractor.extract(txt);

        System.out.println(extracted.toString());
    }
}
