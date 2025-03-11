import java.util.Scanner;           //imports the Scanner class folder for keyboard inputs

/**   Demo class for entering insurance policy data and running calculations
*/
public class Project_daniel_simpson
{
   public static void main(String[] args)
   {
      //Set variables to collect data
      int age;
      String policyNumber, providerName, firstName, lastName, smokingStatus;
      double height, weight;
      
      //Create variable for Scanner class to collect inputs
      Scanner keyboard = new Scanner(System.in);
      
      //Ask user for inputs
      System.out.print("Please enter the Policy Number: ");
      policyNumber = keyboard.nextLine();
      
      System.out.print("Please enter the Provider Name: ");
      providerName = keyboard.nextLine();
      
      System.out.print("Please enter the Policyholder's First Name: ");
      firstName = keyboard.nextLine();
      
      System.out.print("Please enter the Policyholder's Last Name: ");
      lastName = keyboard.nextLine();
      
      System.out.print("Please enter the Policyholder's Age: ");
      age = keyboard.nextInt();
      keyboard.nextLine();             //Clears empty space in Scanner log
      
      System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
      smokingStatus = keyboard.nextLine();
      
      System.out.print("Please enter the Policyholder's Height (in inches): ");
      height = keyboard.nextDouble();
      
      System.out.print("Please enter the Policyholder's Weight (in pounds): ");
      weight = keyboard.nextDouble();
      
      //Create instance of Policy class using constructor with arguments
      Policy userPolicy = new Policy(policyNumber, providerName, firstName, lastName, age, 
                                       smokingStatus, height, weight);
      
      //Display policy information
      System.out.printf("\nPolicy Number: %d\n", userPolicy.getPolicyNumber());
      System.out.printf("Provider Name: %s\n", userPolicy.getProviderName());
      System.out.printf("Policyholder's First Name: %s\n", userPolicy.getHolderFirstName());
      System.out.printf("Policyholder's Last Name: %s\n", userPolicy.getHolderLastName());
      System.out.printf("Policyholder's Age: %d\n", userPolicy.getHolderAge());
      System.out.printf("Policyholder's Smoking Status: %s\n", userPolicy.getHolderSmokingStatus());
      System.out.printf("Policyholder's Height: %.1f inches\n", userPolicy.getHolderHeight());
      System.out.printf("Policyholder's Weight: %.1f pounds\n", userPolicy.getHolderWeight());
      System.out.printf("Policyholder's BMI: %.2f\n", userPolicy.getHolderBMI());
      System.out.printf("Policy Price: $%.2f", userPolicy.getPolicyCost());
   }
}