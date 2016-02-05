package jai.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ClassPathUtil {

	public static File getFileInClassPath(String fileNameWithRelativePath) {
		try {
			File f1 = new File(".");
			String canonicalPath = f1.getCanonicalPath();
			System.out.println("Current execution path : "+ canonicalPath);
			
			
			File f = getFileFromClassLoader(fileNameWithRelativePath, ClassPathUtil.class.getClassLoader());
			
			if(f==null){
				// looks in java execution path not on classpath
				f = new File(fileNameWithRelativePath);
				if(f.exists()){
					return f;
				}
			}
			
			return f;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static File getFileFromClassLoader(String fileNameWithRelativePath, ClassLoader classLoader) {

		if (classLoader != null) {
			InputStream resourceAsStream = classLoader.getResourceAsStream(fileNameWithRelativePath);
			URL resource = classLoader.getResource(fileNameWithRelativePath);

			if (resource == null) {
				ClassLoader parent = classLoader.getParent();
				if (parent != null) {
					File fileFromClassLoader = getFileFromClassLoader(fileNameWithRelativePath, parent);
					String canonicalPath;
					try {
						if(fileFromClassLoader!=null){
						canonicalPath = fileFromClassLoader.getCanonicalPath();
						System.out.println(canonicalPath);
						}
						else{
							return null;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

					return fileFromClassLoader;
				} else {
					return null;
				}

			}
			else{
				String file = resource.getFile();
				File f = new File(file);
				try {
					String canonicalPath = f.getCanonicalPath();
					System.out.println(canonicalPath);
					return f;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return null;
	}

}
