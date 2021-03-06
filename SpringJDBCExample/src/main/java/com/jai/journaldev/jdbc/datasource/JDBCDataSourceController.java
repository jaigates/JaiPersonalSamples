package com.jai.journaldev.jdbc.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/JDBCDataSourceExampleSpring")
public class JDBCDataSourceController {

	//@Autowired
	private HttpServletRequest request;

	//@Autowired
	private	HttpSession session;

	private DataSource dataSource;

	//@Autowired
	//@Qualifier("tomcat_jndi_ds")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@RequestMapping(value = { "", "/" }, produces = "text/html")
	@ResponseBody
	public String doGet() {
		Context ctx = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			ctx = new InitialContext();
			// dataSource = (DataSource)
			// ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
			// DataSource ds = (DataSource) ctx.lookup("tomcat_jndi_ds");

			Object lookup = ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
			
			con = dataSource.getConnection();
			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from Employee");
			StringBuilder out = new StringBuilder();
			out.append("<html><body><h2>Employee Details</h2>");
			out.append("<table border=\"1\" cellspacing=10 cellpadding=5>");
			out.append("<th>Employee ID</th>");
			out.append("<th>Employee Name</th>");

			while (rs.next()) {
				out.append("<tr>");
				out.append("<td>" + rs.getInt("empid") + "</td>");
				out.append("<td>" + rs.getString("name") + "</td>");
				out.append("</tr>");
			}
			out.append("</table></body><br/>");

			// lets print some DB information
			out.append("<h3>Database Details</h3>");
			out.append("Database Product: " + con.getMetaData().getDatabaseProductName() + "<br/>");
			out.append("Database Driver: " + con.getMetaData().getDriverName());
			out.append("</html>");
			return out.toString();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
				ctx.close();
			} catch (SQLException e) {
				System.out.println("Exception in closing DB resources");
			} catch (NamingException e) {
				System.out.println("Exception in closing Context");
			}

		}
		return null;
	}

}