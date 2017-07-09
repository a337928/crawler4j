package com.arthur.web.dao.mapper;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arthur.web.SpringUtil;
import com.arthur.web.bean.HtmlBean;

import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * Created by wangtao on 2017/7/9.
 */
@Repository
public class HtmlDao {

//    @Autowired
//    private static HtmlMapper htmlMapper;

    public static void insertHtml(HtmlParseData htmlParseData){
        HtmlMapper htmlMapper = (HtmlMapper)SpringUtil.getBean("htmlMapper");
        String text = htmlParseData.getText();
        String html = htmlParseData.getHtml();
        Set<WebURL> links = htmlParseData.getOutgoingUrls();

        HtmlBean htmlBean = new HtmlBean();
        //htmlBean.setUrl(links.toString());
        htmlBean.setBody("123");
        //htmlBean.setKeyword(htmlParseData.get);
        htmlBean.setTitle(htmlParseData.getTitle());
        htmlMapper.insertHtml(htmlBean);
    }
}
