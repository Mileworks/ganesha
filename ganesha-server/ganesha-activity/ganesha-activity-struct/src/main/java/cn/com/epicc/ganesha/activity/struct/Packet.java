package cn.com.epicc.ganesha.activity.struct;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

/**
 * Description: 数据包
 * Author: lishangmin
 * Created: 2018-07-13 16:57
 */
@Data
@Builder
@AllArgsConstructor
@JacksonXmlRootElement
@SuppressWarnings("deprecation")
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class Packet {

    /**
     * 头信息
     */
    @JacksonXmlProperty(localName = "Head")
    private Head head;

    /**
     * 消息体
     */
    @JacksonXmlProperty(localName = "Request")
    private Request request;

    public Packet() {
    }
}
