package cn.com.epicc.ganesha.common.date;

import java.util.Calendar;

public enum DateField 
{
	/**
	 * year of date. eg: the YEAR of 2014-03-05 15:04:15.250 is 2014.
	 */
	YEAR(Calendar.YEAR),
	
	/**
	 * month of date. eg: the MONTH of 2014-03-05 15:04:15.250 is 3.
	 */
	MONTH(Calendar.MONTH),
	
	/**
	 * day of date. eg: the DAY of 2014-03-05 15:04:15.250 is 5.
	 */
	DAY(Calendar.DAY_OF_MONTH),
	
	/**
	 * hour of date.(12小时制) eg: the HOUR of 2014-03-05 15:04:15.250 is 3.
	 */
	HOUR12(Calendar.HOUR),
	
	/**
	 * hour of date.(24小时制) eg: the HOUR of 2014-03-05 15:04:15.250 is 15.
	 */
	HOUR24(Calendar.HOUR_OF_DAY),
	
	/**
	 * minute of date. eg: the MINUTE of 2014-03-05 15:04:15.250 is 4.
	 */
	MINUTE(Calendar.MINUTE),
	
	/**
	 * second of date. eg: the SECOND of 2014-03-05 15:04:15.250 is 15.
	 */
	SECOND(Calendar.SECOND),
	
	/**
	 * millisecond of date. eg: the MILLISECOND of 2014-03-05 15:04:15.250 is 250.
	 */
	MILLISECOND(Calendar.MILLISECOND);
	
	private int field;
	
	private DateField(int field)
	{
		this.field = field;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(this.field);
	}
	
	public int value()
	{
		return this.field;
	}
	
}
