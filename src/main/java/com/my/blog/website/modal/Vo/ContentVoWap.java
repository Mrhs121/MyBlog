package com.my.blog.website.modal.Vo;

import com.github.pagehelper.PageInfo;

public class ContentVoWap {

    PageInfo<ContentVo> artices;
    String cateName;

    public ContentVoWap(PageInfo<ContentVo> contentVo, String cataName) {
        this.artices = contentVo;
        this.cateName = cataName;
    }


    public PageInfo<ContentVo> getArtices() {
        return artices;
    }

    public void setArtices(PageInfo<ContentVo> artices) {
        this.artices = artices;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
