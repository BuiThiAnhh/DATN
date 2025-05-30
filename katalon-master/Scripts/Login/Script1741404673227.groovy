import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('https://laluz.vn/login/')

WebUI.setText(findTestObject('Object Repository/Page_ng nhp - laluz.vn/input_Email_user_name'), Email)

WebUI.setText(findTestObject('Page_ng nhp - laluz.vn/input_Mt khu_user_pass'), Password)

WebUI.click(findTestObject('Object Repository/Page_ng nhp - laluz.vn/span_ng nhp'))

// Kiểm tra trường rỗng và lấy validationMessage nếu cần
def errorMessage = '' //Lưu trữ thông điệp lỗi

if (Email.isEmpty() || Password.isEmpty()) {
    if (Password.isEmpty()) {
        errorMessage = WebUI.getAttribute(findTestObject('Object Repository/Page_ng nhp - laluz.vn/input_Mt khu_user_pass'), 
            'validationMessage')
    } else {
        errorMessage = WebUI.getAttribute(findTestObject('Object Repository/Page_ng nhp - laluz.vn/input_Email_user_name'), 
            'validationMessage')
    }
}

WebUI.verifyEqual(errorMessage, KQ1)

//Kiểm tra kết quả mong đợi
WebUI.verifyTextPresent(Result, false)

Checkout = WebUI.getUrl()//Lấy url của web gán cho biến checkout

WebUI.verifyEqual(Checkout, url)//

WebUI.closeBrowser()

