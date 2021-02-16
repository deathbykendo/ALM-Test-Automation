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

// -----------------------------------------------
// Specify the category you want to add to cart from and 4 of it will be added
// WebUI.callTestCase(findTestCase('Shopping Template/_AddToShoppingTemplate_Browse'), [('category') : 'cider'], FailureHandling.STOP_ON_FAILURE)
// -----------------------------------------------
// If no category passed set default one
try {
    category
}
catch (Exception ex) {
    category = GlobalVariable.default_category
} 

if (category == 'beer') {
    WebUI.callTestCase(findTestCase('_Common/Browse/_Browse_Beer'), [:], FailureHandling.STOP_ON_FAILURE)
} else if (category == 'wine') {
    WebUI.callTestCase(findTestCase('_Common/Browse/_Browse_Wine'), [:], FailureHandling.STOP_ON_FAILURE)
} else if (category == 'cider') {
    WebUI.callTestCase(findTestCase('_Common/Browse/_Browse_Cider'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.callTestCase(findTestCase('_Common/Browse/_Browse_Beer'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.sendKeys(findTestObject('Page_Browse/input_Cartons_innerAddToCartFormList0.cartonQty'), '1')

WebUI.sendKeys(findTestObject('Page_Browse/input_Cartons_innerAddToCartFormList1.cartonQty'), '2')

WebUI.sendKeys(findTestObject('Page_Browse/input_Cartons_innerAddToCartFormList2.cartonQty'), '3')

WebUI.sendKeys(findTestObject('Page_Browse/input_Cartons_innerAddToCartFormList3.cartonQty'), '4')

WebUI.click(findTestObject('Page_Browse/button_Add to Shopping Templates'))

WebUI.click(findTestObject('Page_Browse/a_Shopping list(s)'))

WebUI.click(findTestObject('Page_Browse/a_Create a new list'))

Random rnd = new Random()

randomNumber = rnd.nextInt(99)

// Create the template name
templateName = ((category + '_') + randomNumber)

WebUI.setText(findTestObject('Page_Browse/input_Shopping list(s)_js-newList'), templateName)

WebUI.click(findTestObject('Page_Browse/a_Add to list'))

WebUI.delay(3)

WebUI.callTestCase(findTestCase('_Common/_Goto_page/_Goto_ShoppingTemplate_page'), [:], FailureHandling.STOP_ON_FAILURE)

// Click on the new Shopping Template Link
TestObject to = new TestObject('objectName')

to.addProperty('xpath', ConditionType.EQUALS, ((('//span[(text() = \'' + templateName) + '\' or . = \'') + templateName) + 
    '\')]')

WebUI.click(to)

