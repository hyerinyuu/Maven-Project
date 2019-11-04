package com.biz.oracle.mapper;

import java.util.List;
import java.util.Map;

public interface IolistDao {
	
	// List<DTO> selectAll()
	// resultMap으로 설정된 형태는
	// Map<String,Object> 형식의 DTO가 만들어 진 것으로 본다.
	public List<Map<String,Object>>selectAll();

}
