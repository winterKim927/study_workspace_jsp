<%@ page contentType="text/html;charset=UTF-8"%>
<%
    String bg = request.getParameter("bg");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
        function send(){
            let t = document.getElementById("input");
            location.href="/board/bg.jsp?bg="+t.value;
        }
    </script>
</head>
<body bgcolor="<%=bg%>">
    <input type="text" id="input">
    <button onclick="send()">배경색 적용</button>
</body>
</html>