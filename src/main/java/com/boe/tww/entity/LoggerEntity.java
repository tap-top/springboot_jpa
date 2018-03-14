package com.boe.tww.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 日志的实体类
 *
 * @author 唐万万
 * @create 2018-03-13 17:36
 */
@Entity
@Table(name="logger")
public class LoggerEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "logger_id")
    private Long id;

    @Column(name = "logger_client_ip")
    private String clientIp;

    @Column(name = "logger_uri")
    private String uri;

    @Column(name = "logger_type")
    private String type;

    @Column(name = "logger_method")
    private String method;

    @Column(name = "logger_param_data")
    private String paramData;

    @Column(name = "logger_session_id")
    private String sessionId;

    @Column(name = "logger_time",insertable = false)
    private Timestamp time;

    @Column(name = "logger_return_time")
    private String returnTime;

    @Column(name = "logger_return_data")
    private String returnData;

    @Column(name = "logger_http_status_code")
    private String httpStatusCode;

    @Column(name = "logger_time_consuming")
    private int timeConsuming;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(int timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
}
