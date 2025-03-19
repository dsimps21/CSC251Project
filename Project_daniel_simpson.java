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
      int age, smoker = 0, nonSmoker = 0;
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
         
         //Use for loop to display contents of ArrayList for policy holders
         for(int i = 0; i < policyArray.size(); i++)
         {
            //Display policy holder information
            System.out.printf("\nPolicy Number: %s\n", policyArray.get(i).getPolicyNumber());
            System.out.printf("Provider Name: %s\n", policyArray.get(i).getProviderName());
            System.out.printf("Policyholder's First Name: %s\n", policyArray.get(i).getHolderFirstName());
            System.out.printf("Policyholder's Last Name: %s\n", policyArray.get(i).getHolderLastName());
            System.out.printf("Policyholder's Age: %d\n", policyArray.get(i).getHolderAge());
            
            //Create variable to hold smoker status and gather data from array
            String smokerStat = policyArray.get(i).getHolderSmokingStatus();
            
            //Continue display of policy holder information
            System.out.printf("Policyholder's Smoking Status (smoker/non-smoker): %s\n", smokerStat);
            System.out.printf("Policyholder's Height: %.1f inches\n", policyArray.get(i).getHolderHeight());
            System.out.printf("Policyholder's Weight: %.1f pounds\n", policyArray.get(i).getHolderWeight());
            System.out.printf("Policyholder's BMI: %.2f\n", policyArray.get(i).getHolderBMI());
            System.out.printf("Policy Price: $%.2f\n", policyArray.get(i).getPolicyCost());
            
            //Empty space between policy information and totals
            System.out.println();
            
            //Setup accumulator for smoker & non-smoker policies
            if(smokerStat.equalsIgnoreCase("smoker"))
               smoker ++;
            else
               nonSmoker ++;

         }
         
         //Display number of policies for smokers and non-smokers
         System.out.println("The number of policies with a smoker is: " + smoker);
         System.out.println("The number of policies with a non-smoker is: " + nonSmoker);
                  
         
      }//Close try method
      
      catch(IOException ex)
      {
         //Display error message for IOException
         System.out.println("Something went wrong reading the file: " + ex.getMessage());
      }
   }
}