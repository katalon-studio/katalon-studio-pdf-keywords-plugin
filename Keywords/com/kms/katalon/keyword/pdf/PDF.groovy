package com.kms.katalon.keyword.pdf

import java.awt.Color
import java.awt.image.BufferedImage

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import com.kms.katalon.keyword.pdf.ImageUtils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.keyword.pdf.CompareModes
import groovy.transform.CompileStatic

@CompileStatic
public class PDF {

	/**
	 * Get the page count of the document.
	 *
	 * @param file Absolute file path
	 * @return int No of pages in the document.
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static int getPageNumber(String file) throws IOException{
		KeywordUtil.logInfo("file :" + file)
		PDDocument doc = PDDocument.load(new File(file));
		int pageCount = doc.getNumberOfPages();
		KeywordUtil.logInfo("pageCount :" + pageCount);
		doc.close();
		return pageCount;
	}

	/**
	 * Get all the content of the document as plain text.
	 *
	 * @param file Absolute file path
	 * @return String document content in plain text.
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static String getAllText(String file) throws IOException{
		return PDFUtils.getPDFText(file,-1, -1);
	}

	/**
	 * Get the content of a specified PDF page as plain text.
	 *
	 * @param file Absolute file path
	 * @param startPage Starting page number of the document
	 * @return String document content in plain text.
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static String getTextFromPage(String file, int startPage) throws IOException{
		return PDFUtils.getPDFText(file,startPage, -1);
	}

	/**
	 * Get the content of PDF pages in rage as plain text.
	 *
	 * @param file Absolute file path
	 * @param startPage Starting page number of the document
	 * @param endPage Ending page number of the document
	 * @return String document content in plain text.
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static String getTextInPageRange(String file, int startPage, int endPage) throws IOException{
		return PDFUtils.getPDFText(file,startPage, endPage);
	}

	/**
	 * Compares all pages of two given PDF documents.
	 *
	 * <b>Note :</b> <b>TEXT_MODE</b> : Compare 2 pdf documents contents with no formatting.
	 * 			   <b>VISUAL_MODE</b> : Compare 2 pdf documents pixel by pixel for the content and format.
	 * @param file1 Absolute file path of the expected file
	 * @param file2 Absolute file path of the actual file
	 * @param excludePattern The strings need to exclude from the comparison
	 * @return boolean true if matches, false otherwise
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static boolean compareAllPages(String file1, String file2, def excludePattern) throws IOException{
		return PDFUtils.comparePdfFiles(file1, file2, -1, -1, excludePattern as String[]);
	}

	/**
	 * Compares two given PDF documents in a specified page range.
	 *
	 * <b>Note :</b> <b>TEXT_MODE</b> : Compare 2 pdf documents contents with no formatting.
	 * 			   <b>VISUAL_MODE</b> : Compare 2 pdf documents pixel by pixel for the content and format.
	 *
	 * @param file1 Absolute file path of the expected file
	 * @param file2 Absolute file path of the actual file
	 * @param startPage Starting page number of the document
	 * @param endPage Ending page number of the document
	 * @param excludePattern The strings need to exclude from the comparison
	 * @return boolean true if matches, false otherwise
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static boolean compareInPageRange(String file1, String file2, int startPage, int endPage, def excludePattern) throws IOException{
		return PDFUtils.comparePdfFiles(file1, file2, startPage, endPage, excludePattern as String[]);
	}

	/**
	 * Compares two given pdf documents from a specified page.
	 *
	 * <b>Note :</b> <b>TEXT_MODE</b> : Compare 2 pdf documents contents with no formatting.
	 * 			   <b>VISUAL_MODE</b> : Compare 2 pdf documents pixel by pixel for the content and format.
	 *
	 * @param file1 Absolute file path of the expected file
	 * @param file2 Absolute file path of the actual file
	 * @param startPage Starting page number of the document
	 * @param excludePattern The strings need to exclude from the comparison
	 * @return boolean true if matches, false otherwise
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static boolean compareFromPage(String file1, String file2, int startPage, def excludePattern) throws IOException{
		return PDFUtils.comparePdfFiles(file1, file2, startPage, -1, excludePattern as String[]);
	}

	/**
	 * Save PDF pages from a specified page as images
	 *
	 * @param file Absolute file path of the file
	 * @param startPage Starting page number of the document
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> savePageAsImage(String file, int startPage) throws IOException{
		return ImageUtils.saveAsImage(file, startPage, -1);
	}

	/**
	 * Save PDF pages in range as images
	 *
	 * @param file Absolute file path of the file
	 * @param startPage Starting page number of the document
	 * @param endPage Ending page number of the document
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> savePageRangeAsImages(String file, int startPage, int endPage) throws IOException{
		return ImageUtils.saveAsImage(file, startPage, endPage);
	}

	/**
	 * Save each page of the PDF as image
	 *
	 * @param file Absolute file path of the file
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> saveAllPagesAsImages(String file) throws IOException{
		return ImageUtils.saveAsImage(file, -1, -1);
	}

	/**
	 * Compare pages in range of 2 PDF documents pixel by pixel for the content and format.
	 *
	 * @param file1 Absolute file path of the expected file
	 * @param file2 Absolute file path of the actual file
	 * @param startPage Starting page number of the document
	 * @param endPage Ending page number of the document
	 * @param highlightImageDifferences To highlight differences in the images
	 * @param showAllDifferences To compare all the pages of the PDF (by default as soon as a mismatch is found in a page, this method exits)
	 * @return boolean true if matches, false otherwise
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static boolean compareByPixel(String file1, String file2,int startPage, int endPage, boolean highlightImageDifferences, boolean showAllDifferences) throws IOException{
		PDFUtils.compareMode == CompareModes.VISUAL_MODE
		PDFUtils.bHighlightPdfDifference == highlightImageDifferences;
		PDFUtils.bCompareAllPages == showAllDifferences;
		return ImageUtils.comparePdfByImage(file1, file2, startPage, endPage);
	}

	/**
	 * Extract all the embedded images from the specified PDF pages
	 *
	 * @param file Absolute file path of the file
	 * @param startPage Starting page number of the document
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> extractImagesFromPage(String file, int startPage) throws IOException{
		return ImageUtils.extractimages(file, startPage, -1);
	}

	/**
	 * Extract all the embedded images from PDF pages in range
	 *
	 * @param file Absolute file path of the file
	 * @param startPage Starting page number of the document
	 * @param endPage Ending page number of the document
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> extractImagesInPageRange(String file, int startPage, int endPage) throws IOException{
		return ImageUtils.extractimages(file, startPage, endPage);
	}

	/**
	 * Extract all the embedded images from the pdf document
	 *
	 * @param file Absolute file path of the file
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> extractAllImages(String file) throws IOException{
		return ImageUtils.extractimages(file, -1, -1);
	}
}
