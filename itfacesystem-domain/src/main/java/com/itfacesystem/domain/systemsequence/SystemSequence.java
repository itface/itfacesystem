package com.itfacesystem.domain.systemsequence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * Created by wangrongtao on 2017/4/9.
 */
@Entity
@Table(name="system_sequence")
public class SystemSequence implements Serializable {
    @Id
    private String type;
    private Long sequenceindex;
    @Version
    private Long version;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSequenceindex() {
        return sequenceindex;
    }

    public void setSequenceindex(Long sequenceindex) {
        this.sequenceindex = sequenceindex;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
