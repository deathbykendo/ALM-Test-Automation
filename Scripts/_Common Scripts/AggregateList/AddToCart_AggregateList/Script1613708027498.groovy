import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

// Pass the number of products you want to add from the Aggregate list
try {
//#> Check that variable is of type 'int' otherwise throw error
	
	   num_prod_to_add   
}
catch (Exception e) {
    num_prod_to_add = 1
} 

int prod_count = WebUI.callTestCase(findTestCase('_Common Scripts/MyCart/_GetProductCountInCart'), [:], FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('_Common Scripts/_Goto_page/_Goto_AggregateList_page'), [:], FailureHandling.STOP_ON_FAILURE)

for (i = 0; i < num_prod_to_add; i++) {
	WebUI.sendKeys(findTestObject('Page_Browse/input_Cartons_innerAddToCartFormList' + i + '.cartonQty'), '1')	
}

WebUI.delay(GlobalVariable.medium_wait_time)
WebUI.click(findTestObject('Page_Aggregate List/button_Add to Cart'))

if (WebUI.verifyElementVisible(findTestObject('Page_Browse/button_Proceed'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Browse/button_Proceed'))
}

int prod_count2 = WebUI.callTestCase(findTestCase('_Common Scripts/MyCart/_GetProductCountInCart'), [:], FailureHandling.OPTIONAL)

WebUI.verifyEqual(prod_count + num_prod_to_add, prod_count2)



