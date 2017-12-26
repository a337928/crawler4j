package com.arthur.web.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.arthur.web.bean.HtmlBean;

/**
 * Created by wangtao on 2017/7/9.
 */
@Mapper
public interface HtmlMapper {
    @Insert(" insert into crawler4j_html (url,title,body,keyword) " +
            " values (#{url},#{title},#{body},#{keyword}) ")
     int insertHtml(HtmlBean htmlBean);


}
