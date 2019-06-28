package edu.javaee.core.service.impl;

import edu.javaee.core.dao.BaseDictDao;
import edu.javaee.core.po.BaseDict;
import edu.javaee.core.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: customerManager
 * @description: BaseDicr服务层
 * @author: 张清
 * @create: 2019-06-28 09:00
 **/
@Service("baseDictService")
public class BaseDictServiceimpl implements BaseDictService {
    @Autowired
    private BaseDictDao baseDictDao;
    /**
     * 根据类别代码，查询数据字典
     * */
    public List<BaseDict> findBaseDictByTypeCode(String typecode) {
        return baseDictDao.selectBaseDictByTypeCode(typecode);
    }
}
