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

// Mở trình duyệt
WebUI.openBrowser('')

// Khai báo giá trị Name và Price kỳ vọng
String expectedProductName = 'Roja Parfums Apex Eau Intense'
String expectedProductPrice = '8.700.000' // Chỉ số, chưa có đơn vị

// Điều hướng đến trang chủ
WebUI.navigateToUrl('https://laluz.vn/cart/')

// Click về trang chủ
WebUI.click(findTestObject('Object Repository/Page_Gi hng - LALUZ Parfums/a_V trang ch'))

// Chọn mục "Nước hoa"
WebUI.click(findTestObject('Object Repository/Page_LALUZ PARFUMS  Shop Nc Hoa Chnh Hng, G_eb922a/a_Nc hoa'))

// Click chọn sản phẩm cần test
WebUI.click(findTestObject('Object Repository/Page_Nc hoa chnh hng hng hiu, cao cp gi tt/a_Roja Parfums Apex Eau Intense'))

// So sánh tên sản phẩm
WebUI.verifyElementText(
    findTestObject('Object Repository/Page_Roja Parfums Apex Eau Intense - LALUZ Parfums/h1_Roja Parfums Apex Eau Intense'),
    expectedProductName
)

// Lấy giá sản phẩm thực tế
String actualProductPrice = WebUI.getText(findTestObject('Object Repository/Page_Roja Parfums Apex Eau Intense - LALUZ Parfums/bdi_8.700.000'))

// Xử lý loại bỏ ký tự ₫ và khoảng trắng
actualProductPrice = actualProductPrice.replace('₫', '').trim()

// So sánh giá sản phẩm
WebUI.verifyMatch(actualProductPrice, expectedProductPrice, false)

// Thêm sản phẩm vào giỏ
WebUI.click(findTestObject('Object Repository/Page_Roja Parfums Apex Eau Intense - LALUZ Parfums/span_Thm vo gi hng'))

// Xem giỏ hàng
WebUI.click(findTestObject('Object Repository/Page_Roja Parfums Apex Eau Intense - LALUZ Parfums/span_Xem gi hng'))

// Xác nhận lại sản phẩm trong giỏ
WebUI.verifyElementText(
    findTestObject('Object Repository/Page_Gi hng - LALUZ Parfums/a_Roja Parfums Apex Eau Intense'),
    expectedProductName
)

// Lấy số lượng sản phẩm trong giỏ
String quantity = WebUI.getAttribute(
    findTestObject('Object Repository/Page_LALUZ PARFUMS - Ca hng bn nc hoa chnh _8ba4e5/input Soluong'),
    'value'
)
println('Số lượng sản phẩm hiện tại: ' + quantity)

// Tăng số lượng
WebUI.click(findTestObject('Object Repository/Page_Gi hng - LALUZ Parfums/TangSL'))

// Giảm số lượng
WebUI.click(findTestObject('Object Repository/Page_Gi hng - LALUZ Parfums/GiamSL'))

// Xóa sản phẩm
WebUI.click(findTestObject('Object Repository/Page_Gi hng - LALUZ Parfums/XoaSP'))

// Tiến hành thanh toán
WebUI.click(findTestObject('Object Repository/Page_Gi hng - LALUZ Parfums/a_Tin hnh thanh ton'))

// Đóng trình duyệt
WebUI.closeBrowser()
