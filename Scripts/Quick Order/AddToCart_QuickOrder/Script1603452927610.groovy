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

// If no prod_code passed set default one
try {
    prod_code
}
catch (Exception ex) {
    prod_code = GlobalVariable.beer1_prodcode
} 

//#> Future: if they pass an array of prodcodes add them all
WebUI.callTestCase(findTestCase('_Goto_page/_Goto_QuickOrder_page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Page_Quick Order/input_Item code_js-sku-input-field js-quick-order-qty form-control newRow text-left'), 
    prod_code)

WebUI.click(findTestObject('Page_Quick Order/h2_Quick Order'))

// #> for some reason you have to enter the same object twice to add in the qty
WebUI.setText(findTestObject('Page_Quick Order/input_Item code_js-sku-input-field js-quick-order-qty form-control newRow text-left'), 
    '1')

//WebUI.sendKeys(findTestObject('Page_Quick Order/input_Cartons_form-control'), '1')
WebUI.click(findTestObject('Page_Quick Order/h2_Quick Order'))

WebUI.click(findTestObject('Page_Quick Order/button_Add to Cart'))

// Handle Pop up
if (WebUI.verifyElementVisible(findTestObject('Page_Quick Order/button_Proceed'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Quick Order/button_Proceed'))
}

WebUI.verifyTextPresent('Successfully added', false)

