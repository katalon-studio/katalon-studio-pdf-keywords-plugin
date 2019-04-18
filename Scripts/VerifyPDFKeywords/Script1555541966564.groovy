import com.kms.katalon.core.util.KeywordUtil

//Get the page count of the document
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.getPageCount'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test.pdf")

//Get the content of the document as plain text
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.getText'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test.pdf", 25)
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.getText'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test.pdf", 1,2)
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.getText'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test.pdf")

//compare all pages of two given pdf documents without excluding any patterns
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.compare'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore1.pdf", "D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore2.pdf")

//compare all pages of two given pdf documents with excluding patterns: "1998","1999"
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.compare'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore1.pdf", "D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore2.pdf","1998","1999")

//compare particular pages (start page, end page) of two given pdf documents with no difference in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.compare'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore1.pdf", "D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore2.pdf", 6, 7)

//compare particular pages (start page, end page) of two given pdf documents with differences in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.compare'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore1.pdf", "D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore2.pdf", 4, 5)

//compare particular pages (start page, end page) of two given pdf documents with differences in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.compare'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore1.pdf", "D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore2.pdf", 4, 5,"1998", "1999")

//compare particular pages (start page, no end page) of two given pdf documents with differences in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.compare'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore1.pdf", "D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore2.pdf", 4)

//compare particular pages (start page, no end page) of two given pdf documents with differences in pages 
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.compare'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore1.pdf", "D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_ignore2.pdf", 4,"1998", "1999")

//Compare 2 difference pdf documents pixel by pixel for the content and format
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.compareByPixcel'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_image1_diff.pdf", "D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_image2_diff.pdf", -1, -1, true, false)

//Compare 2 same pdf documents pixel by pixel for the content and format
CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.compareByPixcel'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_image1_same.pdf", "D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_image2_same.pdf", -1, -1, true, false)

//save pdf pages as images
List<String> actualExtractedImages = CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.savePdfAsImage'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_image1_same.pdf", -1, -1)

//extracts the embedded images of the pdf document
List<String> extractImages = CustomKeywords.'com.kms.katalon.keyword.pdf.PDFUtil.extractImages'("D:\\Upstar\\PDF_plugin\\PDF_Plugin\\Data Files\\test_image1_same.pdf", 1, 2)