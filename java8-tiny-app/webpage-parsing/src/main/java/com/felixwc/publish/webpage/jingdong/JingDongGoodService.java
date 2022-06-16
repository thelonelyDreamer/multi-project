package com.felixwc.publish.webpage.jingdong;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * in order to learn java!
 * created at 2022/6/15 10:01
 *
 * @author felixwc
 */
@Slf4j
public class JingDongGoodService {

    public static List<Good> goods(String keyword,int page) {
        List<Good> goods =null;
        try {
            URL url = new URL("https://search.jd.com/Search?keyword=" + keyword+"&page="+page);
            Document document = Jsoup.parse(url, 3000);
            goods = getGoods(document);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return goods;
    }


    /**
     * @param document - dom 文档
     * @return 商品列表
     * @Author felixwc
     * @Description //TODO 解析dom 文档
     * @Date 11:25 2022/6/15
     **/
    public static List<Good> getGoods(Document document) {
        LinkedList<Good> goods = new LinkedList<>();
        Element jGoodsList = document.getElementById("J_goodsList");

        Elements goodItems = jGoodsList.getElementsByTag("li");
        for (Element goodItem : goodItems) {
            try {
                String imgUrl = goodItem.getElementsByTag("img")
                        .eq(0)
                        .attr("data-lazy-img");
                String price = goodItem.getElementsByClass("p-price").eq(0).text();
                String titles = goodItem.getElementsByClass("p-name").get(0)
                        .getElementsByTag("em").get(0).text();
                Optional<String> first = Arrays.stream(titles.split(" ")).findFirst();
                Good good = new Good().setTitle(first.orElse(""))
                        .setPrice(price)
                        .setUrlImg(imgUrl);
                goods.add(good);
            } catch (Exception e) {
                log.info(e.getMessage());
            }

        }
        return goods;
    }

    /**
     * @Author felixwc
     * @Description //TODO 记录商品信息的实体类
     * @Date 10:41 2022/6/15
     **/
    @Data
    @Accessors(chain = true)
    public static class Good {
        private String urlImg;
        private String price;
        private String title;
    }
}
