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
import org.openqa.selenium.Keys as Keys

//def Card_0_Status = WebUI.getText(findTestObject((‘Automation_Objects / Card_0) / Card_0_Status’))

//def Card_0_CardDetails_Status = WebUI.getText(findTestObject((‘Automation_Objects / Card_0) / Card_0_CardDetails_Status’))

//WebUI.verifyMatch(Card_0_Status, Card_0_CardDetails_Status, false)

cartonCost = WebUI.getText(findTestObject('Page_Your Shopping Cart/row_0E_cartonCost'))

cartonCost = cartonCost.replaceAll('[^0-9.]', '')
println("Carton Cost:" + cartonCost)

// Convert from STring to floating point number
float cartonCost_num = cartonCost as float

qty = WebUI.getText(findTestObject('Page_Your Shopping Cart/input_Cartons_cartEntries0.innerCartEntry.newCartonQty'))
println("qty:" + qty)
//int qty = qty as int


//WebUI.getText(findTestObject('Page_Your Shopping Cart/row_0H_totalPrice'))




