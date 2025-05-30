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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://laluz.vn/dang-ky/')

WebUI.setText(findTestObject('Object Repository/Page_ng k - laluz.vn/input_Email_register_email'), email)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_ng k - laluz.vn/input_Mt khu_register_pass'), password)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_ng k - laluz.vn/input_Nhp li mt khu_register_repass'), Passwordagain)

WebUI.click(findTestObject('Object Repository/Page_ng k - laluz.vn/span_ng k'))

// Kiểm tra trường rỗng và lấy validationMessage nếu cần
def errorMessage = ''

if (email.isEmpty() || password.isEmpty() || Passwordagain.isEmpty()|| !email.contains("@")) {
    if (password.isEmpty()) {
        errorMessage = WebUI.getAttribute(findTestObject('Object Repository/Page_ng k - laluz.vn/input_Mt khu_register_pass'), 
            'validationMessage')
    } else if (Passwordagain.isEmpty()) {
        errorMessage = WebUI.getAttribute(findTestObject('Object Repository/Page_ng k - laluz.vn/input_Nhp li mt khu_register_repass'), 
            'validationMessage')
    } else if (email.isEmpty()){
        errorMessage = WebUI.getAttribute(findTestObject('Object Repository/Page_ng k - laluz.vn/input_Email_register_email'), 
            'validationMessage')
    }
	else {
		errorMessage = WebUI.getAttribute(findTestObject('Object Repository/Page_ng k - laluz.vn/input_Email_register_email'),
			'validationMessage')
	}
}

WebUI.verifyEqual(errorMessage, KQ2)

//Kiểm tra kết quả mong đợi
WebUI.verifyTextPresent(KQ1, false)

Checkout = WebUI.getUrl()

WebUI.verifyEqual(Checkout, url)

WebUI.closeBrowser()

