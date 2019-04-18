import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

<<<<<<< Updated upstream:keywords/Scripts/VerifyKeywordsRecording/Script1553583847024.groovy
=======
WebUI.openBrowser('')

WebUI.navigateToUrl('http://automationpractice.com/index.php')

CustomKeywords.'com.kms.katalon.keyword.applitools.BasicKeywords.checkElement'(findTestObject('null'),'ctest8')

WebUI.click(findTestObject('null'))

CustomKeywords.'com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow'('4')

WebUI.closeBrowser()


>>>>>>> Stashed changes:keywords/Scripts/VerifyKeywordsRecording/Script1553504890235.groovy
