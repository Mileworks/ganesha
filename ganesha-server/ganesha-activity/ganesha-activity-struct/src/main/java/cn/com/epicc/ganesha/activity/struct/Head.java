package cn.com.epicc.ganesha.activity.struct;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Description: 报文头
 * Author: lishangmin
 * Created: 2018-07-13 16:58
 */
@Data
@AllArgsConstructor
@Builder
@SuppressWarnings("deprecation")
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
public class Head {

    /**
     * 接口类型- 投保、退保、查询
     */
    @JacksonXmlProperty(localName = "RequestType")
    private String requestType;

    /**
     * 险种类型- 车险、旅游险
     */
    @JacksonXmlProperty(localName = "InsureType")
    private String insureType;

    /**
     * 业务会话ID
     */
    @JacksonXmlProperty(localName = "SessionId")
    private String sessionId;

    /**
     * 请求来源- HuiZe
     */
    @JacksonXmlProperty(localName = "from")
    private String from;

    /**
     * 报文发送时间- 长整型
     */
    @JacksonXmlProperty(localName = "SendTime")
    private String sendTime;

    public Head() {
    }
}
