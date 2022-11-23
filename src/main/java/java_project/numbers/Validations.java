package java_project.numbers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validations {

	
	public static List<String> separateLongShort (List<String> inputNumbers, List<String> validCodes) {
		
		int x=0;
		int z=0;
		List<String> shortNumbers = new ArrayList<>();
		List<String> longNumbers = new ArrayList<>();
		
		for(int i=0;i < inputNumbers.size(); i++) {
			
			if( inputNumbers.get(i).length() >= 4 && inputNumbers.get(i).length() < 7) 
				if(validateShort(inputNumbers.get(i))) {
					shortNumbers.add(inputNumbers.get(i));
					x++;
				}
			
			if(validateLong(inputNumbers.get(i), validCodes))
				longNumbers.add(inputNumbers.get(i));
				z++;
			
		}
		
		return Stream.concat(longNumbers.stream(),shortNumbers.stream()).collect(Collectors.toList());
		
	}
	
	
	public static boolean validateShort (String number) {
		
		if (number.startsWith("0")) {
			return false;
		}
		if (number.contains(" ")) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean validateLong (String number, List<String> validCodes) {
		
		if ( number.startsWith("00") && number.replaceAll(" ", "").length() >= 11 && number.replaceAll(" ", "").length() < 17 && validCountryCode(number, validCodes)) {
			return true;
		}
		if ( number.startsWith("+") && number.replaceAll(" ", "").length() >= 10 && number.replaceAll(" ", "").length() < 16 && validCountryCode(number, validCodes)) {
			return true;
		}
			
		
		
		return false;
	}


	private static boolean validCountryCode(String number, List<String> validCodes) {
		
		String numberNoPrefix=null;
		String countryCode=null;
		
		for(int i=0; i < validCodes.size(); i++) {
			if (number.startsWith("00") && !Character.isSpaceChar(number.charAt(2))) {
				numberNoPrefix = number.substring(2);
				countryCode = validCodes.get(i).split("-")[1];
				if (numberNoPrefix.startsWith(countryCode)) {
					return true;
				}
			}	
			
			if (number.startsWith("+") && !Character.isSpaceChar(number.charAt(1))) {
				numberNoPrefix = number.substring(1);
				countryCode = validCodes.get(i).split("-")[1];
				if (numberNoPrefix.startsWith(countryCode))
					return true;
		
			}
			
		}
		return false;
	}


	public static List<String> countValidNumbersCountry(List<String> validNumbers, List<String> validCodes) {
	
		List<String> countNumberCountry = new ArrayList<>();
		List<String> onlyCodes = new ArrayList<>();
		String country;
		String code;
		
		String onlyNumber = "";
	
		for(int i=0;i < validCodes.size() - 1; i++) {
			Integer counterC = 0; 
			country = validCodes.get(i).split("-")[0];
			code = validCodes.get(i).split("-")[1];
			
			for(int x = 0; x < validNumbers.size() - 1; x++) {
				
				if(validNumbers.get(x).startsWith("00")) {
					 if(validNumbers.get(x).substring(1).startsWith(code))
						 counterC = counterC + 1;
						 
				} else if (validNumbers.get(x).startsWith("+")) {
					if(validNumbers.get(x).substring(1).startsWith(code))
						counterC++;
					
				} else {
					if(validNumbers.get(x).startsWith(code))
						counterC++;
					
				}
			}
			
			countNumberCountry.add(country + "-" + counterC);
			System.out.println(country + "-" + counterC);
			counterC = 0;

		}
		
		return countNumberCountry;
	}
	
}
