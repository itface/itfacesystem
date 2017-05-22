package com.itfacesystem.service.systemsequence.impl;

import com.itfacesystem.dao.SystemSequenceRepository;
import com.itfacesystem.domain.systemsequence.SystemSequence;
import com.itfacesystem.service.systemsequence.SystemSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangrongtao on 2017/4/9.
 */
@Service
public class SystemSequenceServiceImpl implements SystemSequenceService {
    private static final long START_SEQUENCE = 10000;
    private static final long SEQUENCE_STEP = 1;

    @Autowired
    private SystemSequenceRepository systemSequenceRepository;

    @Override
    @Transactional
    public Long getSequence(String type) {
        Long sequence = null;
        SystemSequence systemSequence = systemSequenceRepository.findOne(type);
        if (systemSequence == null) {
            SystemSequence systemSequence1 = new SystemSequence();
            systemSequence1.setType(type);
            systemSequence1.setSequenceindex(START_SEQUENCE);
            systemSequenceRepository.save(systemSequence1);
            sequence = START_SEQUENCE;
        }else{
            Long oldSequence = systemSequence.getSequenceindex();
            systemSequence.setSequenceindex(oldSequence + SEQUENCE_STEP);
            SystemSequence systemSequence1 = systemSequenceRepository.save(systemSequence);
            sequence = systemSequence1.getSequenceindex();
        }
        return sequence;
    }

    @Override
    @Transactional
    public List<Long> getSequenceList(String type, int length) {
        List<Long> sequenceList = new ArrayList<>();
        long startSequence = 0;
        SystemSequence systemSequence = systemSequenceRepository.findOne(type);
        if (systemSequence == null) {
            SystemSequence systemSequence1 = new SystemSequence();
            systemSequence1.setType(type);
            systemSequence1.setSequenceindex(START_SEQUENCE + length);
            systemSequenceRepository.save(systemSequence1);
            startSequence = START_SEQUENCE;
        }else{
            Long oldSequence = systemSequence.getSequenceindex();
            systemSequence.setSequenceindex(oldSequence + SEQUENCE_STEP);
            SystemSequence systemSequence1 = systemSequenceRepository.save(systemSequence);
            startSequence = systemSequence1.getSequenceindex();
        }
        for (int i = 0; i < length; i++) {
            sequenceList.add(startSequence + i);
        }
        return sequenceList;
    }
}
