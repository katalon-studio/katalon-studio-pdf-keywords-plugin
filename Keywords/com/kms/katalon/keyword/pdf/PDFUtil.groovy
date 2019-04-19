package com.kms.katalon.keyword.pdf

import java.awt.Color
import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSName
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPageTree
import org.apache.pdfbox.pdmodel.PDResources
import org.apache.pdfbox.pdmodel.graphics.PDXObject
import org.apache.pdfbox.rendering.ImageType
import org.apache.pdfbox.rendering.PDFRenderer
import org.apache.pdfbox.text.PDFTextStripper
import org.apache.pdfbox.tools.imageio.ImageIOUtil

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

import groovy.transform.CompileStatic

@CompileStatic
public class PDFUtil {

	static String imageDestinationPath;
	static boolean bTrimWhiteSpace;
	static boolean bHighlightPdfDifference;
	static Color imgColor;
	static PDFTextStripper stripper;
	static boolean bCompareAllPages;
	static CompareMode compareMode;
	static int startPage = 1;
	static int endPage = -1;

	static {
		bTrimWhiteSpace = true;
		bHighlightPdfDifference = false;
		imgColor = Color.MAGENTA;
		bCompareAllPages = false;
		compareMode = CompareMode.TEXT_MODE;
		System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
	}

	/**
	 * This method is used to change the file comparison mode text/visual
	 * @param mode CompareMode
	 */
	@CompileStatic
	static void setCompareMode(CompareMode mode){
		compareMode = mode;
	}

	/**
	 * This method is used to get the current comparison mode text/visual
	 * @return CompareMode
	 */
	@CompileStatic
	static CompareMode getCompareMode(){
		return this.compareMode;
	}

	/**
	 * getText method by default replaces all the white spaces and compares.
	 * This method is used to enable/disable the feature.
	 *
	 * @param flag true to enable;  false otherwise
	 */
	@CompileStatic
	static void trimWhiteSpace(boolean flag){
		bTrimWhiteSpace = flag;
	}

	/**
	 * Path where images are stored
	 * when the savePdfAsImage or extractPdfImages methods are invoked.
	 *
	 * @return String Absolute path where images are stored
	 */
	@CompileStatic
	static String getImageDestinationPath(){
		return this.imageDestinationPath;
	}

	/**
	 * Set the path where images to be stored
	 * when the savePdfAsImage or extractPdfImages methods are invoked.
	 *
	 * @param path Absolute path to store the images
	 */
	@CompileStatic
	static void setImageDestinationPath(String path){
		imageDestinationPath = path;
	}

	/**
	 * Highlight the difference when 2 pdf files are compared in Binary mode.
	 * The result is saved as an image.
	 *
	 * @param flag true - enable ; false - disable (default);
	 */
	@CompileStatic
	static void highlightPdfDifference(boolean flag){
		bHighlightPdfDifference = flag;
	}

	/**
	 * Color in which pdf difference can be highlighted.
	 * MAGENTA is the default color.
	 *
	 * @param colorCode color code to highlight the difference
	 */
	@CompileStatic
	static void highlightPdfDifference(Color colorCode){
		bHighlightPdfDifference = true;
		imgColor = colorCode;
	}

	/**
	 * To compare all the pages of the PDF files. By default as soon as a mismatch is found, the method returns false and exits.
	 *
	 * @param flag true to enable; false otherwise
	 */
	@CompileStatic
	static void compareAllPages(boolean flag){
		bCompareAllPages = flag;
	}

	/**
	 * To modify the text extracting strategy using PDFTextStripper
	 *
	 * @param stripper Stripper with user strategy
	 */
	@CompileStatic
	static void useStripper(PDFTextStripper stripper){
		stripper = stripper;
	}

	/**
	 * To create image destination directory
	 *
	 * @param file the file path from which defines the location of the image directory
	 */
	@CompileStatic
	static void createImageDestinationDirectory(String file) throws IOException{
		if(null==this.imageDestinationPath){
			File sourceFile = new File(file);
			String destinationDir = sourceFile.getParent() + "/temp/";
			this.imageDestinationPath = destinationDir;
			this.createFolder(destinationDir);
		}
		else
			KeywordUtil.logInfo("The image path is set");
	}

	/**
	 * To update the start and end page
	 *
	 * @param file Absolute file path of the file
	 * @param start the start page
	 * @param end the end page
	 */
	@CompileStatic
	static void updateStartAndEndPages(String file, int start, int end) throws IOException{

		PDDocument document = PDDocument.load(new File(file));
		int pagecount = document.getNumberOfPages();
		KeywordUtil.logInfo("Page Count : " + pagecount);
		KeywordUtil.logInfo("Given start page:" + start);
		KeywordUtil.logInfo("Given end   page:" + end);

		if((start > 0 && start <= pagecount)){
			PDFUtil.startPage = start;
		}else{
			PDFUtil.startPage = 1;
		}
		if((end > 0 && end >= start && end <= pagecount)){
			PDFUtil.endPage = end;
		}else{
			PDFUtil.endPage = pagecount;
		}
		document.close();
		KeywordUtil.logInfo("Updated start page:" + PDFUtil.startPage);
		KeywordUtil.logInfo("Updated end   page:" + PDFUtil.endPage);
	}

	/**
	 * To create folder
	 *
	 * @param dir The path to create the folder
	 */
	@CompileStatic
	static boolean createFolder(String dir) throws IOException{
		FileUtils.deleteDirectory(new File(dir));
		return new File(dir).mkdir();
	}

	/**
	 * This method gets the file name
	 */
	@CompileStatic
	static String getFileName(String file){
		return new File(file).getName();
	}

	/**
	 * This method returns the content of the document
	 */
	@CompileStatic
	static String getPDFText(String file, int startPage, int endPage) throws IOException{

		KeywordUtil.logInfo("file : " + file);
		KeywordUtil.logInfo("startPage : " + startPage);
		KeywordUtil.logInfo("endPage : " + endPage);

		PDDocument doc = PDDocument.load(new File(file));

		PDFTextStripper localStripper = new PDFTextStripper();
		if(null!=PDFUtil.stripper){
			localStripper = PDFUtil.stripper;
		}

		this.updateStartAndEndPages(file, startPage, endPage);
		localStripper.setStartPage(PDFUtil.startPage);
		localStripper.setEndPage(PDFUtil.endPage);

		String txt = localStripper.getText(doc);
		KeywordUtil.logInfo("PDF Text before trimming : " + txt);
		if(PDFUtil.bTrimWhiteSpace){
			txt = txt.trim().replaceAll("\\s+", " ").trim();
			KeywordUtil.logInfo("PDF Text after  trimming : " + txt);
		}

		doc.close();
		return txt;
	}

	/**
	 * This method compare PDF files
	 */
	@CompileStatic
	static boolean comparePdfFiles(String file1, String file2, int startPage, int endPage, String... excludePattern)throws IOException{
		if(CompareMode.TEXT_MODE==PDFUtil.compareMode){
			return comparepdfFilesWithTextMode(file1, file2, startPage, endPage, excludePattern);
		}
		else {
			return ImageUtil.comparePdfByImage(file1, file2, startPage, endPage);
		}
	}

	/**
	 * This method compare PDF files with text mode
	 */
	@CompileStatic
	static boolean comparepdfFilesWithTextMode(String file1, String file2, int startPage, int endPage, String... excludePattern) throws IOException{

		String file1Txt = PDFUtil.getPDFText(file1, startPage, endPage).trim();
		String file2Txt = PDFUtil.getPDFText(file2, startPage, endPage).trim();
		KeywordUtil.logInfo("excludePattern : " + excludePattern);
		if(null!=excludePattern && excludePattern.length>0){
			for(int i=0; i<excludePattern.length; i++){
				file1Txt = file1Txt.replaceAll(excludePattern[i], "");
				file2Txt = file2Txt.replaceAll(excludePattern[i], "");
			}
		}

		KeywordUtil.logInfo("File 1 Txt : " + file1Txt);
		KeywordUtil.logInfo("File 2 Txt : " + file2Txt);

		boolean result = file1Txt.equalsIgnoreCase(file2Txt);

		if(!result){
			KeywordUtil.logInfo("PDF content does not match");
		}
		else {
			KeywordUtil.logInfo("PDF content matches");
		}
		return result;
	}
}
