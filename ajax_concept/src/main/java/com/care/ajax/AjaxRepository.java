package com.care.ajax;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public interface AjaxRepository {
	int insert(AjaxDTO dto);
	
	ArrayList<AjaxDTO> all();

	ArrayList<AjaxDTO> title(String inputData);
	ArrayList<AjaxDTO> artist(String inputData);
	ArrayList<AjaxDTO> price(String inputData);
}
