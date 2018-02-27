package zhenghao.guo;
import java.util.*;
	import java.io.File;
	import java.io.FileNotFoundException;
public class assignment6 {
	
	
		//package zhenghao.guo;

	
	
		    static String fileName = "";
		    static String[] username = new String[100000];
		    static String[] errMsg = new String[10000];
		    static int index = 0;
		    static int errorCount = 0;
		    static boolean game = true;
		    static String account = "";

		    public static void main(String[] args) throws FileNotFoundException {
		        errorMessage();
		        findFile();
		    }

		    public static void findFile() throws FileNotFoundException {
		        fileName = "user.txt";
		        Scanner input = new Scanner(new File(fileName));
		        while (input.hasNext()) {
		            username[index] = input.next();
		            index++;
		        }
		        startAccount(username);
		    }

		    public static void startAccount(String[] username) {
		        printDatabase();
		        while (game) {
		            askUserNameInput();
		        }
		        System.out.println();
		        printDatabase();
		    }

		    public static void printDatabase() {
		        System.out.println("User Database from " + fileName);
		        for (int i = 0; i < index; i++) {
		            System.out.println(username[i]);
		        }
		    }

		    public static void askUserNameInput() {
		        Scanner scan = new Scanner(System.in);
		        System.out.print("\nCreate a new user: ");
		        String accountName = scan.nextLine();
		        checkUsernameSyntax(accountName);
		        if (errorCount == 0) {
		            username[index] = accountName;
		            index++;
		            System.out.println("User \"" + accountName + "\" added to \"" + fileName + "\" successfully!");
		            game = false;
		        }
		    }

		    public static void checkUsernameSyntax(String accountName) {
		        errorCount = 0;
		        for (int i = 0; i < index; i++) {
		            checkDuplicateName(i, accountName);
		        }
		        checkUsernameLength(accountName);
		        checkSpecialCharacter(accountName);
		        checkSpace(accountName);
		        checkStartingLetter(accountName.charAt(0));
		    }

		    public static void printErrorMessageHeading() {
		        if (errorCount == 0) {
		            System.out.print("Invalid Name. ");
		            errorCount++;
		        }
		    }

		    public static void checkDuplicateName(int i, String accountName) {
		        if (username[i].equals(accountName)) {
		            printErrorMessageHeading();
		            System.out.print(printErrorMessage(0));
		        }
		    }

		    public static void checkUsernameLength(String accountName) {
		        if (accountName.length() < 4) {
		            printErrorMessageHeading();
		            System.out.print(printErrorMessage(1));
		        }
		        if (accountName.length() > 8) {
		            printErrorMessageHeading();
		            System.out.print(printErrorMessage(2));
		        }
		    }

		    public static void checkSpecialCharacter(String accountName) {
		        char[] specialCharacterArray = {'!', '@', '#', '$', '%', '^', '&', '*'};
		        for (int i = 0; i < accountName.length(); i++) {
		            for (int j = 0; j < specialCharacterArray.length; j++) {
		                if (accountName.charAt(i) == specialCharacterArray[j]) {
		                    printErrorMessageHeading();
		                    System.out.print(printErrorMessage(3));
		                }
		            }
		        }
		    }

		    public static void checkSpace(String accountName) {
		        for (int i = 0; i < accountName.length(); i++) {
		            if (accountName.charAt(i) == ' ') {
		                printErrorMessageHeading();
		                System.out.print(printErrorMessage(4));
		            }
		        }
		    }

		    public static void checkStartingLetter(char firstLetter) {
		        int intValue = (int) firstLetter;
		        //if char is not "A to Z" or "a to z"
		        if (!((intValue >= 65) && (intValue <= 90) || (intValue >= 97) && (intValue <= 122))) {
		            printErrorMessageHeading();
		            System.out.print(printErrorMessage(5));
		        }
		    }

		    public static void errorMessage() {
		        errMsg[0] = "Name already in use. ";
		        errMsg[1] = "Name too short. ";
		        errMsg[2] = "Name too long. ";
		        errMsg[3] = "Name can’t contain any special character. ";
		        errMsg[4] = "Name can’t contain any space. ";
		        errMsg[5] = "Name must start with a letter like [a-z A-Z]. ";
		    }

		    public static String printErrorMessage(int errorNumber) {
		        return errMsg[errorNumber];
		    }
		
	}
 
