package cn.gch.dao;

import java.util.List;

import cn.gch.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {

	List<BaseDict> getListByTypeCode(String dict_type_code);
	
}
