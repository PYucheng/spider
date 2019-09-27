package com.nowcoder.spider.service;

import com.nowcoder.spider.model.DoubanList;
import com.nowcoder.spider.model.OriginBook;
import com.nowcoder.spider.service.spider.DefaultSpider;
import com.nowcoder.spider.service.spider.observers.ObserverA;
import com.nowcoder.spider.service.spider.observers.ObserverB;
import com.nowcoder.spider.service.spider.pipeline.CallablePipeline;
import com.nowcoder.spider.service.spider.pipeline.bookPipeline;
import com.nowcoder.spider.service.spider.strategy.DoubanProcessor;
import com.nowcoder.spider.service.spider.strategy.IteratorProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nowcoder on 2018/08/16 下午5:23
 */
@Service
public class SpiderService {

  @Autowired
  private DefaultSpider defaultSpider;

  @Autowired
  private CallablePipeline pipeline;

  @Autowired
  private bookPipeline bookPipeline;

  public void getLotsOfBooks(String beginUrl) {
    try {

     // pipeline.addObserver(new ObserverA());
      //pipeline.addObserver(new ObserverB());
      defaultSpider.setProcessStrategy(new IteratorProcessor(new DoubanProcessor()));
      defaultSpider.getSpider()
          .addUrl(beginUrl)
          .addPipeline(bookPipeline)
          .thread(2)
          .run();
     // OriginBook book = (OriginBook) pipeline.getResult();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
