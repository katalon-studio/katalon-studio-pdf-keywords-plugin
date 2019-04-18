package com.kms.katalon.keyword.pdf

import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import com.kms.katalon.core.util.KeywordUtil

public class ImageUtil {

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
	static void saveImage(BufferedImage image, String file){
		try{
			File outputfile = new File(file);
			ImageIO.write(image, "png", outputfile);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
