package dev.drf.l2db;

import dev.drf.l2db.conf.Resource;
import dev.drf.l2db.data.ResultData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("start");

        final int size = Resource.values().length;
        Map<Resource, ResultData> parseData = new ConcurrentHashMap<>(size);
        Executor pool = Executors.newFixedThreadPool(size);

        for (Resource r : Resource.values()) {
            pool.execute(() -> {
                String url = r.getUrl();
                ResultData resultData = new ResultData();
                try {
                    Document doc = Jsoup.connect(url).get();

                    // TODO
                } catch (IOException e) {
                    e.printStackTrace();
                }
                parseData.put(r, resultData);
            });
        }

        System.out.println("end");
    }
}
