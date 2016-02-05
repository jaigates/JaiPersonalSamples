package jai.http.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.cxf.helpers.IOUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 

public class HttpsIgnoreCertificateNTransactionSummaryTest {
	
	private static Logger log = LoggerFactory.getLogger(HttpsIgnoreCertificateNTransactionSummaryTest.class);

	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, InterruptedException {
		IgnoreSSLCertificates.ignoreSSLCertifictes();
		/*
		 * try { for (int i = 1; i < 100; i++) {
		 * log.info("Iterating : " + i); readTransactionSummary(); } }
		 * catch (Exception e) { e.printStackTrace(); }
		 */

		ExecutorService executor = Executors.newFixedThreadPool(50);
		Set<Callable<String>> tasks = new HashSet<Callable<String>>();
		log.info("Begin parallel calling...");
		for (int i = 0; i < 500; i++){
			executor.submit(new MyTask(i));
		}
		
		while(!executor.isTerminated()){
			
		}
		executor.shutdown();
		//(Collection  
		
	}

	private static class MyTask implements Callable<String> {
		int i;
		public MyTask(int i) {
			this.i=i;
		}

		public String call() {
			try {
				log.info("Executing {}",i);
				readTransactionSummary();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

	private static void readTransactionSummary() throws Exception {
		URL url = new URL("https://dcentral1146.intra.aexp.com:8443/ace_liberty/ace/v1/transactionSummary");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("charset", "utf-8");
		log.info("Getting outputstream");
		OutputStream out = con.getOutputStream();
		String path = "./standalone/src/main/java/jai/http/utils/";
		File file = new File(path + "transactionSummary.json");
		// log.info(file.getCanonicalPath());
		FileInputStream fi = new FileInputStream(file);
		IOUtils.copy(fi, out);
		File outFile = new File(path + "/output_" + System.currentTimeMillis() + ".txt");
		FileOutputStream fileOut = new FileOutputStream(outFile);
		InputStream responseStream = con.getInputStream();
		log.info("Writing file : {} " , outFile.getCanonicalPath());
		IOUtils.copy(responseStream, fileOut);
		log.info("File Size : " + outFile.length());
		/*
		 * Reader response = new InputStreamReader(con.getInputStream()); while
		 * (true) { int ch = response.read(); if (ch == -1) { break; }
		 * System.out.print((char) ch); }
		 */

	}
}