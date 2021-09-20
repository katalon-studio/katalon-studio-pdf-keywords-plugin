# Katalon Studio PDF Keywords Plugin

PDF Keywords Plugin allows testers to manipulate existing PDF documents and extract content from them. This plugin comes along with a sample test case that allows you to develop further to suit your testing's purposes.

## Prerequisite

- An active Katalon Studio Enterprise license. You can refer to this document here: [Katalon licensing](https://docs.katalon.com/katalon-studio/docs/license.html).
## Set Parameter

The PDF Keyword plugin is using the PDFbox library. To activate the plugin, follow these steps:

1. Download **Apache PDFBox version 2.0.24** . You can download it here: [Apache PDFBox](https://www.apache.org/dyn/closer.lua/pdfbox/2.0.24/pdfbox-app-2.0.24.jar).
2. Return to Katalon Studio, go to **Project > Settings > Library Management**. 
3. In the **External Libraries**, click **Add** to browse the .jar file downloaded from Step 1. Click **Apply and Close**. Katalon Studio automatically imports the library into the project.

## Execute Test Cases

1. Download and unzip the **PDF Keywords Plugin** project. 
2. Copy and patse your testing PDF files in **Project Folder\Data Files**.
3. Open the **PDF Keywords Plugin** project in Katalon Studio. To create a new test case, go to **File > New > Test Case**.
4. In the new test case, switch to the **Script** tab, use the sample code below to import **PDF Keywords Plugin**:

``` groovy
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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

// To specify path to data files
String path = RunConfiguration.getProjectDir() + '/Data Files/'

```

5. Use one of the 14 custom keywords from the plugin to start automating your test with PDF documents. You can also customize the **VerifyPDFkeywords** sample test case that comes along with this project for your testing purpose.

- `getPageNumber`: To get the total number of pages of the document.
- `getTextFromPage`: To get the content of a specific PDF page as plain text.
- `getTextInPageRange`: To get the content of a range of PDF pages as plain text.
- `getAllText`: To get all the content of the document as plain text.
- `compareFromPage`: To compare a particular page of two given PDF documents.
- `compareInPageRange`: To compare a range of page from two given PDF documents.
- `compareAllPages`: To compare all pages of two given PDF documents.
- `savePageAsImage`: TO save a specific PDF page as a image.
- `savePageRangeAsImages`: To save a range of PDF pages as images.
- `saveAllPagesAsImages`: To save all pages of the PDF document as images.
- `extractImagesFromPage`: To extract all the embedded images from a specific PDF page.
- `extractImagesInPageRange`: To extract all the embedded images from a range of PDF pages.
- `extractAllImages`: To extract all the embedded images from all pages in the PDF document.
- `compareByPixel`: To compare a range of pages from two PDF documents pixel by pixel for the content and format.

6. Check the test case results in the **Log viewer** tab.
## Example

To get the total number of pages of the **Test_text1.pdf** PDF document, after copy the file into the **Project Folder\Data Files**, switch the **Script** tab of the test case and use the `getPageNumber` keyword:

``` groovy
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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

// To specify path to data files
String path = RunConfiguration.getProjectDir() + '/Data Files/'

// To get the total number of pages of the PDF file named "test_text1.pdf".
CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getPageNumber'(path + 'test_text1.pdf')

```
<img src="https://github.com/katalon-studio/docs-images/raw/master/katalon-studio/docs/pdf-keywords-plugin/KS-README-Results-in-Log-viewer-tab.png" alt="Results in Log Viewer Tab" width=70%>

## License

Copyright (c) Katalon LLC. All rights reserved.

Licensed under the LICENSE AGREEMENT FOR KATALON AUTOMATION FRAMEWORK.
