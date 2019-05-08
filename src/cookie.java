import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class cookie extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public class ReadCookieServlet extends HttpServlet {
	     @Override
	     protected void doGet(HttpServletRequest request, HttpServletResponse response)
	             throws ServletException, IOException {
	         response.setCharacterEncoding("UTF-8");//����������ݵı����ʽ
	        response.setContentType("text/plain");//����������ļ�����
	        PrintWriter out = response.getWriter();
	         Cookie[] cookies=request.getCookies();//��ȡ���������е�Cookie
	         if(cookies!=null){
	             for(int i=0;i<cookies.length;i++){
	                 out.println("Cookie Name:"+cookies[i].getName());//���Cookie������
	                out.println("Cookie Value:"+cookies[i].getValue());//���Cookie��ֵ
	            }
	         }else{
	             out.println("No Cookies");
	         }
//	         Cookie cookie=new Cookie("userName", "zhangsan");
//	         cookie.setMaxAge(0);
//	         response.addCookie(cookie);
	         out.flush();
	         out.close();
	     }
	 }

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
