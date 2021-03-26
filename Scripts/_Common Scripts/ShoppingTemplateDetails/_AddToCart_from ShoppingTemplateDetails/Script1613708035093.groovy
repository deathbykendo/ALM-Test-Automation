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

WebUI.callTestCase(findTestCase('_Common Scripts/MyCart/_EmptyCart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('_Common Scripts/_Goto_page/_Goto_ShoppingTemplateDetails_page'), [('templateName') : templateName], FailureHandling.STOP_ON_FAILURE)

prod_count = WebUI.callTestCase(findTestCase('_Common Scripts/ShoppingTemplateDetails/_GetProductCountIn Template'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Shopping Template Details/u_Load Saved Quantities'))
WebUI.delay(GlobalVariable.short_wait_time)
WebUI.click(findTestObject('Page_Shopping Template Details/button_Add to Cart'))
WebUI.delay(GlobalVariable.short_wait_time)

prod_count2 = WebUI.callTestCase(findTestCase('_Common Scripts/MyCart/_GetProductCountInCart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(prod_count, prod_count2, false)

