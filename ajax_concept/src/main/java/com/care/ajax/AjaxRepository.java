package com.care.ajax;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface AjaxRepository {
	int insert(AjaxDTO dto);
	
	ArrayList<AjaxDTO> all();

	ArrayList<AjaxDTO> title(String title);
	
	ArrayList<AjaxDTO> choose(HashMap<String, String> map);
}
