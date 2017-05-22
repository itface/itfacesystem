package com.itfacesystem.domain.wechat.request;

/**
 * Created by wangrongtao on 2016/10/22.
 */
public class WeChatRequestTextMessage extends WeChatBaseRequestMessage {

    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
