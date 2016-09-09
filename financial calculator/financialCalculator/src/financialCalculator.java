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
		System.out.print("Enter the expected years retired:  ");
		double yearsRetired = (input.nextDouble()*12);
		System.out.print("Enter the expected interest rate when retired (1 corresponds to 1%- enter a number between 0 and 3):  ");
		double retiredRate = (input.nextDouble())/(100*12);
		System.out.print("Enter the expected monthly income needed in retiremnt:  ");
		double requiredIncome = (input.nextDouble() - socialSecurity);
		System.out.print("Enter the years expected to work:  ");
		double yearsToWork = (input.nextDouble()*12);
		System.out.print("Enter the expected interest rate when working (1 corresponds to 1%- enter a number between 0 and 20):  ");
		double interestRate = (input.nextDouble()/(100*12));
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
		System.out.println(presentValue + "and" + monthlySavings);
	}

}
