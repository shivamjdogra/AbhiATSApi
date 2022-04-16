package abhi_API;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.ReportContext;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestTag;
import com.thirdparty.api.pages.AxisTelesalesGHI_FullQuote;
import com.thirdparty.utilities.Xls_Reader;

import io.restassured.response.Response;

public class AbhiAxisTelelsalesFullQuote implements IAbstractTest{
	String Error,Error1;
	static Logger LOGGER = Logger.getLogger(AbhiAxisTelelsalesFullQuote.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T00:00:00'");
	
	@Test(dataProvider = "SingleDataProvider" , description ="policy Issuance", enabled=true)
    @MethodOwner(owner = "qk")
	@TestPriority(Priority.P1)
    @TestTag(name = "Squad", value = "TP")
	@TestTag(name = "api_source", value = "")
    @TestTag(name = "test_type", value = "end-2-end")
	@XlsDataSourceParameters(path = "xls/ABHIAxisTelesalesData.xls",sheet = "fullQuote", dsUid = "TUID")
	
	public void AbhiAxisTelelsalesFullQuoteAPI(HashMap<String, String> data) 
	{
		
		String scriptDirectory = System.getProperty("user.dir");
		String testdataPath = scriptDirectory+"/src/test/resources/xls/ABHIAxisTelesalesData.xls";

		String xlsSheetName = "fullQuote";
		
		String TUID = data.get("TUID");
		System.out.println(TUID);
		ReportContext.setCustomTestDirName(TUID);
		String isPayment = "0";
		Xls_Reader xlsReader = new Xls_Reader(testdataPath);
		int xlsRowNum =xlsReader.getCellRowNum(xlsSheetName, "TUID", TUID);

		AxisTelesalesGHI_FullQuote tpPostMethod = new AxisTelesalesGHI_FullQuote();
		tpPostMethod.setPlaceHolder(data, "", isPayment);
		Response resTP = tpPostMethod.callAPI();
		String response = resTP.getBody().print(); 
		int statusCode = resTP.getStatusCode();
		System.out.println("status code is "+statusCode);
		System.out.println("resonse is "+response );
			
		try 
		{
			if(statusCode==200)
			{
					String QuotationNo ="";
					String PolicyNumber="";
					String CertificateNumber="";
					String BasePremium="";
					String NetPremium="";
					String GST="";
					String GrossPremium="";
					isPayment="1";

					String fullErrorText[] = response.split("ErrorMessage\":");
					String fullError =fullErrorText[0].split("</")[1].trim();
					String SuccessError = fullError.split(">")[2].trim();
					
					System.out.println("Success message  is :- "+ SuccessError);
					
					if(SuccessError.equalsIgnoreCase("Success"))
					{
						String fQuoteNumberA[] = response.split("<QuotationNumber>");
						QuotationNo = fQuoteNumberA[1].split("</")[0].trim();
						System.out.println("FullQuoteNumber Number is :- "+ QuotationNo);
						
						AxisTelesalesGHI_FullQuote fullPostMethod = new AxisTelesalesGHI_FullQuote();
						fullPostMethod.setPlaceHolder(data, QuotationNo,isPayment);
						Response resFullQuote = fullPostMethod.callAPI();
						String responseFO = resFullQuote.getBody().print(); 
						statusCode = resFullQuote.getStatusCode();
						System.out.println("status code is "+statusCode);
						System.out.println("resonse is "+responseFO );
						
						if(statusCode==200)
						{
							String PolicyNumberA[] = responseFO.split("<PolicyNumber>");
							PolicyNumber = PolicyNumberA[1].split("</")[0].trim();
							System.out.println("Policy Number is :- "+ PolicyNumber);
							
							xlsReader.setCellData(xlsSheetName, "Policy_No", xlsRowNum, PolicyNumber);

							String CertificateNumberA[] = responseFO.split("<CertificateNumber>");
							CertificateNumber = CertificateNumberA[1].split("</")[0].trim();
							System.out.println("Certificate Number is :- "+ CertificateNumber);
							
							xlsReader.setCellData(xlsSheetName, "CertificateNumber", xlsRowNum, CertificateNumber);

							
						/*	String BasePremiumA[] = responseFO.split("<BasePremium>");
							BasePremium = BasePremiumA[1].split("</")[0].trim();
							System.out.println("BasePremium is :- "+ BasePremium);
							
							String NetPremiumA[] = responseFO.split("<NetPremium>");
							NetPremium = NetPremiumA[1].split("</")[0].trim();
							System.out.println("Net Premium is :- "+ NetPremium);
							
							String GSTA[] = responseFO.split("<GST>");
							GST = GSTA[1].split("</")[0].trim();
							System.out.println("GST is :- "+ GST);
							*/
							String GrossPremiumA[] = responseFO.split("<GrossPremium>");
							GrossPremium = GrossPremiumA[1].split("</")[0].trim();
							System.out.println("Gross Premium is :- "+ GrossPremium);
							
							
							//VP Integration
						/*	if(BasePremium.equalsIgnoreCase(data.get("BasePremium").toString()))
							{
								xlsReader.setCellData(xlsSheetName, "ActualBasePremium", xlsRowNum, "PASS : "+BasePremium);

							}
							else
							{
								xlsReader.setCellData(xlsSheetName, "ActualBasePremium", xlsRowNum, "FAIL : "+BasePremium);

							}
							if(NetPremium.equalsIgnoreCase(data.get("NetPremium").toString()))
							{
								xlsReader.setCellData(xlsSheetName, "ActualNetPremium", xlsRowNum, "PASS : "+NetPremium);

							}
							else
							{
								xlsReader.setCellData(xlsSheetName, "ActualNetPremium", xlsRowNum, "FAIL : "+NetPremium);

							}
							
							if(GST.equalsIgnoreCase(data.get("GST").toString()))
							{
								xlsReader.setCellData(xlsSheetName, "ActualGST", xlsRowNum, "PASS : "+GST);

							}
							else
							{
								xlsReader.setCellData(xlsSheetName, "ActualGST", xlsRowNum, "FAIL : "+GST);

							}
							*/
							if(GrossPremium.equalsIgnoreCase(data.get("GrossPremium").toString()))
							{
								xlsReader.setCellData(xlsSheetName, "ActualGrossPremium", xlsRowNum, "PASS : "+GrossPremium);

							}
							else
							{
								xlsReader.setCellData(xlsSheetName, "ActualGrossPremium", xlsRowNum, "FAIL : "+GrossPremium);
								throw new Exception();
							}
						}
						
					}
			}
			xlsReader.setCellData(xlsSheetName, "Status", xlsRowNum, "PASS");
		}
		catch(Exception e) 
		{
			xlsReader.setCellData(xlsSheetName, "Status", xlsRowNum, "FAIL");
			
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
}
