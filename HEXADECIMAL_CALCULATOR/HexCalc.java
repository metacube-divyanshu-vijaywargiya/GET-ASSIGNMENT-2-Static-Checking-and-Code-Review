package HexaCalculator;

public class HexaCalc {
	
	//to convert hexadecimal to decimal
	public int hexToDecimal(String hexadecimal){  
	    int base = 16;
	    String digits = "0123456789ABCDEF";  
	    hexadecimal = hexadecimal.toUpperCase();  
	    int decimalValue = 0;  
	    int hexaDecimal1Length = hexadecimal.length();
	    
	    for (int i = 0; i < hexaDecimal1Length; i++){  
	      char c = hexadecimal.charAt(i);  
	      int d = digits.indexOf(c);  
	      decimalValue = base*decimalValue + d;  
	    } 
	    
	  return decimalValue;  
	}
	
	//convert decimal to hexadecimal
	public String decimalToHex(int decimal){    
	     int remainder;  
	     String hexadecimal="";   
	     char hexadecimalChars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	     
	     while (decimal>0)  {  
	    	 remainder=decimal%16;   
	       hexadecimal=hexadecimalChars[remainder]+hexadecimal;   
	       decimal=decimal/16;  
	     }  
	     
	  return hexadecimal;  
	}    
	
	//add 2 hexadecimal
	public String addHex(int decimalOfHexadecimal1, int decimalOfHexadecimal2) {
		int sumAns = decimalOfHexadecimal1 + decimalOfHexadecimal2;
		
		return decimalToHex(sumAns);
	}
	
	//subtract 2 hexadecimal
	public String subtractHex(int decimalOfHexadecimal1, int decimalOfHexadecimal2) {
		int subtractAns = decimalOfHexadecimal1 - decimalOfHexadecimal2;
		
		return decimalToHex(subtractAns);
	}
	
	//multiply 2 hexadecimal 
	public String multiplyHex(int decimalOfHexadecimal1, int decimalOfHexadecimal2) {
		int multiplyAns = decimalOfHexadecimal1 * decimalOfHexadecimal2;
		
		return decimalToHex(multiplyAns);
	}
	
	
	//Divide 2 hexadecimal
	public String divideHex(int decimalOfHexadecimal1, int decimalOfHexadecimal2)throws ArithmeticException{
		if( decimalOfHexadecimal2 == 0 ) {
            throw new ArithmeticException("Divisor can't be zero."); 
		}
		
		int divideAns = decimalOfHexadecimal1/decimalOfHexadecimal2;
		
		return decimalToHex(divideAns);
	}
	
	
	//comparing hexadecimal >
	public boolean greaterHex(String hex1, String hex2) {
		return compareHex(hex1, hex2) > 0;
	}
	
	//comparing hexadecimal < 
	public boolean smallerHex(String hex1, String hex2) {
		return compareHex(hex1, hex2) < 0;
	}
	
	//comparing hexadecimal < 
	public boolean equalHex(String hex1, String hex2) {
		return compareHex(hex1, hex2) == 0;
	}
	
	private int compareHex(String hex1, String hex2) {
		hex1 = hex1.toUpperCase();
		hex2 = hex2.toUpperCase();
		int hexaDecimal1Length = hex1.length();
		int hexaDecimal2Length = hex2.length();
		
		if(hexaDecimal1Length > hexaDecimal2Length) {
			return 1;
		}else if(hexaDecimal1Length < hexaDecimal2Length) {
			return -1;
		}
		
		//if length equal
		for( int i =0; i < hexaDecimal2Length; i++ ) {
			char c1 = hex1.charAt(i);
			char c2 = hex2.charAt(i);
			
			if(c1 > c2) {
				return 1;
			}else if(c1 < c2) {
				return -1;
			}			
		}
		
		//both strings are exact identical
		return 0;
	}
	
}
