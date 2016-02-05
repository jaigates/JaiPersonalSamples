package jai.utils.imageutils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class ImageParser {
	
	private static Logger log = LoggerFactory.getLogger(ImageParser.class);
	
	public static void main(String[] args) throws FileNotFoundException {
		log.debug("Inside....");
		//readJson();
		
		convertByteToImage(convertImageTobyte(),null); 
		
		log.debug("Exit");
	}

	private static String convertByteToImage(byte[] imageInByte,String outputFile) {
		try {
			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bImageFromConvert = ImageIO.read(in);
			if(StringUtils.isEmpty(outputFile)){
				outputFile = "./standalone/src/main/java/jai/utils/imageutils/output-"+System.currentTimeMillis()+".jpg";
			}
			ImageIO.write(bImageFromConvert, "jpg", new File(outputFile));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputFile;
	}

	private static byte[] convertImageTobyte() {
		byte[] imageInByte = null;
		try {
			BufferedImage originalImage = ImageIO.read(new File("./standalone/src/main/java/jai/utils/imageutils/sampleimage.jpg"));
			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
			writeToFile(imageInByte);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageInByte;

	}
	 
	private static void writeToFile(byte[] imageInByte) throws IOException {
		String fn = "./standalone/src/main/java/jai/utils/imageutils/OutputByteArray"+System.currentTimeMillis()+".txt";
		FileOutputStream fout = new FileOutputStream(fn);
		fout.write(imageInByte);
		fout.close();
		log.debug("File Written : {} ",fn);
	}

	private static void readJson() throws FileNotFoundException{
		Gson g = new Gson();
		FileReader fr = new FileReader(new File("./standalone/src/main/java/jai/utils/imageutils/EnrollCheckRequest_ACE.txt"));
		ImagePOJO fromJson = g.fromJson(fr,ImagePOJO.class);
		byte[] signature1Image = fromJson.getSignature1Image();
		
		byte[] bytes = Base64.encodeBase64(signature1Image);
		//System.out.println("encodedBytes " + new String(encodedBytes));
		//byte[] bytes = Base64.decodeBase64(signature1Image);
		System.out.println("decodedBytes " + new String(bytes));
		
		
		
		log.debug("Output file : ",convertByteToImage(bytes,"./standalone/src/main/java/jai/utils/imageutils/ByteConverted.jpg"));
		
	}
}