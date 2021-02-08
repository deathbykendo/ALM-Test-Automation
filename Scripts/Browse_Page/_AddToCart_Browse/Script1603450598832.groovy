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

// If no category passed set default one
try {
    category
}
catch (Exception ex) {
    category = GlobalVariable.default_category
} 

// -----------------------------------------------
// Specify the category you want to add to cart from and 4 of it will be added
// WebUI.callTestCase(findTestCase('_Common/_AddToCart'), [('category') : 'wine'], FailureHandling.STOP_ON_FAILURE)
// -----------------------------------------------
if (category == 'beer') {
    WebUI.callTestCase(findTestCase('Browse_Page/_Browse_Beer'), [:], FailureHandling.STOP_ON_FAILURE)
} else if (category == 'wine') {
    WebUI.callTestCase(findTestCase('Browse_Page/_Browse_Wine'), [:], FailureHandling.STOP_ON_FAILURE)
} else if (category == 'cider') {
    WebUI.callTestCase(findTestCase('Browse_Page/_Browse_Cider'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.callTestCase(findTestCase('Browse_Page/_Browse_Beer'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.sendKeys(findTestObject('Page_Browse/input_Cartons_innerAddToCartFormList0.cartonQty'), '1')

WebUI.sendKeys(findTestObject('Page_Browse/input_Cartons_innerAddToCartFormList1.cartonQty'), '2')

WebUI.sendKeys(findTestObject('Page_Browse/input_Cartons_innerAddToCartFormList2.cartonQty'), '3')

WebUI.sendKeys(findTestObject('Page_Browse/input_Cartons_innerAddToCartFormList3.cartonQty'), '4')

WebUI.click(findTestObject('Page_Browse/button_Add to Cart'))

if (WebUI.verifyElementVisible(findTestObject('Page_Browse/button_Proceed'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Browse/button_Proceed'))
} 

WebUI.delay(3)




