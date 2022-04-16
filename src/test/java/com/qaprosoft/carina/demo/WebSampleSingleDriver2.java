/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs.SpecType;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

/**
 * This sample shows how create Web test with dependent methods which shares existing driver between methods.
 * 
 * @author qpsdemo
 */
public class WebSampleSingleDriver2 implements IAbstractTest {
    HomePage homePage = null;
    CompareModelsPage comparePage = null;
    List<ModelSpecs> specs = new ArrayList<>();

    @BeforeSuite
    public void startDriver() {
        // Open GSM Arena home page and verify page is opened
        homePage = new HomePage(getDriver());
    }
    
    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testOpenPage() {
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
    
    @Test(dependsOnMethods="testOpenPage") //for dependent tests Carina keeps driver sessions by default
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testOpenCompare() {
        // Open GSM Arena home page and verify page is opened
        // Open model compare page
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
        comparePage = footerMenu.openComparePage();

    }
    
    @Test(dependsOnMethods="testOpenCompare") //for dependent tests Carina keeps driver sessions by default
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "regression"})
    public void testReadSpecs() {
        // Compare 3 models
        specs = comparePage.compareModels("Samsung Galaxy J3", "Samsung Galaxy J5", "Samsung Galaxy J7 Pro");
    }
    
    @Test(dependsOnMethods="testReadSpecs") //for dependent tests Carina keeps driver sessions by default
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCompareModels() {
        // Verify model announced dates
        Assert.assertEquals(specs.get(0).readSpec(SpecType.ANNOUNCED), "2016, March 31");
        Assert.assertEquals(specs.get(1).readSpec(SpecType.ANNOUNCED), "2015, June 19");
        Assert.assertEquals(specs.get(2).readSpec(SpecType.ANNOUNCED), "2017, June");
    }
    /*
    @Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/HBtestData.xlsx", sheet = "Client", dsUid = "TUID", testRailColumn = "CustomerType")
    public void addClient(HashMap<String, String>Clientdata) throws InterruptedException, AWTException {
    	
    	Client addClient = new Client(getDriver());
    	//addClient.addClient(Clientdata);
    	  	
    }
    */
    @Test(dataProvider = "SingleDataProvider",dependsOnMethods="addClient")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/HBtestData.xlsx", sheet = "Inward", dsUid = "TUID", testRailColumn = "CustomerType")
    public void addInward(HashMap<String, String>data) throws InterruptedException, AWTException {
    	
    	//Inward inwardData = addClient.(getDriver());
    	//inwardData.setInward();
    	  	
    }

}
