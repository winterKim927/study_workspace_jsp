/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.70
 * Generated at: 2023-01-08 14:51:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import notice.domain.Notice;
import notice.repository.NoticeDAO;
import java.util.ArrayList;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 NoticeDAO dao = new NoticeDAO(); 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("notice.domain.Notice");
    _jspx_imports_classes.add("notice.repository.NoticeDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
 
	ArrayList<Notice> list = (ArrayList)dao.selectAll(); 
	int totalRecord = list.size();
	int pageSize = 8;
	int totalPage = (int)Math.round(totalRecord/(float)pageSize);
	int currentPage = 1;
	if(request.getParameter("currentPage")!=null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int blockSize = 10;
	int firstPage = currentPage - (currentPage-1) % blockSize;
	int lastPage = firstPage + blockSize - 1;
	int curPos = (currentPage-1) * pageSize;
	int num = totalRecord - curPos;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<style>\r\n");
      out.write("	table {\r\n");
      out.write("		border-collapse: collapse;\r\n");
      out.write("		border-spacing: 0;\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		border: 1px solid #ddd;\r\n");
      out.write("	}\r\n");
      out.write("	th, td {\r\n");
      out.write("		text-align: left;\r\n");
      out.write("		padding: 16px;\r\n");
      out.write("	}\r\n");
      out.write("	tr:nth-child(even) {\r\n");
      out.write("		background-color: #f2f2f2;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	a {\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("      }\r\n");
      out.write("  	button {\r\n");
      out.write("		background-color: #04AA6D;\r\n");
      out.write("		color: white;\r\n");
      out.write("		padding: 12px 20px;\r\n");
      out.write("		border: none;\r\n");
      out.write("		border-radius: 4px;\r\n");
      out.write("		cursor: pointer;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	button:hover {\r\n");
      out.write("		background-color: #45a049;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	function writeNew(){\r\n");
      out.write("		$(\"button\").click(function(){\r\n");
      out.write("			location.href=\"write.html\";\r\n");
      out.write("		});\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	$(function() {\r\n");
      out.write("		writeNew();\r\n");
      out.write("	})\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h2>글목록</h2>\r\n");
      out.write("	<p>글목록이 표시되는 페이지입니다</p>\r\n");
      out.write("	<table>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th>No</th>\r\n");
      out.write("			<th>제목</th>\r\n");
      out.write("			<th>작성자</th>\r\n");
      out.write("			<th>작성시간</th>\r\n");
      out.write("			<th>조회수</th>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");

			for(int i = 0; i < pageSize; i++){ 
				if(num<1) break;
				Notice dto = list.get(curPos++);
		
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td>");
      out.print(num--);
      out.write("</td>\r\n");
      out.write("			<td><a href=\"/notice/content.jsp?notice_idx=");
      out.print(dto.getNotice_idx());
      out.write('"');
      out.write('>');
      out.print(dto.getTitle());
      out.write("</a></td>\r\n");
      out.write("			<td>");
      out.print(dto.getWriter());
      out.write("</td>\r\n");
      out.write("			<td>");
      out.print(dto.getRegdate());
      out.write("</td>\r\n");
      out.write("			<td>");
      out.print(dto.getHit());
      out.write("</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");
}
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"5\" style=\"text-align: center; word-spacing: 10px\">\r\n");
      out.write("				");
if(firstPage-1 > 0){ 
      out.write("\r\n");
      out.write("					<a href=\"list.jsp?currentPage=");
      out.print(firstPage-1);
      out.write("\">◀</a>\r\n");
      out.write("				");
}
      out.write("\r\n");
      out.write("				");
for(int i = firstPage; i <= lastPage; i++){
      out.write("\r\n");
      out.write("					");
if(i > totalPage) break;
      out.write("\r\n");
      out.write("					<a href=\"list.jsp?currentPage=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\r\n");
      out.write("				");
}
      out.write("\r\n");
      out.write("				");
if(lastPage+1 <= totalPage){ 
      out.write("\r\n");
      out.write("				<a href=\"list.jsp?currentPage=");
      out.print(lastPage+1);
      out.write("\">▶</a>\r\n");
      out.write("				");
}
      out.write("\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("	<button>글쓰기</button>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
