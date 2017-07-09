package com.arthur.web.crawler;

import org.springframework.stereotype.Service;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * Created by wangtao on 2017/7/9.
 */
@Service
public class Controller {

    public void doController () throws Exception {
        String crawlStorageFolder = "/Users/wangtao/Documents/downWeb";
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);

            /*
             * Instantiate the controller for this crawl.
             */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

            /*
             * For each crawl, you need to add some seed urls. These are the first
             * URLs that are fetched and then the crawler starts following links
             * which are found in these pages
             */
        //        controller.addSeed("http://www.zhihu.com/~lopes/");
        //        controller.addSeed("http://www.zhihu.com/~welling/");
        controller.addSeed("http://sports.sina.com.cn/nba/");

            /*
             * Start the crawl. This is a blocking operation, meaning that your code
             * will reach the line after this only when crawling is finished.
             */
        controller.start(MyCrawler.class, numberOfCrawlers);


    }

}
