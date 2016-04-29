package com.xupt.bookshop.common.utils;

import java.util.Random;
import java.util.UUID;

/** 生成商品的随机编码
 * Created by ge.zhang on 16-4-18.
 */
public class UUIDGenerator {
    public UUIDGenerator() {
    }

    public static String getUUID() {
        Random random = new Random();
        int a = random.nextInt(10);
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return temp;
    }
}
