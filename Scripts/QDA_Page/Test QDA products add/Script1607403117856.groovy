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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


WebUI.verifyElementVisible(findTestObject('Page_Promotions/span_QDA'), FailureHandling.OPTIONAL)

WebUI.verifyElementVisible(findTestObject('Page_Promotions/h2_QDAs xx products available'), FailureHandling.OPTIONAL)

WebUI.verifyElementVisible(findTestObject('Page_Promotions/div_682056'), FailureHandling.OPTIONAL)

WebUI.verifyElementVisible(findTestObject('Page_Promotions/h4_Quantity dependant allowance'), FailureHandling.OPTIONAL)

//WebUI.click(findTestObject('Page_Promotions/strong_10 or morecartons 51.60'))

WebUI.verifyElementVisible(findTestObject('Page_Promotions/strong_10 or morecartons 51.60'), FailureHandling.OPTIONAL)

//WebUI.click(findTestObject('Page_Promotions/p_10 or morecartons 51.60Start03Nov20, Ends29Jan21'))

WebUI.verifyElementVisible(findTestObject('Page_Promotions/p_10 or morecartons 51.60Start03Nov20, Ends29Jan21'), FailureHandling.OPTIONAL)

//WebUI.setText(findTestObject('Page_Promotions/input_Cartons_innerAddToCartFormList0.cartonQty'), '1')

WebUI.sendKeys(findTestObject('Page_Promotions/input_Cartons_innerAddToCartFormList0.cartonQty'), '1')

//..

WebUI.click(findTestObject('Page_Promotions/a_995831'))

WebUI.click(findTestObject('Page_Promotions/span_QDA'))

WebUI.click(findTestObject('Page_Promotions/h4_Quantity dependant allowance'))

WebUI.click(findTestObject('Page_Promotions/strong_5 or morecartons 50.14'))

WebUI.click(findTestObject('Page_Promotions/p_5 or morecartons 50.14Start23Sep20, Ends30Nov20'))

WebUI.setText(findTestObject('Page_Promotions/input_Cartons_innerAddToCartFormList1.cartonQty'), 
    '1')

WebUI.click(findTestObject('Page_Promotions/div_681076'))

WebUI.click(findTestObject('Page_Promotions/span_QDA'))

WebUI.click(findTestObject('Page_Promotions/h4_Quantity dependant allowance'))

WebUI.click(findTestObject('Page_Promotions/strong_10 or morecartons 50.70'))

WebUI.click(findTestObject('Page_Promotions/p_10 or morecartons 50.70Start03Nov20, Ends29Jan21'))

WebUI.setText(findTestObject('Page_Promotions/input_Cartons_innerAddToCartFormList2.cartonQty'), 
    '1')

WebUI.click(findTestObject('Page_Promotions/button_Add to Cart'))

