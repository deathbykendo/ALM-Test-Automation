import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.click(findTestObject('Page_Login/button_Registration'))

WebUI.verifyElementVisible(findTestObject('Page_Registration/button_Register now'))

WebUI.verifyElementVisible(findTestObject('Page_Registration/h1_Registration'))

WebUI.verifyElementVisible(findTestObject('Page_Registration/input_Customer ID_customerId'))

WebUI.verifyElementVisible(findTestObject('Page_Registration/input_Email address_email'))

WebUI.verifyElementVisible(findTestObject('Page_Registration/input_Postcode_postCode'))

'Check for error message, if fields blank'
WebUI.click(findTestObject('Page_Registration/button_Register now'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Page_Registration/div_Please fill all mandatory fields'))

'Check for error message, if fields blank'
WebUI.click(findTestObject('Page_Registration/a_Login'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Page_Login/h1_Login'))

