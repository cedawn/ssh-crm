package cn.gch.service;

import java.util.List;

import cn.gch.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
