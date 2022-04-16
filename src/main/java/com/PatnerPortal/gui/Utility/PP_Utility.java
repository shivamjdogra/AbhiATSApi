package com.PatnerPortal.gui.Utility;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PP_Utility {
	static int i = 0 ;
	static String lastName="";
	static String firstName="";
	static String middleName="";
	static String mobileNum="";

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public static String generateFirstName(String userExisting) {

		if(userExisting.equals("")) {
			String AlphabeticString="abcdefghijklmnopqrstuvwxyz";
			int nLen=6;
			StringBuilder sb= new StringBuilder(nLen);
			for (int i = 0; i < nLen; i++) {
				int index=(int) (AlphabeticString.length()*Math.random());
				sb.append(AlphabeticString.charAt(index));
			}
			firstName =sb.toString();
		}
		return firstName;
	}
	
	public static String generateMiddleName(String userExisting) {

		if(userExisting.equals("")) {
			String AlphabeticString="abcdefghijklmnopqrstuvwxyz";
			int nLen=6;
			StringBuilder sb= new StringBuilder(nLen);
			for (int i = 0; i < nLen; i++) {
				int index=(int) (AlphabeticString.length()*Math.random());
				sb.append(AlphabeticString.charAt(index));
			}
			middleName =sb.toString();
		}
		return middleName;
	}

	public static String generateLastName(String userExisting) {

		if(userExisting.equals("")) {
			String AlphabeticString="abcdefghijklmnopqrstuvwxyz";
			int nLen=6;
			StringBuilder sb=new StringBuilder(nLen);
			for (int i = 0; i < nLen; i++) {
				int index=(int) (AlphabeticString.length() * Math.random());
				sb.append(AlphabeticString.charAt(index));
			}
			lastName=sb.toString();
		}
		return lastName;
	}

	public static String generateEmail() {
		return firstName+"."+lastName+"@gmail.com";
	}

	public static String generateMobileNum(String userExisting) {

		if(userExisting.equals("")) {
			String NumericString="1234567890";
			int nLen=10;
			StringBuilder sb= new StringBuilder(nLen);
			sb.append(5);
			for (int i = 1; i < nLen; i++) {
				int index=(int) (NumericString.length()*Math.random());
				sb.append(NumericString.charAt(index));
			}
			mobileNum =sb.toString();
		}
		return mobileNum;
	}

	public static String createScreenshotDir(String ScreenShotPath) {
		String sDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));
		String sTime = sdf.format(cal.getTime());
		ScreenShotPath = ScreenShotPath + File.separator + "Screenshots"+ File.separator + sDate + "_" + sTime.replace(":", "-");
		try {
			if (!new File(ScreenShotPath).exists()) {
				new File(ScreenShotPath).mkdirs();
			}
		} catch (Exception e) {
			LOGGER.error("Screenshot Path Exception:"+e.getMessage());
		}
		return ScreenShotPath;
	}


	public static void Screenshot(WebDriver driver, String TestCaseId, String Name,String ScreenShotPath) {

		ScreenShotPath = ScreenShotPath + File.separator + TestCaseId;
		try {
			if (!new File(ScreenShotPath).exists()) {
				new File(ScreenShotPath).mkdirs();
			}
		} catch (Exception e) {
			LOGGER.error("Screenshot Path Exception:"+e.getMessage());
		}

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String dDate = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
		dDate = dDate.replace(":", "").replace(" ", "").replace(".", "");

		try {
			FileUtils.copyFile(src, new File(ScreenShotPath + "/" + dDate + "_" + Name + ".png"));
		} catch (IOException e) {
			LOGGER.error("Exception while taking Screenshot:"+e.getMessage());
			e.printStackTrace();
		}
	}
}

