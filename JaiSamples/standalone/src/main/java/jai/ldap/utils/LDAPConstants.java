package jai.ldap.utils;

import static jai.utils.ClassPathUtil.getFileInClassPath;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LDAPConstants {

	/*	*//** latest from kevin */
	/*
	 * public static final String
	 * UserName="CN=LDSAdmin,CN=Users,O=ibo,DC=adld,DC=ibo,DC=org"; public
	 * static final String Password="m1grat1on!"; public static final String
	 * LDAP_URL="ldaps://10.0.19.72:636";
	 */

	/*
	 * public static final String UserName =
	 * "CN=APPuser,CN=Users,O=ibo,DC=adld,DC=ibo,DC=org"; public static final
	 * String Password = "APPl1m1ted!"; public static final String LDAP_URL =
	 * "ldaps://172.16.1.49:636";
	 */

/*	public static final String LDAP_UserName = "cn=Directory Manager";
	public static final String LDAP_Password = "password";
	public static final String LDAP_ProviderURL = "ldap://127.0.0.1";
	public static final String LDAP_SearchBase = "dc=example,dc=com";*/
	
	public static final String LDAP_UserName = "uid=admin,ou=system";
	public static final String LDAP_Password = "secret";
	public static final String LDAP_ProviderURL = "ldap://127.0.0.1:10389";
	public static final String LDAP_SearchBase = "uid=admin,ou=system";


	public static DirContext getLdapContext(boolean ssl) {

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, LDAP_ProviderURL);

		env.put(Context.SECURITY_PRINCIPAL, LDAP_UserName);
		env.put(Context.SECURITY_CREDENTIALS, LDAP_Password);

		if (ssl)
			env.put(Context.SECURITY_PROTOCOL, "ssl");

		// Authenticate as S. User and password "mysecret"

		DirContext ctx = getLdapContext(env, false);
		return ctx;
	}

	public static DirContext getLdapContext(Hashtable<String, String> env, boolean ssl) {

		InitialDirContext ctx = null;
		try {
			ctx = new InitialDirContext(env);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return ctx;
	}

	public static Properties readPropertyFile(String filePath) {

		try {
			File f = getFileInClassPath(filePath);
			if (f != null) {
				FileReader fr = new FileReader(f);
				Properties p = new Properties();
				p.load(fr);
				return p;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static DirContext getLdapContextFromProperties() {
		Properties readPropertyFile = readPropertyFile("./ldapconstants.properties");
		Hashtable ht = readPropertyFile;
		DirContext ladpContextInternal = getLdapContext(ht, false);
		return ladpContextInternal;

	}

	public static void main(String[] args) {
		// DirContext ctx = getLdapContextFromProperties();
		DirContext ctx = getLdapContext(false);
		System.out.println(ctx);
	}
}
