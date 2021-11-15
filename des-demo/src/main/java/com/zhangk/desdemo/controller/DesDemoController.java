package com.zhangk.desdemo.controller;

import com.zhangk.desdemo.entity.DesDemo;
import com.zhangk.desdemo.service.DesDemoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 数据库加解密demo
(DesDemo)表控制层
 *
 * @author zhangk
 * @since 2021-11-15 15:26:41
 */
@RestController
@RequestMapping("desDemo")
public class DesDemoController {
    /**
     * 服务对象
     */
    @Resource
    private DesDemoService desDemoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DesDemo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.desDemoService.queryById(id));
    }
    /**
     * 新增数据
     *
     * @param desDemo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DesDemo> add(@RequestBody DesDemo desDemo) {
        return ResponseEntity.ok(this.desDemoService.insert(desDemo));
    }
}

