import java.util.Scanner;
public class financialCalculator {

	public static void main(String[] args) {
		/*this program is a financial calculator; using several user inputed financial 
		 * it returns the amount a user must save each month to retire given the 
		 * expected conditions
		 * variables:
		 * socialSecuirty (float)- the amount of social security expected
		 * yearsRetired (float)-number of years expected to be retired for
		 * retiredRate (float)- interest rate while retired domain: [0,3]
		 * requiredIncome (float)- monthly amount required to retire comfortably
		 * yearsToWork (floats)- number of years left to work
		 * interestRate (float)- interest rate while working domain: [0,20]
		 * outputs:
		 * presentValue (float)-the present value of an annuity to comfortably retire 
		 * bought on the last day of work
		 * monthlySavings (float)- amount needed to save each day to buy said annuity  */
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the expected social secuity:  ");
		double socialSecurity = input.nextDouble();
		byte x = 0;
		while (x==0){
			if (socialSecurity >= 0 && socialSecurity <=2642){
				x++;
			}
			else{
				System.out.print("Invalid value. Enter valid social secuity amount:  ");
				socialSecurity = input.nextDouble();
			}
		}
		System.out.print("Enter the expected years retired:  ");
		double yearsRetired = (input.nextDouble()*12);
		byte y = 0;
		while (y==0){
			if (yearsRetired >= 0){
				y++;
			}
			else{
				System.out.print("Invalid value. Enter valid number of years retired:  ");
				yearsRetired = input.nextDouble();
			}
		}	
		System.out.print("Enter the expected interest rate when retired (1 corresponds to 1%- enter a number between 0 and 3):  ");
		double retiredRate = input.nextDouble();
		byte z = 0;
		while (z==0){
			if (retiredRate >= 0 && retiredRate <=3){
				z++;
			}
			else{
				System.out.print("Invalid value. Enter valid retired interest rate:  ");
				retiredRate = input.nextDouble();
			}
		}
		retiredRate = retiredRate/1200;
		System.out.print("Enter the expected monthly income needed in retiremnt:  ");
		double requiredIncome = input.nextDouble();
		byte a = 0;
		while (a==0){
			if (requiredIncome >= 0){
				a++;
			}
			else{
				System.out.print("Invalid value. Enter valid required income:  ");
				requiredIncome = input.nextDouble();
			}
		}
		requiredIncome = requiredIncome - socialSecurity;
		if( requiredIncome < 0){
			requiredIncome = 0;
		}
		System.out.print("Enter the years expected to work:  ");
		double yearsToWork = (input.nextDouble()*12);
		byte b = 0;
		while (b==0){
			if (yearsToWork >= 0){
				b++;
			}
			else{
				System.out.print("Invalid value. Enter valid required income:  ");
				yearsToWork = input.nextDouble();
			}
		}
		System.out.print("Enter the expected interest rate when working (1 corresponds to 1%- enter a number between 0 and 20):  ");
		double interestRate = input.nextDouble();
		byte c = 0;
		while (c==0){
			if (interestRate >= 0 && interestRate <=20){
				c++;
			}
			else{
				System.out.print("Invalid value. Enter valid interest rate:  ");
				interestRate = input.nextDouble();
			}
		}
		interestRate = interestRate/1200;
		double presentValue = 0 ;
		long j = 0 ;
		while (j < yearsRetired){
			presentValue = presentValue + requiredIncome/(Math.pow((1.0 + retiredRate), j));
		j++;
		}
		double monthlySavings;
		long k = 0;
		double interestMultiplier = 0;
		while (k < yearsToWork){
			interestMultiplier = interestMultiplier + (Math.pow((1.0+interestRate), k));
			k++;
		}
		monthlySavings = presentValue/interestMultiplier;
		System.out.println("You need to save " + presentValue + " in total, and " + monthlySavings + " a month");
		}
}