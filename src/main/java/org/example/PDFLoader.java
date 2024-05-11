package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFLoader {


    public static PDDocument loadPDF(String path) throws IOException {

        PDDocument pdDocument = null;
        try{
            pdDocument = PDDocument.load(new File("src/main/resources/Test_PDF_Extractor.pdf"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return pdDocument;
    }

}
