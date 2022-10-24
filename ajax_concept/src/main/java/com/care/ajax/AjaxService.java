package com.care.ajax;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class AjaxService {
		@Autowired private AjaxRepository repo;

		public int insert() throws FileNotFoundException, IOException {
			ClassPathResource resource = new ClassPathResource("ex5.json");
			FileReader reader = new FileReader(resource.getFile());
			
			Gson gson = new Gson(); 
			JsonObject obj = gson.fromJson(reader, JsonObject.class);
			
			JsonArray array = obj.get("cd").getAsJsonArray(); 
			for(int i = 0; i < array.size(); i++) {
				JsonObject o = array.get(i).getAsJsonObject();
				AjaxDTO dto = new AjaxDTO();
				dto.setTitle(o.get("title").toString());
				dto.setArtist(o.get("artist").toString());
				dto.setPrice(o.get("price").toString());
				
				int result = repo.insert(dto);
				if(result == 0)
					return 0;
				}
			return 1;
		}
		
		// 클라이언트에게 반환하기 위해 공통으로 쓰이는 json형태의 String form
		public String fromJson(ArrayList<AjaxDTO> list) {
			String data = "{\"cd\" : [";
			for(AjaxDTO tmp : list) {
				data += "{ \"title\" : " + tmp.getTitle() + ",";
				data +=	 " \"artist\" : " + tmp.getArtist() + ",";
				data += " \"price\" : " + tmp.getPrice() +" },";
			}
			data = data.substring(0, data.length()-1);
			data += "]}";
			return data;
		}
		
		public String all() {
			ArrayList<AjaxDTO> list = repo.all();
			return fromJson(list);
		}

		public String title(String inputData) {
			ArrayList<AjaxDTO> list = repo.title(inputData);
			return fromJson(list);
		}
		
		public String choose(HashMap<String, String> map) {
			ArrayList<AjaxDTO> list = repo.choose(map);
			if(list.isEmpty() == true)
				return "";
			return fromJson(list);
		}
}
