package shiyue.jery.doubledatasourse.db2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import shiyue.jery.doubledatasourse.entity.Money;

/**
 * @author Jery
 * @date 2019/9/25
 */
@Qualifier("db2SqlSessionTemplate")
@Mapper
public interface MoneyDao {

    @Select({"select * from tb_money where basic = #{id}"})
    Money selectMoney(Integer id);
}
