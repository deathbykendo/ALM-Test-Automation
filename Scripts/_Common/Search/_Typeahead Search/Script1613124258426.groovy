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

WebUI.callTestCase(findTestCase('_Common/Goto_page/_Goto_Home_page'), [:], FailureHandling.STOP_ON_FAILURE)

// Note: this Test script is hard coded cause its the only way I could get it to work
// So be it......... (KS)
WebUI.setText(findTestObject('Page_My Dashboard/input_MIP_js-site-search-input'), 'carlton draught')

WebUI.delay(GlobalVariable.short_wait_time)

WebUI.click(findTestObject('Page_My Dashboard/typeahead div_CARLTON DRAUGHT BTL      375ML'))

WebUI.delay(GlobalVariable.short_wait_time)

// Check that the prod code for Carlton Draught is on the page
WebUI.verifyTextPresent('505173', false)

