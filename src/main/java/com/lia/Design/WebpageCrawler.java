package com.lia.Design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by liqu on 10/29/16.
 */
public class WebpageCrawler {
    private int thread_num = 5;
    /**
     * @param url a url of root page
     * @return all urls
     */
    public List<String> crawler(String url) {
        final Set<String> crawled = new CopyOnWriteArraySet<>();
        final ExecutorService service = Executors.newFixedThreadPool(thread_num);
        service.execute(new Crawler(url, service, crawled));

        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            //
        }

        service.shutdown();
        return new ArrayList<>(crawled);
    }
}
