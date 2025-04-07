/**   Policy class to model an insurance policy for one person 
*/
public class Policy
{
   /**   Fields for class use    */
   private String policyNumber;
   private String providerName;
   
   
   /**  No-arg constructor that initializes all fields.
            Defaults all fields to 0 or blank as necessary, based on data type.
   */ 
   public Policy()
   {
      policyNumber = "";
      providerName = "";
      
   }
   
   /**   Constructor that accepts arguments
            @param   acct        The insurance policy number for the policy holder
            @param   provider    The name of the provider of the insurance policy
   */
   public Policy(String acct, String provider)
   {
      policyNumber = acct;
      providerName = provider;
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
