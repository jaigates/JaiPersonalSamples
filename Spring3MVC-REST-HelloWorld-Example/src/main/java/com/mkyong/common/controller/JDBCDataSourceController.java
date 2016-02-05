package com.mkyong.common.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/JDBCDataSourceExampleSpring")
public class JDBCDataSourceController {

	private @Autowired
	HttpServletRequest request;

	private @Autowired
	HttpSession session;

	@RequestMapping(value = { "", "/" }, produces = "text/html")
	public @ResponseBody
	String doGet() throws JsonParseException, JsonMappingException, IOException {
		/*
		 * try { // now try reading the request's input stream -- we expect it
		 * to be there StringBuilder stringBuilder = new StringBuilder();
		 * InputStream inputStream = request.getInputStream(); BufferedReader
		 * bufferedReader = null; if (inputStream != null) { bufferedReader =
		 * new BufferedReader(new InputStreamReader(inputStream)); char[]
		 * charBuffer = new char[128]; int bytesRead = -1; while ((bytesRead =
		 * bufferedReader.read(charBuffer)) > 0) {
		 * stringBuilder.append(charBuffer, 0, bytesRead); } }
		 * System.out.println(stringBuilder);
		 * 
		 * } catch (Exception ex) { System.out.println(ex); }
		 */

		Scanner s = new Scanner(request.getInputStream());
		System.out.println("Value : " + (s.hasNext() ? s.next() : ""));

		Context ctx = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
			// DataSource ds = (DataSource) ctx.lookup("jdbc/MyLocalDB");

			con = ds.getConnection();
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

	@RequestMapping(value = "/getemployee")
	public @ResponseBody
	Employee getemployee(@RequestBody Employee emp) {
		System.out.println(emp);

		emp.setName(emp.getName() + "-" + new Date());
		return emp;

	}

	@RequestMapping(value = "/setemployee")
	public @ResponseBody
	String setemployee(@RequestBody Employee emp) {

		System.out.println(emp);

		return emp.toString();

	}

	/*@RequestMapping(value = "/uploadImage")
	public @ResponseBody
	String uploadImage(@RequestBody ImagePojo image) {

		// convert byte array back to BufferedImage
		InputStream in = new ByteArrayInputStream(imageInByte);
		BufferedImage bImageFromConvert = ImageIO.read(in);

		ImageIO.write(bImageFromConvert, "jpg", new File("c:/new-darksouls.jpg"));
		return "";
	}*/

}