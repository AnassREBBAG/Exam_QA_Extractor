package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello from QA extractor!");

        PDDocument pdDocument =  PDFLoader.loadPDF("Exam_QA_Extractor/src/main/resources/GCP-229ques.pdf");

        PDFTextStripper pdfTextStripper = new PDFTextStripper();

        String text = pdfTextStripper.getText(pdDocument);

        //System.out.println(text);

        
        System.out.println("-------------------------------");

        System.out.println(text.replaceAll("\\d+\\n", ""));

        System.out.println("-------------------------------");


        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> AOptions = new ArrayList<>();
        ArrayList<String> BOptions = new ArrayList<>();
        ArrayList<String> COptions = new ArrayList<>();
        ArrayList<String> DOptions = new ArrayList<>();
        ArrayList<String> EOptions = new ArrayList<>();
        ArrayList<String> correctAnswers = new ArrayList<>();




        Pattern questionPattern = Pattern.compile("Question \\d+\\n(.*?)(?=Question \\d+|$)", Pattern.DOTALL);
        Matcher matcher = questionPattern.matcher(text);

        while (matcher.find()) {
            String question = matcher.group(1).trim();
            questions.add(question);

            // Extract options
            Pattern optionPattern = Pattern.compile("[A-E]\\. .*");
            Matcher optionMatcher = optionPattern.matcher(question);
            while (optionMatcher.find()) {
                String option = optionMatcher.group().trim();
                char optionChar = option.charAt(0);
                switch (optionChar) {
                    case 'A':
                        AOptions.add(option.substring(3));
                        break;
                    case 'B':
                        BOptions.add(option.substring(3));
                        break;
                    case 'C':
                        COptions.add(option.substring(3));
                        break;
                    case 'D':
                        DOptions.add(option.substring(3));
                        break;
                    case 'E':
                        EOptions.add((option.substring(3)));
                }
            }

            // Extract correct answer
            Pattern answerPattern = Pattern.compile("Correct Answer: ([A-E])");
            Matcher answerMatcher = answerPattern.matcher(question);
            if (answerMatcher.find()) {
                String correctAnswer = answerMatcher.group(1);
                correctAnswers.add(correctAnswer);
            }
        }

        // Print the ArrayLists
        System.out.println("Questions:");
        System.out.println(questions);
        System.out.println("A Options:");
        System.out.println(AOptions);
        System.out.println("B Options:");
        System.out.println(BOptions);
        System.out.println("C Options:");
        System.out.println(COptions);
        System.out.println("D Options:");
        System.out.println(DOptions);
        System.out.println("E Options:");
        System.out.println(EOptions);
        System.out.println("Correct Answers:");
        System.out.println(correctAnswers);


    }



}