package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.text.FieldPosition;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello from QA extractor!");

        PDDocument pdDocument =  PDFLoader.loadPDF("Test_PDF_Extractor.pdf");

        PDFTextStripper pdfTextStripper = new PDFTextStripper();

        String text = pdfTextStripper.getText(pdDocument);

        //System.out.println(text);

        //todo :  add cleaning methods, to remove text from the first page, and remove page numbers and apply them
        // on the text


    }
}