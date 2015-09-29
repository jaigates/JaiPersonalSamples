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
package jai.classpath;

import java.net.URL;

public class JarPathInServer {
	public static void main(String[] args) throws ClassNotFoundException {

		JarPathInServer jp = new JarPathInServer();
		jp.displayPath();
		ClassLoader classLoader = jp.getClass().getClassLoader();

		
	}
	
	void displayPath(){
		URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
		LOG.trace(this.getClass().getName() + " is loaded from " + location);
	}

}
