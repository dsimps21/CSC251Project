/**   Policy class to model an insurance policy for one person 
*/
public class Policy
{
   /**   Fields for class use    */
   private String policyNumber;
   private String providerName;
   private PolicyHolder policyHolder;        //Instance of the PolicyHolder class
   private static int policyCount = 0;
   
   
   /**  No-arg constructor that initializes all fields.
            Defaults all fields to 0 or blank as necessary, based on data type.
   */ 
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      policyHolder = new PolicyHolder();
      policyCount++;
      
   }
   
   /**   Constructor that accepts arguments
            @param   acct        The insurance policy number for the policy holder
            @param   provider    The name of the provider of the insurance policy
            @param   insured     A PolicyHolder object for the insured holder
   */
   public Policy(String acct, String provider, PolicyHolder insured)
   {
      policyNumber = acct;
      providerName = provider;
      policyHolder = new PolicyHolder(insured);
      policyCount++;
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
   
   /**   Mutator (setter) method to set PolicyHolder object
            @param   insured     PolicyHolder object for the insured holder
   */
   public void setPolicyHolder(PolicyHolder insured)
   {
      policyHolder = new PolicyHolder(insured);
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
   
   /**   Accessor (getter) method to return reference to copy of PolicyHolder object
            @return  Reference to copy of this policy's PolicyHolder object
   */
   public PolicyHolder getPolicyHolder()
   {
      return new PolicyHolder(policyHolder);
   }
   
   
   
   /**   Accessor (getter) method to return number of policies created
            @return  Number of policies objects created
   */
   public int getPolicyCount()
   {
      return policyCount;
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
      double BMI = policyHolder.getHolderBMI();    //BMI variable to retrieve BMI calculation
      
      if(policyHolder.getHolderAge() > AGE_THRESHOLD)
         policyCost += ADDL_FEE_AGE;
      if(policyHolder.getHolderSmokingStatus().equalsIgnoreCase("smoker"))
         policyCost += ADDL_FEE_SMOKING;
      if(BMI > BMI_THRESHOLD)
         policyCost += ((BMI - BMI_THRESHOLD)*ADDL_FEE_PER_BMI);
      
      return policyCost; 
   }
   
   
   /**   Accessor method toString for display of policy information
      @return - A string containing the policy information
   */
   public String toString()
   {
      return String.format("Policy Number: %s\n" +  
                           "Provider Name: %s\n" +  
                           policyHolder.toString() +
                           "Policy Price: $%.2f\n", policyNumber, providerName, getPolicyCost());
   }
   
}
