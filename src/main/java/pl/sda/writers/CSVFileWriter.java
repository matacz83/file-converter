package pl.sda.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CSVFileWriter implements SDAFileWriter {

    @Override
    public void write(List<Map<String, String>> records, String path) {

        //Budowanie wiersza nagłówkowego
        Set<String> headers = new HashSet<>();
        for (Map<String, String> record : records) {
            headers.addAll(record.keySet());
        }
        String headerRow = "";
        int counter = 0;
        for (String header : headers) {
            headerRow = headerRow + header;
            if (counter < headers.size() - 1) {
                headerRow = headerRow + ";";
            }
            counter++;
        }

        //Budowanie wierszy do zapisu
        List<String> rows = new ArrayList<>();
        rows.add(headerRow + "\n");
        for (Map<String, String> record : records) {
            String row = "";
            int rowCounter = 0;
            for (String header : headers) {
                row = row + record.get(header);
                if (rowCounter < headers.size() - 1) {
                    row = row + ";";
                }
                rowCounter++;
            }
            rows.add(row + "\n");
        }

        //zapis do pliku
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (String row : rows) {
                bufferedWriter.append(row);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
