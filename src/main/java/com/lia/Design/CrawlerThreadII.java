package com.lia.Design;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.lang.Thread;
import java.net.*;

/**
 * Created by liqu on 10/29/16.
 */
class CrawlerThreadII extends Thread {
    private static AtomicLong counter;
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private static Set<String> set = new HashSet<>();
    private static List<String> result = new ArrayList<>();

    public static void setFirstUrl(String url, int thread_num) {
        counter = new AtomicLong(thread_num);
        try {
            queue.put(url);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }

    public static Long getCounter() {
        return counter.get();
    }

    public static List<String> getResult() {
        return result;
    }

    @Override
    public void run() {
        while (true) {

            String url = "";
            try {
                counter.decrementAndGet();
                url = queue.take();
                counter.incrementAndGet();
            } catch (Exception e) {
                break;
            }

            String domain = "";
            try {
                URL netURL = new URL(url);
                domain = netURL.getHost();
            } catch (MalformedURLException e) {
                //e.printStackTrace();
            }

            if (!set.contains(url) && domain.endsWith("wikipedia.org")) {
                set.add(url);
                result.add(url);
                List<String> urls = HtmlParser.parseUrls(url);
                for (String u : urls) {
                    try {
                        queue.put(u);
                    } catch (InterruptedException e) {
                        // e.printStackTrace();
                    }
                }
            }
        }
    }
}
