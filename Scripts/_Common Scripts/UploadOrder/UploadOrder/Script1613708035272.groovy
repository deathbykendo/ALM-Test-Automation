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

//WebUI.click(findTestObject('Page_Upload Order File/label_Browse'))
/*WebUI.click(findTestObject('Page_My Dashboard/span_Order'))

WebUI.click(findTestObject('Page_My Dashboard/a_Upload Order'))

WebUI.verifyElementPresent(findTestObject('Page_Upload Order File/h2_Upload Order File'), 0)
*/
//
//Passing the path of the file
WebUI.sendKeys(findTestObject('Page_Upload Order File/label_Browse'), 'C:\\\\Users\\\\smitkir\\\\OneDrive - Metcash Trading Limited\\\\Katalon Projects\\\\_TestData\\\\ALM_CSV_upload_data.csv')

//WebUI.sendKeys(findTestObject('Upload File'), 'C:\\Users\\smitkir\\Katalon Studio\\ALM Portal\\Data Files\\Upload_Order_Sample.csv')
//Capturing the file name after upload and storing it in a variable
FilePath = WebUI.getAttribute(findTestObject('Page_Upload Order File/label_Browse'), 'value')

//Verifying the Actual path and Expected path of file
WebUI.verifyMatch(FilePath, 'C:\\Users\\smitkir\\OneDrive - Metcash Trading Limited\\Katalon Projects\\_TestData\\ALM_CSV_upload_data.csv', 
    false)

WebUI.verifyElementClickable(findTestObject(null))

