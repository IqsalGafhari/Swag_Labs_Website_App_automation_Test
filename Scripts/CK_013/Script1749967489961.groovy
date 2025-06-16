import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/v1/')

WebUI.setText(findTestObject('CK_013/Page_Swag Labs/input_standard_userlocked_out_userproblem_userperformance_glitch_user_user-name'), 
    username)

WebUI.setText(findTestObject('CK_013/Page_Swag Labs/input_standard_userlocked_out_userproblem_userperformance_glitch_user_password'), 
    password)

WebUI.click(findTestObject('CK_013/Page_Swag Labs/input_standard_userlocked_out_userproblem_userperformance_glitch_user_login-button'))

WebUI.click(findTestObject('CK_013/Page_Swag Labs/svg_Open Menu_svg-inline--fa fa-shopping-cart fa-w-18 fa-3x'))

//WebUI.getText(findTestObject('CK_013/Page_Swag Labs/div_Sauce Labs Bike LightA red light isnt the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.9.99REMOVE'))
boolean isItemAvailable = WebUI.verifyElementPresent(findTestObject('CK_013/Page_Swag Labs/div_Sauce Labs Bike LightA red light isnt the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.9.99REMOVE'), 
    5, FailureHandling.OPTIONAL)

if (!(isItemAvailable)) {
    KeywordUtil.markFailed('Item kosong')
	
	WebUI.takeScreenshot()

    WebUI.closeBrowser()
} else {
    KeywordUtil.markPassed('item tersedia')

    WebUI.click(findTestObject('CK_013/Page_Swag Labs/a_CHECKOUT'))

    WebUI.setText(findTestObject('CK_013/Page_Swag Labs/input_Checkout Your Information_first-name'), 'John')

    WebUI.setText(findTestObject('CK_013/Page_Swag Labs/input_Checkout Your Information_last-name'), 'Doe')

    WebUI.setText(findTestObject('CK_013/Page_Swag Labs/input_Checkout Your Information_postal-code'), '12345')

    WebUI.click(findTestObject('CK_013/Page_Swag Labs/input_CANCEL_btn_primary cart_button'))

    WebUI.click(findTestObject('CK_013/Page_Swag Labs/a_FINISH'))
	
	WebUI.takeScreenshot()

    WebUI.closeBrowser()
}

