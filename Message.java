package com.mycompany.Message;

public class Message {
            
//1. Checks that the message ID length is valid (max 10 characters)
public boolean checkMessageID(String identificationToken) {
    return identificationToken != null && identificationToken.length() <= 10;
}

//2. Checks recipient nuumber prefix rules and layout lengths
public String checkRecipientCell(String incomingNumber) {
if (incomingNumber == null) {
    return "Cell phone number is incorrectly formated or does not contain an international code. Please correct the number and try again.";
}
boolean validPrefix = incomingNumber.startsWith("+") || incomingNumber.startWith("00");
boolean validLength = incomingNumber.length() <=10
if (validPrefix && validLength) {
    return "Cell phone number successfully captured.";
}else{
    return "Cell phone number is incorrectly frormatted or does not contain an international coed. Please correct the number and try again.";
    }
}

//3. Creates the custom uppercase validation has tracking string
public String createMessageHash(String msgId, int currentLoopIndex, String fullTextPayLoad) {
String sequenceCode = msgId.substring(0, 2);
String[] textSegments = fullTextPayload.trim().split("\\s+");
String initialWord = textSegments[0];
String terminalWord = textSegments[textSegments.length - 1];
String assembledHash = sequenceCode + ":" + currentLoopIndex + ":" + initialWord + terminalWord;
   return assembledHash.toUpperCase();
}
 
//4. Evaluates the user action selections and returns system status text
public String SentMessage(String userActionInput) {
String localizedAction = userActionInput.toLowerCase().trim();
if (localizedAction.contains("send")) {
    return "Message successfully sent.";
}else if (localizedAction.contains("disregard") || localizedAction.contains("discard")) {
    return "Press 0 to delete the message.";   
}else if (localizedAction.contains("store")){
    return "Message successfully stored.";
}else{
    return "Operational error: Unknown workflow path selected.";
}
    
//5. Formats and prints out the final detailed message report display blocks
public String printMessages(String id, String hash, String recipient,String message) {
    return "Message ID: " + id + "Message Hash: " + hash + "Recipient: " + recipient + "Message: " + message;
}

//6. Pulls the absolute sum counter tracking calculation
public int returnTotalMessages(int totalSentCount) {
    return totalSentCount;
}

// RESEARCH REQUIREMENT: Manually assembles variables into a structured JSON block format
public String storeMessage(String msgId, String hash, String cell, String text) {                                                                                                                                                          
    return "{\" + " \messageId\": \"" + msgId + "\",\" + " \"messageHash\": \"" + hash + "\",\ + \"recipientCell\": \"" + cell + "\",\" +  \"messagePsyload\": \"" + text + "\"\" + "}";
      } 
}                                                       

