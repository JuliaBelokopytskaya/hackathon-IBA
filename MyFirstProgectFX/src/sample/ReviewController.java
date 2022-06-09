package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static sample.CreateExcel.WriterExcel;

public class ReviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button msgSend;

    @FXML
    private Label result;

    @FXML
    private Label result1;

    @FXML
    private TextField reviewText;


    @FXML
    void initialize() {

        msgSend.setOnMouseClicked(mouseEvent -> {
            msgSend.getScene().getWindow().hide();
            Document document = new Document();
            try {
                String reviewGet;
                reviewGet = reviewText.getText();

                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Reviews.pdf"));
                String FONT = "./fonts/arial.ttf";
                BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font font = new Font(bf, 14, Font.NORMAL);
                document.open();
                document.add(new Paragraph(reviewGet, font));
                document.close();
                writer.close();
                WriterExcel();
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}


