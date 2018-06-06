package com.sd.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sreesdas
 *
 */
public class FileWriterUtil {

	public FileWriter appendColumns(FileWriter fileWriter) {
		try {
			fileWriter.append("Customer Mobile Number");// A
			fileWriter.append(',');
			fileWriter.append("CUSTOMER_ID");// B
			fileWriter.append(',');
			fileWriter.append("LINE_OF_BUSSINESS");// C
			fileWriter.append(',');
			fileWriter.append("STATUS_TYPE");// D
			fileWriter.append(',');
			fileWriter.append("STATUS_REASON");// E
			fileWriter.append(',');
			fileWriter.append("SUBSCRIPTION_STATUS");// F
			fileWriter.append(',');
			fileWriter.append("ACQUISITION_CHANNEL");// G
			fileWriter.append(',');
			fileWriter.append("PRODUCT_GROUP");// H
			fileWriter.append(',');
			fileWriter.append("DEVICE_BRAND");// I
			fileWriter.append(',');
			fileWriter.append("DEVICE_MODEL");// J
			fileWriter.append(',');
			fileWriter.append("NETWORK_BANDS");// K
			fileWriter.append(',');
			fileWriter.append("POSTCODE");// L
			fileWriter.append(',');
			fileWriter.append("CITY");// M
			fileWriter.append(',');
			fileWriter.append("STATE");// N
			fileWriter.append(',');
			fileWriter.append("CUSTOMER_NAME");// O
			fileWriter.append(',');
			fileWriter.append("Customer Email Address");// P
			fileWriter.append(',');
			fileWriter.append("GENDER");// Q
			fileWriter.append(',');
			fileWriter.append("NATIONALITY");// R
			fileWriter.append(',');
			// default Value
			fileWriter.append("*PREFERRED_LANGUAGE");// S
			fileWriter.append(',');

			fileWriter.append("RACE");
			fileWriter.append(',');
			fileWriter.append("ACTIVATION_DATE");
			fileWriter.append(',');
			fileWriter.append("RECENCY_IN_USAGE");
			fileWriter.append(',');
			fileWriter.append("RECENCY_OUT_USAGE");
			fileWriter.append(',');
			fileWriter.append("AGE");
			fileWriter.append(',');
			fileWriter.append("SUBSCRIPTION_TENURE");
			fileWriter.append(',');
			fileWriter.append("BRANCH_CODE");
			fileWriter.append(',');
			fileWriter.append("BILL_TYPE");
			fileWriter.append(',');
			fileWriter.append("BILL_PLAN_NAME");
			fileWriter.append(',');
			fileWriter.append("CONTRACT_PLAN_NAME");
			fileWriter.append(',');
			fileWriter.append("CUST_SEGMENT");
			fileWriter.append(',');
			fileWriter.append("PREV_PLAN");
			fileWriter.append(',');
			fileWriter.append("SECONDARY_PLAN_NAME");
			fileWriter.append(',');
			fileWriter.append("MVNO_NAME");
			fileWriter.append(',');
			fileWriter.append("CUST_TAG");
			fileWriter.append(',');

			fileWriter.append("BRANCH_REGION");
			fileWriter.append(',');
			fileWriter.append("BRANCH_STATE");
			fileWriter.append(',');
			// default values
			fileWriter.append("Service Type");
			fileWriter.append(',');
			fileWriter.append("*Lifecycle_stage_repeat");
			fileWriter.append(',');
			fileWriter.append("*Lifecycle_Stage");
			fileWriter.append(',');
			fileWriter.append("*LifeCycle_SubStage");
			fileWriter.append(',');
			// db value
			fileWriter.append("*Transaction_Date");
			fileWriter.append(',');

			fileWriter.append("Salutation");
			fileWriter.append(',');
			fileWriter.append("MNP_Tag");
			fileWriter.append(',');
			fileWriter.append("Roaming_Tag");
			fileWriter.append(',');
			fileWriter.append("Online_Tag");
			fileWriter.append(',');
			fileWriter.append("Social_Media_Tag");
			fileWriter.append(',');
			fileWriter.append("Custom_A");
			fileWriter.append(',');
			fileWriter.append("Custom_B");
			fileWriter.append(',');
			fileWriter.append("Custom_C");
			fileWriter.append(',');
			fileWriter.append("Custom_D");
			fileWriter.append(',');
			fileWriter.append("Custom_E");
			fileWriter.append(',');
			fileWriter.append("Custom_F");
			fileWriter.append(',');
			fileWriter.append("Custom_G");
			fileWriter.append(',');
			fileWriter.append("Custom_H");
			fileWriter.append(',');
			fileWriter.append("Custom_I");
			fileWriter.append(',');
			fileWriter.append("Custom_J");
			fileWriter.append(',');
			fileWriter.append("Custom_K");
			fileWriter.append(',');
			fileWriter.append("Custom_L");
			fileWriter.append(',');
			fileWriter.append("Custom_M");
			fileWriter.append(',');
			fileWriter.append("Custom_N");
			fileWriter.append('\n');
			return fileWriter;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileWriter;

	}

	public FileWriter appendValues(String customerMobileNumber, String transDate, FileWriter fileWriter) {

		try {
			fileWriter.append(customerMobileNumber);
			fileWriter.append(',');// A
			fileWriter.append("");
			fileWriter.append(',');// B
			fileWriter.append("");
			fileWriter.append(',');// C
			fileWriter.append("");
			fileWriter.append(',');// D
			fileWriter.append("");
			fileWriter.append(',');// E
			fileWriter.append("");
			fileWriter.append(',');// F
			fileWriter.append("");
			fileWriter.append(',');// G
			fileWriter.append("");
			fileWriter.append(',');// H
			fileWriter.append("");
			fileWriter.append(',');// I
			fileWriter.append("");
			fileWriter.append(',');// J
			fileWriter.append("");
			fileWriter.append(',');// K
			fileWriter.append("");
			fileWriter.append(',');// L
			fileWriter.append("");
			fileWriter.append(',');// M
			fileWriter.append("");
			fileWriter.append(',');// N
			fileWriter.append("");
			fileWriter.append(',');// O
			fileWriter.append("");
			fileWriter.append(',');// P
			fileWriter.append("");
			fileWriter.append(',');// Q
			fileWriter.append("");
			fileWriter.append(',');// R
			fileWriter.append("English");
			fileWriter.append(',');// S
			fileWriter.append("");
			fileWriter.append(',');// T
			fileWriter.append("");
			fileWriter.append(',');// U
			fileWriter.append("");
			fileWriter.append(',');// V
			fileWriter.append("");
			fileWriter.append(',');// W
			fileWriter.append("");
			fileWriter.append(',');// X
			fileWriter.append("");
			fileWriter.append(',');// Y
			fileWriter.append("");
			fileWriter.append(',');// Z
			fileWriter.append("");
			fileWriter.append(',');// AA
			fileWriter.append("");
			fileWriter.append(',');// AB
			fileWriter.append("");
			fileWriter.append(',');// AC
			fileWriter.append("");
			fileWriter.append(',');// AD
			fileWriter.append("");
			fileWriter.append(',');// AE
			fileWriter.append("");
			fileWriter.append(',');// AF
			fileWriter.append("");
			fileWriter.append(',');// AG
			fileWriter.append("");
			fileWriter.append(',');// AH
			fileWriter.append("");
			fileWriter.append(',');// AI
			fileWriter.append("");
			fileWriter.append(',');// AJ
			fileWriter.append("Celcom Life");
			fileWriter.append(',');// AK
			fileWriter.append("I RECONSIDER");
			fileWriter.append(',');// AL
			fileWriter.append("Mobile App");
			fileWriter.append(',');// AM
			fileWriter.append("LifeStyle OptIn");
			fileWriter.append(',');// AN
			fileWriter.append(transDate);
			fileWriter.append(',');// AO
			fileWriter.append("");
			fileWriter.append(',');// AP
			fileWriter.append("");
			fileWriter.append(',');// AQ
			fileWriter.append("");
			fileWriter.append(',');// AR
			fileWriter.append("");
			fileWriter.append(',');// AS
			fileWriter.append("");
			fileWriter.append(',');// AT
			fileWriter.append("");
			fileWriter.append(',');// AU
			fileWriter.append("");
			fileWriter.append(',');// AV
			fileWriter.append("");
			fileWriter.append(',');// AW
			fileWriter.append("");
			fileWriter.append(',');// AX
			fileWriter.append("");
			fileWriter.append(',');// AY
			fileWriter.append("");
			fileWriter.append(',');// AZ
			fileWriter.append("");
			fileWriter.append(',');// BA
			fileWriter.append("");
			fileWriter.append(',');// BB
			fileWriter.append("");
			fileWriter.append(',');// BC
			fileWriter.append("");
			fileWriter.append(',');// BD
			fileWriter.append("");
			fileWriter.append(',');// BE
			fileWriter.append("");
			fileWriter.append(',');// BF
			fileWriter.append("");
			fileWriter.append(',');// BG
			fileWriter.append("");
			fileWriter.append('\n');// BH

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileWriter;
	}
}