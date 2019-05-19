package pl.sda.writers;

public class FileWriterFactory {
    public SDAFileWriter produce(String path){

        if (path.endsWith(".json")){
            return new JsonFileWriter();
        }
        if (path.endsWith(".csv")){
            return new CSVFileWriter();
        }
        if (path.endsWith("xlsx")){
            return new ExcelFileWriter();
        }
        return null;
    }

}
