package zhenghao.guo;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class assignment6practice {
 static String []username=new String[100000];
 static String[]errMsg=new String[10000];
 static String accountName = "";
 static int index=0;
 static int errorCount = 0;
 static boolean game=true;
 static String account="";
	public static void main(String[] args)throws FileNotFoundException {
		errMessage();
		findFile();
   
    }
	public static void findFile() throws FileNotFoundException{
	Scanner scan=new Scanner(System.in);	
    String Filename=scan.next();
    System.out.println("userdata comes from "+ Filename);
    Scanner input=new Scanner(new File(Filename));
    while (input.hasNext()) {
    	username[index]=input.next();
        index++;         
    }
    startaccount(username); 	
	}

    public static void startaccount(String[]username) {
    	for(int i=0;i<index;i++) {
    		System.out.println(username[i]);
    	}
    	while(game) {
    	   Scanner scan=new Scanner(System.in);
    	   System.out.println("Creat a new account");
    	   accountName=scan.nextLine();
    	   String errorMessage =sorting(username,accountName,index);
    	   System.out.println(errorMessage);
    	}
    	
    	System.out.println("your name is "+ accountName);
    	username[index] = accountName;
    	index++;
    	for(int i=0;i<index;i++) {
    		System.out.println(username[i]);
    	}
    }
    
    public static String addErrorMessageHeading() {
    	if(errorCount == 0) {
    		return "Invalid Name. ";
    	}
    	else return "";
    }
    
    public static String sorting(String[]username,String accountName,int index) {
    	errorCount = 0;
    	String errorMessage = "";
    	//check duplicate name
    	for(int i=0;i<index;i++) {
    		if (username[i].equals(accountName)) {
    			errorMessage += addErrorMessageHeading();
    			errorMessage += printErrorMessage(0);
    			errorCount++;
    			//
    		}
    	}
    		if (accountName.length()<4||accountName.length()>8) {
    			errorMessage += addErrorMessageHeading();
    			errorMessage += printErrorMessage(1);
    			errorCount++;
    		}
    		
    		char[] specialCharacterArray = {'!', '@', '#', '$', '%', '^', '&', '*'};
	        for (int k = 0; k < accountName.length(); k++) {
	            for (int j = 0; j < specialCharacterArray.length; j++) {
	                if (accountName.charAt(k) == specialCharacterArray[j]) {
	                	errorMessage += addErrorMessageHeading();
	                    errorMessage += printErrorMessage(2);
	                    errorCount++;
	                }
	            }
	        }
	        
	        for (int i = 0; i < accountName.length(); i++) {
	            if (accountName.charAt(i) == ' ') {
	            	errorMessage += addErrorMessageHeading();
	                errorMessage += printErrorMessage(3);
	                errorCount++;
	            }
	        }
	        
	        char charValue = accountName.charAt(0);
	        // charValue = (int) accountName.charAt(0);
	        //if char is not "A to Z" or "a to z"
	       // if (!((charValue >= 65) && (charValue <= 90) || (charValue >= 97) && (charValue <= 122))) {
	          if(!((charValue>'a'&&charValue<'z')||(charValue>'A' && charValue < 'Z'))){ 
	        	errorMessage += addErrorMessageHeading();
	            errorMessage += printErrorMessage(4);
	            errorCount++;
	        }
	        
    		if(errorCount == 0) {
    			game = false;
    		} 
    	return errorMessage;
    }
    public static void errMessage() {
    	errMsg[0]= "duplicate name. ";
    	errMsg[1]= "Usernames must be between 4 and 8 characters in length. ";
    	errMsg[2]= " Username can’t contain any special character. "; 
    	errMsg[3]= " Username can’t contain any space. ";
    	errMsg[4]=  "Usernames must start with a letter like [a-z A-Z]. ";
   }
   
   public static String printErrorMessage(int errorNumber) {
	   return errMsg[errorNumber];
   }
   










}