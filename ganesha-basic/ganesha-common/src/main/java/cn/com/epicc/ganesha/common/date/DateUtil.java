package cn.com.epicc.ganesha.common.date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Description: 时间格式化
 * Author: lishangmin
 * Created: 2018-06-20 15:53
 */
public class DateUtil {

    //str->Date
    //Date->str
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date strToDate(String dateTimeStr,String formatStr){
        return DateTimeFormat.forPattern(formatStr).parseDateTime(dateTimeStr).toDate();
    }

    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date strToDate(String dateTimeStr){
        return strToDate(dateTimeStr,STANDARD_FORMAT);
    }

    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    public static Date toDate(String time){
        Long m = Long.parseLong(time);
        return toDate(m);
    }

    public static Date toDate(Long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.getTime();
    }

    public static String timeToStr(Long time){
        return dateToStr(toDate(time));
    }

    public static String getTimestamp(){
       return String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

}
