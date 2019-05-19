package pl.sda.writers;

import org.json.JSONArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonFileWriter implements SDAFileWriter {

    @Override
    public void write(List<Map<String, String>> records, String path) {
        JSONArray jsonArray = new JSONArray();

        for (Map<String, String> record : records) {
            jsonArray.put(record);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(jsonArray.toString(2));
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
