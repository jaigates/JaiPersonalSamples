package com.jcg.test;

import com.jcg.prop.ApplicationProperties;
import com.jcg.prop.PropertiesConstants;

/**
 * @author ashraf
 *
 */
public class PropReaderThread implements Runnable {

	// Thread name
	private String name;
	private int sleepTime;
	private ApplicationProperties applicationProperties;
	private Thread t;
	private int counter = 1;

	public PropReaderThread(String threadname, int sleepTime,
			ApplicationProperties applicationProperties) {
		this.name = threadname;
		this.sleepTime = sleepTime;
		this.applicationProperties = applicationProperties;
		t = new Thread(this, name);
		System.out.println(t);
		// Start the thread
		t.start();
	}

	public void run() {
		while (true) {
			try {
				if (PropertiesConstants.ACTIVE_MODE
						.equals(applicationProperties
								.getProperty(PropertiesConstants.MODE))) {
					System.out.println(name
							+ " Thread (request: "
							+ counter
							+ "): "
							+ " [ host: "
							+ applicationProperties
									.getProperty(PropertiesConstants.HOST)
							+ ", port: "
							+ applicationProperties
									.getProperty(PropertiesConstants.PORT)
							+ ", user: "
							+ applicationProperties
									.getProperty(PropertiesConstants.USER)
							+ ", password: "
							+ applicationProperties
									.getProperty(PropertiesConstants.PASSWORD)
							+ " ]");
				} else {
					System.out.println(name + " Thread (request: " + counter
							+ "): Client disabled the active mode!");
				}
				counter++;
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
