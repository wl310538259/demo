package com.example.demo.web.dal.mapper;

import com.example.demo.web.dal.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wanglei on 2017/5/31.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user_test where name = #{name}")
    User findUserByName(@Param("name")String name);
}
