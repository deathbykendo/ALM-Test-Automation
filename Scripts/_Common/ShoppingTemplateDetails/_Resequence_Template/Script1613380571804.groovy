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


// Tempalte page - resequence item adkljlkasdjfjf

WebUI.click(findTestObject('Page_Shopping Template Details/u_Resequence'))

WebUI.dragAndDropToObject(findTestObject('Page_Shopping Template Resequence/div_19 CRIMES PALE ALE CAN   375ML'), findTestObject(
        'Page_Shopping Template Resequence/div_4 PINES DINGO PUP ALE    330ML'))

WebUI.click(findTestObject('Page_Shopping Template Resequence/button_Save Sequence'))

WebUI.click(findTestObject('Page_Shopping Template Resequence/a_ Back to Template'))

WebUI.acceptAlert()

