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

try {
    num_prod_to_add
}
catch (Exception ex) {
    num_prod_to_add = 4
} 

// Empty Cart otherwise if you run this test case in a row it will fail cause it won't count the products correctly
WebUI.callTestCase(findTestCase('_Common/MyCart/_EmptyCart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('_Common/Goto_page/_Goto_Favorites_page'), [:], FailureHandling.STOP_ON_FAILURE)

for (i = 0; i < num_prod_to_add; i++) {
    WebUI.sendKeys(findTestObject(('Page_Browse/input_Cartons_innerAddToCartFormList' + i) + '.cartonQty'), '1')
}

WebUI.delay(GlobalVariable.short_wait_time)

WebUI.click(findTestObject('Page_Browse/button_Add to Cart'))

WebUI.delay(GlobalVariable.short_wait_time)

if (WebUI.verifyElementVisible(findTestObject('Page_Browse/button_Proceed'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Page_Browse/button_Proceed'))

    WebUI.delay(GlobalVariable.short_wait_time)
}

int prod_count2 = WebUI.callTestCase(findTestCase('_Common/MyCart/_GetProductCountInCart'), [:], FailureHandling.OPTIONAL)

WebUI.verifyEqual(num_prod_to_add, prod_count2)

