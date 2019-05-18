package pl.sda.readers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class JSONReader implements SDAFileReader {

    @Override
    public List<Map<String, String>> read(String path) {
        List<Map<String, String>> result = new ArrayList<>();

        String content = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            content = new String(bytes, "UTF-8");

        } catch (IOException e) {
            //TODO: dodać wyrzucenie nowego wyjątku
            e.printStackTrace();
        }

        JSONArray jsonArray = new JSONArray(content);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject recordRaw = new JSONObject(jsonArray.get(i).toString());
            Set<String> keys = recordRaw.keySet();
            Map<String, String> record = new HashMap<>();
            for (String key : keys) {
                String value = recordRaw.get(key).toString();
                record.put(key, value);
            }
            result.add(record);
        }

        return result;
    }
}
