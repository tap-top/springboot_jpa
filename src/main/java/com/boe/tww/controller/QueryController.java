package com.boe.tww.controller;

import com.boe.tww.base.Inquirer;
import com.boe.tww.entity.GoodEntity;
import com.boe.tww.entity.QGoodEntity;
import com.boe.tww.jpa.GoodJPA;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 唐万万
 * @create 2018-03-14 14:50
 */
@RestController
public class QueryController {
    @Autowired
    private GoodJPA goodJPA;

    /*
     *注入EntityManager
     */

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 查询方法
     * @return
     */
    @GetMapping("/query")
    public List<GoodEntity> list() {
        //querydslc查询实体
        QGoodEntity _good = QGoodEntity.goodEntity;
        //构建JPA查询对象
        JPAQuery<GoodEntity> jpaQuery = new JPAQuery<>(entityManager);
        //返回查询接口
        return jpaQuery
                //查询字段
                .select(_good)
                //查询表
                .from(_good)
                //查询条件
                .where(_good.type.id.eq(Long.valueOf("1")))
                //返回结果
                .fetch();
    }

    /**
     * Spring data jpa 整合querydsl完成查询
     * @return
     */
    @GetMapping("/join")
    public List<GoodEntity> join() {
        //querydsl查询实体
        QGoodEntity _good = QGoodEntity.goodEntity;

        ////查询条件
        //BooleanExpression expression = _good.type.id.eq(Long.valueOf("1"));
        ////执行查询
        //Iterator<GoodEntity> iterator = goodJPA.findAll(expression).iterator();
        //List<GoodEntity> goods = new ArrayList<>();
        ////转成list
        //while (iterator.hasNext()) {
        //    goods.add(iterator.next());
        //}
        //return goods;

        //自定义查询对象
        Inquirer inquirer = new Inquirer();
        //添加查询对象
        inquirer.putExpression(_good.type.id.eq(Long.valueOf("1")));

        return inquirer.iteratorToList(goodJPA.findAll(inquirer.buidleQuery()));
    }
}
