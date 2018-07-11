package cn.com.epicc.ganesha.integral.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Description: 用户积分表
 * Author: lishangmin
 * Created: 2018-07-01 23:42
 */
@Repository
@Mapper
public interface IntegralDao {

    @Update("UPDATE `ganesha_integral` a SET a.`balance` = #{balance} WHERE a.`account_id` = #{accountId}")
    int updateBalanceByAccountId(@Param("accountId") String accountId, @Param("balance") Long balance);

    @Update("UPDATE `ganesha_integral` a SET a.`balance` = a.`balance` + #{integral} WHERE a.`account_id` = #{accountId}")
    int addIntegralByAccountId(@Param("accountId") String accountId, @Param("integral") Long integral);

    @Update("UPDATE `ganesha_integral` a SET a.`balance` = a.`balance` - #{integral} WHERE a.`account_id` = #{accountId} AND a.balance >= #{integral}")
    int subIntegralByAccountId(@Param("accountId") String accountId, @Param("integral") Long integral);

    @Select("SELECT a.`balance` FROM `ganesha_integral` a WHERE a.`account_id` = #{accountId} ")
    Long selectBalanceByAccountId(@Param("accountId")String accountId);

}
