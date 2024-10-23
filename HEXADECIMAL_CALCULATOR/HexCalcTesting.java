package HexaCalculator;
import java.util.Scanner;


public class HexCalcTesting {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HexaCalc calc = new HexaCalc();
		
		System.out.println("Enter the first hexadecimal number : ");
		String hex1 = scanner.nextLine();
		int decimalOfHexadecimal1 = calc.hexToDecimal(hex1);
		
		System.out.println("Enter the second hexadecimal number : ");
		String hex2 = scanner.nextLine();
		int decimalOfHexadecimal2 = calc.hexToDecimal(hex2);
		
		//menu for options
		System.out.println("Select an option : ");
		System.out.println("1. Check if greater");
		System.out.println("2. Check if smaller");
		System.out.println("3. Check if Equal");
		System.out.println("4. Addition");
		System.out.println("5. Subtraction");
		System.out.println("6. Multiplication");
		System.out.println("7. Division");
		
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			if(calc.greaterHex(hex1, hex2)) {
				System.out.println(hex1 + " is greater than "+ hex2);
			}else {
				System.out.println(hex1 + " is not greater than "+ hex2);
			}
			break;
			
		case 2:
			if(calc.smallerHex(hex1, hex2)) {
				System.out.println(hex1 + " is smaller than "+ hex2);
			}else {
				System.out.println(hex1 + " is not smaller than "+ hex2);
			}
			break;
			
		case 3:
			if(calc.equalHex(hex1, hex2)) {
				System.out.println(hex1 + " is equal to "+ hex2);
			}else {
				System.out.println(hex1 + " is not equals to "+ hex2);
			}
			break;
			
		case 4: 
			String sum = calc.addHex(decimalOfHexadecimal1, decimalOfHexadecimal2);
			System.out.println("Addition of " + hex1 + " & " + hex2 + " is : " + sum);
			break;
			
		case 5:
			String difference = calc.subtractHex(decimalOfHexadecimal1, decimalOfHexadecimal2);
			System.out.println("Subtraction of " + hex1 + " & " + hex2 + " is : " + difference);
			break;
			
		case 6:
			String product = calc.multiplyHex(decimalOfHexadecimal1, decimalOfHexadecimal2);
			System.out.println("Multiplication of " + hex1 + " & " + hex2 + " is : " + product);
			break;
			
		case 7:
			try {
				String quotientOfDivision = calc.divideHex(decimalOfHexadecimal1, decimalOfHexadecimal2);
				System.out.println("Quotient on division of " + hex1 + " & " + hex2 + " is : " + quotientOfDivision);
				break;				
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}
			
		}		
	}

}
