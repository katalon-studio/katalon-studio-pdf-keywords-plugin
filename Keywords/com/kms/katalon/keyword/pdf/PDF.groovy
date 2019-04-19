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
import com.kms.katalon.keyword.pdf.ImageUtil
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.keyword.pdf.CompareMode
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
	static int getPageCount(String file) throws IOException{
		KeywordUtil.logInfo("file :" + file)
		PDDocument doc = PDDocument.load(new File(file));
		int pageCount = doc.getNumberOfPages();
		KeywordUtil.logInfo("pageCount :" + pageCount);
		doc.close();
		return pageCount;
	}

	/**
	 * Get the content of the document as plain text.
	 *
	 * @param file Absolute file path
	 * @return String document content in plain text.
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static String getText(String file) throws IOException{
		return PDFUtil.getPDFText(file,-1, -1);
	}

	/**
	 * Get the content of the document as plain text.
	 *
	 * @param file Absolute file path
	 * @param startPage Starting page number of the document
	 * @return String document content in plain text.
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static String getText(String file, int startPage) throws IOException{
		return PDFUtil.getPDFText(file,startPage, -1);
	}

	/**
	 * Get the content of the document as plain text.
	 *
	 * @param file Absolute file path
	 * @param startPage Starting page number of the document
	 * @param endPage Ending page number of the document
	 * @return String document content in plain text.
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static String getText(String file, int startPage, int endPage) throws IOException{
		return PDFUtil.getPDFText(file,startPage, endPage);
	}

	/**
	 * Compares two given pdf documents.
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
	static boolean compare(String file1, String file2, String... excludePattern) throws IOException{
		return PDFUtil.comparePdfFiles(file1, file2, -1, -1, excludePattern);
	}

	/**
	 * Compares two given pdf documents.
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
	static boolean compare(String file1, String file2, int startPage, int endPage, String... excludePattern) throws IOException{
		return PDFUtil.comparePdfFiles(file1, file2, startPage, endPage, excludePattern);
	}

	/**
	 * Compares two given pdf documents.
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
	static boolean compare(String file1, String file2, int startPage, String... excludePattern) throws IOException{
		return PDFUtil.comparePdfFiles(file1, file2, startPage, -1, excludePattern);
	}

	/**
	 * Save each page of the pdf as image
	 *
	 * @param file Absolute file path of the file
	 * @param startPage Starting page number of the document
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> savePdfAsImage(String file, int startPage) throws IOException{
		return ImageUtil.saveAsImage(file, startPage, -1);
	}

	/**
	 * Save each page of the pdf as image
	 *
	 * @param file Absolute file path of the file
	 * @param startPage Starting page number of the document
	 * @param endPage Ending page number of the document
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> savePdfAsImage(String file, int startPage, int endPage) throws IOException{
		return ImageUtil.saveAsImage(file, startPage, endPage);
	}

	/**
	 * Save each page of the pdf as image
	 *
	 * @param file Absolute file path of the file
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> savePdfAsImage(String file) throws IOException{
		return ImageUtil.saveAsImage(file, -1, -1);
	}

	/**
	 * Compare 2 pdf documents pixel by pixel for the content and format.
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
		PDFUtil.compareMode == CompareMode.VISUAL_MODE
		PDFUtil.bHighlightPdfDifference == highlightImageDifferences;
		PDFUtil.bCompareAllPages == showAllDifferences;
		return ImageUtil.comparePdfByImage(file1, file2, startPage, endPage);
	}

	/**
	 * Extract all the embedded images from the pdf document
	 *
	 * @param file Absolute file path of the file
	 * @param startPage Starting page number of the document
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> extractImages(String file, int startPage) throws IOException{
		return ImageUtil.extractimages(file, startPage, -1);
	}

	/**
	 * Extract all the embedded images from the pdf document
	 *
	 * @param file Absolute file path of the file
	 * @param startPage Starting page number of the document
	 * @param endPage Ending page number of the document
	 * @return List list of image file names with absolute path
	 * @throws java.io.IOException when file is not found.
	 */
	@CompileStatic
	@Keyword
	static List<String> extractImages(String file, int startPage, int endPage) throws IOException{
		return ImageUtil.extractimages(file, startPage, endPage);
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
	static List<String> extractImages(String file) throws IOException{
		return ImageUtil.extractimages(file, -1, -1);
	}
}
