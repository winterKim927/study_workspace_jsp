package notice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.domain.Noticemember;
import notice.repository.NoticememberDAO;

public class LoginServlet extends HttpServlet{
	NoticememberDAO dao = new NoticememberDAO();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		Noticemember dto = new Noticemember();
		dto.setId(id);
		dto.setPass(pass);
		Noticemember member = dao.select(dto);
		out.print("<script>");
		if(member!=null) {
			session.setAttribute("member", member);
			out.print("alert('"+member.getName()+"님 어서옵쇼~');");
			out.print("location.href='/notice/list.jsp'");
		} else {
			out.print("alert('로그인정보가 틀렸나봐 확인해봐!');");
			out.print("history.back();");
		}
		out.print("</script>");
	}
}
