package com.mycompany.poepartii;

import java.util.Scanner;
import java.util.Random;

public class POEPartII {

    public static void main(String[] args) {
        
Scanner input = new Scanner(System.in);
Random rand = new Random();
Message workflowEngine = new Message();
// Connects to the rubric worker class

// Welcome Message
System.out.println("Welcome to QuickChat.");

// Define Message Amount
System.out.print("How many messages do you wish to enter?");
int totalTargetMessages = input.nextInt();
// Clear  buffer

// Arrays to hold the message details for final summary display
String[] savedIds = new String[totalTargetMessages];
String[] savedReceipts = new String[totalTargetMessages];
String[] savedMessages = new String[totalTargetMessages];
String[] savedHashes = new String[totalTargetMessages];
int messagesSuccessfullySent = 0;
int currentMessageIndex = 0;

// Main Application Loop
int userMenuSelection = 0;
while (userMenuSelection !=3) {
System.out.println("Please choose from a numeric menu:");
System.out.println("1.Send Messages");
System.out.println("2.Show recently sent messages");
System.out.println("3.Quit");
System.out.print("Your choice");
userMenuSelection = input.nextInt();
input.nextLine();
// Clear buffer

if (userMenuSelection ==1) {
// Check if we have already filled the user's  defined limit
if (currentMessageIndex >= totalTargetMessages) {
System.out.println("Limit reached! You can only enter " + totalTargetMessages + "messages.");  
 continue;
}
System.out.println("Step 1:Recipient Information");
System.out.print("Enter recipient cell phone number: ");
String cellNumber = input.nextLine();

// Validate the phone number format
if (!validate ReceiptNumber (cellNumber)) {
System.out.println("Cell phone number is incorrectly formatted or does not contain an international code.Please correct the number and try again.");
continue;
// Skip the rest and jump back to the menu
}else{
System.out.println("Cell phone number successfully captured");
}
System.out.println("Step 2: Write Message");
System.out.print("Enter short message (under 250 characters):");
String userTextMessage = input.nextLine();
 
// Validate message text length
if (userTextMessage.length()> 250) {
System.out.println("Please enter a message of less than 250 characters.");
continue;
}else{
System.out.println("Message sent");
}

// Step 3: Autogenerate Data
// Generate a random 10-digit tracking number
long randomTenDigit = 1000000000L + (long)(rand.nextDouble()* 9000000000L);
String uniqueMessageID = String.valueOf(randomTenDigit);

// Generate the custom required Message Haash format
String generatedHash = createMessageHash(uniqueMessageID, currentMessageIndex, userTextMessage);

// Step 4 : Choose Option Action
System.out.println("Choose one of the following options:");
System.out.println("*Send Message");
System.out.println("*Disregard Message");
System.out.println("Store Message to send later");
System.out.print("Type selection exactly (or type Send/Disregard/Store):");
String actionChoice = input.nextLine().toLowerCase();
if  (actionChoice.contains("send")) {
System.out.println("Message successfully sent");
messagesSuccessfullySent++;
}else if(actionChoice.contains("disregard")) {
System.out.println("Press 0 to delete the message");
continue;
// Skip saving this message
}else if (actionChoice.contains("store")) {
System.out.println("Message successfully stored");
}

// Save data to memory arrays 
savedIds[currentMessageIndex] = uniqueMessageId;
savedRecipients[currentMessageIndex] = cellNumber;
savedMessages[currentMessageIndex] = userTextMessage;
savedHashes[currentMessageIndex] = generatedHash;
currentMessageIndex++;
}else if (userMenuSelection == 3){
System.out.println("Exiting application processing loop");
}else{
System.out.println("Invalid option.Please input 1, 2, or 3.");
   }
}

// Final Sreen Reports
System.out.println("Final Outcomes Report");
for (int i = 0;i < currentMessageIndex; i++) {
System.out.println("Displaying details for message #" + (i + 1) + ":");
}
// Call
System.out.println('workflowEngine.printMessages (savedIds[i];savedMessages[i]));
}

// Call
System.out.println("Total number of successfully sent messages accumulated: "  + workflowEngine.returnTotalMessages(messagesSuccessfullySent));

input.close
    }
}


        
        


    
        



    
        
  

