package com.nowcoder.spider.service.spider.pipeline;

import com.nowcoder.spider.model.DoubanList;
import com.nowcoder.spider.dao.bookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class bookPipeline implements Pipeline {
    private static final Logger LOGGER = LoggerFactory.getLogger(bookPipeline.class);
    @Autowired
    private bookMapper bookMapper;
    @Override
    public void process(ResultItems resultItems, Task task) {
        ArrayList<String> str=new ArrayList<>();
        for(String n:resultItems.getAll().keySet()) {

           str = (ArrayList<String>) resultItems.getAll().get(n);
           String rate = resultItems.get("rate");

       }
           for(int i=0;i<str.size();i++) {
               DoubanList doubanList = new DoubanList();
               String name=str.get(i);
               if(name!=null)
               doubanList.setName(name);
               else break;
               doubanList.setRate("0");
               try {
                   boolean success = bookMapper.addBook(doubanList) > 0;
                   LOGGER.info("保存知乎文章成功：{}", name);
               } catch (Exception ex) {
                   LOGGER.error("保存知乎文章失败", ex);
               }
           }
    }
}
