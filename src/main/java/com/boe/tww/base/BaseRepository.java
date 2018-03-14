package com.boe.tww.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author 唐万万
 * @create 2018-03-14 14:02
 */
@NoRepositoryBean
public interface BaseRepository <T,PK extends Serializable> extends JpaRepository<T,PK> {
}
