public class PolicyHolder
{
   /**   Fields for class     */
   private String holderFirstName;
   private String holderLastName;
   private int holderAge;
   private String holderSmokingStatus;
   private double holderHeight;
   private double holderWeight;
   
   /**  No-arg constructor that initializes all fields.
            Defaults all fields to 0 or blank as necessary, based on data type.
   */ 
   public PolicyHolder()
   {
      holderFirstName = "";
      holderLastName = "";
      holderAge = 0;
      holderSmokingStatus = "";
      holderHeight = 0.0;
      holderWeight = 0.0;
   }
   
   /**   Constructor that accepts arguments
            @param   first       The first name of the policy holder
            @param   last        The last name of the policy holder
            @param   age         The age of the policy holder
            @param   smoke       The smoking status of the policy holder ("smoker" or "non-smoker")
            @param   height      The height of the policy holder
            @param   weight      The weight of the policy holder
   */
   public PolicyHolder(String first, String last, int age, String smoke, double height, double weight)
   {
      holderFirstName = first;
      holderLastName = last;
      holderAge = age;
      holderSmokingStatus = smoke;
      holderHeight = height;
      holderWeight = weight;
   
   }



   /**   *****    Mutator (setter) methods    *****   */

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


   /**   Accessor method toString for display of policyholder information
      @return - A string containing the policyholder information
   */
   public String toString()
   {
      return String.format("Policyholder's First Name: %s\n", holderFirstName +
                           "Policyholder's Last Name: %s\n", holderLastName +
                           "Policyholder's Age: %d\n",holderAge +
                           "Policyholder's Smoking Status (Y/N): %s\n", holderSmokingStatus +
                           "Policyholder's Height: %.1f inches", holderHeight +
                           "Policyholder's Weight: %.1f pounds", holderWeight +
                           "Policyholder's BMI: %.2f", getHolderBMI());
   
   }


}