package cn.com.epicc.ganesha.integral.dao;

import cn.com.epicc.ganesha.integral.model.IntegralAddEvent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Description: 积分增加事件表
 * Author: lishangmin
 * Created: 2018-07-06 16:54
 */
@Mapper
@Repository
public interface IntegralAddEventDao {

    @Insert("INSERT INTO `ganesha_integral_add_event` (`account_id`, `amount`, `operator`, `source`, `m_time`, `c_time`) " +
            "VALUES " +
            "(#{accountId}, #{amount}, #{operator}, #{source}, #{mTime}, #{cTime})")
    int insert(IntegralAddEvent integralAddEvent);

}
