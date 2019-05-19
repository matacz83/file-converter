package pl.sda;

import pl.sda.readers.FileReaderFactory;
import pl.sda.readers.SDAFileReader;
import pl.sda.writers.FileWriterFactory;
import pl.sda.writers.SDAFileWriter;

import java.util.List;
import java.util.Map;

public class App
{
    public static void main( String[] args )
    {
        String input = "C:\\Users\\mmata\\IdeaProjects\\converter\\cars.csv";
        String output = "C:\\Users\\mmata\\IdeaProjects\\converter\\CarsProducedFromJsonBySDAFileConverter.xlsx";

        SDAFileConverter converter = new SDAFileConverter();
        converter.convert(input, output);
    }
}
