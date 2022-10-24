<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex3</title>
<script>
	var req
	function send(){
		req = new XMLHttpRequest(); // 객체 생성
		req.onreadystatechange = changeText  // onreadystatechange이벤트가 changeText 함수를 호출
		req.open('post', 'ex3') // 경로지정
		var i = document.getElementById('id').value; // id가 'id'인 태그의 value을 변수에 저장
		var p = document.getElementById('pw').value; // id가 'pw'인 태그의 value을 변수에 저장
		
		var reqData = {id:i, pw:p} // hashmap의 형태로 key:value 형태로 reqData 저장
		// JSON 자료형의 데이터를 문자열 자료형의 데이터로 변환
		reqData = JSON.stringify(reqData)
// 		console.log(reqData)
		
		// requestheader(서버)에게 데이터가 json이라고 set
		req.setRequestHeader('Content-Type', "application/json; charset=UTF-8")
		req.send(reqData) // 참조값(reqData)를 send
	}
	
	function changeText(){
		// readyState가 4(송수신이 완료된 상태)가 되었고 status상태가 200이면
		if(req.readyState == 4 && req.status == 200){
			var printId = document.getElementById("printId")
			var printPw = document.getElementById("printPw")
			// 반환받은 문자열 자료형 데이터를 JSON 자료형의 데이터로 변환
			var resData = JSON.parse(req.responseText)
			printId.innerHTML = resData.id // resData의 id의 value를 innerHTML
			printPw.innerHTML = resData.pw // resData의 pw의 value를 innerHTML
		}
	}
</script>
</head>
<body>
	<input type="text" id="id" placeholder="아이디" /><br>
	<input type="password" id="pw" placeholder="비밀번호"/><br>
	응답 아이디 : <span id="printId"></span><br>
	응답 비밀번호 : <span id="printPw"></span><br>
	<button type="button" onclick="send()">로그인</button>
</body>
</html>