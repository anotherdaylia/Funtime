package com.lia.Design;

import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;


/**
 * Created by liqu on 10/29/16.
 */
public class Crawler implements Runnable {
    private final String url;
    private final Set<String> crawled;
    private final ExecutorService service;
    private static String DOM = "wikipedia.org";


    public Crawler(String url, ExecutorService service, Set<String> crawled) {
        this.url = url;
        this.crawled = crawled;
        this.service = service;
    }

    @Override
    public void run() {
        if (shouldCrawl(url)) {
            crawled.add(url);
            for (String nextUrl : HtmlParser.parseUrls(url)) {
                service.execute(new Crawler(nextUrl, service, crawled));
            }
        }
    }

    private boolean shouldCrawl(String url) {
        try {
            if (!crawled.contains(url) && new URL(url).getHost().endsWith(DOM)) {
                return true;
            }
        } catch (MalformedURLException e) {
            return false;
        }
        return false;
    }

}