package com.itfacesystem.dao;

import com.itfacesystem.domain.systemsequence.SystemSequence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangrongtao on 2017/4/9.
 */
public interface SystemSequenceRepository extends JpaRepository<SystemSequence, String> {
    /*User findByNameAndAge(String name, Integer age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);*/
}
