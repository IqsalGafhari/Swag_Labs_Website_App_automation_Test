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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/v1/')

WebUI.setText(findTestObject('CK_011/Page_Swag Labs/input_standard_userlocked_out_userproblem_userperformance_glitch_user_user-name'), 
    username)

WebUI.setText(findTestObject('CK_011/Page_Swag Labs/input_standard_userlocked_out_userproblem_userperformance_glitch_user_password'), 
    password)

WebUI.click(findTestObject('CK_011/Page_Swag Labs/input_standard_userlocked_out_userproblem_userperformance_glitch_user_login-button'))

WebUI.click(findTestObject('CK_011/Page_Swag Labs/button_ADD TO CART'))

WebUI.click(findTestObject('CK_011/Page_Swag Labs/path'))

WebUI.click(findTestObject('CK_011/Page_Swag Labs/a_CHECKOUT'))

WebUI.setText(findTestObject('CK_011/Page_Swag Labs/input_Checkout Your Information_first-name'), first_name)

WebUI.setText(findTestObject('CK_011/Page_Swag Labs/input_Checkout Your Information_last-name'), last_name)

WebUI.setText(findTestObject('CK_011/Page_Swag Labs/input_Checkout Your Information_postal-code'), zip)

WebUI.click(findTestObject('CK_011/Page_Swag Labs/input_CANCEL_btn_primary cart_button'))

//WebUI.getText(findTestObject('CK_011/Page_Swag Labs/div_Item total 9.99'))
//WebUI.getText(findTestObject('CK_011/Page_Swag Labs/div_Tax 0.80'))
//WebUI.getText(findTestObject('CK_011/Page_Swag Labs/div_Total 10.79'))
//get price, tax, and total
String priceText = WebUI.getText(findTestObject('CK_011/Page_Swag Labs/div_Item total 9.99')).replaceAll('[^\\d.]', '')

String taxText = WebUI.getText(findTestObject('CK_011/Page_Swag Labs/div_Tax 0.80')).replaceAll('[^\\d.]', '')

String totalText = WebUI.getText(findTestObject('CK_011/Page_Swag Labs/div_Total 10.79')).replaceAll('[^\\d.]', '')

//convert to double
double price = Double.parseDouble(priceText)

double tax = Double.parseDouble(taxText)

double total = Double.parseDouble(totalText)

//logging
KeywordUtil.logInfo('Item total : ' + price)

KeywordUtil.logInfo('Tax total : ' + tax)

KeywordUtil.logInfo('Total : ' + total)

//compare
double calculatedTotal = price + tax

if (Math.abs(calculatedTotal - total) < 0.01) {
    KeywordUtil.markPassed('Perhitungan Sesuai')

    WebUI.click(findTestObject('CK_011/Page_Swag Labs/a_FINISH'))
	
	WebUI.takeScreenshot()

    WebUI.closeBrowser()
} else {
    KeywordUtil.markFailed((('Perhitungan tidak sesuai. Total :' + total) + ', Calculated : ') + calculatedTotal)
	
	WebUI.takeScreenshot()

    WebUI.closeBrowser()
}

