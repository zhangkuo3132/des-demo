package com.zhangk.desdemo.service.impl;

import com.zhangk.desdemo.entity.DesDemo;
import com.zhangk.desdemo.dao.DesDemoDao;
import com.zhangk.desdemo.service.DesDemoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 数据库加解密demo
(DesDemo)表服务实现类
 *
 * @author zhangk
 * @since 2021-11-15 15:26:45
 */
@Service("desDemoService")
public class DesDemoServiceImpl implements DesDemoService {
    @Resource
    private DesDemoDao desDemoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DesDemo queryById(Integer id) {
        return this.desDemoDao.queryById(id);
    }
    /**
     * 新增数据
     *
     * @param desDemo 实例对象
     * @return 实例对象
     */
    @Override
    public DesDemo insert(DesDemo desDemo) {
        this.desDemoDao.insert(desDemo);
        return desDemo;
    }
}
