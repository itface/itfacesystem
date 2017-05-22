package com.itfacesystem.domain.wechat.request;

/**
 * Created by wangrongtao on 2016/10/22.
 */
public class WeChatRequestShortvideoMessage extends WeChatBaseRequestMessage {
    private long MediaId;

    public long getMediaId() {
        return MediaId;
    }

    public void setMediaId(long mediaId) {
        MediaId = mediaId;
    }
}
