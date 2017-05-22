package com.itfacesystem.web.systemsequence;

import com.itfacesystem.service.systemsequence.SystemSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangrongtao on 2017/4/9.
 */
@RestController
public class SystemSequenceController {
    private Set<String> set1 = new HashSet<>();
    private Set<String> set2 = new HashSet<>();
    @Autowired
    private SystemSequenceService systemSequenceService;

    @RequestMapping("/getsequence")
    public String getSequence() throws InterruptedException {
        new Thread(new SequenceThread()).start();
        new Thread(new SequenceThread()).start();
        Thread.sleep(3000);
        return set1.size() + "";
    }
    class SequenceThread implements Runnable{
        private String type = "type1";
        @Override
        public void run() {
            for (int i = 0; i < 50000; i++) {
                Long sequence = null;
                try {
                    sequence = systemSequenceService.getSequence(type);
                } catch (Exception e) {
                    sequence = systemSequenceService.getSequence(type);
                }
                set1.add(sequence + "");
            }
        }
    }

}
