import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('_Common/Login/_Login'), [:], FailureHandling.STOP_ON_FAILURE)

// Check Privacy link
WebUI.click(findTestObject('Page_My Dashboard/a_Privacy policy'))

WebUI.delay(GlobalVariable.short_wait_time)

WebUI.switchToWindowIndex(1)

WebUI.verifyElementVisible(findTestObject('Metcash  Australia/h1_Privacy Policy'))

WebUI.closeWindowIndex(1)

// Check Terms and condition link
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_My Dashboard/a_Terms  conditions'))

WebUI.delay(GlobalVariable.short_wait_time)

WebUI.switchToWindowIndex(1)

WebUI.verifyElementVisible(findTestObject('Metcash  Australia/h1_Terms  Conditions'))

WebUI.closeWindowIndex(1)

// Check TRading link
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_My Dashboard/a_Trading terms'))

WebUI.delay(GlobalVariable.short_wait_time)

WebUI.switchToWindowIndex(1)

WebUI.verifyElementVisible(findTestObject('Metcash  Australia/h1_Trading Terms'))

WebUI.closeWindowIndex(1)

// Check Credit link
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_My Dashboard/a_Credit reporting policy'))

WebUI.delay(GlobalVariable.short_wait_time)

WebUI.switchToWindowIndex(1)

WebUI.verifyElementVisible(findTestObject('Metcash  Australia/h1_Credit  Data Policy'))

WebUI.closeWindowIndex(1)

// Check Help link
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_My Dashboard/a_Help'))

WebUI.delay(GlobalVariable.short_wait_time)

WebUI.switchToWindowIndex(1)

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Help/h2_Help'))

WebUI.closeWindowIndex(1)

// Check Privacy link
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_My Dashboard/a_Contact us'))

WebUI.delay(GlobalVariable.short_wait_time)

WebUI.switchToWindowIndex(1)

WebUI.verifyElementVisible(findTestObject('Page_My Dashboard/a_Contact us'))

WebUI.closeWindowIndex(1)
WebUI.switchToWindowIndex(0)

