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

    @Update("update `ganesha_integral` a set a.`balance` = #{balance} where a.`account_id` = #{accountId}")
    int updateBalanceByAccountId(@Param("accountId") String accountId, @Param("balance") Long balance);

    @Update("update `ganesha_integral` a set a.`balance` = a.`balance` + #{integral} where a.`account_id` = #{accountId}")
    int addIntegralByAccountId(@Param("accountId") String accountId, @Param("integral") Long integral);

    @Update("update `ganesha_integral` a set a.`balance` = a.`balance` - #{integral} where a.`account_id` = #{accountId} and a.balance >= #{integral}")
    int subIntegralByAccountId(@Param("accountId") String accountId, @Param("integral") Long integral);

    @Select("select a.`balance` from `ganesha_integral` a where a.`account_id` = #{accountId} ")
    Long selectBalanceByAccountId(@Param("accountId")String accountId);

}
