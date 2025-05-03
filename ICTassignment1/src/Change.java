/**
 *@author    Khon Min Thite    khonminthite@gamil.com
 *@version   1.1               (current version of the program)
 */
public class Change {
	/**
	 * The name of the person.
	 */
	private String name;
	/**
	 * The amount of coins
	 */
	private int coinAmount;
	/**
	 * Singapore coin denominations( 1 dollar, fifty cent, twenty cent, ten cent, five cent )
	 */
	private int dollar,fiftyCent,twentyCent,tenCent,fiveCent;
	/**
	 * default constructor
	 * <p>
	 * This class is used to represent a default Change object with name as "no name" and coinAmount as "0".
	 * </p>
	 * <p>
	 * precondition: nil<br>
	 * postcondition: a Change object is created with assigned default value.
	 * </p>
	 */
	public Change() {
		this.name = "no name";
		this.coinAmount = 0;
	}
	
    /**
	 * constructor for Change class
	 * <p>
	 * This class is used to represent a Change object with name and coinAmount.
	 * </p>
	 * <p>
     * precondition:<br>
     * - Name and coinAmount should be valid data.<br>
     * post-condition:<br>
     * - A new Change object is created<br>
     * - It calculate the change for the given 'coinAmount' and display the Change object together with coin denominations. 
     * </p>
     * @param name The name of the person
     * @param coinAmount The amount of coins
     * @return change A new Change object 
     */
    private Change(String name,int coinAmount) {
	 this.name = name;
     this.coinAmount = coinAmount;
     calculateChange();
	 }
    /**
	 * This method is used to create a Change object with valid name and valid coinAmount .
	 * <p>
     * precondition:
     * - user create a new object passing through name and coinAmount.<br>
     * - name should be one string word.<br>
     * post-condition:<br>
     * - Validates coinAmount to determine if it is a multiple of 5 and more than 0, and if it is, it creates a Change object.
     * </p>
     * @param name The name of the person
     * @param coinAmount The amount of coins
     * @return change A new Change object 
     */
    public static Change createChange(String name, int coinAmount) {
        if (coinAmount % 5 != 0 || coinAmount < 0) {
            System.out.println("Incorrect coin value. Must be a multiple of 5 and greater than 0.");
            return null;
         } else {
            return new Change(name, coinAmount);
         }
    }
    /**
	 * This method is used to get the name of the person.
	 * <p>
     * precondition:nil<br>
     * postcondition: The name of the person is returned.
     * </p>
     * @return name Return the name of the person
     */
	public String getName() {
		return name;
	}
    /**
    * This method is used to set the name of the person.
    * <p>
    * precondition: name is initialized at the constructor<br>
    * postcondition:The name of the person is returned.
    *</p>
    *@param name the name of the person 
    *@return name return the name of the person
    */
	public void setName(String name) {
		this.name = name;
	}
    /**
	 * This method is used to get the amount of coins.
	 * <p>
     * precondition:nil<br>
     * postcondition: The amount of coins is returned.
     * </p>
     * @return coinAmount Return the amount of coins
     */
	public int getCoinAmount() {
		return coinAmount;
	}
    /**
    * This method is used to set the amount of coins.
    * <p>
    * precondition: coinAmount is initialized at the constructor.<br>
    * postcondition: Validates coinAmount to determine if it is a multiple of 5 and more than 0, and if it is,
    * the amount of coins is returned.
    *</p>
    *@param coinAmount the amount of coins
    *@return coinAmount return the amount of coins
    */
	public void setCoinAmount(int coinAmount) {
        if (coinAmount % 5 != 0 || coinAmount < 0) {
            System.out.println("Incorrect coin value. Must be a multiple of 5 and greater than 0.");
        } else {
		this.coinAmount = coinAmount;
        }
	}
    /**
	 * This method is used to get the number of dollars.
	 * <p>
     * precondition:nil<br>
     * postcondition: the number of dollars is returned.
     * </p>
     * @return dollar Return the number of dollars
     */
	public int getDollar() {
		return dollar;
	}
    /**
	 * This method is used to get the number of fifty-cent coins.
	 * <p>
     * precondition:nil<br>
     * postcondition: The number of fifty-cent coins is returned.
     * </p>
     * @return fiftyCent Return the number of fifty-cent coins
     */
	public int getFiftyCent() {
		return fiftyCent;
	}
    /**
	 * This method is used to get the number of twenty-cent coins .
	 * <p>
     * precondition:nil<br>
     * postcondition: The number of twenty-cent coins is returned.
     * </p>
     * @return twentyCent Return the number of twenty-cent coins
     */
	public int getTwentyCent() {
		return twentyCent;
	}
    /**
	 * This method is used to get the number of ten-cent coins.
	 * <p>
     * precondition:nil<br>
     * postcondition: The number of ten-cent coins is returned.
     * </p>
     * @return tenCent Return the number of ten-cent coins
     */
	public int getTenCent() {
		return tenCent;
	}
    /**
	 * This method is used to get the number of five-cent coins.
	 * <p>
     * precondition:nil<br>
     * postcondition: The number of five-cent coins is returned.
     * </p>
     * @return fiveCent Return the number of five-cent coins
     */
	public int getFiveCent() {
		return fiveCent;
	}
 
	/**
	 * This method is used to calculate the change for given coinAmount.
	 * <p>
	 * Precondition:<br>
	 * - The variable 'coinAmount' must be a non negative integer that is divisible by 5.<br>
	 * post-condition:<br>
	 * - The instance variables 'dollar', 'fiftyCent', 'twentyCent', 'tenCent', and 'fiveCent'
     * will be updated to store the number of dollars, fifty-cent coins, twenty-cent coins,
     * ten-cent coins, and five-cent coins, respectively, needed to represent the change for
     * the given 'coinAmount'. 
     * </p>
     *@param coinAmount The amount of coins
     *@return dollar Return the number of dollars
     *@return fiftyCent Return the number of fifty-cent coins
     *@return twentyCent Return the number of twenty-cent coins
     *@return tenCent Return the number of ten-cent coins
     *@return fiveCent Return the number of five-cent coins
	 */
	private void calculateChange() {
        int cents = coinAmount;

        dollar = cents / 100;
        cents %= 100;// Update cents to the remaining amount

        fiftyCent = cents / 50;
        cents %= 50;

        twentyCent = cents / 20;
        cents %= 20;

        tenCent = cents / 10;
        cents %= 10;

        fiveCent = cents / 5;
    }
	
	/**
	 * This method constructs a formatted string representing the customer's change details.
	 * <p>
	 * Precondition: <br>
	 * - The instance variables name, coinAmount, dollar, fiftyCent, twentyCent, tenCent, and fiveCent
	 * should be properly initialized.<br>
	 * Postcondition:<br>
	 * - Returns a formatted string containing the customer's name, total coin amount,
	 *   and a breakdown of their change in dollars, fifty cents, twenty cents, ten cents, and five cents.
	 * </p>
	 * @return return a string representation of the customer's change details
	 */
    @Override
    public String toString() {
    	 // Create a StringBuilder to construct the output string
        StringBuilder output = new StringBuilder("Customer:"+"\n" + name +" "+ coinAmount +" cents"+":\n");
        output.append("Change: ").append("\n");
        // Check if there are dollars in the change and include them in the output
        // Do the same for fiftyCent,twentyCent,tenCent,fiveCent
        if (dollar > 0) {
            output.append("$1(100 cents): ").append(dollar).append("\n");
        }
        if (fiftyCent > 0) {
            output.append("50 cents: ").append(fiftyCent).append("\n");
        }
        if (twentyCent> 0) {
            output.append("20 cents: ").append(twentyCent).append("\n");
        }
        if (tenCent > 0) {
            output.append("10 cents: ").append(tenCent).append("\n");
        }
        if (fiveCent > 0) {
            output.append("5 cents: ").append(fiveCent).append("\n");
        }

     // Convert the StringBuilder to a String and return the final result
        return output.toString();
    }
    
    /**
     * This method calculates the total coin amounts for each unique name in the given array of Change objects.
     * <p>
     * Precondition:<br>
	 * - 'change' array must not be null, and it should contain valid Change objects.<br>
     * Postcondition: <br>
     * - The 'change' array will be modified in-place with updated coin amounts for each unique name.
     * </p> 
     * @param change An array of Change objects.
     * @return change[]:return an array of Change object with each unique name and their updated coinAmount
     */
	public static void calculateTotalAmounts(Change[] change) {
	    // Check if the input array is null
	    if (change == null) {
	        return;// If null, exit the method
	    }
	    // Create an array to store total amounts for each unique name
	    int[] totalAmounts = new int[change.length];
       // Initialize a boolean array to keep track of processed entries
	    boolean[] processed = new boolean[change.length];
	    // Iterate through the Change objects
	    for (int i = 0; i < change.length; i++) {
	        Change currentChange = change[i];
	        // Check if the currentChange is null
	        if (currentChange == null) {
	            continue;
	        }
	        if (!processed[i]) {
	            String name = currentChange.getName();
	            int totalAmount = currentChange.getCoinAmount();
	            // Check for other entries with the same name and aggregate their amounts
	            for (int j = i + 1; j < change.length; j++) {
	                Change otherChange = change[j];
	                // Check if the otherChange is null
	                if (otherChange == null) {
	                    continue;
	                }
	                // Check if the other entry has the same name
	                if (!processed[j] && name.equals(otherChange.getName())) {
	                    totalAmount += otherChange.getCoinAmount();
	                    processed[j] = true;
	                }
	            }
	            // Store the total amount for the current name in the array
	            totalAmounts[i] = totalAmount;
	            // Update the coinAmount of the currentChange with the total amount
	            currentChange.setCoinAmount(totalAmount);
	        }
	    }
	}
}

