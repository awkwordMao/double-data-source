package shiyue.jery.doubledatasourse.db1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import shiyue.jery.doubledatasourse.entity.User;

/**
 * @author Jery
 * @date 2019/9/25
 */
@Mapper
@Qualifier("db1SqlSessionTemplate")
public interface UserDao {

    @Select({"select id, name, money from tb_user where name = #{name}"})
    User selectUser(String name);
}
