package jai.ldap;

import static jai.ldap.utils.LDAPConstants.*;

import java.io.IOException;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class SampleLdap {

	/**
	 * @param args
	 * @throws NamingException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NamingException, IOException {

		DirContext ctx = getLdapContext();

		// Specify the search filter
		String FILTER = "(&(objectClass=Person) ((sAMAccountName=" + LDAP_UserName + ")))";

		// limit returned attributes to those we care about
		String[] attrIDs = { "sn", "givenName" };

		SearchControls ctls = new SearchControls();
		ctls.setReturningAttributes(attrIDs);
		ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		// Search for objects using filter and controls

		NamingEnumeration answer = ctx.search("CN=jaikumaranv", FILTER, ctls);

		while (answer.hasMore()) {
			SearchResult sr = (SearchResult) answer.next();
			Attributes attrs = sr.getAttributes();
			String surName = attrs.get("sn").toString();
			String givenName = attrs.get("givenName").toString();

			System.out.println(surName + "," + givenName);
		}

	}
}
