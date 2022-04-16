package abhi_API;

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
import com.thirdparty.api.pages.RetailQuote;
import com.thirdparty.utilities.Xls_Reader;

import io.restassured.response.Response;

public class RetailRunner implements IAbstractTest {

	String Error, Error1;
	static Logger LOGGER = Logger.getLogger(RetailRunner.class);

	@Test(dataProvider = "SingleDataProvider", description = "policy Issuance", enabled = true)
	@MethodOwner(owner = "qk")
	@TestPriority(Priority.P1)
	@TestTag(name = "Squad", value = "TP")
	@TestTag(name = "api_source", value = "")
	@TestTag(name = "test_type", value = "end-2-end")
	@XlsDataSourceParameters(path = "xls/retail.xls", sheet = "sheet1", dsUid = "TUID")

	public void AbhiAxisTelelsalesFullQuoteAPI(HashMap<String, String> data) {

		// Excel
		String scriptDirectory = System.getProperty("user.dir");
		String testdataPath = scriptDirectory + "/src/test/resources/xls/retail.xls";
		String xlsSheetName = "sheet1";
		// sysout
		String TUID = data.get("TUID");
		System.out.println(TUID);
		ReportContext.setCustomTestDirName(TUID);
		Xls_Reader xlsReader = new Xls_Reader(testdataPath);
		int xlsRowNum = xlsReader.getCellRowNum(xlsSheetName, "TUID", TUID);

		System.out.println("**********Quick Quote**********");
		RetailQuote qq = new RetailQuote();
		qq.doQuickQuote(data, "", "3");
		Response qqResponse = qq.callAPI();
		String res = qqResponse.getBody().print();
		int statusCode = qqResponse.getStatusCode();

		System.out.println("Quick Quote status code: " + statusCode);
		try {
			// Check Quick Quote status code
			if (statusCode == 200) {

				// Get error message and quote number
				String msg[] = res.split("<errorMessage>");
				String splitMsg[] = msg[1].split("</");
				String errorMessage = splitMsg[0].trim();
				String isPayment = "1";
				System.out.println("ErrorMessage is: " + errorMessage);

				// check QQ error message
				if (errorMessage.equalsIgnoreCase("Sucess")) {

					xlsReader.setCellData(xlsSheetName, "QQ_ErrorMessage", xlsRowNum, "PASS: " + errorMessage);
					System.out.println("**********Full Quote**********");

					String qNo[] = res.split("<quoteNumber>");
					String splitqNo[] = qNo[1].split("</");
					String Quotation = splitqNo[0].trim();
					System.out.println("Quotation no is: " + Quotation);
					System.out.println("isPayment is: " + isPayment);

					RetailQuote fq = new RetailQuote();
					fq.doFullQuote(data, Quotation, isPayment);
					Response finalResponse = fq.callAPI();
					String finalResMsg = finalResponse.getBody().print();
					int finalStatusCode = finalResponse.getStatusCode();

					System.out.println("Full Quote status code: " + finalStatusCode);

					// Check full quote status code
					if (finalStatusCode == 200) {
						String amount[] = finalResMsg.split("<FinalPremium>");
						String finalAmount[] = amount[1].split("</");

						String policy[] = finalResMsg.split("<policyNumber>");
						String finalPolicy[] = policy[1].split("</");

						String proposal[] = finalResMsg.split("<proposalNumber>");
						String finalProposal[] = proposal[1].split("</");

						String actualPremium = finalAmount[0].trim();
						String policyNo = finalPolicy[0].trim();
						String proposalNo = finalProposal[0].trim();

						xlsReader.setCellData(xlsSheetName, "Policy_Number", xlsRowNum, policyNo);
						xlsReader.setCellData(xlsSheetName, "Proposal_Number", xlsRowNum, proposalNo);

						if (actualPremium.equalsIgnoreCase(data.get("collectionAmount"))) {
							System.out.println("Expected Premium: " + data.get("collectionAmount"));
							System.out.println("Actual Premium: " + actualPremium);
							xlsReader.setCellData(xlsSheetName, "Actual_Premium", xlsRowNum, "PASS: " + actualPremium);
						} 
						else {
							xlsReader.setCellData(xlsSheetName, "Actual_Premium", xlsRowNum, "FAIL: " + actualPremium);
							System.out.println("Premium Mismatch");
							throw new Exception();
						}
						// FQ error message
						String fq_msg[] = finalResMsg.split("<errorMessage>");
						String fq_splitMsg[] = fq_msg[1].split("</");
						String fq_errorMessage = fq_splitMsg[0].trim();
						System.out.println("ErrorMessage is: " + fq_errorMessage);
						// Check FQ error message
						if (fq_errorMessage.equalsIgnoreCase("Sucess")) {
							xlsReader.setCellData(xlsSheetName, "FQ_ErrorMessage", xlsRowNum,"PASS: " + fq_errorMessage);
						} 
						else {
							xlsReader.setCellData(xlsSheetName, "FQ_ErrorMessage", xlsRowNum,"FAIL: " + fq_errorMessage);
							throw new Exception();
						}

					}
				} 
				else {
					xlsReader.setCellData(xlsSheetName, "QQ_ErrorMessage", xlsRowNum, "FAIL: " + errorMessage);
				}
				
				xlsReader.setCellData(xlsSheetName, "Execution_Status", xlsRowNum, "PASS");
			}

		} catch (Exception e) {
			xlsReader.setCellData(xlsSheetName, "Execution_Status", xlsRowNum, "FAIL");
			e.printStackTrace();
			Assert.assertFalse(true);
		}

	}
}
