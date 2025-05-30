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

WebUI.navigateToUrl('https://laluz.vn/cart/')

WebUI.click(findTestObject('Page_Gi hng - LALUZ Parfums/a_V trang ch'))

WebUI.click(findTestObject('Object Repository/Page_LALUZ PARFUMS  Shop Nc Hoa Chnh Hng, G_eb922a/a_Nc hoa'))

WebUI.click(findTestObject('Object Repository/Page_Nc hoa chnh hng hng hiu, cao cp gi tt/a_Maison Francis Kurkdjian Amyris Femme EDP'))

WebUI.click(findTestObject('Object Repository/Page_Maison Francis Kurkdjian Amyris Femme _8477f1/span_Mua ngay'))

WebUI.setText(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/input_Thng tin lin h_email'), Email)

WebUI.setText(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/input_Sa_shipping-first_name'), Ten)

WebUI.setText(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/input_Tn_shipping-last_name'), Ho)

WebUI.setText(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/input_Cng ty (khng bt buc)_shipping-address_1'), 
    Diachi)

WebUI.click(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/fieldset_a ch giao hnga ch giao hngNhp a ch_52f670'))

WebUI.setText(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/input_Quc giaKhu vc_components-form-token-input-0'), 
    Quocgia)

WebUI.setText(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/input_M bu in (khng bt buc)_shipping-city'), 
    Thanhpho)

WebUI.setText(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/input_Thnh ph_shipping-phone'), sdt)

WebUI.click(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/input_Chuyn khon ngn hng_radio-control-wc-p_b4fe05'))

WebUI.click(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/input_Tr tin mt khi giao hng_checkbox-control-0'))

WebUI.setText(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/textarea_em ang lm test, mong anh ch thng c_24bd0d'), 
    Ghichu)

// Kiểm tra kết quả mong đợi xuất hiện trên trang
WebUI.verifyTextPresent(ketqua, false)

// Lấy URL hiện tại sau khi điền form
String Checkout = WebUI.getUrl()

// Gán URL mong đợi
String expectedUrl = 'https://laluz.vn/thanh-toan/'

// So sánh URL thực tế với URL mong đợi
WebUI.verifyEqual(Checkout, expectedUrl)

// Sau khi kiểm tra xong, click "Đặt hàng"
WebUI.click(findTestObject('Object Repository/Page_Thanh ton - LALUZ Parfums/span_t hng'))

WebUI.closeBrowser()

