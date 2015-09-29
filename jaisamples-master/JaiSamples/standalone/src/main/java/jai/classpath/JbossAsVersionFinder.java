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

public class JbossAsVersionFinder {
	
	public static void main(String[] args){
		Class<?> forName = null;;
		try {
			forName = Class.forName("org.jboss.jmx.adaptor.rmi.RMIAdaptor");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(forName);
	}

}
