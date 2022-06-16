package com.felixwc.publish.webpage.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;

/**
 * in order to learn java!
 * created at 2022/6/14 23:55
 *
 * @author felixwc
 */
public class BaiduPictureService {

    private String url;

    /**
     * @param keyword
     * @param resultCount
     * @Author felixwc
     * @Description //TODO 向搜索引擎获取图片
     * @Date 01:09 2022/6/15
     **/
    public String[] getByKeyWord(String keyword, int resultCount) throws IOException {
        String addr = "http://image.baidu.com/search/index";
        // https://image.baidu.com/search/index?tn=baiduimage&word=tiger
        HashMap<String, String> paramMap = new HashMap<>(16);
        paramMap.put("tn","baiduimage");
        paramMap.put("word",keyword);
        Connection connect = Jsoup.connect(addr);
        connect.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");

        connect.data(paramMap);
        Document document = connect.get();
        System.out.println(document);
        for (Element img : document.getElementsByTag("img")){
            System.out.println(img.absUrl("src"));
        }


        return null;
    }

    public static void main(String[] args) throws Exception{
        new BaiduPictureService().getByKeyWord("tiger",3);
    }
}
