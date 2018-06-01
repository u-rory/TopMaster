package net.rory.springserverapp.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Message {

    private Long idUserFrom;

    private Long idUserTo;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm",
            timezone = "Asia/Tomsk")
    private Date datetime;

    public Message(){
    }

    public Message(Long idUserFrom, Long idUserTo, String content, Date datetime) {
        this.idUserFrom = idUserFrom;
        this.idUserTo = idUserTo;
        this.content = content;
        this.datetime = datetime;
    }

    public Long getIdUserFrom() {
        return idUserFrom;
    }

    public void setIdUserFrom(Long idUserFrom) {
        this.idUserFrom = idUserFrom;
    }

    public Long getIdUserTo() {
        return idUserTo;
    }

    public void setIdUserTo(Long idUserTo) {
        this.idUserTo = idUserTo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
