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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.callTestCase(findTestCase('_Common/_Goto_page/_Goto_Login_page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Login/a_Forgotten password'))

WebUI.verifyElementPresent(findTestObject('Page_Reset your password/h2_Reset your password'), 0)

WebUI.setText(findTestObject('Page_Reset your password/input_Customer ID_customerId'), '')

WebUI.click(findTestObject('Page_Reset your password/button_Submit'))

WebUI.verifyElementPresent(findTestObject('Page_Reset your password/div_Please enter a valid CustomerID'), 0)

WebUI.click(findTestObject('Page_Reset your password/img_Created using Figma_id-logo'))

WebUI.verifyElementPresent(findTestObject('Page_Login/h1_Login'), 0)

