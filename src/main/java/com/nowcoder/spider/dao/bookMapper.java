package com.nowcoder.spider.dao;

import com.nowcoder.spider.model.DoubanList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface bookMapper {
    int addBook(DoubanList book);
    //cant push
}
