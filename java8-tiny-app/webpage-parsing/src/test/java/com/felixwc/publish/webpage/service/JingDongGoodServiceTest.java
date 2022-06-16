package com.felixwc.publish.webpage.service;

import com.felixwc.publish.webpage.jingdong.JingDongGoodService;
import org.junit.Test;

import java.util.List;

public class JingDongGoodServiceTest {

    @Test
    public void goods() {
        try {
            for(int i=1;i<10;i++){
                List<JingDongGoodService.Good> javaBook = JingDongGoodService.goods("java",i);
                for (JingDongGoodService.Good good : javaBook) {
                    System.out.println(good);
                }
                System.out.println(javaBook.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}