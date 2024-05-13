package org.springboot.example.server_basic_structure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springboot.example.server_basic_structure.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p> 2023/7/26 </p>
 * mapper 层，与数据库交互
 *
 * @author Fqq
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过注解注入 SQL
     */
    @Select("select * from sys_user")
    List<User> findAll();
}
