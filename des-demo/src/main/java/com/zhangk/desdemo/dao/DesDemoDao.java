package com.zhangk.desdemo.dao;

import com.zhangk.desdemo.entity.DesDemo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 数据库加解密demo
(DesDemo)表数据库访问层
 *
 * @author zhangk
 * @since 2021-11-15 15:26:42
 */
@Mapper
public interface DesDemoDao {

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
     * @return 影响行数
     */
    int insert(DesDemo desDemo);

}

