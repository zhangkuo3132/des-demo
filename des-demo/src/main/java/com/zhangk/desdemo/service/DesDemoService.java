package com.zhangk.desdemo.service;

import com.zhangk.desdemo.entity.DesDemo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 数据库加解密demo
(DesDemo)表服务接口
 *
 * @author zhangk
 * @since 2021-11-15 15:26:44
 */
public interface DesDemoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DesDemo queryById(Integer id);

    /**
     * 新增数据
     *
     * @param desDemo 实例对象
     * @return 实例对象
     */
    DesDemo insert(DesDemo desDemo);

}
