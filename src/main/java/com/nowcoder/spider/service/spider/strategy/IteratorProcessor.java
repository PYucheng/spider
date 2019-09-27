package com.nowcoder.spider.service.spider.strategy;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;

/**
 * IteratorProcessor Description: CreateDate: 2018/8/15
 *
 * @author nowcoder
 */

/**
 * 装饰者，用来装饰book的迭代爬取功能
 */
public class IteratorProcessor extends FilterProcessor {

  private Set<String> requestCache = new HashSet<>(32);

  public IteratorProcessor() {
    super(new DoubanProcessor());
  }

  public IteratorProcessor(DoubanProcessor processStrategy) {
    super(processStrategy);
  }

  @Override
  public void doProcess(Page page) {
    if (StringUtils.startsWith(page.getRequest().getUrl(), "https://www.douban.com/doulist/110879547/")) {
      //requestCache.addAll(page.getHtml().regex("https://www.douban.com/doulist/110879547/?start=[0-9]+&sort=seq&playable=0&sub_type=").all());
      for(int i=0;i<=250;i+=25)
        requestCache.add("https://www.douban.com/doulist/110879547/?start="+i+"&sort=seq&playable=0&sub_type=");
      page.addTargetRequests(new ArrayList<>(requestCache));
      processStrategy.doProcess(page);
      requestCache.clear();
      //page.setSkip(true);
    } else {
      processStrategy.doProcess(page);
    }
  }
}
