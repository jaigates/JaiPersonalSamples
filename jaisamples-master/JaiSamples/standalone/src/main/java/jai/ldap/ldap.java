package jai.ldap;

import java.util.Hashtable;

import static jai.ldap.utils.LDAPConstants.*;

import javax.naming.Context;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class ldap {
	public static void main(String a[]) {

		Hashtable<String, String> env = new Hashtable<String, String>();

		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, LDAP_ProviderURL);
		try {

			env.put(Context.SECURITY_PRINCIPAL, LDAP_UserName);
			env.put(Context.SECURITY_CREDENTIALS, LDAP_Password);

			// Specify SSL
			env.put(Context.SECURITY_PROTOCOL, "ssl");

			// Authenticate as S. User and password "mysecret"
			env.put(Context.SECURITY_AUTHENTICATION, "simple");

			DirContext ctx = getLdapContext();
			Attributes userAttributes = new BasicAttributes(true);
			BasicAttribute basicattribute = new BasicAttribute("objectclass", "top");
			basicattribute.add(1, "person");
			basicattribute.add(2, "OpenLDAPperson");
			basicattribute.add(3, "connectme");
			userAttributes.put(basicattribute);
			// This depends upon your LDAP tree structure
			userAttributes.put(new BasicAttribute("cn", "abc"));
			userAttributes.put(new BasicAttribute("userpassword", "hello"));
			userAttributes.put(new BasicAttribute("uid", "abc"));
			userAttributes.put(new BasicAttribute("sn", "abc"));
			userAttributes.put(new BasicAttribute("ispid", "0005"));
			userAttributes.put(new BasicAttribute("userblocked", "no"));
			userAttributes.put(new BasicAttribute("parentid", "abc"));
			userAttributes.put(new BasicAttribute("filename", " "));
			userAttributes.put(new BasicAttribute("jpegphoto", ""));
			ctx.createSubcontext("uid=" + "abc" + ",ou=usermast,o=abc.com,c=US", userAttributes);// DN
			ctx.close();
		} catch (Exception e) {
			e.printStackTrace();
			// return "false";
		}
		// return "true";
	}// end of verify

	

}// end of class