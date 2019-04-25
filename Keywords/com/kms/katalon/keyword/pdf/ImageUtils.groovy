package com.kms.katalon.keyword.pdf

import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.apache.pdfbox.cos.COSName
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPageTree
import org.apache.pdfbox.pdmodel.PDResources
import org.apache.pdfbox.pdmodel.graphics.PDXObject
import org.apache.pdfbox.rendering.ImageType
import org.apache.pdfbox.rendering.PDFRenderer
import org.apache.pdfbox.tools.imageio.ImageIOUtil

import com.kms.katalon.core.util.KeywordUtil

import groovy.transform.CompileStatic

@CompileStatic
public class ImageUtils {

	/**
	 * This method compares and highlights the differences between two images
	 */
	@CompileStatic
	static boolean compareAndHighlight(final BufferedImage img1, final BufferedImage img2, String fileName, boolean highlight, int colorCode) throws IOException {
		final int w = img1.getWidth();
		final int h = img1.getHeight();
		final int[] p1 = img1.getRGB(0, 0, w, h, null, 0, w);
		final int[] p2 = img2.getRGB(0, 0, w, h, null, 0, w);

		if(!(java.util.Arrays.equals(p1, p2))){
			KeywordUtil.logInfo("Image compared - does not match" + '\n');
			if(highlight){
				for (int i = 0; i < p1.length; i++) {
					if (p1[i] != p2[i]){
						p1[i] = colorCode;
					}
				}
				final BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				out.setRGB(0, 0, w, h, p1, 0, w);
				saveImage(out, fileName);
			}
			return false;
		}
		KeywordUtil.logInfo("Image compared - matched" + '\n');
		return true;
	}

	/**
	 * This method saves the image
	 */
	static void saveImage(BufferedImage image, String file){
		try{
			File outputfile = new File(file);
			ImageIO.write(image, "png", outputfile);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * This method saves the each page of the pdf as image
	 */
	@CompileStatic
	static List<String> saveAsImage(String file, int startPage, int endPage) throws IOException{
		KeywordUtil.logInfo("file : " + file);
		KeywordUtil.logInfo("startPage : " + startPage);
		KeywordUtil.logInfo("endPage : " + endPage);

		ArrayList<String> imgNames = new ArrayList<String>();

		try {
			File sourceFile = new File(file);
			PDFUtils.createImageDestinationDirectory(file);
			PDFUtils.updateStartAndEndPages(file, startPage, endPage);
			String fileName = sourceFile.getName().replace(".pdf", "");

			PDDocument document = PDDocument.load(sourceFile);
			PDFRenderer pdfRenderer = new PDFRenderer(document);
			for(int iPage=PDFUtils.startPage-1;iPage<PDFUtils.endPage;iPage++){
				KeywordUtil.logInfo("Page No : " + (iPage+1));
				String fname = PDFUtils.imageDestinationPath + fileName + "_" + (iPage + 1) + ".png";
				BufferedImage image = pdfRenderer.renderImageWithDPI(iPage, 300, ImageType.RGB);
				ImageIOUtil.writeImage(image, fname , 300);
				imgNames.add(fname);
				KeywordUtil.logInfo("PDf Page saved as image : " + fname);
			}
			document.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return imgNames;
	}

	/**
	 * This method reads each page of a given doc, converts to image
	 * compare. If it fails, exits immediately.
	 */
	@CompileStatic
	static boolean comparePdfByImage(String file1, String file2, int startPage, int endPage) throws IOException{
		KeywordUtil.logInfo("file1 : " + file1);
		KeywordUtil.logInfo("file2 : " + file2);

		int pgCount1 = PDF.getPageNumber(file1);
		int pgCount2 = PDF.getPageNumber(file2);

		if(pgCount1!=pgCount2){
			KeywordUtil.logInfo("files page counts do not match - returning false");
			return false;
		}

		if(PDFUtils.bHighlightPdfDifference)
			PDFUtils.createImageDestinationDirectory(file2);

		PDFUtils.updateStartAndEndPages(file1, startPage, endPage);
		KeywordUtil.logInfo("PDFUtils.startPage: " + PDFUtils.startPage);
		KeywordUtil.logInfo("PDFUtils.endPage: " + PDFUtils.endPage);
		KeywordUtil.logInfo("file1: " + file1);
		KeywordUtil.logInfo("file2: " + file2);
		return this.convertToImageAndCompare(file1, file2, PDFUtils.startPage, PDFUtils.endPage);
	}

	/**
	 * This method converts the PDF files to images then compares
	 */
	@CompileStatic
	static boolean convertToImageAndCompare(String file1, String file2, int startPage, int endPage) throws IOException{
		boolean result = true;

		PDDocument doc1=null;
		PDDocument doc2=null;

		PDFRenderer pdfRenderer1 = null;
		PDFRenderer pdfRenderer2 = null;

		try {

			doc1 = PDDocument.load(new File(file1));
			doc2 = PDDocument.load(new File(file2));

			pdfRenderer1 = new PDFRenderer(doc1);
			pdfRenderer2 = new PDFRenderer(doc2);


			for(int iPage=startPage-1;iPage<endPage;iPage++){
				String fileName = new File(file1).getName().replace(".pdf", "_") + (iPage + 1);
				String fileNametemp = PDFUtils.getImageDestinationPath() + fileName + "_diff.png"
				fileName = PDFUtils.getImageDestinationPath() + "/" + fileName + "_diff.png";


				KeywordUtil.logInfo("Comparing Page No : " + (iPage+1));
				BufferedImage image1 = pdfRenderer1.renderImageWithDPI(iPage, 300, ImageType.RGB);
				BufferedImage image2 = pdfRenderer2.renderImageWithDPI(iPage, 300, ImageType.RGB);
				result = ImageUtils.compareAndHighlight(image1, image2, fileName, PDFUtils.bHighlightPdfDifference, PDFUtils.imgColor.getRGB()) && result
				if(!PDFUtils.bCompareAllPages && !result){
					KeywordUtil.logInfo("See the differences in path: " + fileNametemp);
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			doc1.close();
			doc2.close();
		}
		return result;
	}

	/**
	 * This method extracts all the embedded images of the pdf document
	 */
	@CompileStatic
	static List<String> extractimages(String file, int startPage, int endPage){

		KeywordUtil.logInfo("file : " + file);
		KeywordUtil.logInfo("startPage : " + startPage);
		KeywordUtil.logInfo("endPage : " + endPage);

		ArrayList<String> imgNames = new ArrayList<String>();
		boolean bImageFound = false;
		try {

			PDFUtils.createImageDestinationDirectory(file);
			String fileName = PDFUtils.getFileName(file).replace(".pdf", "_resource");

			PDDocument document = PDDocument.load(new File(file));
			PDPageTree list = document.getPages();

			PDFUtils.updateStartAndEndPages(file, startPage, endPage);

			int totalImages = 1;
			KeywordUtil.logInfo("start : " + PDFUtils.startPage);
			KeywordUtil.logInfo("endPage : " + PDFUtils.endPage);
			for(int iPage=PDFUtils.startPage-1;iPage<PDFUtils.endPage;iPage++){
				KeywordUtil.logInfo("Page No : " + (iPage+1));
				PDResources pdResources = list.get(iPage).getResources();
				for (COSName c : pdResources.getXObjectNames()) {
					PDXObject o = pdResources.getXObject(c);
					if (o instanceof org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) {
						bImageFound = true;
						String fname = PDFUtils.imageDestinationPath + "/" + fileName+ "_" + totalImages + ".png";
						ImageIO.write(((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject)o).getImage(), "png", new File(fname));
						imgNames.add(fname);
						totalImages++;
					}
				}
			}
			document.close();
			if(bImageFound)
				KeywordUtil.logInfo("Images are saved @ " + PDFUtils.imageDestinationPath);
			else
				KeywordUtil.logInfo("No images were found in the PDF");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return imgNames;
	}
}
