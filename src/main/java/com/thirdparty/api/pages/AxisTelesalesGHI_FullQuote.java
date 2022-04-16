package com.thirdparty.api.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class AxisTelesalesGHI_FullQuote extends AbstractApiMethodV2 {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy 00:00:00");
	static SimpleDateFormat datesdf = new SimpleDateFormat("dd/MM/yyyy");
	static SimpleDateFormat ysdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public AxisTelesalesGHI_FullQuote() 
	{
		super("abhi_post/rqABHIAxisTelesalesGHI_FullQuote.json", "", "abhi_prop/ABHIAxisTelesalesFullQuote.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}
	
	public void setPlaceHolder(HashMap<String, String> data, String Quotation, String isPayment) 
	{	
		Calendar cal = Calendar.getInstance();
		String policy_StartDate = sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -364);
		policy_StartDate = sdf.format(cal.getTime());
		
		
		setHeaders("content-Type=application/json");
		setHeaders("User-Agent=PostmanRuntime/7.26.1");
		setHeaders("Accept=*/*");
		setHeaders("Accept-Encoding=gzip, deflate, br");
		setHeaders("Connection=keep-alive");
		ignoreSSLCerts();
		expectResponseStatus(HttpResponseStatusType.OK_200);
		
		String Construct = data.get("Construct").toString();
		String Product = data.get("Product-plan").toString();

		getProperties().replace("Member_Customer_ID", data.get("Member_Customer_ID").toString());
		getProperties().replace("salutation", data.get("salutation").toString());		
		getProperties().replace("firstName", data.get("firstName").toString());
		getProperties().replace("lastName", data.get("lastName").toString());
		getProperties().replace("dateofBirth", data.get("dateofBirth").toString());
		getProperties().replace("gender", data.get("gender").toString());
		getProperties().replace("pinCode", data.get("pinCode").toString());		
		getProperties().replace("primaryEmailID", data.get("primaryEmailID").toString());
		getProperties().replace("contactMobileNo", data.get("contactMobileNo").toString());
		
		getProperties().replace("startDate", policy_StartDate);
		getProperties().replace("Quotation_Number", Quotation.toString());
		getProperties().replace("MasterPolicyNumber", data.get("MasterPolicyNumber").toString());	
		getProperties().replace("GroupID", data.get("GroupID").toString());
		getProperties().replace("Product_Code", data.get("Product_Code").toString());
		
		getProperties().replace("leadID", data.get("leadID").toString());
		getProperties().replace("Source_Name", data.get("Source_Name").toString());
		
		
		getProperties().replace("IsPayment", isPayment.toString());
		getProperties().replace("SumInsured", data.get("SumInsured").toString());
		
		//Member_No
		if(data.get("MemberNo_1").equalsIgnoreCase("NA"))
        	removeProperty("MemberNo_1");
        else
        {   
        	getProperties().replace("MemberNo_1",data.get("MemberNo_1").toString());;
        	getProperties().replace("Member1_Salutation",data.get("Member1_Salutation").toString());
        	getProperties().replace("Member1_First_Name",data.get("Member1_First_Name").toString());
        	getProperties().replace("Member1_Gender",data.get("Member1_Gender").toString());
        	getProperties().replace("Member1_DateOfBirth",data.get("Member1_DateOfBirth").toString());
        	getProperties().replace("Member1_Relation_Code",data.get("Member1_Relation_Code").toString());
        	getProperties().replace("Member1_PrimaryMember",data.get("Member1_PrimaryMember").toString());
        }
		System.out.println(data.get("MemberNo_2"));
//		Member_No2
		if(data.get("MemberNo_2").toString().equalsIgnoreCase("NA"))
		{
        	removeProperty("MemberNo_2");
		}
        else
        {   
        	getProperties().replace("MemberNo_2",data.get("MemberNo_2").toString());;
        	getProperties().replace("Member2_Salutation",data.get("Member2_Salutation").toString());
        	getProperties().replace("Member2_First_Name",data.get("Member2_First_Name").toString());
        	getProperties().replace("Member2_Gender",data.get("Member2_Gender").toString());
        	getProperties().replace("Member2_DateOfBirth",data.get("Member2_DateOfBirth").toString());
        	getProperties().replace("Member2_Relation_Code",data.get("Member2_Relation_Code").toString());
        	getProperties().replace("Member2_PrimaryMember",data.get("Member2_PrimaryMember").toString());
        }
		
//		Member_No3
		if(data.get("MemberNo_3").equalsIgnoreCase("NA"))
        	removeProperty("MemberNo_3");
        else
        {   
        	getProperties().replace("MemberNo_3",data.get("MemberNo_3").toString());;
        	getProperties().replace("Member3_Salutation",data.get("Member3_Salutation").toString());
        	getProperties().replace("Member3_First_Name",data.get("Member3_First_Name").toString());
        	getProperties().replace("Member3_Gender",data.get("Member3_Gender").toString());
        	getProperties().replace("Member3_DateOfBirth",data.get("Member3_DateOfBirth").toString());
        	getProperties().replace("Member3_Relation_Code",data.get("Member3_Relation_Code").toString());
        	getProperties().replace("Member3_PrimaryMember",data.get("Member3_PrimaryMember").toString());
        }
		
//		MemberNo_4
		if(data.get("MemberNo_4").equalsIgnoreCase("NA"))
        	removeProperty("MemberNo_4");
        else
        {   
        	getProperties().replace("MemberNo_4",data.get("MemberNo_4").toString());;
        	getProperties().replace("Member4_Salutation",data.get("Member4_Salutation").toString());
        	getProperties().replace("Member4_First_Name",data.get("Member4_First_Name").toString());
        	getProperties().replace("Member4_Gender",data.get("Member4_Gender").toString());
        	getProperties().replace("Member4_DateOfBirth",data.get("Member4_DateOfBirth").toString());
        	getProperties().replace("Member4_Relation_Code",data.get("Member4_Relation_Code").toString());
        	getProperties().replace("Member4_PrimaryMember",data.get("Member4_PrimaryMember").toString());
        }
		
		System.out.println( data.get("Nominee_First_Name").toString() + data.get("Nominee_Relationship_Code").toString());
		getProperties().replace("Nominee_First_Name", data.get("Nominee_First_Name").toString());	
		getProperties().replace("Nominee_Relationship_Code", data.get("Nominee_Relationship_Code").toString());
		
		getProperties().replace("collectionAmount", data.get("collectionAmount").toString());
		getProperties().replace("collectionRcvdDate", policy_StartDate);
		getProperties().replace("instrumentNumber", data.get("Source_Name").toString());
		getProperties().replace("instrumentDate", policy_StartDate);
	}
	
	public void setFQPlaceHolder(HashMap<String, String> data, String Quotation) 
	{	
		Calendar cal = Calendar.getInstance();
		String policy_StartDate = sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -364);
		policy_StartDate = sdf.format(cal.getTime());
		
		
		setHeaders("content-Type=application/json");
		setHeaders("User-Agent=PostmanRuntime/7.26.1");
		setHeaders("Accept=*/*");
		setHeaders("Accept-Encoding=gzip, deflate, br");
		setHeaders("Connection=keep-alive");
		ignoreSSLCerts();
		expectResponseStatus(HttpResponseStatusType.OK_200);
		
		String Construct = data.get("Construct").toString();
		String Product = data.get("Product-plan").toString();

		getProperties().replace("Member_Customer_ID", data.get("Member_Customer_ID").toString());
		getProperties().replace("salutation", data.get("salutation").toString());		
		getProperties().replace("firstName", data.get("firstName").toString());
		getProperties().replace("lastName", data.get("lastName").toString());
		getProperties().replace("dateofBirth", data.get("dateofBirth").toString());
		getProperties().replace("gender", data.get("gender").toString());
		getProperties().replace("pinCode", data.get("pinCode").toString());		
		getProperties().replace("primaryEmailID", data.get("primaryEmailID").toString());
		getProperties().replace("contactMobileNo", data.get("contactMobileNo").toString());
		
		getProperties().replace("startDate", policy_StartDate);
		getProperties().replace("Quotation_Number", Quotation);
		getProperties().replace("MasterPolicyNumber", data.get("MasterPolicyNumber").toString());	
		getProperties().replace("GroupID", data.get("GroupID").toString());
		getProperties().replace("Product_Code", data.get("Product_Code").toString());
		
		getProperties().replace("leadID", data.get("leadID").toString());
		getProperties().replace("Source_Name", data.get("Source_Name").toString());
		
		
		getProperties().replace("IsPayment", data.get("IsPayment").toString());
		getProperties().replace("SumInsured", data.get("SumInsured").toString());
		
		//Member_No
		if(data.get("MemberNo_1").equalsIgnoreCase("No"))
        	removeProperty("MemberNo_1");
        else
        {   
        	getProperties().replace("MemberNo_1",data.get("MemberNo_1").toString());;
        	getProperties().replace("Member1_Salutation",data.get("Member1_Salutation").toString());
        	getProperties().replace("Member1_First_Name",data.get("Member1_First_Name").toString());
        	getProperties().replace("Member1_Gender",data.get("Member1_Gender").toString());
        	getProperties().replace("Member1_DateOfBirth",data.get("Member1_DateOfBirth").toString());
        	getProperties().replace("Member1_Relation_Code",data.get("Member1_Relation_Code").toString());
        	getProperties().replace("Member1_PrimaryMember",data.get("Member1_PrimaryMember").toString());
        }
		
//		Member_No2
		if(data.get("MemberNo_2").equalsIgnoreCase("No"))
        	removeProperty("MemberNo_2");
        else
        {   
        	getProperties().replace("MemberNo_2",data.get("MemberNo_2").toString());;
        	getProperties().replace("Member2_Salutation",data.get("Member2_Salutation").toString());
        	getProperties().replace("Member2_First_Name",data.get("Member2_First_Name").toString());
        	getProperties().replace("Member2_Gender",data.get("Member2_Gender").toString());
        	getProperties().replace("Member2_DateOfBirth",data.get("Member2_DateOfBirth").toString());
        	getProperties().replace("Member2_Relation_Code",data.get("Member2_Relation_Code").toString());
        	getProperties().replace("Member2_PrimaryMember",data.get("Member2_PrimaryMember").toString());
        }
		
//		Member_No3
		if(data.get("MemberNo_3").equalsIgnoreCase("No"))
        	removeProperty("MemberNo_3");
        else
        {   
        	getProperties().replace("MemberNo_3",data.get("MemberNo_3").toString());;
        	getProperties().replace("Member3_Salutation",data.get("Member3_Salutation").toString());
        	getProperties().replace("Member3_First_Name",data.get("Member3_First_Name").toString());
        	getProperties().replace("Member3_Gender",data.get("Member3_Gender").toString());
        	getProperties().replace("Member3_DateOfBirth",data.get("Member3_DateOfBirth").toString());
        	getProperties().replace("Member3_Relation_Code",data.get("Member3_Relation_Code").toString());
        	getProperties().replace("Member3_PrimaryMember",data.get("Member3_PrimaryMember").toString());
        }
		
//		MemberNo_4
		if(data.get("MemberNo_4").equalsIgnoreCase("No"))
        	removeProperty("MemberNo_4");
        else
        {   
        	getProperties().replace("MemberNo_4",data.get("MemberNo_4").toString());;
        	getProperties().replace("Member4_Salutation",data.get("Member4_Salutation").toString());
        	getProperties().replace("Member4_First_Name",data.get("Member4_First_Name").toString());
        	getProperties().replace("Member4_Gender",data.get("Member4_Gender").toString());
        	getProperties().replace("Member4_DateOfBirth",data.get("Member4_DateOfBirth").toString());
        	getProperties().replace("Member4_Relation_Code",data.get("Member4_Relation_Code").toString());
        	getProperties().replace("Member4_PrimaryMember",data.get("Member4_PrimaryMember").toString());
        }
		
		getProperties().replace("Nominee_First_Name", data.get("Nominee_First_Name").toString());	
		getProperties().replace("Nominee_Relationship_Code", data.get("Nominee_Relationship_Code").toString());
		
		getProperties().replace("collectionAmount", data.get("collectionAmount").toString());
		getProperties().replace("collectionRcvdDate", policy_StartDate);
		getProperties().replace("instrumentNumber", data.get("Source_Name").toString());
		getProperties().replace("instrumentDate", policy_StartDate);
	}
	

}

