package com.biz.sec.dao;

import java.util.List;
import java.util.Map;

import com.biz.sec.persistance.IolistDTO;

public interface IolistDao {

	// mapper.xml에 설정된 resultMap에 각 레코드 데이터를 담고,
	// resultMap의 요소를 List로 묶어라
	public List<Map<String,Object>> selectAllMap();
	
	public List<IolistDTO> selectAll();
	
}
