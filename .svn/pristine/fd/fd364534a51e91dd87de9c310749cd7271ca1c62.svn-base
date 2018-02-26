package cn.gch.service.impl;

import java.util.List;

import cn.gch.dao.BaseDictDao;
import cn.gch.domain.BaseDict;
import cn.gch.service.BaseDictService;

public class BaseDictServiceImp implements BaseDictService {
	private BaseDictDao baseDictDao;
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		
		return baseDictDao.getListByTypeCode(dict_type_code);
	}
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

}
