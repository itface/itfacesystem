package com.itfacesystem.domain.wechat.request;

/**
 * Created by wangrongtao on 2016/10/22.
 */
public class WeChatRequestPicMessage extends WeChatBaseRequestMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
