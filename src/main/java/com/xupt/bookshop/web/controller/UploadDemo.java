package com.xupt.bookshop.web.controller;

import com.google.common.collect.Lists;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangge on 16-4-28.
 */
public class UploadDemo {



    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "y5o4ohv3iRU6H0ha3BxqGllu-Au7YkzeyV5Z-4Q8";
    String SECRET_KEY = "wGD6J1UGgAqlodPEibUqtrbwPMwzyG9wGrOhTA0K";
    //要上传的空间
    String bucketname = "zhangge";
    //上传到七牛后保存的文件名

    //上传文件的路径
    List<String> FilePaths= Lists.newArrayList();



    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    UploadManager uploadManager = new UploadManager();

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException{
        try {
            FilePaths.add("/home/zhangge/图片/2.jpg");
            FilePaths.add("/home/zhangge/图片/1.jpg");

            //调用put方法上传
            Response res = null;
            for(String str:FilePaths) {
                String key = str;
                 res = uploadManager.put(str, key, getUpToken());
            }
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    public static void main(String args[]) throws IOException {
        new UploadDemo().upload();
    }





}
