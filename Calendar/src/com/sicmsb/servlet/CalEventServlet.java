package com.sicmsb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sicmsb.bean.Data;
import com.sicmsb.bean.DataDao;

/**
 * Servlet implementation class CalEventServlet
 */
@WebServlet("/calevent")
public class CalEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static String user;

	public static void setUsername(String username) {
		user = username;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalEventServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}

	protected void doReq(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String start = "Test";
		try {

			DataDao dao = new DataDao();
			List<Data> list = dao.findName(user);
			int i = 0;
			StringBuilder buf = new StringBuilder();
			buf.append("[");
			System.out.println("[");

			// for (Data dat : list) {
			for (Data dat : list) {

				buf.append("{");
				System.out.println("{");
				buf.append("\"id\": \"").append(dat.getId()).append("\",");
				buf.append("\"title\": \"" + dat.getRemarks() + "\","); //
				System.out.println("\"title\": \"" + dat.getRemarks() + "\",");
				buf.append("\"start\": \"" + dat.getStartdate() + "T"
						+ dat.getStarttime() + "\",");
				System.out.println("\"start\": \"" + dat.getStartdate() + "T"
						+ dat.getStarttime() + "\",");
				buf.append("\"end\": \"\"");
				System.out.println("\"end\": \"\"");
				buf.append("}");
				System.out.println("}");
				buf.append(",");
				System.out.println(",");

			}
			buf.append("{");
			System.out.println("{");
			buf.append("\"title\": \"0\","); //
			System.out.println("\"title\": \"\",");
			buf.append("\"start\": \"0\",");
			System.out.println("\"start\": \"\",");
			buf.append("\"end\": \"\"");
			System.out.println("\"end\": \"\"");
			buf.append("}");
			System.out.println("}");

			buf.append("]");
			System.out.println("]");
			PrintWriter pw = response.getWriter();
			pw.print(buf);
			pw.flush();
			pw.close();
			// request.setAttribute("listRemarks", list);

			/*
			 * System.out.println("here"); StringBuilder buf = new
			 * StringBuilder(); buf.append("["); buf.append("{");
			 * buf.append("\"title\": \"test\",");
			 * buf.append("\"start\": \"2015-01-05T12:30:00\",");
			 * buf.append("\"end\": \"\""); buf.append("}");
			 * 
			 * buf.append(",");
			 * 
			 * buf.append("{"); buf.append("\"title\": \"test2\",");
			 * buf.append("\"start\": \"2015-01-10T12:30:00\",");
			 * buf.append("\"end\": \"\""); buf.append("}");
			 * 
			 * //buf.append(",");
			 * 
			 * 
			 * buf.append("]");
			 * 
			 * PrintWriter pw = response.getWriter(); pw.print(buf); pw.flush();
			 * pw.close();
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
