/**   Policy class to model an insurance policy for one person 
*/
public class Policy
{
   /**   Fields for class use    */
   private String policyNumber;
   private String providerName;
   private String holderFirstName;
   private String holderLastName;
   private int holderAge;
   private String holderSmokingStatus;
   private double holderHeight;
   private double holderWeight;
   
   
   /**  No-arg constructor that initializes all fields.
            Defaults all fields to 0 or blank as necessary, based on data type.
   */ 
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      holderFirstName = "";
      holderLastName = "";
      holderAge = 0;
      holderSmokingStatus = "";
      holderHeight = 0.0;
      holderWeight = 0.0;
   }
   
   /**   Constructor that accepts arguments
            @param   acct        The insurance policy number for the policy holder
            @param   provider    The name of the provider of the insurance policy
            @param   first       The first name of the policy holder
            @param   last        The last name of the policy holder
            @param   age         The age of the policy holder
            @param   smoke       The smoking status of the policy holder ("smoker" or "non-smoker")
            @param   height      The height of the policy holder
            @param   weight      The weight of the policy holder
   */
   public Policy(String acct, String provider, String first, String last, int age,
                     String smoke, double height, double weight)
   {
      policyNumber = acct;
      providerName = provider;
      holderFirstName = first;
      holderLastName = last;
      holderAge = age;
      holderSmokingStatus = smoke;
      holderHeight = height;
      holderWeight = weight;
   }
   
   /**   *****    Mutator (setter) methods    *****   */
   
   /**   Mutator (setter) method to set policy number
            @param   acct        The insurance policy number of the policy holder
   */
   public void setPolicyNumber(String acct)
   {
      policyNumber = acct;
   }  
   
   /**   Mutator (setter) method to set provider name
            @param   provider    The name of the provider of the insurance policy
   */
   public void setProviderName(String provider)
   {
      providerName = provider;
   }
   
   /**   Mutator (setter) method to set policy holder's name
            @param   first       The first name of the policy holder
   */
   public void setHolderFirstName(String first)
   {
      holderFirstName = first;
   }
   
   /**   Mutator (setter) method to set policy holder's last name
            @param   last        The last name of the policy holder
   */
   public void setHolderLastName(String last)
   {
      holderLastName = last;
   }
   
   /**   Mutator (setter) method to set policy holder's age
            @param   age         The age of the policy holder
   */
   public void setHolderAge(int age)
   {
      holderAge = age;
   }
   
   /**   Mutator (setter) method to set policy holder's smoking status
            @param   smoke       The smoking status (smoker/non-smoker) of policy holder
   */
   public void setHolderSmokingStatus(String smoke)
   {
      holderSmokingStatus = smoke;
   }
   
   /**   Mutator (setter) method to set policy holder's height
            @param   height      The height of the policy holder
   */
   public void setHolderHeight(double height)
   {
      holderHeight = height;
   }
   
   /**   Mutator (setter) method to set policy holder's weight
            @param   weight      The weight of the policy holder
   */
   public void setHolderWeight(double weight)
   {
      holderWeight = weight;
   }
   
   
   /**   *****    Accessor (getter) methods     *****       */
   
   /**   Accessor (getter) method to get policy holder's policy number
            @return  The policy holder's insurance policy number
   */
   public String getPolicyNumber()
   {
      return policyNumber;
   }
   
   /**   Accessor (getter) method to get insurance provider's name
            @return  The policy holder's insurance provider name
   */
   public String getProviderName()
   {
      return providerName;
   }
   
   /**   Accessor (getter) method to get policy holder's first name
            @return  The policy holder's first name
   */
   public String getHolderFirstName()
   {
      return holderFirstName;
   }
   
   /**   Accessor (getter) method to get policy holder's last name
            @return  The policy holder's last name
   */
   public String getHolderLastName()
   {
      return holderLastName;
   }
   
   /**   Accessor (getter) method to get policy holder's age
            @return  The policy holder's age
   */
   public int getHolderAge()
   {
      return holderAge;
   }
   
   /**   Accessor (getter) method to get policy holder's smoking status
            @return  The policy holder's smoking status
   */
   public String getHolderSmokingStatus()
   {
      return holderSmokingStatus;
   }
   
   /**   Accessor (getter) method to get policy holder's height
            @return  The policy holder's height
   */
   public double getHolderHeight()
   {
      return holderHeight;
   }
   
   /**   Accessor (getter) method to get policy holder's weight
            @return  The policy holder's weight
   */
   public double getHolderWeight()
   {
      return holderWeight;
   }
   
   /**   Acccessor (getter) method to calculate and return the BMI of the policy holder
            @return  The policy holder's calculated BMI
   */
   public double getHolderBMI()
   {
      final double CONV_FACTOR = 703;              //Conversion factor for BMI calculation
      //BMI calculation = (Weight * CONV_FACTOR) / (Height * Height)
      return (holderWeight * CONV_FACTOR) / (Math.pow(holderHeight,2));
   }
   
   /**   Accessor (getter) method to calculate and return the insurance policy costs
            @return  The policy holder's calculated insurance policy cost
   */
   public double getPolicyCost()
   {
      final double BASE_FEE = 600.0;               //Base rate of policy
      final double ADDL_FEE_AGE = 75.0;            //Additional fee if age over AGE_THRESHOLD
      final double ADDL_FEE_SMOKING = 100.0;       //Additional fee if smoker
      final double ADDL_FEE_PER_BMI = 20;          //Addtional fee if BMI over BMI_THRESHOLD
      
      final int AGE_THRESHOLD = 50;                //Age which additional fee imposed
      final int BMI_THRESHOLD = 35;                //BMI which additional fee imposed
      
      double policyCost = BASE_FEE;                //Total variable set to base rate
      double BMI = getHolderBMI();                 //BMI variable to retrieve BMI calculation
      
      if(holderAge > AGE_THRESHOLD)
         policyCost += ADDL_FEE_AGE;
      if(holderSmokingStatus.equalsIgnoreCase("smoker"))
         policyCost += ADDL_FEE_SMOKING;
      if(BMI > BMI_THRESHOLD)
         policyCost += ((BMI - BMI_THRESHOLD)*ADDL_FEE_PER_BMI);
      
      return policyCost; 
   }
   
}
