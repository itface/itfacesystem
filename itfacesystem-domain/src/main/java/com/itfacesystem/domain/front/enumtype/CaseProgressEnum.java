package com.itfacesystem.domain.front.enumtype;


import com.itfacesystem.domain.front.vo.CaseProgressTreeVo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangrongtao on 15/11/11.
 */
public enum CaseProgressEnum {

    LEVEL_1(100,"合约恰谈",100,0,1),
    LEVEL_1_STEP_1(200,"银行委托恰谈",200,100,1),
    LEVEL_1_STEP_2(300,"合同已签订",300,100,1),
    LEVEL_1_STEP_3(400,"初期律师费已支出",400,100,1),
    LEVEL_1_STEP_4(500,"诉前财产保全",500,100,1),

    LEVEL_2(600,"一审立案",600,0,1),
    LEVEL_2_STEP_1(700,"立案",700,600,1),
    LEVEL_2_STEP_5(701,"添加诉讼案号",701,600,1),
    LEVEL_2_STEP_2(800,"财产保全",800,600,1),
    LEVEL_2_STEP_3(900,"文书送达",900,600,1),
    LEVEL_2_STEP_4(1000,"确定开庭日",1000,600,1),

    LEVEL_3(1100,"一审开庭",1100,0,1),
    LEVEL_3_STEP_1(1200,"已开庭",1200,1100,1),
    LEVEL_3_STEP_2(1300,"代理文书提交",1300,1100,1),
    LEVEL_3_STEP_3(1400,"判决书跟进",1400,1100,1),

    LEVEL_4(1500,"一审调解",1500,0,1),
    LEVEL_4_STEP_1(1600,"是否调解",1600,1500,1),

    LEVEL_5_STEP_1(1700,"一审判决",1700,0,1),
    LEVEL_5_STEP_2(1800,"法院已出具判决书",1800,1700,1),
    LEVEL_5_STEP_3(1900,"判决送达",1900,1700,1),


    LEVEL_6_STEP_1(2000,"上诉期",2000,0,1),
    LEVEL_6_STEP_2(2100,"是否上诉",2100,2000,1),

    LEVEL_7_STEP_1(2200,"二审立案",2200,0,1),
    LEVEL_7_STEP_2(2300,"立案",2300,2200,1),
    LEVEL_7_STEP_3(2400,"文书送达",2400,2200,1),
    LEVEL_7_STEP_4(2500,"确定开庭日",2500,2200,1),

    LEVEL_8_STEP_1(2600,"二审开庭",2600,0,1),
    LEVEL_8_STEP_2(2700,"已开庭",2700,2600,1),
    LEVEL_8_STEP_3(2800,"代理文书提交",2800,2600,1),
    LEVEL_8_STEP_4(2900,"判决书跟进",2900,2600,1),

    LEVEL_9_STEP_1(3000,"二审调解",3000,0,1),
    LEVEL_9_STEP_2(3100,"是否调解",3100,3000,1),

    LEVEL_10_STEP_1(3200,"二审判决",3200,0,1),
    LEVEL_10_STEP_2(3300,"法院已出具判决书",3300,3200,1),
    LEVEL_10_STEP_3(3400,"判决书送达",3400,3200,1),

//    LEVEL_11_STEP_0(3401,"结束诉讼阶段",3401,0,1),

    LEVEL_11_STEP_1(3500,"执行阶段",3500,0,2),
    LEVEL_11_STEP_2(3600,"已申请执行立案",3600,3500,2),
    LEVEL_11_STEP_3(3700,"已确定法官",3700,3500,2),
    LEVEL_11_STEP_4(3800,"执行文书送达",3800,3500,2),
    LEVEL_11_STEP_5(3900,"财产拍卖",3900,3500,2),
    LEVEL_11_STEP_6(4000,"结案",4000,3500,2),

    LEVEL_12_STEP_1(4100,"律师费结算",4100,0,2),
    LEVEL_12_STEP_2(4200,"提交律师费结算",4200,4100,2),
    LEVEL_12_STEP_3(4300,"开出发票",4300,4100,2),
    LEVEL_12_STEP_4(4400,"律师费到帐",4400,4100,2);

    private int id;
    private String name;
    private int index;
    private int parentid;
    private int type;//1:诉讼,2:执行

    CaseProgressEnum(int id, String name, int index, int parentid,int type) {
        this.id = id;
        this.name = name;
        this.index = index;
        this.parentid = parentid;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private static void findSubCaseProgressTree(CaseProgressTreeVo caseProgressTreeVo){
        CaseProgressEnum[] caseProgressEnums = CaseProgressEnum.values();
        List<CaseProgressTreeVo> caseProgressTreeVos = new ArrayList<CaseProgressTreeVo>();
        for (int i = 0; i < caseProgressEnums.length; i++) {
            CaseProgressEnum caseProgressEnum = caseProgressEnums[i];
            if(caseProgressTreeVo.getId() == caseProgressEnum.parentid){
                CaseProgressTreeVo caseProgressTreeVo2 = new CaseProgressTreeVo();
                caseProgressTreeVo2.setId(caseProgressEnum.id);
                caseProgressTreeVo2.setParentprocessnodeid(caseProgressEnum.parentid);
                caseProgressTreeVo2.setProcessnodeindex(caseProgressEnum.index);
                caseProgressTreeVo2.setText(caseProgressEnum.name);
                caseProgressTreeVos.add(caseProgressTreeVo2);
            }
        }
        Collections.sort(caseProgressTreeVos);
        caseProgressTreeVo.setNodes(caseProgressTreeVos);
    }
    public static List<CaseProgressTreeVo> initCaseProgressTree(boolean ifss,boolean sfss){
        List<CaseProgressTreeVo> caseProgressTreeVos = new ArrayList<CaseProgressTreeVo>();
        CaseProgressEnum[] caseProgressEnums = CaseProgressEnum.values();
        for (int i = 0; i < caseProgressEnums.length; i++) {
            CaseProgressEnum caseProgressEnum = caseProgressEnums[i];
            int parentid = caseProgressEnum.parentid;
            if (parentid==0) {
                if ((caseProgressEnum.id==3500||caseProgressEnum.id==4100)&&ifss) {
                    continue;
                }
                if ((caseProgressEnum.id==2200||caseProgressEnum.id==2600||caseProgressEnum.id==3000||caseProgressEnum.id==3200)&&!sfss) {
                    continue;
                }
                CaseProgressTreeVo caseProgressTreeVo = new CaseProgressTreeVo();
                caseProgressTreeVo.setId(caseProgressEnum.id);
                caseProgressTreeVo.setParentprocessnodeid(caseProgressEnum.parentid);
                caseProgressTreeVo.setProcessnodeindex(caseProgressEnum.index);
                caseProgressTreeVo.setText(caseProgressEnum.name);
                findSubCaseProgressTree(caseProgressTreeVo);
                caseProgressTreeVos.add(caseProgressTreeVo);
            }
        }
        Collections.sort(caseProgressTreeVos);
        return caseProgressTreeVos;
    }
    public static List<CaseProgressTreeVo> getExecuteCaseProgressTree(boolean ifSslawyerOnly){
        List<CaseProgressTreeVo> caseProgressTreeVos = new ArrayList<CaseProgressTreeVo>();
        if (!ifSslawyerOnly) {
            CaseProgressEnum[] caseProgressEnums = CaseProgressEnum.values();
            for (int i = 0; i < caseProgressEnums.length; i++) {
                CaseProgressEnum caseProgressEnum = caseProgressEnums[i];
                int parentid = caseProgressEnum.parentid;
                if (parentid == 0 && caseProgressEnum.type == 2) {
                    CaseProgressTreeVo caseProgressTreeVo = new CaseProgressTreeVo();
                    caseProgressTreeVo.setId(caseProgressEnum.id);
                    caseProgressTreeVo.setParentprocessnodeid(caseProgressEnum.parentid);
                    caseProgressTreeVo.setProcessnodeindex(caseProgressEnum.index);
                    caseProgressTreeVo.setText(caseProgressEnum.name);
                    findSubCaseProgressTree(caseProgressTreeVo);
                    caseProgressTreeVos.add(caseProgressTreeVo);
                }
            }
            Collections.sort(caseProgressTreeVos);
        }
        return caseProgressTreeVos;
    }
    public static List<CaseProgressTreeVo> getSsCaseProgressTree(boolean ifSslawyerOnly,boolean sfss){
        List<CaseProgressTreeVo> caseProgressTreeVos = new ArrayList<CaseProgressTreeVo>();
        CaseProgressEnum[] caseProgressEnums = CaseProgressEnum.values();
        for (int i = 0; i < caseProgressEnums.length; i++) {
            CaseProgressEnum caseProgressEnum = caseProgressEnums[i];
            int parentid = caseProgressEnum.parentid;
            if (parentid == 0 && caseProgressEnum.type == 1) {
                if ((caseProgressEnum.id==2200||caseProgressEnum.id==2600||caseProgressEnum.id==3000||caseProgressEnum.id==3200)&&!sfss) {
                    continue;
                }
                CaseProgressTreeVo caseProgressTreeVo = new CaseProgressTreeVo();
                caseProgressTreeVo.setId(caseProgressEnum.id);
                caseProgressTreeVo.setParentprocessnodeid(caseProgressEnum.parentid);
                caseProgressTreeVo.setProcessnodeindex(caseProgressEnum.index);
                caseProgressTreeVo.setText(caseProgressEnum.name);
                findSubCaseProgressTree(caseProgressTreeVo);
                caseProgressTreeVos.add(caseProgressTreeVo);
            }
        }
        Collections.sort(caseProgressTreeVos);
        return caseProgressTreeVos;
    }
}
