package com.neo.gateway.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author By15
 * @date 2021/11/24 13:38
 */
@Data
public class LogDto implements Serializable {
    private static final long serialVersionUID = -1L;

    /**
     * 来源IP
     */
    private String source;

    /**
     * 请求方法(GET,POST,PUT,DELETE,OPTION)
     */
    private String method;

    /**
     * 目标接口URL
     */
    private String url;

    /**
     * 请求头信息
     */
    private Map<String, String> headers;

    /**
     * 请求参数
     */
    private Map<String, String> params;

    /**
     * 请求体数据
     */
    private Object body;

}