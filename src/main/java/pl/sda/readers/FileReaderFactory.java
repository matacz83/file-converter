package pl.sda.readers;

public class FileReaderFactory {
    public SDAFileReader produce(String path){
        if(path.endsWith(".json")){
            return new JSONReader();
        }
        return null;
    }
}
