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

// Not sure if we should use this Test Script 
// Use _getProductCountInCart instead (before and after


//--------------------------------------------------------------------------
// Pass the expected product count when calling test
// WebUI.callTestCase(findTestCase('_Common/MyCart/_CheckProductCountInCart'), [('product_count'):'4'], FailureHandling.STOP_ON_FAILURE)
//--------------------------------------------------------------------------


// If no search_term passed set default one
try {
    product_count
}
catch (Exception ex) {
    // Do something here if they don't pass the value
} 

WebUI.callTestCase(findTestCase('_Common/Goto_page/_Goto_MyCart_page'), [:], FailureHandling.STOP_ON_FAILURE)

// Get the text from the element
MyCart_text = WebUI.getText(findTestObject('Page_Your Shopping Cart/h2_My cart'))

// Get the number from the string and store in var
OnPage_product_count = MyCart_text.replaceAll('[^0-9]', '')

//println('>> On page Product Count: ' + OnPage_product_count + 'product_count:' + product_count)

WebUI.verifyEqual(OnPage_product_count, product_count)
