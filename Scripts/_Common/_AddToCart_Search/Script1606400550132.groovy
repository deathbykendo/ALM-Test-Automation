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


// If no search_term passed set default one
try {
	search_term
}
catch (Exception ex) {
	search_term = GlobalVariable.Search_term_default
}

WebUI.callTestCase(findTestCase('_Goto_page/_Goto_Home_page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('_Common/_Search_product'), [('search_term') : search_term], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Page_BEER  LIQUOR  Open Catalogue/input_Cartons_innerAddToCartFormList0.cartonQty'), '1')

WebUI.click(findTestObject('Page_BEER  LIQUOR  Open Catalogue/button_Add to Cart'))

if (WebUI.verifyElementVisible(findTestObject('Page_BEER  LIQUOR  Open Catalogue/button_Proceed'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Page_BEER  LIQUOR  Open Catalogue/button_Proceed'))
}

WebUI.delay(3)