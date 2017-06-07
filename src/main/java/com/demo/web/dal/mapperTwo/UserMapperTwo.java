package com.demo.web.dal.mapperTwo;


import com.demo.web.dal.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017-06-01.
 */
@Mapper
public interface UserMapperTwo {

    List<User> getAll();

    User getOne(Long id);

}
