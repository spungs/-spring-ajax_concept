package com.care.ajax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
public class AjaxController {
	
	@GetMapping("ex1")
	public String ex1Get() {
		return "ajax/ex1";
	}
	
	@ResponseBody //클라이언트가 준 데이터를 받는다.
	@PostMapping(value="ex1", produces = "text/html; charset=UTF-8")
	public String ex1Post() {
		return "서버의 응답 데이터";
//		return "AJAX Server Response Data";
	}
	
	@GetMapping("ex2")
	public String ex2Get() {
		return "ajax/ex2";
	}
	
	//클라이언트가 준 데이터를 받는다.
	@ResponseBody
	@PostMapping(value="ex2", produces = "text/html; charset=UTF-8")
	public String ex2Post(@RequestBody String reqData) {
		return "서버의 응답 데이터 : " + reqData; // 전달받은 데이터를 반환
	}
	
	@GetMapping("ex3")
	public String ex3Get() {
		return "ajax/ex3";
	}
	
	@ResponseBody //클라이언트가 준 데이터를 받는다.
	@PostMapping(
			value="ex3", 
			produces = "application/json; charset=UTF-8") // 클라이언트에게 데이터가 json이라고 set 
	public HashMap<String,String> ex3Post(
			@RequestBody HashMap<String, String> map) {
		System.out.println("아이디 : " + map.get("id"));
		System.out.println("비밀번호 : " + map.get("pw"));
//		map.put("id", "아이디값");
//		map.put("pw", "비밀번호값");
		return map;
	}
	
	@GetMapping("ex4")
	public String ex4Get() {
		return "ajax/ex4";
	}
	
	@ResponseBody //클라이언트가 준 데이터를 받는다.
	@PostMapping(
			value="ex4", 
			produces = "application/json; charset=UTF-8") // 클라이언트에게 데이터가 json이라고 set 
	public String ex4Post() throws FileNotFoundException, IOException {
		//resource 폴더 하위에 있는 파일중에 ex5.json 파일의 경로를 객체로 생성 (전에 파일 다운로드 했을 때 File 객체를 썻던것과 비슷)
		// 둘다 사용할 수 있지만 File 객체는 C:부터 경로를 써줘야하고 ClassPathResource 객체는 해당 경로에서 바로 불러올수 있음
		ClassPathResource resource
		= new ClassPathResource("ex5.json");
		
		//ex5.json 파일을 읽을  FileReader 객체를 생성
		FileReader reader = new FileReader(resource.getFile());
		// BufferedReader 객체는 readLine()메서드로 한줄 씩 읽을 수 있어서 더 빠르게 처리할 수 있어서 사용
		BufferedReader buffer = new BufferedReader(reader); 
		
		String data = "";
		
		while(true) {
			// readLine()메서드는 한 줄씩 읽어와줘 (반환은 문자열이라서 String tmp변수에 저장)
			String tmp = buffer.readLine(); 
			if(tmp == null) // 읽다가 null이 나오면(다 읽었으면)
				break; // while문 탈출
			data += tmp; // 한줄씩 읽은 데이터를 String data변수에 추가
		}
//		System.out.println(data);
		return data;
		// data 출력
		// {"cd" : [{ "title" : "Empire Burlesque", "artist" : "Bob Dylan", "price" : "10.90" },{ "title" : "Hide your heart", "artist" : "Bonnie Tyler", "price" : "9.90" },{ "title" : "Greatest Hits", "artist" : "Dolly Parton", "price" : "9.90" },{ "title" : "Still got the blues", "artist" : "Bob Dylan", "price" : "10.20" },{ "title" : "Eros", "artist" : "Eros Ramazzotti", "price" : "9.90" },{ "title" : "One night only", "artist" : "Bee Gees", "price" : "10.90" },{ "title" : "Sylvias Mother", "artist" : "Dr.Hook", "price" : "8.10" },{ "title" : "Maggie May", "artist" : "Rod Stewart", "price" : "8.50" },{ "title" : "Empire Burlesque", "artist" : "Bob Dylan", "price" : "10.90" },{ "title" : "Hide your heart", "artist" : "Bonnie Tyler", "price" : "9.90" },{ "title" : "Greatest Hits", "artist" : "Dolly Parton", "price" : "9.90" },{ "title" : "Still got the blues", "artist" : "Bob Dylan", "price" : "10.20" },{ "title" : "Eros", "artist" : "Eros Ramazzotti", "price" : "9.90" },{ "title" : "One night only", "artist" : "Bee Gees", "price" : "10.90" },{ "title" : "Sylvias Mother", "artist" : "Dr.Hook", "price" : "8.10" },{ "title" : "Maggie May", "artist" : "Rod Stewart", "price" : "8.50" },{ "title" : "Empire Burlesque", "artist" : "Bob Dylan", "price" : "10.90" },{ "title" : "Hide your heart", "artist" : "Bonnie Tyler", "price" : "9.90" },{ "title" : "Greatest Hits", "artist" : "Dolly Parton", "price" : "9.90" },{ "title" : "Still got the blues", "artist" : "Bob Dylan", "price" : "10.20" },{ "title" : "Eros", "artist" : "Eros Ramazzotti", "price" : "9.90" },{ "title" : "One night only", "artist" : "Bee Gees", "price" : "10.90" },{ "title" : "Sylvias Mother", "artist" : "Dr.Hook", "price" : "8.10" },{ "title" : "Maggie May", "artist" : "Rod Stewart", "price" : "8.50" },{ "title" : "Empire Burlesque", "artist" : "Bob Dylan", "price" : "10.90" },{ "title" : "Hide your heart", "artist" : "Bonnie Tyler", "price" : "9.90" },{ "title" : "Greatest Hits", "artist" : "Dolly Parton", "price" : "9.90" },{ "title" : "Still got the blues", "artist" : "Bob Dylan", "price" : "10.20" },{ "title" : "Eros", "artist" : "Eros Ramazzotti", "price" : "9.90" },{ "title" : "One night only", "artist" : "Bee Gees", "price" : "10.90" },{ "title" : "Sylvias Mother", "artist" : "Dr.Hook", "price" : "8.10" },{ "title" : "Maggie May", "artist" : "Rod Stewart", "price" : "8.50" },{ "title" : "Empire Burlesque", "artist" : "Bob Dylan", "price" : "10.90" },{ "title" : "Hide your heart", "artist" : "Bonnie Tyler", "price" : "9.90" },{ "title" : "Greatest Hits", "artist" : "Dolly Parton", "price" : "9.90" },{ "title" : "Still got the blues", "artist" : "Bob Dylan", "price" : "10.20" },{ "title" : "Eros", "artist" : "Eros Ramazzotti", "price" : "9.90" },{ "title" : "One night only", "artist" : "Bee Gees", "price" : "10.90" },{ "title" : "Sylvias Mother", "artist" : "Dr.Hook", "price" : "8.10" },{ "title" : "Maggie May", "artist" : "Rod Stewart", "price" : "8.50" }]}
	}
	
	@GetMapping("ex5")
	public String ex5Get() {
		return "ajax/ex5";
	}
	
	@ResponseBody //클라이언트가 준 데이터를 받는다. 받은 데이터를 클라이언트에게 준다.
	@PostMapping(
			value="ex5", 
			produces = "application/json; charset=UTF-8") // 클라이언트에게 데이터가 json이라고 set 
	public String ex5Post(@RequestBody(required = false) String title) throws FileNotFoundException, IOException {
		//resource 폴더 하위에 있는 파일중에 ex5.json 파일의E 경로를 객체로 생성 (전에 파일 다운로드 했을 때 File 객체를 썻던것과 비슷)
		// 둘다 사용할 수 있지만 File 객체는 C:부터 시작해야하고 ClassPathResource 객체는 해당 경로로 바로 불러올수 있음
		ClassPathResource resource = new ClassPathResource("ex5.json");
		FileReader reader = new FileReader(resource.getFile()); //경로에서 파일을 get하고 reader객체에 저장
		
		// Gson객체를 생성
		Gson gson = new Gson(); 
		// Gson객체의 fromJson메서드로 reader객체를 JsonObject클래스로 변환
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		
		System.out.println(obj.toString()); // Object형태를 String형태로 변환
		System.out.println("title: " + title); // 입력한 title
		if(title == null) // 아무것도 입력하지 않았으면
			return obj.toString(); // 모두 반환
		
		// obj.get("cd") : cd 키의 값은 배열(Array)
		System.out.println("obj.get(\"cd\") : "+obj.get("cd")); // key를 지정하면 value를 반환
		JsonElement element = obj.get("cd"); // key의 value
		
		// 배열로 변환
		JsonArray array = element.getAsJsonArray(); 
		//array.get(0) : 배열 인덱스 지정해서 행단위로 데이터 추출
		JsonElement element2 = array.get(0); 
		// 행 단위 데이터는 { "title" : "Sylvias Mother", "artist" : "Dr.Hook", "price" : "8.10" } JSON 객체
		JsonObject obj2 = element2.getAsJsonObject();
		
		System.out.println("obj2.get(\"title\").getAsString()) : " + obj2.get("title").getAsString());
		System.out.println("obj2.get(\"title\").getAsString()) : " + obj2.get("title").getAsString().equals(title));
		
		/*
		{"cd" : [
		{ "title" : "Sylvias Mother", "artist" : "Dr.Hook", "price" : "8.10" },
		{ "title" : "Maggie May", "artist" : "Rod Stewart", "price" : "8.50" }
		]}
		아래에서 지금 형식을 만들자.
		 */
		String data = "{\"cd\" : [";
		boolean check = true;
		for(int i = 0; i < array.size(); i++) {
			JsonElement e = array.get(i);
			JsonObject o = e.getAsJsonObject();
			//getAsString() : 값에서 ""를 제외하고 데이터 추출
			if(o.get("title").getAsString().equals(title)) {
				check = false;
				// toString : 값에서 ""를 포함한 데이터 추출
				data += "{\"title\" : " + o.get("title").toString();
				data += "{\"artist\" : " + o.get("artist").toString();
				data += "{\"price\" : " + o.get("price").toString() + "},";
			}
		}
		
		// 마지막 행 콤마(,)제거
		data = data.substring(0, data.length()-1);
		data += "]}";
		System.out.println(data);
		
		if(check)
			return obj.toString();
		
		return data;
	}
	
	@Autowired AjaxService service;
	@ResponseBody
	@GetMapping(value = "ex6Insert", produces = "text/html; charset=UTF-8")
	public String ex6Insert() throws FileNotFoundException, IOException {
		int result = service.insert();
		if(result == 1)
			return "DB 입력 완료";
		return "DB 입력 실패";
	}
	
	@GetMapping("ex6")
	public String ex6Get() {
		return "ajax/ex6";
	}
	
	@ResponseBody
	@PostMapping(value="ex6",produces="application/json; charset=UTF-8")
	public String ex6Post(@RequestBody(required = false) String title) {
		if(title == null || title.isEmpty()) {
			// 모든 데이터
			return service.all();
		}
		// 검색어에 맞는 결과
		return service.title(title);
	
	}
	
	@GetMapping("ex7")
	public String ex7Get() {
		return "ajax/ex7";
	}
	
	@ResponseBody
	@PostMapping(value="ex7",produces="application/json; charset=UTF-8")
	public String ex7Post(@RequestBody(required = false) HashMap<String, String> map) {
		
		String inputData = map.get("inputData");
		String sel = map.get("sel");
		
		if(inputData == null || inputData.isEmpty()) {
			// 모든 데이터
			return service.all();
		}
		
		if(sel.equals("artist")) {
			return service.artist(inputData);
		}
		if(sel.equals("price")) {
			return service.price(inputData);
		}
		
		// title
		return service.title(inputData);
	
	}
}
