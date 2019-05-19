package pl.sda.readers;

public class FileReaderFactory {
    public SDAFileReader produce(String path){
        if(path.endsWith(".json")){
            return new JSONReader();
        }
        if (path.endsWith(".csv")){
            return new CSVReader();
        }
        if (path.endsWith("xlsx")){
            return new ExcelReader();
        }
        return null;
    }
}
