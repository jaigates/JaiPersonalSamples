/*******************************************************************************
 * Copyright (c) 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package jai.file.utils;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class FileMonitorTest {

	private static final String FILE_TO_MONITOR = "C:/Users/25721/GlobalAPI.properties";

	// private static final String FILE_DEST = "D://dest/";

	private void backup(File srcFile) {
		/*
		 * // FMD try { File destFile = new File(FILE_DEST + "/" +
		 * srcFile.getName() + new
		 * SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()));
		 * FileUtils.copyFile(srcFile, destFile);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
	}

	public class FAListener implements FileAlterationListener {

		@Override
		public void onDirectoryChange(File arg0) {
			System.out.println("onDirectoryChange : " + arg0);

		}

		@Override
		public void onDirectoryCreate(File arg0) {
			System.out.println("onDirectoryCreate : " + arg0);

		}

		@Override
		public void onDirectoryDelete(File arg0) {
			System.out.println("onDirectoryDelete : " + arg0);
		}

		@Override
		public void onFileChange(File arg0) {
			System.out.println("onFileChange : " + arg0);
			backup(arg0);
		}

		@Override
		public void onFileCreate(File arg0) {
			System.out.println("onFileCreate : " + arg0);
			backup(arg0);

		}

		@Override
		public void onFileDelete(File arg0) {
			System.out.println("onFileDelete : " + arg0);

		}

		@Override
		public void onStart(FileAlterationObserver arg0) {
			// System.out.println("onStart !!!!!");

		}

		@Override
		public void onStop(FileAlterationObserver arg0) {
			// System.out.println("onStop !!!!!");
		}

	}

	public static void main(String[] args) throws Exception {
		FileMonitorTest nt = new FileMonitorTest();
		nt.sample();
	}

	// public FileAlterationListener
	private void sample() {
		System.out.println("begin sample-> observer=" + FILE_TO_MONITOR);
		File directory = new File(FILE_TO_MONITOR);
		if (directory.exists()) {
			FileAlterationObserver observer = new FileAlterationObserver(directory);
			observer.addListener(new FAListener());

			long interval = 1000;
			FileAlterationMonitor monitor = new FileAlterationMonitor(interval);
			monitor.addObserver(observer);
			try {
				monitor.start();
				// monitor.stop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Path "+ FILE_TO_MONITOR+" does not exist.");
		}

	}
}