package com.thirdparty.api.pages;

import java.util.HashMap;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

/*
//@ContentType()
@Endpoint(url = "${base_url}/ABHICL_FullQuoteNSTP/Service1.svc/GenericFullQuote", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "abhi_retail_api/rqRetailProduct.json")
//@ResponseTemplatePath(path = "api/users/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
*/

public class RetailQuote extends AbstractApiMethodV2 {
	
	/*
	public RetailQuote() {
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	} */

	public RetailQuote() {
		//super("abhi_post/rqRetailProduct.json", "", "abhi_prop/retail.properties");
		super("abhi_retail_api/rqRetailProduct.json", "", "abhi_retail_prop/retail.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}
	
	public void doQuickQuote(HashMap<String, String> data, String Quotation, String isPayment) {
		// Set headers
		setHeaders("content-Type=application/json");
		setHeaders("User-Agent=PostmanRuntime/7.26.1");
		setHeaders("Accept=*/*");
		setHeaders("Accept-Encoding=gzip, deflate, br");
		setHeaders("Connection=keep-alive");
		ignoreSSLCerts();
		expectResponseStatus(HttpResponseStatusType.OK_200);

		// Receipt Creation
		getProperties().replace("collectionRcvdDate", data.get("collectionRcvdDate").toString());
		getProperties().replace("collectionAmount", data.get("collectionAmount").toString());
		getProperties().replace("instrumentNumber", data.get("instrumentNumber").toString());
		getProperties().replace("instrumentDate", data.get("instrumentDate").toString());

		// Member Object
		// Member_No1
		if (data.get("MemberNo_1").equalsIgnoreCase("NA"))
			removeProperty("MemberNo_1");
		else {
			getProperties().replace("MemberNo_1", data.get("MemberNo_1").toString());
			getProperties().replace("Member1_Email", data.get("Member1_Email").toString());
			getProperties().replace("Member1_Gender", data.get("Member1_Gender").toString());
			getProperties().replace("Member1_productComponentValue",data.get("Member1_productComponentValue").toString());
			getProperties().replace("Member1_Salutation", data.get("Member1_Salutation").toString());
			getProperties().replace("Member1_Relation_Code", data.get("Member1_Relation_Code").toString());
			getProperties().replace("Member1_First_Name", data.get("Member1_First_Name").toString());
			getProperties().replace("Member1_PrimaryMember", data.get("Member1_PrimaryMember").toString());
			getProperties().replace("Member1_DateOfBirth", data.get("Member1_DateOfBirth").toString());
			getProperties().replace("Member1_Last_Name", data.get("Member1_Last_Name").toString());
			getProperties().replace("Member1_Mobile_Number", data.get("Member1_Mobile_Number").toString());
		}

		// Member_No2
		if (data.get("MemberNo_2").toString().equalsIgnoreCase("NA")) {
			removeProperty("MemberNo_2");
		} else {
			getProperties().replace("MemberNo_2", data.get("MemberNo_2").toString());
			getProperties().replace("Member2_Email", data.get("Member2_Email").toString());
			getProperties().replace("Member2_Gender", data.get("Member2_Gender").toString());
			getProperties().replace("Member2_productComponentValue",data.get("Member2_productComponentValue").toString());
			getProperties().replace("Member2_Salutation", data.get("Member2_Salutation").toString());
			getProperties().replace("Member2_Relation_Code", data.get("Member2_Relation_Code").toString());
			getProperties().replace("Member2_First_Name", data.get("Member2_First_Name").toString());
			getProperties().replace("Member2_PrimaryMember", data.get("Member2_PrimaryMember").toString());
			getProperties().replace("Member2_DateOfBirth", data.get("Member2_DateOfBirth").toString());
			getProperties().replace("Member2_Last_Name", data.get("Member2_Last_Name").toString());
			getProperties().replace("Member2_Mobile_Number", data.get("Member2_Mobile_Number").toString());
		}
		// Policy creation
		getProperties().replace("IsPayment", isPayment);
		getProperties().replace("SumInsured_Type", data.get("SumInsured_Type").toString());
		getProperties().replace("QuoteDate", data.get("QuoteDate").toString());
		getProperties().replace("Plan_Code", data.get("Plan_Code").toString());
		getProperties().replace("Product_Code", data.get("Product_Code").toString());
		getProperties().replace("Policy_Tanure", data.get("Policy_Tanure").toString());
		getProperties().replace("leadID", data.get("leadID").toString());
		getProperties().replace("Quotation_Number", Quotation);
		// Client creation
		getProperties().replace("dateofBirth", data.get("dateofBirth").toString());
		getProperties().replace("dateofBirth", data.get("dateofBirth").toString());
		getProperties().replace("primaryEmailID", data.get("primaryEmailID").toString());
		getProperties().replace("firstName", data.get("firstName").toString());
		getProperties().replace("salutation", data.get("salutation").toString());
		getProperties().replace("lastName", data.get("lastName").toString());
		getProperties().replace("contactMobileNo", data.get("contactMobileNo").toString());

	}

	public void doFullQuote(HashMap<String, String> data, String Quotation, String isPayment) {
		setHeaders("content-Type=application/json");
		setHeaders("User-Agent=PostmanRuntime/7.26.1");
		setHeaders("Accept=*/*");
		setHeaders("Accept-Encoding=gzip, deflate, br");
		setHeaders("Connection=keep-alive");
		ignoreSSLCerts();
		expectResponseStatus(HttpResponseStatusType.OK_200);

		// Receipt Creation
		getProperties().replace("collectionRcvdDate", data.get("collectionRcvdDate").toString());
		getProperties().replace("collectionAmount", data.get("collectionAmount").toString());
		getProperties().replace("instrumentNumber", data.get("instrumentNumber").toString());
		getProperties().replace("instrumentDate", data.get("instrumentDate").toString());
		

		// Member Object
		// Member_No1
		if (data.get("MemberNo_1").equalsIgnoreCase("NA"))
			removeProperty("MemberNo_1");
		else {
			getProperties().replace("MemberNo_1", data.get("MemberNo_1").toString());
			getProperties().replace("Member1_Email", data.get("Member1_Email").toString());
			getProperties().replace("Member1_Gender", data.get("Member1_Gender").toString());
			getProperties().replace("Member1_productComponentValue",data.get("Member1_productComponentValue").toString());
			getProperties().replace("Member1_Salutation", data.get("Member1_Salutation").toString());
			getProperties().replace("Member1_Relation_Code", data.get("Member1_Relation_Code").toString());
			getProperties().replace("Member1_First_Name", data.get("Member1_First_Name").toString());
			getProperties().replace("Member1_PrimaryMember", data.get("Member1_PrimaryMember").toString());
			getProperties().replace("Member1_DateOfBirth", data.get("Member1_DateOfBirth").toString());
			getProperties().replace("Member1_Last_Name", data.get("Member1_Last_Name").toString());
			getProperties().replace("Member1_Mobile_Number", data.get("Member1_Mobile_Number").toString());
		}

		// Member_No2
		if (data.get("MemberNo_2").toString().equalsIgnoreCase("NA")) {
			removeProperty("MemberNo_2");
		} else {
			getProperties().replace("MemberNo_2", data.get("MemberNo_2").toString());
			getProperties().replace("Member2_Email", data.get("Member2_Email").toString());
			getProperties().replace("Member2_Gender", data.get("Member2_Gender").toString());
			getProperties().replace("Member2_productComponentValue",data.get("Member2_productComponentValue").toString());
			getProperties().replace("Member2_Salutation", data.get("Member2_Salutation").toString());
			getProperties().replace("Member2_Relation_Code", data.get("Member2_Relation_Code").toString());
			getProperties().replace("Member2_First_Name", data.get("Member2_First_Name").toString());
			getProperties().replace("Member2_PrimaryMember", data.get("Member2_PrimaryMember").toString());
			getProperties().replace("Member2_DateOfBirth", data.get("Member2_DateOfBirth").toString());
			getProperties().replace("Member2_Last_Name", data.get("Member2_Last_Name").toString());
			getProperties().replace("Member2_Mobile_Number", data.get("Member2_Mobile_Number").toString());
		}
		// Policy creation
		getProperties().replace("IsPayment", isPayment);
		getProperties().replace("SumInsured_Type", data.get("SumInsured_Type").toString());
		getProperties().replace("QuoteDate", data.get("QuoteDate").toString());
		getProperties().replace("Plan_Code", data.get("Plan_Code").toString());
		getProperties().replace("Product_Code", data.get("Product_Code").toString());
		getProperties().replace("Policy_Tanure", data.get("Policy_Tanure").toString());
		getProperties().replace("leadID", data.get("leadID").toString());
		getProperties().replace("Quotation_Number", Quotation);
		// Client creation
		getProperties().replace("dateofBirth", data.get("dateofBirth").toString());
		getProperties().replace("dateofBirth", data.get("dateofBirth").toString());
		getProperties().replace("primaryEmailID", data.get("primaryEmailID").toString());
		getProperties().replace("firstName", data.get("firstName").toString());
		getProperties().replace("salutation", data.get("salutation").toString());
		getProperties().replace("lastName", data.get("lastName").toString());
		getProperties().replace("contactMobileNo", data.get("contactMobileNo").toString());

	}

}
