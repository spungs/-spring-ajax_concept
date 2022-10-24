<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex1</title>
<script>
	var req
	function send(){
		req = new XMLHttpRequest();	// 객체 생성
		req.onreadystatechange = changeText // onreadystatechange이벤트가 changeText 함수를 호출
		req.open('post', 'ex1') // 경로 지정
		req.send(null)			// send
	}
	
	function changeText(){
		// readyState가 4(송수신이 완료된 상태)가 되었고 status상태가 200이면
		if(req.readyState == 4 && req.status == 200){
			// id가 'print'인 태그의 innerHTML 값을 바꾸겠다
			var print = document.getElementById("print")
			print.innerHTML = req.responseText // responseText는 서버에서 return해준 값
		}
	}
</script>
</head>
<body>
	<div id="print">출력 데이터</div>
	<button type="button" onclick="send()">데이터 가져오기</button>
</body>
</html>