package edu.javaee.core.service;

import edu.javaee.core.po.BaseDict;

import java.util.List;

public interface BaseDictService {
    /**
     * 根据typecode确定关联
     * */
    public List<BaseDict> findBaseDictByTypeCode(String typecode);
}
