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

### Enable PDF Keywords Plugin

1. Download and unzip the **PDF Keywords Plugin** project.
2. Copy and patse your testing PDF files in **Project Folder\Data Files**.
3. Open the **PDF Keywords Plugin** project in Katalon Studio. To create a new test case, go to **File > New > Test Case**.
4. In the new test case, switch to the **Script** tab, use the sample code below to enable **PDF Keywords Plugin**:

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

### Use PDF Keyword Plugin

PDF keywords Plugin offers 14 custom keywords to help you start automating the test with PDF documents. 

- To get the total number of pages of the PDF documents, use the following keyword:

<details><summary> The getPageNumber keyword </summary>

### Description

This keyword gets the total number of pages in the document.
### Parameters

<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>File</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path</td>
</tr>
</tbody>
</table>

### Example

To get the total number of pages of the **Test_text1.pdf** PDF document, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getPageNumber'(path + 'test_text1.pdf')

```
</details>
&nbsp;

- To get the content of PDF file as plain text, use the following keywords:

<details><summary> The getTextFromPage keyword </summary>

### Description

This keyword gets the content of a specific PDF page as plain text.
### Parameters

<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>File</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path</td>
</tr>
<tr>
<td>startPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The page number of the desired PDF page</td>
</tr>
</tbody>
</table>

### Example

To get the Page 3 of the **Test_text1.pdf** PDF document as plain text, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getTextFromPage'(path + 'test_text1.pdf', 3)

```
</details>

<details><summary> The getTextInPageRange keyword </summary>

### Description

This keyword gets the content of a range of PDF pages as plain text.

### Parameters

<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>File</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path</td>
</tr>
<tr>
<td>startPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The starting page number of the page range</td>
</tr>
<tr>
<td>endPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The ending page number of the page range</td>
</tr>
</tbody>
</table>

### Example

To get the Page 1-3 of the **Test_text1.pdf** PDF document as plain text, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getTextInPageRange'(path + 'test_text1.pdf', 1, 3)

```

</details>


<details><summary> The getAllText keyword </summary>

### Description

This keyword gets all content of the document as plain text.
### Parameters
<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>File</td>
<td>
<p>String</p>
</td>
<td>&nbsp;Required</td>
<td>The absolute file path</td>
</tr>
</tbody>
</table>

### Example

To get all pages of the **Test_text1.pdf** PDF document as plain text, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.getAllText'(path + 'test_text1.pdf')

```

</details>
&nbsp;

- To compare the content between two PDF files, use the following keywords:

<details><summary> The compareFromPage keyword </summary>

### Description

This keyword compares a particular page of two given PDF documents. The value returns true if the pages match, false if otherwise.
### Parameters
<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>file1</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the expected file</td>
</tr>
<tr>
<td>file2</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the actual file</td>
</tr>
<tr>
<td>startPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The page number of the specific PDF page</td>
</tr>
<tr>
<td>excludePattern</td>
<td>
<p>def</p>
</td>
<td>Optional</td>
<td>The strings need to exclude from the comparison</td>
</tr>
</tbody>
</table>

### Example

1.  To compare Page 3 of the **Test_text1.pdf** file and the **Test_text2.pdf** file without excluding any strings, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareFromPage'(path + 'test_text1.pdf', path + 'test_text2.pdf', 3, null)

```
2.  To compare Page 3 of the **Test_text1.pdf** file and the **Test_text2.pdf** file excluding the **1998**, **1999** strings, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareFromPage'(path + 'test_text1.pdf', path + 'test_text2.pdf', 3, ['1998', '1999'])

```
</details>


<details><summary> The compareInPageRange keyword </summary>

### Description

This keyword compares a range of page from two given PDF documents. The value returns true if the pages match, false if otherwise.

### Parameters
<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>file1</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the expected file</td>
</tr>
<tr>
<td>file2</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the actual file</td>
</tr>
<tr>
<td>startPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The starting page number of the page range</td>
</tr>
<tr>
<td>endPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The ending page number of the page range </td>
</tr>
<tr>
<td>excludePattern</td>
<td>
<p>def</p>
</td>
<td>Optional</td>
<td>The strings need to exclude from the comparison</td>
</tr>
</tbody>
</table>

### Example

1.  To compare Page 1-3 of the **Test_text1.pdf** file and the **Test_text2.pdf** file without excluding any strings, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareInPageRange'(path + 'test_text1.pdf', path + 'test_text2.pdf', 1, 3, null)

```
2.  To compare Page 1-3 of the **Test_text1.pdf** file and the **Test_text2.pdf** file excluding the **1998**, **1999** strings, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareInPageRange'(path + 'test_text1.pdf', path + 'test_text2.pdf', 1, 3, ['1998', '1999'])

```

</details>

<details><summary> The compareAllPages keyword </summary>

### Description

This keyword compares all pages of two given PDF documents. The value returns true if the pages match, false if otherwise.

### Parameters
<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>file1</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the expected file</td>
</tr>
<tr>
<td>file2</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the actual file</td>
</tr>
<tr>
<td>excludePattern</td>
<td>
<p>def</p>
</td>
<td>Optional</td>
<td>The strings need to exclude from the comparison</td>
</tr>
</tbody>
</table>

### Example

1.  To compare all pages of the **Test_text1.pdf** file and the **Test_text2.pdf** file without excluding any strings, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareAllPages'(path + 'test_text1.pdf', path + 'test_text2.pdf', null)

```
2.  To compare Page 1-3 of the **Test_text1.pdf** file and the **Test_text2.pdf** file excluding the **1998**, **1999** strings, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareAllPages'(path + 'test_text1.pdf', path + 'test_text2.pdf', ['1998', '1999'])

```

</details>
&nbsp;

- To compare two PDF files pixel by pixel for content and format, use the following keyword:

<details><summary> The compareByPixel keyword </summary>

### Description

This keyword compares a range of pages from two PDF documents pixel by pixel for the content and format. The value returns true if the pages match, false if otherwise.
### Parameters
<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>file1</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the expected file</td>
</tr>
<tr>
<td>file2</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the actual file</td>
</tr>
<tr>
<td>startPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The starting page number of the page range</td>
</tr>
<tr>
<td>endPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The ending page number of the page range </td>
</tr>
<tr>
<td>highlightImageDifferences</td>
<td>
<p>boolean</p>
</td>
<td>Required</td>
<td>To highlight differences in the images</td>
</tr>
<tr>
<td>showAllDifferences</td>
<td>
<p>boolean</p>
</td>
<td>Required</td>
<td>To compare all the pages of the PDF files (by default as soon as a mismatch is found in a page, this method exits)</td>
</tr>
</tbody>
</table>

### Example

To compare all pages of the **Test_text1.pdf** and the **Test_text2.pdf** pixel by pixel for content and format, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.compareByPixel'(path + 'test_image1_diff.pdf', path + 'test_image2_diff.pdf', -1, -1, true, false)

```

</details>
&nbsp;

- To save PDF pages as images, use the following keywords:

<details><summary> The savePageAsImage keyword </summary>

### Description

To save a specific PDF page as a image. By default, the images are saved to your **Project Folder\Data Files\Temp**.
### Parameters

<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>File</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path</td>
</tr>
<tr>
<td>startPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The page number of the desired PDF page</td>
</tr>
</tbody>
</table>

### Example

To save the Page 3 of the **Test_text1.pdf** PDF document as an image, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.savePageAsImage'(path + 'test_text1.pdf', 3)

```
</details>

<details><summary> The savePageRangeAsImages keyword </summary>

### Description

To save a range of PDF pages as images. By default, the images are saved to your **Project Folder\Data Files\Temp**.
### Parameters
<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>file1</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the expected file</td>
</tr>
<tr>
<td>startPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The starting page number of the page range</td>
</tr>
<tr>
<td>endPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The ending page number of the page range </td>
</tr>
</tbody>
</table>

### Example

To save the Page 1-3 of the **Test_text1.pdf** PDF document as images, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.savePageRangeAsImages'(path + 'test_text1.pdf', 1, 3)

```
</details>

<details><summary> The saveAllPagesAsImages keyword </summary>

### Description

This keyword saves all pages of the PDF document as images. By default, the images are saved to your **Project Folder\Data Files\Temp**.

### Parameters
<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>File</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path</td>
</tr>
</tbody>
</table>

### Example

To save all pages of the **Test_text1.pdf** PDF document as images, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.saveAllPagesAsImages'(path + 'test_text1.pdf')

```

</details>
&nbsp;

- To extract and save images from PDF pages, use the following keywords:

<details><summary> The extractImagesFromPage keyword </summary>

### Description

This keyword extracts all the embedded images from a specific PDF page. By default, the images are saved to your **Project Folder\Data Files\Temp**.
### Parameters

<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>File</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path</td>
</tr>
<tr>
<td>startPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The page number of the desired PDF page</td>
</tr>
</tbody>
</table>

### Example

To extract all images from Page 3 of the **Test_text1.pdf** PDF document, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.extractImagesFromPage'(path + 'test_text1.pdf', 3)

```
</details>
<details><summary> The extractImagesInPageRange keyword </summary>

### Description

This keywords extract all the embedded images from a range of PDF pages. By default, the images are saved to your **Project Folder\Data Files\Temp**.
### Parameters
<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>file1</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path of the expected file</td>
</tr>
<tr>
<td>startPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The starting page number of the page range</td>
</tr>
<tr>
<td>endPage</td>
<td>
<p>int</p>
</td>
<td>Required</td>
<td>The ending page number of the page range </td>
</tr>
</tbody>
</table>

### Example

To extract all images from Page 1-3 of the **Test_text1.pdf** PDF document, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.extractImagesFromPage'(path + 'test_text1.pdf', 1, 3)

```

</details>

<details><summary> The extractAllImages keyword </summary>

### Description

This keyword extracts all the embedded images from all pages in the PDF document. By default, the images are saved to your **Project Folder\Data Files\Temp**.

### Parameters
<table width="854">
<tbody>
<tr>
<td><strong>Parameter</strong></td>
<td><strong>Type</strong></td>
<td><strong>Mandatory</strong></td>
<td><strong>Description</strong></td>
</tr>
<tr>
<td>File</td>
<td>
<p>String</p>
</td>
<td>Required</td>
<td>The absolute file path</td>
</tr>
</tbody>
</table>

### Example

To extract all images from all pages of the **Test_text1.pdf** PDF document, copy and patse the sample code as below:

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

String path = RunConfiguration.getProjectDir() + '/Data Files/'

CustomKeywords.'com.kms.katalon.keyword.pdf.PDF.extractAllImages'(path + 'test_text1.pdf')

```

</details>
&nbsp;

You can also customize the **VerifyPDFkeywords** sample test case that comes along with this project for your testing purpose.

6. Check the test case results in the **Log viewer** tab.

<img src="https://github.com/katalon-studio/docs-images/raw/master/katalon-studio/docs/pdf-keywords-plugin/KS-README-Results-in-Log-viewer-tab.png" alt="Results in Log Viewer Tab" width=70%>

## License

Copyright (c) Katalon LLC. All rights reserved.

Licensed under the LICENSE AGREEMENT FOR KATALON AUTOMATION FRAMEWORK.
