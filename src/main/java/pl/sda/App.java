package pl.sda;

import pl.sda.utils.SDAFileConverter;

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
