<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="notice.domain.Notice" %>
<%@ page import="notice.repository.NoticeDAO" %>
<%@ page import="java.util.ArrayList"%>
<%! NoticeDAO dao = new NoticeDAO(); %>
<% 
	ArrayList<Notice> list = (ArrayList)dao.selectAll(); 

	int totalRecord = list.size();
	int pageSize = 10;
	int totalPage = (int)Math.ceil(totalRecord/(float)pageSize);
	int currentPage = 1;
	if(request.getParameter("currentPage")!=null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int blockSize = 10;
	int firstPage = currentPage - ((currentPage - 1)%blockSize);
	int lastPage = firstPage + blockSize -1;
	int curPos = (currentPage-1)*pageSize;
	int num = totalRecord - curPos;
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
	table {
		border-collapse: collapse;
		border-spacing: 0;
		width: 100%;
		border: 1px solid #ddd;
	}
	th, td {
		text-align: left;
		padding: 16px;
	}
	tr:nth-child(even) {
		background-color: #f2f2f2;
	}
	
	a {
        text-decoration: none;
      }
  	button {
		background-color: #04AA6D;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
	}
	
	button:hover {
		background-color: #45a049;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	

	function writeNew(){
		$("button").click(function(){
			location.href="write.html";
		});
	}
	
	$(function() {
		writeNew();
	})
</script>
</head>
<body>
	<h2>글목록</h2>
	<p>글목록이 표시되는 페이지입니다</p>
	<table>
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
		</tr>
		<%for(int i = 0; i < pageSize; i++){
				if(num<1) break;
				Notice dto = list.get(curPos++);
				int notice_idx = dto.getNotice_idx();
				String title = dto.getTitle();
				String writer = dto.getWriter();
				String regdate = dto.getRegdate();
				int hit = dto.getHit();
		%>
		<tr>
			<td><%=num--%></td>
			<td><a href="content.jsp?notice_idx=<%=notice_idx%>"><%=title%></a></td>
			<td><%=writer%></td>
			<td><%=regdate%></td>
			<td><%=hit%></td>
		</tr>
		<%} %>
		<tr>
			<td colspan="5" style="text-align: center">
				<%if(firstPage-1>0){%>
				<a href="list.jsp?currentPage=<%=firstPage-1%>">◀</a>
				<%} else {%>
				<a>◀</a>
				<%}%>
				<%for(int i = firstPage; i <= lastPage; i++){%> 
					<%if(i>totalPage) break;%>
				<a href="list.jsp?currentPage=<%=i%>"><%=i%></a>
				<%}%>
				<%if(lastPage+1<=totalPage){%>
				<a href="list.jsp?currentPage=<%=lastPage+1%>">▶</a>
				<%} else {%>
				<a>▶</a>
				<%}%>
			</td>
		</tr>
	</table>
	<button>글쓰기</button>

</body>
</html>
