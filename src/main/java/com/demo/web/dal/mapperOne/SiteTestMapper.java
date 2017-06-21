package com.demo.web.dal.mapperOne;

import com.demo.web.dal.model.SiteTest;
import com.demo.web.dal.model.SiteTestExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SiteTestMapper {
    long countByExample(SiteTestExample example);

    int deleteByExample(SiteTestExample example);

    int insert(SiteTest record);

    int insertSelective(SiteTest record);

    List<SiteTest> selectByExample(SiteTestExample example);

    int updateByExampleSelective(@Param("record") SiteTest record, @Param("example") SiteTestExample example);

    int updateByExample(@Param("record") SiteTest record, @Param("example") SiteTestExample example);
}