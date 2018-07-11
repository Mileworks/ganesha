package cn.com.epicc.ganesha.activity.dao;

import cn.com.epicc.ganesha.activity.model.Activity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Description: 活动信息表
 * Author: lishangmin
 * Created: 2018-07-09 13:22
 */
@Mapper
@Repository
public interface ActivityDao {

    @Insert("INSERT INTO `ganesha_activity` (`operator`, `name`, `start_time`, `end_time`, `m_time`, `c_time`)" +
            "VALUES" +
            "(#{operator}, #{name}, #{startTime}, #{endTime}, #{mTime}, #{cTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Activity activity);

    @Select("SELECT * FROM `ganesha_activity` a WHERE a.`id` = #{id}")
    Activity selectByPrimaryKey(@Param("id")String id);

}
