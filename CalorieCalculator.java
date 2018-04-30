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
		int heightInCm = (int) (height1.height * 2.54);
		int weightInKg = (int) (weight1.weight * 0.453592);

		//use first three formulas from https://www.livestrong.com/article/178764-caloric-intake-formula/
		int intake1 = 0;
		int intake2 = 0; 
		int intake3 = 0; 

		if (sex1.sex.equalsIgnoreCase("male"))
		{
			if (activity1.activity.equalsIgnoreCase("low"))
			{			
			intake1 = (int) ((66.5 + (13.8 * weightInKg) + (5 * heightInCm) - (6.8 * age1.age))*1.2);
			intake2 = (int) ((15.3 * weightInKg + 679)*1.2);
			intake3 = (int) (((10 * weightInKg) + (6.25 * heightInCm) - (5 * age1.age + 5))*1.2);
			}
			
			else if (activity1.activity.equalsIgnoreCase("medium"))
			{			
			intake1 = (int) ((66.5 + (13.8 * weightInKg) + (5 * heightInCm) - (6.8 * age1.age))*1.3);
			intake2 = (int) ((15.3 * weightInKg + 679)*1.3);
			intake3 = (int) (((10 * weightInKg) + (6.25 * heightInCm) - (5 * age1.age + 5))*1.3);
			}
			
			else
			{			
			intake1 = (int) ((66.5 + (13.8 * weightInKg) + (5 * heightInCm) - (6.8 * age1.age))*1.4);
			intake2 = (int) ((15.3 * weightInKg + 679)*1.4);
			intake3 = (int) (((10 * weightInKg) + (6.25 * heightInCm) - (5 * age1.age + 5))*1.4);
			}
			
		}	
		else
		{
			if (activity1.activity.equalsIgnoreCase("low"))
			{
			intake1 = (int) (((665.1 + 9.6 *weightInKg) + (1.9 *heightInCm) - (4.7 * age1.age))*1.2);
			intake2 = (int) ((14.7 * weightInKg + 496)*1.2);
			intake3 = (int) (((10 * weightInKg) + (6.25 * heightInCm) - (5 * age1.age) - 161)*1.2);
			}
			
			else if (activity1.activity.equalsIgnoreCase("medium"))
			{
			intake1 = (int) (((665.1 + 9.6 *weightInKg) + (1.9 *heightInCm) - (4.7 * age1.age))*1.2);
			intake2 = (int) ((14.7 * weightInKg + 496)*1.3);
			intake3 = (int) (((10 * weightInKg) + (6.25 * heightInCm) - (5 * age1.age) - 161)*1.2);
			}
			
			else
			{
			intake1 = (int) (((665.1 + 9.6 *weightInKg) + (1.9 *heightInCm) - (4.7 * age1.age))*1.4);
			intake2 = (int) ((14.7 * weightInKg + 496)*1.4);
			intake3 = (int) (((10 * weightInKg) + (6.25 * heightInCm) - (5 * age1.age) - 161)*1.4);
			}
		}

		//find average caloric intake from three (this is maintenance calories)
		int avgIntake = (intake1 + intake2 + intake3)/3;

		System.out.println("To maintain your current weight, you should eat " +avgIntake +" calories a day");


		System.out.println("What is your weight goal?");
		System.out.println("'Gain', 'Lose', or 'Stay'?");	

		String goal = input.next();

		while (error1 == 0)
		{
			//if goal is gain, suggest to eat 300 calories above maintenance
			if (goal.equalsIgnoreCase("gain"))
			{
				int desiredIntake1 = avgIntake+300;
				System.out.println("You should eat " +desiredIntake1  +" calories a day to gain one lb a week.");
				error1 = 1;
			}

			//if goal is lose, suggest to eat 300 calories below maintenance
			else if (goal.equalsIgnoreCase("lose"))
			{
				int desiredIntake2 = avgIntake-300;
				System.out.println("You should eat " +desiredIntake2  +" calories a day to lose one lb a week.");
				error1 = 1;

			}

			//if goal is to stay the same, suggest to eat maintenance
			else if (goal.equalsIgnoreCase("stay"))
			{
				System.out.println(" You should eat " +avgIntake  + " calories a day to maintain your current weight.");
				error1 = 1;

			}

			else
			{
				System.out.println("Your goal was not recognized. Plejase try again.");
			}
		}

	}	

}