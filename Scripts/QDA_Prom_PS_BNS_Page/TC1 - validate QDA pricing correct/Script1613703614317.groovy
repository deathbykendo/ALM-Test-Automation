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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

// *** QDA details
qda_prodcode = (GlobalVariable.QDA['prodcode'])

qda_price = (GlobalVariable.QDA['qda_price'])

println('qda_price :' + qda_price)

qda_qty = (GlobalVariable.QDA['quantity'])

println('qda_qty :' + qda_qty)

qda_qty_str = String.valueOf(qda_qty)

qda_tot_cost = (qda_price * qda_qty)

println('qda_tot_cost :' + qda_tot_cost)

WebUI.callTestCase(findTestCase('_Common Scripts/MyCart/_EmptyCart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('_Common Scripts/Search/_AddToCart_Search'), [('search_term') : qda_prodcode], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('_Common Scripts/_Goto_page/_Goto_MyCart_page'), [:], FailureHandling.STOP_ON_FAILURE)

/// ** verify that QDA product is same as cart product
cart_prodcode = WebUI.getText(findTestObject('Page_Your Shopping Cart/span_product'))
cart_prodcode = cart_prodcode.replaceAll('\\s', '')


println((('product :' + qda_prodcode) + 'cart: ') + cart_prodcode)



WebUI.verifyEqual(qda_prodcode, cart_prodcode)

//--------------------------------------
// refresh Cart with qty withn QDA Qty
WebUI.callTestCase(findTestCase('_Common Scripts/MyCart/_UpdateProduct_Qty'), [('qty') : qda_qty_str], FailureHandling.STOP_ON_FAILURE)

total_cost = WebUI.getText(findTestObject('Page_Your Shopping Cart/row_0H_total_price'))

total_cost = total_cost.replaceAll('[^0-9.]', '')

//Convert from STring to floating point number
float total_cost_num = ((total_cost) as float)

/// ** verify that QDA total cost is same as cart total cost when qty is QDA
WebUI.verifyEqual(qda_tot_cost, total_cost_num)

cart_qty = WebUI.getAttribute(findTestObject('Page_Your Shopping Cart/input_Cartons_cartEntries0.innerCartEntry.newCartonQty'), 
    'value')

int cart_qty_int = ((cart_qty) as int)

//println('qty :' + cart_qty_int)
/// ** verify that QDA qty  is same as cart qty
WebUI.verifyEqual(qda_qty, cart_qty_int)

println((((('cart qty: ' + qda_qty) + ' cart tot cost :') + total_cost_num) + ' QDA tot cost :') + qda_tot_cost)

// end of 1st test case
//begin 2nd test case
qda_qty_less = (qda_qty - 1)

println('test with qty less than QDA qty ' + qda_qty_less)

qda_qty_less_str = String.valueOf(qda_qty_less)

WebUI.callTestCase(findTestCase('_Common Scripts/MyCart/_UpdateProduct_Qty'), [('qty') : qda_qty_less_str], FailureHandling.STOP_ON_FAILURE)

cart_qty2 = WebUI.getAttribute(findTestObject('Page_Your Shopping Cart/input_Cartons_cartEntries0.innerCartEntry.newCartonQty'), 
    'value')

int cart_qty2_int = ((cart_qty2) as int)

//println('qty2 :' + cart_qty2_int)
/// ** verify that  cart qty is same as passed during 2nd test i.e. one less than QDA qty
WebUI.verifyEqual(cart_qty2_int, qda_qty_less)

cart_price2 = WebUI.getText(findTestObject('Page_Your Shopping Cart/row_0E_carton_cost'))

cart_price2 = cart_price2.replaceAll('[^0-9.]', '')

// Convert from STring to floating point number
float cart_price2_num = ((cart_price2) as float)

//println('cart price 2 :' + cart_price2_num)
WebUI.verifyLessThan(qda_price, cart_price2_num)

println((((('cart qty: ' + qda_qty_less) + 'cart price:') + cart_price2_num) + '  QDA price:') + qda_price)

