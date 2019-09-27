package com.nowcoder.spider.service.spider.strategy;

import com.nowcoder.spider.model.DoubanList;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class DoubanProcessor implements ProcessStrategy {



    @Override
    public void doProcess(Page page) {
         DoubanList doubanList = new DoubanList();
        List<String> titles = page.getHtml().xpath("//div[@class='title']/a/text()").all(); //这是匹配标题
        List<String> ratings = page.getHtml().xpath("//div[@class='rating']/span[@class='rating_nums']/text()").all(); //这是匹配评分
        page.putField("name",titles);
        for (int i = 0; i < titles.size(); i++) { //循环存储到数据库

            doubanList.setName(titles.get(i));
            doubanList.setRate(ratings.get(i));
          //  System.out.println(doubanList.getName() + " accomplish!");
        }
    }}
