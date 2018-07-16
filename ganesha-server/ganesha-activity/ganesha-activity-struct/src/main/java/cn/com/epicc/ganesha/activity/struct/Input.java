package cn.com.epicc.ganesha.activity.struct;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Description: 输入数据
 * Author: lishangmin
 * Created: 2018-07-13 16:52
 */
@Data
@AllArgsConstructor
@Builder
@SuppressWarnings("deprecation")
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class Input {

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlText
    private String value;



    public Input() {
    }
}
