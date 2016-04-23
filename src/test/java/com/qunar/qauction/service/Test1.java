package com.qunar.qauction.service;

import java.util.List;

import javax.annotation.Resource;

import com.qunar.qauction.service.common.ImgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * Created by liuyanjiang on 16-4-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class Test1 {
    @Resource
    ImgService imgService;

    @Test
    public void test() {

        // InputStream stream=Test1.class.getClassLoader().getResourceAsStream("liuyan.jpg");
        // imgService.upLoadImg(stream, UUIDGenerator.getUUID(),"liuyan.jpg");
        List<String> list = imgService.getPictureUrl("501d9f8fd3274aa1a44806c250ef294a");
        int i = 0;
    }
}