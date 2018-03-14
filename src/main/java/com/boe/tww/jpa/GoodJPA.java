package com.boe.tww.jpa;

import com.boe.tww.entity.GoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author 唐万万
 * @create 2018-03-14 14:51
 */
public interface GoodJPA extends
        JpaRepository<GoodEntity, Long>,
        QuerydslPredicateExecutor<GoodEntity> {
}
