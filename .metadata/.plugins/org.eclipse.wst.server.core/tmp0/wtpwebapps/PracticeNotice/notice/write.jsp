<%@ page import="notice.domain.Noticemember"%>
<%@ page contentType="text/html; charset=utf-8"%>
<% 
	Noticemember member = (Noticemember)session.getAttribute("member");
	if(member==null){
		out.print("<script>");
		out.print("alert('멤버전용이야, 나가');");
		out.print("location.href='/'");
		out.print("</script>");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
	body {
		font-family: Arial, Helvetica, sans-serif;
	}
	
	* {
		box-sizing: border-box;
	}
	
	input[type=text], select, textarea {
		width: 100%;
		padding: 12px;
		border: 1px solid #ccc;
		border-radius: 4px;
		box-sizing: border-box;
		margin-top: 6px;
		margin-bottom: 16px;
		resize: vertical;
	}
	
	input[type=submit] {
		background-color: #04AA6D;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
	}
	
	input[type=submit]:hover {
		background-color: #45a049;
	}
	
	.container {
		border-radius: 5px;
		background-color: #f2f2f2;
		padding: 20px;
	}
	</style>
</head>
<body>

	<h3>새로운 글 환영해~</h3>

	<div class="container">
		<form action="/notice/regist" method="post">
			<label for="title">제목</label> 
			<input type="text" name="title" placeholder="제목 입력">
			 
			<label for="writer">작성자</label> 
			<input type="text" name="writer" value="<%=member.getName()%>" readonly> 
			
			<label for="content">내용</label>
			<textarea name="content" placeholder="Write something.." style="height: 200px"></textarea>

			<input type="submit" value="작성완료♡">
		</form>
	</div>

</body>
</html>
