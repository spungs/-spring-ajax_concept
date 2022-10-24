<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex7</title>
<script>
	var req;
	function send(){
		req = new XMLHttpRequest();
		req.onreadystatechange = changeText
		req.open('post', "ex7")
		var s = document.getElementById('sel').value
		var i = document.getElementById('inputData').value
		
		var reqData = {sel : s, inputData : i}
		reqData = JSON.stringify(reqData)
		console.log(reqData) // 확인용
		req.setRequestHeader('Content-Type', "application/json; charset=UTF-8")
		req.send(reqData)
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
	<select id="sel">
		<option value="title">제목</option>
		<option value="artist">아티스트</option>
		<option value="price">가격</option>
	</select>
	<input type="text" id="inputData" onkeyup="send()"> 
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













