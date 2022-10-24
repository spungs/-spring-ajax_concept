<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex6</title>
<script>
	var req;
	function send(){
		req = new XMLHttpRequest();
		req.onreadystatechange = changeText
		req.open('post', "ex6")
		req.send(document.getElementById('title').value)
	}
	function changeText(){
		if(req.readyState == 4 && req.status == 200){
			var tbody = document.getElementById("tbody")
// 			console.log(req.responseText)
// 			console.log(JSON.parse(req.responseText))
			try{
				var resData = JSON.parse(req.responseText)
				var printData = ''
				for(i = 0; i < resData.cd.length; i++){
					printData += "<tr><td>"+resData.cd[i].title+"</td>"	
					printData += "<td>" + resData.cd[i].artist + "</td>"
					printData += "<td>" + resData.cd[i].price + "</td></tr>"
				}
				tbody.innerHTML = printData
			} catch (e) {
				tbody.innerHTML = "일치하는게 없습니다."
			}
		}
	}
</script>
</head>
<body onload="send()">
	<input type="text" id="title" onkeyup="send()"> 
	<table border=1>
		<thead>
			<tr>
				<th>title</th>
				<th>artist</th>
				<th>price</th>
			</tr>
		</thead>
		<tbody id="tbody">
			
		</tbody>
	</table>
</body>
</html>













