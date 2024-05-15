package org.example;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class PDFLoader {


    public static PDDocument loadPDF(String path) throws IOException {

        PDDocument pdDocument = null;
        try{
            pdDocument = PDDocument.load(new File(path));
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("file not found");
        }
        return pdDocument;
    }

}
