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

// You changed the login to be production, so you put this here in case it gets called. 
throw new Exception("Warning - You changed the login to be production, so you put this here to stop an accidental checkouts")

WebUI.callTestCase(findTestCase('_Goto_page/_Goto_MyCart_page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Page_Your Shopping Cart/button_Proceed to checkout'), 0)

WebUI.click(findTestObject('Page_Your Shopping Cart/button_Proceed to checkout'))

WebUI.verifyElementPresent(findTestObject('Page_Checkout/h2_Checkout - Review Order'), 0)

WebUI.click(findTestObject('Page_Checkout/button_Place order'))

WebUI.verifyElementPresent(findTestObject('Page_Order Confirmation/h2_Checkout - Order Placed'), 0)



