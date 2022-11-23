package java_project.numbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManeger {

	
	public static List<String> openFileIndexs () throws IOException {
		
		List<String> codes = new ArrayList<>();
		
		File file = new File("..\\numbers\\coutryCodes.txt");   
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		StringBuffer sb=new StringBuffer();    
		String line;  
		int i=0;
		
		while((line=br.readLine())!=null)  {  
			
			codes.add(line);
			i++;
		}  
		fr.close(); 
		
		
		return codes;
		
	}
	
	
public static List<String> openNumbers (String path) throws IOException {
		
		List<String> numbers = new ArrayList<>();
		
		File file = new File(path);   
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		StringBuffer sb=new StringBuffer();    
		String line;  
		int i=0;
		
		while((line=br.readLine())!=null)  {  
			
			numbers.add(line);
			i++;
		}  
		fr.close(); 
		
		
		return numbers;
		
	}
	
}
