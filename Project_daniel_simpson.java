import java.util.Scanner;           //imports the Scanner class folder for keyboard inputs
import java.util.ArrayList;         //imports the ArrayList class folder for storing multiple policy data
import java.io.*;                   //imports the IO class to work with file data

/**   Demo class for entering insurance policy data and running calculations
*/
public class Project_daniel_simpson
{
   public static void main(String[] args) throws IOException
   {
      //Set variables to collect data
      int age, numSmokers = 0, countPolicies=0;
      String policyNumber, providerName, firstName, lastName, smokingStatus;
      double height, weight;
      
      //Constant for file name
      final String fileName = "PolicyInformation.txt";
         
      //Create File class object to obtain data
      File readFile = new File(fileName);
      
      //Create Scanner class object to collect data from file
      Scanner inputFile = new Scanner(readFile);
      
      //Create ArrayList class object to store policy information from Policy class
      ArrayList<Policy> policyArray = new ArrayList<Policy>();
      
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
         
         //Create instance of PolicyHolder class using constructor with arguments
         PolicyHolder holder = new PolicyHolder(firstName, lastName, age, 
                                       smokingStatus, height, weight); 
      
         //Create instance of Policy class using constructor with arguments and PolicyHolder object
         Policy userPolicy = new Policy(policyNumber, providerName, holder);
         
         //Add Policy class information to ArrayList
         policyArray.add(userPolicy);
         
         countPolicies = userPolicy.getPolicyCount();
      } //End of while loop
      
      //Close the file
      inputFile.close();
      
      //Use for loop to display contents of ArrayList for policy holders
      for(int i = 0; i < policyArray.size(); i++)
      {
         //Display policy holder information
         System.out.println(policyArray.get(i));
         
         
         //Empty space between policy information and totals
         System.out.println();
         
         //Setup accumulator for smoker & non-smoker policies
         if(policyArray.get(i).getPolicyHolder().getHolderSmokingStatus().equalsIgnoreCase("smoker"))
            numSmokers++;

      }
      
      //Display number of policies total, number of smokers, and number of non-smokers
      System.out.printf("There were %d Policy objects created.\n", countPolicies); 
      System.out.println("The number of policies with a smoker is: " + numSmokers);
      System.out.println("The number of policies with a non-smoker is: " + 
                           (policyArray.size() - numSmokers));
                  
         
      

   }
}