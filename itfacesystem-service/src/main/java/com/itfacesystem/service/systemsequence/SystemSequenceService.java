package com.itfacesystem.service.systemsequence;

import java.util.List;

/**
 * Created by wangrongtao on 2017/4/9.
 */
public interface SystemSequenceService {
    public Long getSequence(String type);
    public List<Long> getSequenceList(String type,int length);
}
