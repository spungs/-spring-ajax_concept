<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex4</title>
<script>
	var req
	function send(){
		req = new XMLHttpRequest();
		req.onreadystatechange = changeText
		req.open('post', 'ex4')
		req.send(null)
	}
	
	function changeText(){
		if(req.readyState == 4 && req.status == 200){
			var tbody = document.getElementById("tbody")
			tbody.innerHTML = "아직은 데이터가 없음"
			//console.log(JSON.parse(req.responseText))
			var resData = JSON.parse(req.responseText)
			var printData = ''
			for(i = 0; i < resData.cd.length; i++){
				printData += "<tr><td>"+resData.cd[i].title+"</td>"
				printData += "<td>"+resData.cd[i].artist+"</td>"
				printData += "<td>"+resData.cd[i].price+"</td></tr>"
			}
			tbody.innerHTML = printData
		}
	}
</script>
</head>
<body>
	<button type="button" onclick="send()">실행</button>
	<table border="1">
		<thead>
			<tr>
				<th>title</th>
				<th>artist</th>			
				<th>price</th>			
			</tr>
		</thead>
		<tbody id="tbody"></tbody>
	</table>
</body>
</html>