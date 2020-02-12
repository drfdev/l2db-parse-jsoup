package dev.drf.l2db;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private static final String SELECTOR = "article.content > div > table > tbody > tr > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr > td > a[href^=\"/npc/view/\"]";
    private static final String PREFIX = "http://l2db.ru";

    @Test
    public void testParser() throws IOException {
        String url = "http://l2db.ru/items/loock/5550/c4";
        Document doc = Jsoup.connect(url).get();

        Elements links = doc.select(SELECTOR);

        assertEquals(18, links.size());
    }

    @Test
    public void loadFirstSpoilTest() throws IOException {
        String url = "http://l2db.ru/items/loock/5550/c4";
        Document doc = Jsoup.connect(url).get();

        Elements links = doc.select(SELECTOR);

        Element el = links.get(0);
        Elements hrefs = el.getElementsByAttribute("href");
        String hrefValue = hrefs.attr("href");

        Document spoilMob = Jsoup.connect(PREFIX + hrefValue).get();

        assertEquals("http://l2db.ru/npc/view/829/c4/", spoilMob.baseUri());
    }
}
