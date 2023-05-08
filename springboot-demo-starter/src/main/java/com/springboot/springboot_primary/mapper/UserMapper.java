package com.springboot.springboot_primary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.springboot_primary.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();

    // 如果没有配置映射文件xml，可以这样写sql
    @Select("select * from sys_user")
    List<User> findAll2();
}
