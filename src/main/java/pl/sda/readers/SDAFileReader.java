package pl.sda.readers;

import java.util.List;
import java.util.Map;

public interface SDAFileReader {
    List<Map<String, String>> read(String path);
}
