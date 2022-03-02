package starter.ResponseExtraction;

import java.util.List;

import io.restassured.specification.Argument;

public class ClientProfileAPISExtraction {

	// Things to be compared

//	public static final String COUNTRY = "VMX_MSGOUT.ACCT_BS_OUTPUT.COUNTRY";
//    public static final String ACCOUNT_NUMBER = "VMX_MSGOUT.ACCT_BS_OUTPUT.ACCT_NBR";
//    public static final String NUMBER_TO_WORD="/NumberToWordsResult";

	// Get contact data spain

	public static final String Message_ID = "messages.messageId";
	public static final String subject = "messages.subject";

	// Get contact data portugaze

	public static final String Message_ID1 = "messages.messageId";
	public static final String subject1 = "messages.subject";

	// Get PersonalData Spain

	public static final String Message_ID2 = "messages.messageId";
	public static final String subject2 = "messages.subject";

	// Get PersonalData Portuguize

	public static final String Message_ID3 = "messages.messageId";
	public static final String subject3 = "messages.subject";

}
