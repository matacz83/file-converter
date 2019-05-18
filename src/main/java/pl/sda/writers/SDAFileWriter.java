package pl.sda.writers;

import java.util.List;
import java.util.Map;

public interface SDAFileWriter {
    void write(List<Map<String, String>> records, String path);
}
