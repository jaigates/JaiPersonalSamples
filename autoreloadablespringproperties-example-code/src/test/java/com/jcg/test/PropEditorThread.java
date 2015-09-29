package com.jcg.test;

import com.jcg.prop.ApplicationProperties;
import com.jcg.prop.PropertiesConstants;

/**
 * @author ashraf
 *
 */
public class PropEditorThread implements Runnable {

	// Thread name
	private String name;
	private int sleepTime;
	private ApplicationProperties applicationProperties;
	private Thread t;

	public PropEditorThread(String threadname, int sleepTime,
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
				String mode = applicationProperties
						.getProperty(PropertiesConstants.MODE);
				if (PropertiesConstants.ACTIVE_MODE
						.equals(mode)) {
					applicationProperties.setProperty(PropertiesConstants.MODE, PropertiesConstants.IDLE_MODE);
					System.out.println(name
							+ " thread updates the mode property to "
							+ PropertiesConstants.IDLE_MODE);
				} else if (PropertiesConstants.IDLE_MODE
						.equals(mode)) {
					applicationProperties.setProperty(PropertiesConstants.MODE, PropertiesConstants.ACTIVE_MODE);
					System.out.println(name
							+ " thread updates the mode property to "
							+ PropertiesConstants.ACTIVE_MODE);
				}
				applicationProperties.save();
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
