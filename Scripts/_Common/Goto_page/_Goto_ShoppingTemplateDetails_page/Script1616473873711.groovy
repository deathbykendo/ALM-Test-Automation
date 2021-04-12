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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

// Click on the TemplateName you pass it or the first from the list
try {
	templateName
}
catch (Exception ex) {
	throw new Exception("You need to pass the 'Shopping Template Name' of which you want to go to")
}

println("templateName1:" + templateName + ":::")

WebUI.click(findTestObject('Page_My Dashboard/span_Order'))

WebUI.click(findTestObject('Page_My Dashboard/a_Shopping Templates'))

WebUI.verifyElementPresent(findTestObject('Page_Shopping Templates/h2_Shopping Templates'), 5)

// This should be a KeyWord
// Click on the new Shopping Template Link
TestObject to = new TestObject('objectName')

to.addProperty('xpath', ConditionType.EQUALS, ((('//span[(text() = \'' + templateName) + '\' or . = \'') + templateName) +
	'\')]')

WebUI.click(to)

WebUI.delay(GlobalVariable.short_wait_time)