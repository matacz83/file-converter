package pl.sda.readers;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader implements SDAFileReader {

    @Override
    public List<Map<String, String>> read(String path) {
        List<Map<String, String>> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String headerLine = bufferedReader.readLine();
            String[] headers = headerLine.split(";");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(";");

                Map<String, String> record = new HashMap<>();

                for (int i = 0; i < headers.length; i++) {
                    record.put(headers[i], values[i]);
                }

                result.add(record);
            }

            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}