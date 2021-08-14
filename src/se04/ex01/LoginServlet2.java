package se04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/loginTest2")
public class LoginServlet2 extends HttpServlet {
	


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
		doHandle(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메서드 호출");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doHandle 메서드 호출");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("아이디: " + user_id);
		System.out.println("비밀번호: " + user_pw);		
		
		if(user_id != null && user_id.length() != 0) {
			if(user_id.equals("admin")) {
				out.print("<html>");
				out.print("<body>");
				out.print("<font size='12'>관리자로 로그인 하셨습니답!!</font>");
				out.print("<br>");
				out.print("<input type='button' value='회원정보 수정하기' />");
				out.print("<input type='button' value='회원정보 삭제하기' />");
				out.print("<br>");
				out.print("</body>");
				out.print("</html>");
			} else {
				out.print("<html>");
				out.print("<body>");
				out.print(user_id + " 님!! 로그인 하셨습니다!");
				out.print("</body>");
				out.print("</html>");				
				
			}
		} else {
				out.print("<html>");
				out.print("<body>");
				out.print("아이디를 올바르게 입력하세요!!!!");
				out.print("<br>");
				out.print("<a href='http://localhost:8080/pro06/test01/login.html'>로그인 창으로 이동</a>");
				out.print("</body>");
				out.print("</html>");			
		}
	}
	

	public void destroy() {
		System.out.println("destory 메서드 호출");
	}

}
