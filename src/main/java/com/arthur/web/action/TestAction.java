package com.arthur.web.action;

import org.bouncycastle.eac.EACException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.arthur.web.crawler.Controller;
import com.arthur.web.crawler.MyCrawler;
import com.arthur.web.dao.mapper.HtmlMapper;
import com.arthur.web.bean.HtmlBean;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Created by wangtao on 2017/7/9.
 */
@RestController
public class TestAction {
    @Autowired
    private HtmlMapper htmlMapper;
    @Autowired
    private Controller controller;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        HtmlBean htmlBean = new HtmlBean();
        htmlBean.setUrl("wwww.163.com");
        htmlBean.setBody("123");
        htmlBean.setKeyword("123");
        htmlBean.setTitle("123");
        htmlMapper.insertHtml(htmlBean);
        return "ok";
    }

    @RequestMapping("/crawler")
    @ResponseBody
    public String crawler() throws Exception {
        controller.doController();
        return  "crawler";
    }
}
