package com.thirdparty.api.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class AxisTelesalesGPAGCI_FullQuote extends AbstractApiMethodV2 {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy 00:00:00");
	static SimpleDateFormat datesdf = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat ysdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public AxisTelesalesGPAGCI_FullQuote() 
	{
		super("abhi_post/rqABHIAxisTelesalesGPAGCI_FullQuote.json", "", "abhi_prop/ABHIAxisTelesalesFullQuote.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}
	
	public void setPlaceHolder(HashMap<String, String> data) 
	{	
		Calendar cal = Calendar.getInstance();
		String policy_StartDate = sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -364);
		policy_StartDate = sdf.format(cal.getTime());
		
		String Construct = data.get("construct").toString();
		String Product = data.get("product_plan").toString();
		
		setHeaders("content-Type=application/json");
		setHeaders("User-Agent=PostmanRuntime/7.26.1");
		setHeaders("Accept=*/*");
		setHeaders("Accept-Encoding=gzip, deflate, br");
		setHeaders("Connection=keep-alive");
		expectResponseStatus(HttpResponseStatusType.OK_200);

		getProperties().replace("Member_Customer_ID", data.get("Member_Customer_ID").toString());
		getProperties().replace("Salutation", data.get("Salutation").toString());		
		getProperties().replace("firstName", data.get("firstName").toString());
		getProperties().replace("dateofBirth", data.get("dateofBirth").toString());
		getProperties().replace("gender", data.get("gender").toString());
		getProperties().replace("pinCode", data.get("pinCode").toString());		
		getProperties().replace("primaryEmailID", data.get("primaryEmailID").toString());
		getProperties().replace("contactMobileNo", data.get("contactMobileNo").toString());
		
		getProperties().replace("startDate", policy_StartDate);
		getProperties().replace("MasterPolicyNumber", data.get("MasterPolicyNumber").toString());	
		getProperties().replace("GroupID", data.get("GroupID").toString());
		getProperties().replace("Product_Code", data.get("Product_Code").toString());
		
		getProperties().replace("leadID", data.get("leadID").toString());
		getProperties().replace("Source_Name", data.get("Source_Name").toString());
		
		
		getProperties().replace("IsPayment", data.get("IsPayment").toString());
		getProperties().replace("SumInsured", data.get("SumInsured").toString());
		  
        getProperties().replace("MemberNo_1",data.get("MemberNo_1").toString());;
       	getProperties().replace("Member1_Salutation",data.get("Member1_Salutation").toString());
       	getProperties().replace("Member1_First_Name",data.get("Member1_First_Name").toString());
       	getProperties().replace("Member1_Gender",data.get("Member1_Gender").toString());
       	getProperties().replace("Member1_DateOfBirth",data.get("Member1_DateOfBirth").toString());
       	getProperties().replace("Member1_Relation_Code",data.get("Member1_Relation_Code").toString());
       	getProperties().replace("Member1_PrimaryMember",data.get("Member1_PrimaryMember").toString());
		
		getProperties().replace("Nominee_First_Name", data.get("Nominee_First_Name").toString());	
		getProperties().replace("Nominee_Relationship_Code", data.get("Nominee_Relationship_Code").toString());
		
		getProperties().replace("collectionAmount", data.get("collectionAmount").toString());
		getProperties().replace("collectionRcvdDate", policy_StartDate);
		getProperties().replace("instrumentNumber", data.get("Source_Name").toString());
		getProperties().replace("instrumentDate", policy_StartDate);
	}
	

}


