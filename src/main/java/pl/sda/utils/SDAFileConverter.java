import pl.sda.readers.FileReaderFactory;
import pl.sda.readers.SDAFileReader;
import pl.sda.writers.FileWriterFactory;
import pl.sda.writers.SDAFileWriter;

import java.util.List;
import java.util.Map;

public class SDAFileConverter {
    /**
     * Zadaniem metody jest wywołanie mechanizmów służących do przeprowadzenia
     * konwersji między typami plików.
     * Ogólny przebieg działania metody:
     * 1. utworzenie fabryki readerów
     * 2. zbudowanie obiektu readera na bazie ścieżki do pliku
     * 3. pobranie listy map zawierających obiekty zbudowane na bazie zawartości pliku
     * 4. utworzenie fabryki writerów
     * 5. utworzenie obiektu writera poprzez przekazanie do fabryki ścieżki do pliku
     * 6. wywołanie klasy writera i zapis pliku w żądanym formacie
     *
     * @param inputPath - ścieżka do pliku źródłowego
     * @param outputPath - ścieżka do pliku wyjściowego
     */
    public void convert(String inputPath, String outputPath) {
        FileReaderFactory fileReaderFactory = new FileReaderFactory();
        SDAFileReader reader = fileReaderFactory.produce(inputPath);
        List<Map<String, String>> records = reader.read(inputPath);

        FileWriterFactory fileWriterFactory = new FileWriterFactory();
        SDAFileWriter writer = fileWriterFactory.produce(outputPath);
        writer.write(records, outputPath);
    }
}