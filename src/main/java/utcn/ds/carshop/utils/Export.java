package utcn.ds.carshop.utils;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.ListItem;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.multipart.MultipartFile;
import utcn.ds.carshop.model.Car;

import java.io.*; import java.text.*;
import java.util.List;

public class Export {
    public static void buildHtml(List<Car> listOfCars) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("cars.html"));
        pw.println("<TABLE BORDER><TR><TH>Type<TH>Model<TH>Price<TH>Year<TH>Image<TH>Details</TR>");
        for (Car carIterator:listOfCars) {
            pw.println("<TR><TD>" + carIterator.getType() +
                    "<TD>" + carIterator.getModel() +
                    "<TD>" + carIterator.getPrice() +
                    "<TD>" + carIterator.getYear() +
                    "<TD>" + carIterator.getImage() +
                    "<TD>" + carIterator.getDetails());

        }
//        for (int i = 1; i <= 20; i++) {
//            int square = i * i;
//            pw.println("<TR><TD>" + i + "<TD>" + square + "<TD>" + square+ "<TD>" + square+ "<TD>" + square+ "<TD>" + square);
//        }
        pw.println("</TABLE>");
        pw.close();
    }

    public static void buildPdf(java.util.List<Car> listOfCars) throws Exception {
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("cars.pdf"));
        doc.open();
        com.lowagie.text.List list = new com.lowagie.text.List(true, 30);
        for (Car carIterator : listOfCars) {
            list.add(new ListItem("MARCA: " + carIterator.getType() + " " +
                    "MODEL: " + carIterator.getModel() + " " +
                    "PRET: " + carIterator.getPrice() + " " +
                    "AN: " + carIterator.getYear() + " " +
                    "IMAGINE: " + carIterator.getImage() + " " +
                    "DETALII: " + carIterator.getDetails() + " "
            ));
        }
        doc.add(list);
        doc.add(Chunk.NEWLINE);
        list = new com.lowagie.text.List(false, 30);
        doc.add(list);
        doc.close();
    }
}