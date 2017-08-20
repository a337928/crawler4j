package com.arthur.web.dao.mapper;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.arthur.web.SpringUtil;
import com.arthur.web.bean.HtmlBean;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * Created by wangtao on 2017/7/9.
 */
@Repository
public class HtmlDao {


    private static HtmlMapper htmlMapper;

    public static void insertHtml(HtmlParseData htmlParseData, Page page){
//        HtmlMapper mapper = (HtmlMapper)SpringUtil.getBean("htmlMapper");
//        String text = htmlParseData.getText();
//        String html = htmlParseData.getHtml();
//        Set<WebURL> links = htmlParseData.getOutgoingUrls();

        HtmlBean htmlBean = new HtmlBean();
        htmlBean.setUrl(page.getWebURL().getURL());
        htmlBean.setBody("测试");
        htmlBean.setTitle(htmlParseData.getTitle());
        htmlMapper.insertHtml(htmlBean);
    }

    @Autowired
    public void setHtmlMapper(HtmlMapper htmlMapper) {
        HtmlDao.htmlMapper = htmlMapper;
    }
}
