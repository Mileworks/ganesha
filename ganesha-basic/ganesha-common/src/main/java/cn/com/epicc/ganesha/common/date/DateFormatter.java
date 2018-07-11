package cn.com.epicc.ganesha.common.date;

public enum DateFormatter 
{
	/**
	 * pattern <font>"yyyy-MM-dd"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyy-MM-dd"
	 */
	Year_To_Day("yyyy-MM-dd"),
	
	/**
	 * pattern <font>"yyyy-MM-dd HH"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyy-MM-dd HH"
	 */
	Year_To_Hour("yyyy-MM-dd HH"),
	
	/**
	 * pattern <font>"yyyy-MM-dd HH:mm"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyy-MM-dd HH:mm"
	 */
	Year_To_Minute("yyyy-MM-dd HH:mm"),
	
	/**
	 * pattern <font>"yyyy-MM-dd HH:mm:ss"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyy-MM-dd HH:mm:ss"
	 */
	Year_To_Second("yyyy-MM-dd HH:mm:ss"),
	
	/**
	 * pattern <font>"yyyy-MM-dd HH:mm:ss.SSS"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyy-MM-dd HH:mm:ss.SSS"
	 */
	Year_To_Millisecond("yyyy-MM-dd HH:mm:ss.SSS"),
	
	/**
	 * pattern <font>"yyyyMMdd"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyyMMdd"
	 */
	YearToDay("yyyyMMdd"),
	
	/**
	 * pattern <font>"yyyyMMddHH"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyyMMddHH"
	 */
	YearToHour("yyyyMMddHH"),
	
	/**
	 * pattern <font>"yyyyMMddHHmm"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyyMMddHHmm"
	 */
	YearToMinute("yyyyMMddHHmm"),
	
	/**
	 * pattern <font>"yyyyMMddHHmmss"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyyMMddHHmmss"
	 */
	YearToSecond("yyyyMMddHHmmss"),
	
	/**
	 * pattern <font>"yyyyMMddHHmmssSSS"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyyMMddHHmmssSSS"
	 */
	YearToMillisecond("yyyyMMddHHmmssSSS"),
	
	/**
	 * pattern <font>"yyyy年MM月dd日"</font>
	 * </br></br>
	 * Formats a Date into a date/time string or parses text from the beginning of the given string to produce a date with pattern "yyyy年MM月dd日"
	 */
	Year_Month_Day("yyyy年MM月dd日");
	
	private String pattern = "";
	
	private DateFormatter(String pattern)
	{
        this.pattern = pattern;
    }
	
	@Override
    public String toString()
	{
		return this.pattern;
    }
	
	public String value()
	{
		return this.pattern;
	}
}
