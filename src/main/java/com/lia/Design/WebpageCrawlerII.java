package com.lia.Design;

import java.util.*;

/**
 * Created by liqu on 10/29/16.
 */
public class WebpageCrawlerII {
    /**
     * @param url a url of root page
     * @return all urls
     */
    public List<String> crawler(String url) {
        // Write your code here
        int thread_num = 7;
        CrawlerThreadII.setFirstUrl(url, thread_num);

        CrawlerThreadII[] thread_pools = new CrawlerThreadII[thread_num];
        for (int i = 0; i < thread_num; ++i) {
            thread_pools[i] = new CrawlerThreadII();
            thread_pools[i].start();
        }

        while (CrawlerThreadII.getCounter() > 0);

        for (int i = 0; i < thread_num; ++i) {
            thread_pools[i].stop();
        }

        return CrawlerThreadII.getResult();
    }
}
