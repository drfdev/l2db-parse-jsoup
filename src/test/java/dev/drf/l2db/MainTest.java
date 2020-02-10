package dev.drf.l2db;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void testParser() throws IOException {
        String url = "http://l2db.ru/items/loock/5550/c4";
        Document doc = Jsoup.connect(url).get();

        Elements links = doc.select("article.content > div > table > tbody > tr > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr > td > a[href^=\"/npc/view/\"]");

        assertEquals(18, links.size());
    }
}
