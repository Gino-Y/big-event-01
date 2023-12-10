package com.itheima.service;

import com.itheima.pojo.Article;
import com.itheima.pojo.PageBean;

public interface ArticleService {
    // 添加文章
    void add(Article article);

    // 查询文章列表
    PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state);
}
