import java.util.Scanner;


public class CalorieCalculator {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);	


		String decision2 = null;
		int error1 = 0;
		int error2 = 0;

		System.out.println("Hello! I am the Calorie Bot!");
		System.out.println("It is my job to help you find figure out how many calories you should be eating a day.");
		


			System.out.println("Are you male or female?");		
			sex sex1 = new sex(input.nextLine());

			System.out.println("How old are you?");		
			age age1 = new age(input.nextInt());

			System.out.println("How tall are you in inches?");		
			height height1 = new height(input.nextInt());

			System.out.println("What is your weight in lbs?");		
			weight weight1 = new weight(input.nextInt());

			System.out.println("How active are you?");
			System.out.println("Low, Medium, High");		
			activity activity1 = new activity(input.next());


			//convert height and weight to cm and kg

			//use first three formulas from https://www.livestrong.com/article/178764-caloric-intake-formula/

			//find average caloric intake from three (this is maintenance calories)

			System.out.println("What is your weight goal?");
			System.out.println("Gain, Lose, Stay the same");	

			String goal = input.nextLine();

			//if goal is gain, suggest to eat 300 calories above maintenance

			//if goal is lose, suggest to eat 300 calories below maintenance

			//if goal is to stay the same, suggest to eat maintenance

			//print out how much they should eat a day



		
	}	

}
