import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration

 
 
 String path = RunConfiguration.getProjectDir() + "/Data Files/"
//Get the page count of the document
 CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getPageNumber'(path + "test_text1.pdf")

//Get the content of the document as plain text
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getTextFromPage'(path + "test_text1.pdf", 
    3)

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getTextInPageRange'(path + "test_text1.pdf", 
    1, 2)

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getAllText'(path + "test_text1.pdf")

//compare all pages of two given pdf documents without excluding any patterns
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareAllPages'(path+ "test_text1.pdf", 
    path + "test_text2.pdf",null)

//compare all pages of two given pdf documents with excluding patterns: "1998","1999"
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareAllPages'(path+ "test_text1.pdf", 
    path+ "test_text2.pdf", ['1998','1999'])

//compare particular pages (start page, end page) of two given pdf documents with no difference in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareInPageRange'(path + "test_text1.pdf", 
    path + "test_text2.pdf", 6, 7,null)

//compare particular pages (start page, end page) of two given pdf documents with differences in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareInPageRange'(path+ "test_text1.pdf", 
   path + "test_text2.pdf", 4, 5,null)

//compare particular pages (start page, end page) of two given pdf documents with differences in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareInPageRange'(path + "test_text1.pdf", 
    path+ "test_text2.pdf", 4, 5, ['1998', '1999'])

//compare particular pages (start page, no end page) of two given pdf documents with differences in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareFromPage'(path+ "test_text1.pdf", 
    path+ "test_text2.pdf", 4,null)

//compare particular pages (start page, no end page) of two given pdf documents with differences in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareFromPage'(path+ "test_text1.pdf", 
    path+ "test_text2.pdf", 4, ['1998', '1999'])

//Compare 2 difference pdf documents pixel by pixel for the content and format
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareByPixel'(path+ "test_image1_diff.pdf", 
    path + "test_image2_diff.pdf", -1, -1, true, false)

//Compare 2 same pdf documents pixel by pixel for the content and format
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareByPixel'(path+ "test_image1_same.pdf", 
    path+ "test_image2_same.pdf", -1, -1, true, false)

//save pdf pages as images
List<String> actualExtractedImages = CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.savePageRangeAsImages'(path+ "test_image1_same.pdf", 
    -1, -1)

//extracts the embedded images of the pdf document
List<String> extractImages = CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.extractImagesInPageRange'(path+ "test_image1_same.pdf", 
    1, 6)

