package com.boe.tww.jpa;

import com.boe.tww.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * 用户jpa
 *
 * @author 唐万万
 * @create 2018-03-13 10:26
 */
public interface UserJPA extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, Serializable {

    @Query(value="select * from user where t_age > ?1",nativeQuery = true)
    public List<User> nativeQuery(int age);

    @Transactional
    @Modifying
    @Query(value="delete from user where t_name= ?1 and t_password = ?2",nativeQuery = true)
    public void deleteQuery(String name, String pwd);
}
