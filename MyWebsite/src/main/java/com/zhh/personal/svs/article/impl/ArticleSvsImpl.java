package com.zhh.personal.svs.article.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhh.personal.dao.ArticleMapper;
import com.zhh.personal.entity.Article;
import com.zhh.personal.svs.article.IArticleSvs;

@Service
public class ArticleSvsImpl implements IArticleSvs {

	@Resource
	private ArticleMapper articleMapper;
	
	@Override
	public int num() {
		Article a = new Article();
		a.setImgId(1);
		a.setKeyword("1");
		a.setState(1);
		a.setUrl("1");
		a.setTitle("1");
		articleMapper.save(a);
		return articleMapper.getList().size();
	}
	
	
}
