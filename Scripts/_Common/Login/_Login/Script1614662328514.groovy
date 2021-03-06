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
import org.openqa.selenium.Keys as Keys
import org.apache.commons.io.FileUtils

try {
    WebUI.navigateToUrl(GlobalVariable.URL_login)
}
catch (def BrowserNotOpenedException) {
    WebUI.openBrowser(GlobalVariable.URL_login)

    WebUI.maximizeWindow()
} 


WebUI.setText(findTestObject('Object Repository/Page_Login/input_Customer ID_j_username'), GlobalVariable.username)

WebUI.setText(findTestObject('Object Repository/Page_Login/input_Password_j_password'), GlobalVariable.password)

WebUI.click(findTestObject('Object Repository/Page_Login/button_Login'))

WebUI.delay(GlobalVariable.short_wait_time)

if (WebUI.waitForElementVisible(findTestObject('Page_My Dashboard/NewFlash popup'), 3, FailureHandling.CONTINUE_ON_FAILURE)) {
    WebUI.click(findTestObject('Page_My Dashboard/NewFlash popup'))

    WebUI.delay(GlobalVariable.short_wait_time)
}

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_My Dashboard/h2_My Dashboard'), GlobalVariable.short_wait_time)

// test ks