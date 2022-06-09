package sample;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class CreateExcel {
    public static int noOfRows;
    public static String [] data=new String[15];
/*        public static void CreatExcel(){

        // создание самого excel файла в памяти
        Workbook workbook = new HSSFWorkbook();
        // создание листа с названием "Просто лист"
        Sheet sheet = workbook.createSheet("Опрос");
       // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
       Row row = sheet.createRow(0);
       row.createCell(0).setCellValue("Имя");
        row.createCell(1).setCellValue("Фамилия");
       row.createCell(2).setCellValue("Номер телефона");
       row.createCell(3).setCellValue("Дата рождения ребенка");
       //row.createCell(4).setCellValue("Были ли ранее");
      //row.createCell(5).setCellValue("Желаемая частота посещения");
       //row.createCell(6).setCellValue("Физическая активность ребенка");
      //ow.createCell(7).setCellValue("Интерес к музыке");
       //row.createCell(8).setCellValue("Интерес к рисованию");
       //row.createCell(9).setCellValue("Желание отпраздновать праздник");
      //row.createCell(10).setCellValue("Желаемое количество гостей");
       //row.createCell(10).setCellValue("Желаемое времяпровождение");
      for(int i=1;i<=5;i++){
//            sheet.autoSizeColumn(i);
        }

        // записываем созданный в памяти Excel документ в файл
        try (FileOutputStream out = new FileOutputStream(new File("CreateExcel.xls"))) {
           workbook.write(out);
           workbook.close();
       } catch (IOException e) {
           e.printStackTrace();
        }
       System.out.println("Excel файл успешно создан!");
}*/
    public static void WriterExcel() {

        FileInputStream inputStream = null;
        Workbook workBook = null;
        try {
            inputStream = new FileInputStream("CreateExcel.xls");
            workBook = WorkbookFactory.create(inputStream);
            Sheet sh = workBook.getSheet("Опрос");
            noOfRows = sh.getLastRowNum();
            Row row = sh.createRow(noOfRows + 1);
            for(int i=0;i<data.length;i++) {
                row.createCell(i).setCellValue(data[i]);
                sh.autoSizeColumn(noOfRows + 1);
            }
            inputStream.close();
            FileOutputStream out1 = new FileOutputStream("CreateExcel.xls");
            workBook.write(out1);
            out1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}