package cn.com.epicc.ganesha.activity.struct;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-07-13 16:58
 */
@Data
@AllArgsConstructor
@Builder
@SuppressWarnings("deprecation")
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class Request {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "InputList")
    List<InputList> inputLists;

    public Request() {
    }
}
