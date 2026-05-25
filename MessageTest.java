package com.mycompany.messagetest;

import org junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

// Test 1: Message Length Validation (Success & Failure)
@Test
public void testVefifyMessageLengthSuccess() {
 Message testEngine = new Message();

// Using Test case 1 explicit message value from the worksheet
String result = testEngine.verifyMessageLength("Hi Mike, can you join us for dinner tonight?");
assertEquals("Message ready to send." , result);
}

@Test
public void testVerifyMessageLengthFailure() {
 Message testEngine = new Message();

// Buliding a string that has 252 characters(exceeds limit by 2)
StringBuilder longMessage = new StringBuilder();
for (int i= 0; i < 252; i++) {
    longMessage.append("A");
}
String result = testEngine.verifyMessageLength(longMessage.toString());
assertEquals("Message exceeds 250 characters by 2; please reducew the size.", result);
}

// Test 2: Recipient Number Formatting (Success & Failure)
@Test
public void testCheckRecipientCellSuccess() {
Message testEngine = new Message();

// Uses the vaild Test Case 1 number provided (+27718693002)
String result = testEngine.checkRecipientCell("+27718693002");
assertEquals("Cell phone number successfully captured.", result)
}

@Test
public void testCheckRecipientCellFailure() {
Message testEngine = new Message();

// Uses the invalid Test Case 2 number provided (08575975889 - missing code prefix)
String result = testEngine.checkRecipientCell("08575975889");
assertEquals("Cell phone is incorrectly formatted or does not contain an international code.Please correct the number and try again.", result);
}

// Test 3: Custom Generated UpoerCase Tracking Hash Code
@Test
public void testCreateMessageHash() {
,essage testEngine = new Message();

// Setup values utilizizing data strings from assignment Test Case 1 table
String trackingIdMock = "0012345678";
int loopIndexMock = 0;
String messageBodyMock = "Hi Mike, can you join us for dinner tonight?";
String result = testEngine.createMessageHash(trackingIdMock, loopIndexMock, messageBodyMock);

//Rubric target requrement signature test:00:0:HITONIGHT
assertEquals("00:0:HITONIGHT", result);       
}

// Test 4: Action Workflow Selection Verification State Returns
@Test
public void testSentMessageWorkflowRoutes() {
Message testMessage = new Messages();

// 1) Test Sends Action Route Response
assertEquals("Message successfully sent.",testEngine.SentMessage("Send Message"));

// 2) Test Disregard Action Route Response
assertEquals("Press 0 to delete the message.",testEngine.SentMessage("Disregard Message"));

// 3) Test Store Action Route Response
assertEquals("Message successfully stored.",testEngine.SentMessage("Store Message"));
}