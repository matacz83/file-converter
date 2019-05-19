package pl.sda.writers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExcelFileWriter implements SDAFileWriter {

    @Override
    public void write(List<Map<String, String>> records, String path) {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        //1. Tworzenie wiersza nagłówkowego
        Set<String> headers = new HashSet<>();
        for (Map<String, String> record : records) {
            headers.addAll(record.keySet());
        }
        Row headerRow = sheet.createRow(0);
        int cellCounter = 0;
        for (String header : headers) {
            Cell cell = headerRow.createCell(cellCounter);
            cell.setCellValue(header);
            cellCounter++;
        }

        //2. Generowanie wierszy z danymi
        int rowCounter = 1;
        for (Map<String, String> record : records) {
            Row row = sheet.createRow(rowCounter);
            cellCounter = 0;
            for (String header : headers) {
                Cell cell = row.createCell(cellCounter);
                cell.setCellValue(record.get(header));
                cellCounter++;
            }
            rowCounter++;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
