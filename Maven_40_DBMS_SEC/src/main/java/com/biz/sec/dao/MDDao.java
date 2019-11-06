package com.biz.sec.dao;

import java.util.List;

import com.biz.sec.persistance.MasterDTO;
import com.biz.sec.persistance.MasterDetailVO;

public interface MDDao {

	public List<MasterDetailVO> selectAll();
	
	public int insertMaster(MasterDTO masterDTO);
}
