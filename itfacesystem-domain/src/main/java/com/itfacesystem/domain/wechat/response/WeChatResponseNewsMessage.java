package com.itfacesystem.domain.wechat.response;

import java.util.List;

/**
 * Created by wangrongtao on 2016/10/22.
 */
public class WeChatResponseNewsMessage extends WeChatBaseResponseMessage {
    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<WeChatArticle> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<WeChatArticle> getArticles() {
        return Articles;
    }

    public void setArticles(List<WeChatArticle> articles) {
        Articles = articles;
    }
}
