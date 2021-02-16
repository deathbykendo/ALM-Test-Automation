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

// Get the value from the Global Variables
templateName = GlobalVariable.ShoppingTemplateName

templateName = 'wine_6843'

WebUI.callTestCase(findTestCase('_Common/_Goto_page/_Goto_ShoppingTemplate_page'), [:], FailureHandling.STOP_ON_FAILURE)

// Verify that the Template name appears on the page
WebUI.verifyTextPresent(templateName, false)

// Verify that that Tamplate name we are going to change it to does NOT exisit yet
WebUI.verifyTextNotPresent('New_Template_Name_Bobby', false)

WebUI.click(findTestObject('Page_Shopping Templates/ShoppingTemplate Edit Name'))

WebUI.setText(findTestObject('Page_Shopping Templates/input_Name_templateName'), 'New_Template_Name_Bobby')

WebUI.click(findTestObject('Page_Shopping Templates/button_Save'))
WebUI.delay(GlobalVariable.short_wait_time)
// Verify that the Template name appears on the page
WebUI.verifyTextPresent('New_Template_Name_Bobby', false)

WebUI.click(findTestObject('Page_Shopping Templates/ShoppingTemplate Edit Name'))

WebUI.setText(findTestObject('Page_Shopping Templates/input_Name_templateName'), templateName)
WebUI.click(findTestObject('Page_Shopping Templates/button_Save'))
