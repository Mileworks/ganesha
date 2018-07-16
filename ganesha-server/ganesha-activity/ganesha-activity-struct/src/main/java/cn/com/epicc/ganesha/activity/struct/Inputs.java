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
 * Created: 2018-07-13 16:53
 */
@Data
@AllArgsConstructor
@Builder
@SuppressWarnings("deprecation")
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class Inputs {

    @JacksonXmlProperty(isAttribute = true)
    private String type;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Input")
    private List<Input> inputs;

    @JacksonXmlProperty(localName = "InputList")
    private InputList inputList;

    public Inputs() {
    }
}
