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

// Check the current cart product count
String cart_ProductCount = WebUI.callTestCase(findTestCase('MyCart_Page/_GetProductCountInCart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Your Shopping Cart/input_removeEntry_0'))

WebUI.click(findTestObject('Page_Your Shopping Cart/button_Delete selected'))

// Now check the product count is one less
String cart_ProductCount2 = WebUI.callTestCase(findTestCase('MyCart_Page/_GetProductCountInCart'), [:], FailureHandling.STOP_ON_FAILURE)

// Convert to integer, increment it's count, convert back to String then compare it back to the original figure cart_ProductCount
int cart_ProductCount2_int = cart_ProductCount2 as int
cart_ProductCount2_int = cart_ProductCount2_int + 1       // increment by 1 
cart_ProductCount2 = cart_ProductCount2_int as String

WebUI.verifyEqual(cart_ProductCount, cart_ProductCount2)

