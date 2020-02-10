package dev.drf.l2db;

import dev.drf.l2db.conf.Resource;
import dev.drf.l2db.data.ResultData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final int ATTEMPTS = 3;
    private static final int TIME_TO_SLEEP = 500;

    public static void main(String[] args) throws IOException {
        System.out.println("start");

        final int size = Resource.values().length;
        final int cores = Runtime.getRuntime().availableProcessors();

        Map<Resource, ResultData> parseData = new ConcurrentHashMap<>(size);
        ExecutorService pool = Executors.newFixedThreadPool(cores);
        CountDownLatch latch = new CountDownLatch(size);

        for (Resource r : Resource.values()) {
            pool.execute(() -> {
                String url = r.getUrl();

                ResultData resultData = parseUrl(url);

                parseData.put(r, resultData);
                latch.countDown();
            });
        }

        pool.shutdown();
        try {
            latch.await();
        } catch (InterruptedException ex) {
            log.error("Await error: ", ex);
        }

        long failedCount = parseData.values().stream()
                .filter(ResultData::isFailed)
                .count();
        if (failedCount > 0) {
            System.out.println("Failed: " + failedCount);
        } else {
            System.out.println("All done");
        }

        System.out.println("end");
    }

    private static ResultData parseUrl(String url) {
        ResultData resultData = new ResultData();
        int attempt = ATTEMPTS;
        boolean done = false;

        while (!done || attempt > 0) {
            try {
                Document doc = Jsoup.connect(url).get();

                // TODO
                done = true;
                resultData.notFailed();
            } catch (IOException e) {
                log.error("Get error {} from {}, reconnect...", e.getMessage(), url);
            }
            attempt --;
            if (!done) {
                try {
                    Thread.sleep(TIME_TO_SLEEP);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    attempt = -1;
                }
            }
        }
        if (resultData.isFailed()) {
            log.error("Failed {}", url);
        }
        return resultData;
    }
}
