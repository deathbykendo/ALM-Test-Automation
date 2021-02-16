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

WebUI.callTestCase(findTestCase('_Common/_Goto_page/_Goto_Home_page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('null'), [('search_term') : GlobalVariable.QDA.product], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('MyCart/_UpdateProduct_Qty'), [('qty') : GlobalVariable.QDA.qty], FailureHandling.STOP_ON_FAILURE)

// Convert to Floating point number or Integer
float QDA_price = Float.parseFloat(GlobalVariable.QDA.price)
Integer QDA_qty = ((GlobalVariable.QDA.qty) as Integer)

float QDA_total_price = (QDA_qty * QDA_price)

// Get the Carton Cost field
OnPage_carton_cost = WebUI.getText(findTestObject('null'))

OnPage_total_cost = WebUI.getText(findTestObject('null'))

// Get the number from the string
OnPage_carton_cost = OnPage_carton_cost.replaceAll('[^0-9.]', '')
OnPage_total_cost = OnPage_total_cost.replaceAll('[^0-9.]', '')

// Convert to Floating point number
float OnPage_total_cost = Float.parseFloat(OnPage_total_cost)

// Verify that the QDA cost per carton matches
WebUI.verifyEqual(OnPage_carton_cost, GlobalVariable.QDA.price)
WebUI.verifyEqual(OnPage_total_cost, QDA_total_price)


println((((('QDA Deal - product: ' + GlobalVariable.QDA.product) + ' Deal: ') + GlobalVariable.QDA.qty) + ' or more cartons @ $') + 
    GlobalVariable.QDA.price)

