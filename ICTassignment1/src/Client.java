import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		boolean carryOn = true;
		int choice =0;
		while(carryOn) {
		//Display menu
		System.out.println("Welcome to coin denomination program.");
		System.out.println("1. Input your own data.\n"+
		                   "2. Use existing data.\n"+
				           "3. Student information\n"+
		                   "4. Quit.");
        //Asking user to make choice
         choice = getInt("Enter (1,2,3,4): "); 
		 switch(choice){
		//Represents a situation where a menu-driven program is executed with
		// user input to initialize an array of Change objects.
		 case 1:situation1(); ; break;
		//Represents a situation where a menu-driven program is executed with
		 //a pre-initialized array of Change objects
		 case 2:;situation2(); ; break;
		 case 3:;studentInfo(); ; break;
		 case 4:; System.out.println("Fare well."); 
	     carryOn = false; break;
	  // Display an error message for an invalid choice
		 default :System.out.println("Invalid choice");
         }	
		 System.out.println("End of Program...");	
		}
    }
     
	//helper method
	/**
	 * This method reads an integer value from the standard input and returns it.
	 * <p>
	 * Precondition: <br>
	 *   - The method is called with a non-null 'message' parameter.<br>
	 *   - The input value provided by the user is a integer without leading or trailing whitespace.<br>
	 *   Postconditions:<br>
     *   - Prints 'message' to the console.<br>
     *   - Reads and returns a user-provided integer.
     *   </p>
     * @param message The message to display as a prompt for the user's input.
     * @return integer return the integer value read from the user's input.
	 */
	public static int getInt(String message) {
		Scanner kb = new Scanner(System.in);
			System.out.print(message);
			int value =kb.nextInt();
			return value;	
	}

	/**
	 * This method reads an string value from the standard input and returns it.
	 * <p>
	 * Precondition: <br>
	 *   - The method is called with a non-null 'message' parameter.<br>
	 *   - The input value provided by the user is a one word string without leading or trailing whitespace.<br>
	 *   Postconditions:<br>
     *   - Prints 'message' to the console.<br>
     *   - Reads and returns a user-provided string.
     *   </p>
     * @param message The message to display as a prompt for the user's input.
     * @return String return the string value read from the user's input.
	 */
	public static String getString(String message) {
		Scanner kb = new Scanner(System.in);
			System.out.print(message);
			String value =kb.next();
			return value;	
	}
	
	/**
	 * This method initializes an array of Change objects with specific names and coin amounts.
	 * <p>
	 * Precondition: <br>
	 * - The 'change' array is a valid array of Change objects.<br>
	 * Post-condition: <br>
	 * - array 'change' will contain 10 Change objects with specific names and coinAmounts assigned to them.
	 * </p>
	 * @param change An array of Change objects
	 * @return  An array of Change objects
	 */
    private static void initializeChangeObjects(Change[] change) {
        change[0] =Change.createChange("John", 50);
        change[1] =Change.createChange("Jane", 30);
        change[2] =Change.createChange("John", 70);
        change[3] =Change.createChange("Henry", 10);
        change[4] =Change.createChange("Ahri", 100);
        change[5] =Change.createChange("Lux", 90);      
        change[6] =Change.createChange("Garen", 53 );
        change[7] =Change.createChange("Micky", 15 );
        change[8] =Change.createChange("Ghost", -40 );
        change[9] =Change.createChange("Micky", 70 );
    }
    
     /**
     * This method initializes an array of Change objects based on user input, where the user provides
     * names and coin amounts for each person.
     * <p>
     * Precondition: <br>
     * This method is intended to be executed as part of a menu-driven program
     *  where the user provides input to initialize an array of Change objects. <br>
     *  The user will be prompted to enter the number of persons.<br>
     *  After getting the input from the user,it will create an array whose length is the number of persons.<br> 
     *  Then, the user will be prompted to enter their valid name(one-word strings), and coinAmount for each person.<br>
     *  The coin values should be multiples of 5 and greater than 0.
	 *  Post-condition:<br>
     *  -'changeArray' will be populated with Change objects representing the entered names and coin values.<br>
     *  The program will then calculate the total coin amounts for each unique name in the array and enter
     *  a menu-driven loop where the user can perform various actions on the data.<br> The program continues until
     *  the user chooses to exit, and the method returns once the program is finished.
     *  </p>
	 */
	public static void situation1() {
		    System.out.println("Recommendation: Please enter at least 8 records to test the program.");
			//Prompt the user to enter the number of persons.
	        int numPersons = getInt("Enter the number of persons: ");
	        // Create an array to store Change objects based on the number of persons.
            Change[] changeArray = new Change[numPersons];
	        // Read data for each person and create Change objects.
	        	for(int i = 0; i < numPersons; i++) {
	        	//enter one word string
	            String name = getString("Please enter the name of the person: ");
	            int coinAmount = getInt("Please enter the coin value for the person (multiple of 5): ");
	            // Check if the entered coin amount is a multiple of 5 and greater than 0
	                  if(coinAmount%5 == 0 && coinAmount > 0) { 
	                     // Create a Change object and store it in the array.
		                 changeArray[i] =Change.createChange(name, coinAmount);
	        	      } else {
	        		     System.out.println("Incorrect coin value. Must be multiple of 5.");
	        		     i--; // Decrement i to re-enter data for the same person.
	        	      }

	                  String str = getString("Do you have more person to enter (Y/N): ");
	               // Check if the response is "N" (ignoring case) to exit the loop
	               if (str.equalsIgnoreCase("N")) {
	                   break;
	               } else if (!str.equalsIgnoreCase("Y")) {
	                   System.out.println("Invalid response. Please enter 'Y' or 'N'.");
	                   i--; // Decrement i to re-enter data for the same person.
	               }
	        }
            // Calculate the total coin amounts for each unique name in the array
            Change.calculateTotalAmounts(changeArray);
            menuloop(changeArray);

	}
	
	/**
	 * This method simulates a situation where the program is expected to be executed with existing data.
	 * <p>
	 * Precondition: <br>
	 * This method is expected to be executed when the user use existing data where
	 * an array of Change objects is preinitialized and populated with valid data.<br> The 'initializeChangeObjects'
	 * and 'calculateTotalAmounts' methods should have been called when invoking this method.
	 * Post-condition: <br>
	 * enter a menu-driven loop where the user can perform various actions on the data.<br> The program
     *continues until the user chooses to exit, and the method returns once the program is finished.
     * </p>
	 */
	public static void situation2() {
		// Create an array of Change objects with a size of 100
        Change[] change = new Change[100];
        // Initialize the Change objects in the array
        initializeChangeObjects(change);
        // Calculate the total coin amounts for each unique name in the array
        Change.calculateTotalAmounts(change);
        menuloop(change);     
	}
	
	/**
	 * This method prints information about the student.
	 * <p>
	 * precondition:<br>
	 * - This method is intended to be executed as part of a menu-driven program where
	 * - the user choose the option to print student information.<br>
	 * post-condition:<br>
	 * - display student information(name, student number, mode of enrollment, tutor name, tutorial attendance day and time).
	 * </p>
	 * @return studentInfo return student information
	 */
	public static void studentInfo() {
		System.out.println("Name : Khon Min Thite");
		System.out.println("Student Number: 35141021");
		System.out.println("Mode of enrollment: ICT167 Principles of Computer Science (tsa, 2023)");
		System.out.println("Tutor name: Aaron Yeo");
		System.out.println("Tutorial attendance day and time: ");
		System.out.println();
	}
    /**
     * This method is used to enters a menu loop, allowing the user to perform various functions on an array of Change objects.
	 * <p>
	 * Precondition: <br>
	 * - 'change' array must not be null, and it should contain valid Change objects.<br>
	 * Post-condition: <br>
	 * - allowing the user to interactively choose from various options related to the 'changeArray'<br>
	 * Depending on the user's choices, different methods are invoked to perform actions like searching
     * for a name, displaying the largest/smallest amount, calculating total coins per denomination, and calculating
     * and displaying the total amount.<br>
     * The loop continues until the user chooses option 7, and the method ends with a message indicating the end 
     * of the program.
     * </p>.
     * @param change An array of Change objects
     * @return menu return a menu prompt
	 */
	public static void menuloop(Change[] change) {
        boolean carryOn = true;
        int choice =0;
    	while(carryOn) {
    			
    		//Display menu
    		System.out.println("1.Display change for the entered name.\n"+
    		                   "2.Find the name with the largest amount.\n"+
    		                   "3.Find the name with the smallest amount.\n"+
    		                   "4.Calculate and display the total number of coins for each denomination.\n"+
    		                   "5.Calculate and display the total amount for each denomination.\n"+
    		                   "6.Display all change object.\n"+ 
    		                   "7.Exit.\n");
    		
         //Asking user to make choice
         choice = getInt("Enter (1,2,3,4,5,6,7): ");     
		 switch(choice){
		 case 1:String enteredName = getString("Enter a name: ");
			    searchAndPrintName(change, enteredName); ; break;
		 case 2:displayLargestAmountChange(change); ; break;
		 case 3:displaySmallestAmountChange(change); ; break;
		 case 4:displayTotalCoinsPerDenomination(change); ; break;
		 case 5:calculateAndDisplayTotalAmountPerDenomination(change); ; break;
		 //Display change object the user enter
		 case 6:display(change); ;break;
		 //repeat until the user enter 7
		 case 7: System.out.println("Fare well."); 
			     carryOn = false; break;
	     // Display an error message for an invalid choice	     
		 default :System.out.println("Invalid choice");
                       }	 
    	 }	 
	}

	
	/**
	 * This method is used to find Change object of the entered name in the array.
	 * <p>
	 * Preconditions:<br>
	 * - This method is executed as part of a menu-driven program where
	 * - the user can choose from (1 to 6) to do various function and 7 to exit the program.<br>
	 * - 'change' array must not be null, and it should contain valid Change objects.<br>
     * - 'enteredName' is a one word String and should not be null.<br>
	 * Post-condition: <br>
	 * - If 'enteredName' is found in the 'change' array, the corresponding change object
	 * - is printed. If not found, a message indicating that the name was not found is printed.
	 * </p>
	 * @param enteredName The name to search for within the array.
	 * @param change An array of Change objects
	 * @return return Change object of the entered name or return not found
	 */
	public static void searchAndPrintName(Change[] change, String enteredName){
		// Loop through the Individual objects and find the identical name
        boolean nameFound = false;
        for (Change customer : change) {
            if (customer != null && customer.getName().equals(enteredName)) {
                System.out.println(customer);
                nameFound = true;
                break;
            }
        }        
        // If the name doesn't exist 
        if (!nameFound) {
            System.out.println("Name: " + enteredName);
            System.out.println("Not found.");
        }
	}
	
	/**
	  * This method is used to find Change object with the largest coinAmount in the array.
	  * <p>
	  * Preconditions:<br>
	  * - This method is executed as part of a menu-driven program where
	  * - the user can choose from (1 to 6) to do various function and 7 to exit the program.<br>
	  * - 'change' array must not be null, and it should contain valid Change objects.
	  * Postconditions:<br>
	  * - If 'change' is not null, the method displays the customer with the largest coin amount.
	  * </p>
	  *  @param change An array of Change objects
	  *  @return changeWithLargestAmount return Charge object with the largest coinAmmount
	  */
	 public static void displayLargestAmountChange(Change[] change) {
		    // Check if the input array is null
		    if (change == null) {
		       return; }// If null, exit the method 
		    // Initialize variables to store the name and amount of the customer with the smallest amount
	        String nameWithLargestAmount = null;
	        int largestAmount = 0;
	        // Find the name with the largest coin amount
	        for (Change customer : change) {
	            if (customer != null && customer.getCoinAmount() > largestAmount) {
	            	 // Update the largest amount and associated customer name
	                largestAmount = customer.getCoinAmount();
	                nameWithLargestAmount = customer.getName();
	            }
	        }
	        if (nameWithLargestAmount != null) {
	        	 // Create a new Change object for the customer with the largest amount
	        	Change customerWithLargestAmount = Change.createChange(nameWithLargestAmount, largestAmount);
	        	System.out.println(customerWithLargestAmount);
	        }    
	 }
	 
	  /**
	  * This method is used to find Change object with the smallest coinAmount in the array.
	  * <p>
	  * Preconditions:<br>
	  * - This method is executed as part of a menu-driven program where
	  * - the user can choose from (1 to 6) to do various function and 7 to exit the program.<br>
	  * - 'change' array must not be null, and it should contain valid Change objects.<br>
	  * Postconditions:<br>
	  * - If 'change' is not null, the method displays the customer with the smallest coin amount.
	  * </p>
	  * @param change An array of Change objects
	  * @return changeWithSmallAmount return Change object with the smallest coinAmount
	  */
	 public static void displaySmallestAmountChange(Change[] change) {
		    // Check if the input array is null
		    if (change == null) {
		      return;// If null, exit the method 
		    }
		    // Initialize variables to store the name and amount of the customer with the smallest amount
	        String nameWithSmallestAmount = null;
	        int smallestAmount = Integer.MAX_VALUE;      
	        // Find the name with the smallest coin amount
	        for (Change customer : change) {
	            if (customer != null && customer.getCoinAmount() < smallestAmount) {
	                // Update the smallest amount and associated customer name
	                smallestAmount = customer.getCoinAmount();
	                nameWithSmallestAmount = customer.getName();
	            }
	        }
	        if (nameWithSmallestAmount != null) {
	        	// Create a new Change object for the customer with the smallest amount
	        	Change customerWithSmallAmount = Change.createChange(nameWithSmallestAmount, smallestAmount);
	        	System.out.println(customerWithSmallAmount);
	        }        
	 }
	 
	 /**
	  * This method is used to calculate and display the total number for each denomination based on an array of Change objects.
	  * <p>
	  * Precondition:<br>
	  * - This method is executed as part of a menu-driven program where
	  *   the user can choose from (1 to 6) to perform various functions and 7 to exit the program.<br>
	  * - The 'change' array must not be null, and it should contain valid Change objects.<br>
	  * Post-condition:<br>
	  * - Print out the total number of coins for each denomination based on the Change objects in the array.
	  * </p>
	  * @param  change An array of Change object
	  * @return return total number of coins of each denomination
	  */
	 public static void displayTotalCoinsPerDenomination(Change[] change) {
		    int totalDollar = 0;
		    int totalFiftyCent = 0;
		    int totalTwentyCent = 0;
		    int totalTenCent = 0;
		    int totalFiveCent = 0;
            
		    // Calculate the total number of coins for each denomination
		    for (Change customer : change) {
		        // Check if the current Change object is null
		        if (customer == null) {
		            continue; // Skip this iteration if null
		        }
	
		            totalDollar += customer.getDollar();
		            totalFiftyCent += customer.getFiftyCent();
		            totalTwentyCent += customer.getTwentyCent();
		            totalTenCent += customer.getTenCent();
		            totalFiveCent += customer.getFiveCent();
		        }

		    // Display the total number of coins for each denomination
		    System.out.println("Total Number of Coins for Each Denomination:");
		    System.out.println("Total Dollar Coins: " + totalDollar);
		    System.out.println("Total Fifty Cent coins: " + totalFiftyCent);
		    System.out.println("Total Twenty Cent coins: " + totalTwentyCent);
		    System.out.println("Total Ten coins: " + totalTenCent);
		    System.out.println("Total Five coins: " + totalFiveCent);
		    System.out.println();
		}
	
	 /**
      * This method is used to calculate and display the total amount for each denomination based on an array of Change objects.
	  * <p>
	  * Precondition:<br>
	  * - This method is executed as part of a menu-driven program where
	  *   the user can choose from (1 to 6) to perform various functions and 7 to exit the program.<br>
	  * - The 'change' array must not be null, and it should contain valid Change objects.<br>
	  * Post-condition:<br>
	  * - Print out the total amount for each denomination based on the Change objects in the array.
	  * </p>
	  * @param  change An array of Change object
	  * @return return total amount of each denomination
	  */
		public static void calculateAndDisplayTotalAmountPerDenomination(Change[] change) {
		    int totalDollar = 0;
		    int totalFiftyCent = 0;
		    int totalTwentyCent = 0;
		    int totalTenCent = 0;
		    int totalFiveCent = 0;

		    // Calculate the total amount for each denomination
		    for (Change customer : change) {
		        // Check if the current Change object is null
		        if (customer == null) {
		            continue; // Skip this iteration if null
		        }

		        // Add the total amount for each denomination
		        totalDollar += customer.getDollar() * 100; // Convert dollar to cents
		        totalFiftyCent += customer.getFiftyCent() * 50;
		        totalTwentyCent += customer.getTwentyCent() * 20;
		        totalTenCent += customer.getTenCent() * 10;
		        totalFiveCent += customer.getFiveCent() * 5;
		    }

		    // Display the total amount for each denomination
		    System.out.println("Total Dollar Coins Amount: " +totalDollar);
		    System.out.println("Total Fifty Cent Coins Amount: " + totalFiftyCent);
		    System.out.println("Total Twenty Cent Coins Amount: " + totalTwentyCent);
		    System.out.println("Total Ten Cent Coins Amount: " +  totalTenCent);
		    System.out.println("Total Five Cent Coins Amount: " + totalFiveCent);
		    System.out.println();
		}
		
		/**
		 * This method is used to display all Change object in the array.
		 * <p>
		 * Precondition: <br>
		 * -This method is executed as part of a menu-driven program where
		 * -the user can choose from (1 to 6) to do various function and 7 to exit the program.<br>
		 * -'change' array must not be null, and it should contain valid Change objects.<br>
		 * Post-condition:<br>
		 * -print out all the change object in the array.
		 * </p>
		 * @param change An array of Change objects
		 * @return display all the change object in Change array
		 */
		public static void display(Change[] change) {
			//print out name and coinAmount for each change object.
		        for (Change customer : change) {
	                    System.out.print(customer);
	                    System.out.println();
		            }
		        }  
}



