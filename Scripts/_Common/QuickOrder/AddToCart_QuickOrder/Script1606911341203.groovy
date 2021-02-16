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

// If no prod_code passed set default one
try {
    prod_code
}
catch (Exception ex) {
    prod_code = GlobalVariable.beer1_prodcode
} 

WebUI.callTestCase(findTestCase('_Common/MyCart/_EmptyCart'), [:], FailureHandling.STOP_ON_FAILURE)

//--------------------------------
//#> Future: alway an array to be passed to this Test Script and add all the products with a qty of 1
//--------------------------------
int prod_count = WebUI.callTestCase(findTestCase('_Common/MyCart/_GetProductCountInCart'), [:], FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('_Common/_Goto_page/_Goto_QuickOrder_page'), [:], FailureHandling.STOP_ON_FAILURE)

// Add first product
WebUI.setText(findTestObject('Page_Quick Order/input_Item code_ItemCode1'), '577536')

// Take the focus out of the input field by clicking here
WebUI.click(findTestObject('Page_Quick Order/h2_Quick Order'))
WebUI.delay(GlobalVariable.short_wait_time)

WebUI.setText(findTestObject('Page_Quick Order/input_Cartons_Cartons1'), '1')

// Take the focus out of the input field by clicking here
WebUI.click(findTestObject('Page_Quick Order/h2_Quick Order'))
WebUI.delay(GlobalVariable.short_wait_time)
// Add 2nd product
WebUI.setText(findTestObject('Page_Quick Order/input_Item code_ItemCode2'), '500767')

// Take the focus out of the input field by clicking here
WebUI.click(findTestObject('Page_Quick Order/h2_Quick Order'))
WebUI.delay(GlobalVariable.short_wait_time)

WebUI.setText(findTestObject('Page_Quick Order/input_Cartons_Cartons2'), '1')

// Take the focus out of the input field by clicking here
WebUI.click(findTestObject('Page_Quick Order/h2_Quick Order'))

WebUI.delay(GlobalVariable.short_wait_time)

WebUI.click(findTestObject('Page_Quick Order/button_Add to Cart'))

WebUI.delay(GlobalVariable.short_wait_time)

// Handle Pop up
if (WebUI.verifyElementVisible(findTestObject('Page_Quick Order/button_Proceed'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Quick Order/button_Proceed'))
}

int prod_count2 = WebUI.callTestCase(findTestCase('_Common/MyCart/_GetProductCountInCart'), [:], FailureHandling.OPTIONAL)


//#> this is hard code will need to be Dynamic
WebUI.verifyEqual(prod_count + 2, prod_count2)

