package jai.ldap;

import static jai.ldap.utils.LDAPConstants.getLdapContext;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

/**
 * User: gmc Date: 16/02/11
 */
public class LdapBasicExample {

	public static void main(String[] args) {

		DirContext ctx = getLdapContext();
		NamingEnumeration results = null;
		try {
			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			results = ctx.search("", "(objectclass=person)", controls);
			while (results.hasMore()) {
				SearchResult searchResult = (SearchResult) results.next();
				Attributes attributes = searchResult.getAttributes();
				Attribute attr = attributes.get("cn");
				String cn = (String) attr.get();
				System.out.println(" Person Common Name = " + attributes.get("cn"));
				System.out.println(" Person Display Name = " + attributes.get("displayName"));
				System.out.println(" Person logonhours = " + attributes.get("logonhours"));
				System.out.println(" Person MemberOf = " + attributes.get("memberOf"));
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (results != null) {
				try {
					results.close();
				} catch (Exception e) {
				}
			}
			if (ctx != null) {
				try {
					ctx.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
