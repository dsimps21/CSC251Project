import java.util.Scanner;           //imports the Scanner class folder for keyboard inputs
import java.util.ArrayList;         //imports the ArrayList class folder for storing multiple policy data
import java.io.*;                   //imports the IO class to work with file data

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
      
      //Constant for file name
      final String fileName = "PolicyInformation.txt";
      
      //Use try method to open file and process data
      try
      {   
         //Create File class object to obtain data
         File readFile = new File(fileName);
         
         //Create Scanner class object to collect data from file
         Scanner inputFile = new Scanner(readFile);
         
         //Create ArrayList class object to store policy information from Policy class
         ArrayList<Policy> policyArray = new ArrayList<>();
         
         //Read file data using while loop. hasNext method will ensure data collected until end of file
         while(inputFile.hasNext())
         {
            policyNumber = inputFile.nextLine();
            providerName = inputFile.nextLine();
            firstName = inputFile.nextLine();
            lastName = inputFile.nextLine();
            age = inputFile.nextInt();
            
            //Clear empty space in Scanner log
            inputFile.nextLine();
            
            smokingStatus = inputFile.nextLine();
            height = inputFile.nextDouble();
            weight = inputFile.nextDouble();
            
            /* Skip any empty cells and clear empty space in Scanner log. 
                  Perform only if data still remains in file.
            */
            if(inputFile.hasNext())
            {
               inputFile.nextLine();
               inputFile.nextLine();
            } 
         
            //Create instance of Policy class using constructor with arguments
            Policy userPolicy = new Policy(policyNumber, providerName, firstName, lastName, age, 
                                          smokingStatus, height, weight);
            
            //Add Policy class information to ArrayList
            policyArray.add(userPolicy);
         } //End of while loop
         
         //Close the file
         inputFile.close();
         
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
         
         
         
      }//Close try method
      
      catch(IOException ex)
      {
         //Display error message for IOException
         System.out.println("Something went wrong reading the file: " + ex.getMessage());
      }
   }
}