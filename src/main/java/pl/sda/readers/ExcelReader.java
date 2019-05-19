package pl.sda.readers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelReader implements SDAFileReader {

    @Override
    public List<Map<String, String>> read(String path) {

        try {
            List<Map<String, String>> result = new ArrayList<>();
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            Sheet sheet = workbook.getSheetAt(0);

            //1. Pobranie 1 wiersza zawierającego nagłówki
            Iterator<Row> rowIterator = sheet.rowIterator();

            Row headerRow = rowIterator.next();
            List<String> headers = new ArrayList<>();
            Iterator<Cell> headerIterator = headerRow.cellIterator();

            //2. Wpisywanie wartości z wiersza nagłówkowego do zbioru nagłówków
            while (headerIterator.hasNext()) {
                String value = headerIterator.next().getStringCellValue();
                headers.add(value);
            }

            //3. Przetwarzanie kolejnych wierszy pliku i wpisywanie nowych rekordów do listy
            while (rowIterator.hasNext()) {
                Map<String, String> record = new HashMap<>();
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int counter = 0;
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    String header = headers.get(counter);
                    record.put(header, cell.getStringCellValue());
                    counter++;
                }
                result.add(record);
            }

            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
