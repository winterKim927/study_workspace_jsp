<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        a{
            text-decoration: none;
        }
    </style>
    <script>
        function send(){
            let t = document.getElementById("t");
            location.href="/board/gugu.jsp?dan="+t.value;
        }
    </script>
</head>
<body>
    <input type="text" id="t">
    <button onclick="send()">실행</button>
    <%
        String param = request.getParameter("dan");
        if(param == null){
            param = "2";
        }
        int dan = Integer.parseInt(param);
    %>
    <table width="500px" border="1px">
        <tr>
            <td>구구단 <%=dan%>단</td>
        </tr>
        <%for(int i=1;i<10;i++){%>
        <tr>
            <td><%=dan +" * "+i +" = "+dan*i%></td>
        </tr>
        <%}%>
        
    </table>
</body>
</html>