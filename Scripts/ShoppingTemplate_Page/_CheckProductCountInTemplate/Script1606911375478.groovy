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

//--------------------------------------------------------------------------
// Pass the expected product count when calling test
// WebUI.callTestCase(findTestCase('MyCart_Page/_CheckProductCountInCart'), [('product_count'):'4'], FailureHandling.STOP_ON_FAILURE)
//--------------------------------------------------------------------------
// If no search_term passed set default one
try {
    product_count
}
catch (Exception ex) {
    // Do something here if they don't pass the value
    product_count = "4"
} 

// Get the text from the element
MyCart_text = WebUI.getText(findTestObject('Page_Shopping Template Details/h2_ShoppingTemplate_Details'))

// Get the number from the string and store in var

String[] str;
str = MyCart_text.split(/\(/);
String MyCart_text = str[1]

OnPage_product_count = MyCart_text.replaceAll('[^0-9]', '')

println('>> On page Product Count: ' + OnPage_product_count + ' Expected_count:' + product_count)
WebUI.verifyEqual(OnPage_product_count, product_count)

