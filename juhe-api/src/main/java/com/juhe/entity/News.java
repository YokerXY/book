package com.juhe.entity;

/**
 * 新闻实体类
 */
public class News {
    private  String title;//标题
    private  String authorName;//作者名
    private  String thumbnailPicS;//缩略图

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getThumbnailPicS() {
        return thumbnailPicS;
    }

    public void setThumbnailPicS(String thumbnailPicS) {
        this.thumbnailPicS = thumbnailPicS;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", thumbnailPicS='" + thumbnailPicS + '\'' +
                '}';
    }
}
