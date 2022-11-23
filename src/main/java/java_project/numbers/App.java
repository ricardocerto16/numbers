package java_project.numbers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException{
    	
    	List<String> inputNumbers = FileManeger.openNumbers(args[0]);
    	
    	List<String> validCodes = FileManeger.openFileIndexs();
    	
    	List<String> validNumbers = Validations.separateLongShort(inputNumbers, validCodes);
    	
    	List<String> validNumbersCnt = Validations.countValidNumbersCountry(validNumbers,validCodes); 
    }
}
