package com.yubo.test;


import com.yubo.interceptor.OKHttpInterceptor;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/14 14:51
 */
public class OKHttp3Test {
    public static void main(String[] args) {
//        String url = "https://test.tianxingshuke.com/api/rest/police/identity?account=test_y8k5z&accessToken=4b36fadec4b74705a662e508a89431db&name=陈为&idCard=460003199010055212&mockType=SAME";
//        // 创建OKHttpClient对象
//        OkHttpClient okHttpClient = new OkHttpClient();
//        // 创建Request对象,设置url，请求方式(默认为get请求，可以不写)
//        Request request = new Request.Builder().url(url).get().build();
//        // 创建一个call对象，参数为request对象
//        Call call = okHttpClient.newCall(request);
//        // call异步调用请求，返回Response对象
//        call.enqueue(new Callback() {
//            @Override
//            // 请求失败执行的方法
//            public void onFailure(Call call, IOException e) {
//            }
//
//            @Override
//            // 请求成功执行的方法
//            public void onResponse(Call call, Response response) throws IOException {
//                // 获取请求相应的状态码
//                int code = response.code();
//                System.out.println(code);
//                // 获得响应的数据
//                String body = response.body().string();
//                System.out.println(body);
//            }
//        });


//         post

//        String url = "https://test.tianxingshuke.com/api/rest/common/organization/auth?account=test_y8k5z&signature=02f2148344c24de5b846219166d26d6c";
//        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        //String json = "{\"account\":\"test_y8k5z\",\"signature\":\"02f2148344c24de5b846219166d26d6c\"}";
        //RequestBody requestBody = RequestBody.create(json, mediaType);
        // post调用---- get的rul形式
        // 注意：如果是com.squareup.okhttp 则为RequestBody formBody = new FormEncodingBuilder().build();
//        RequestBody requestBody = new FormBody.Builder().build();
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder().url(url).post(requestBody).build();
//        Call call = okHttpClient.newCall(request);
//        // 异步post请求
//        call.enqueue(new Callback() {
//            @Override
//            // 访问失败的执行方法
//            public void onFailure(Call call, IOException e) {
//            }
//
//            @Override
//            // 访问成功的执行方法
//            public void onResponse(Call call, Response response) throws IOException {
//                int code = response.code();
//                System.out.println(code);
//                String content = response.body().string();
//                System.out.println(content);
//            }
//        });


        // OKHttp高级特性--流的形式处理相应数据量大的情况
        // 下载文件--下载图片保存到本地
//        String url = "http://a3.att.hudong.com/14/75/01300000164186121366756803686.jpg";
//        File file = new File("C:\\Users\\Administrator\\Desktop\\fast", "tmp.jpg");
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url(url).get().build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    InputStream is = response.body().byteStream();
//                    OutputStream os = new FileOutputStream(file);
//                    int b = 0;
//                    while ((b = is.read()) != -1) {
//                        os.write(b);
//                    }
//                    os.close();
//                }
//            }
//        });


        // 以流的形式上传一张图片
//        File photo = new File("C:\\Users\\Administrator\\Desktop\\fast", "1.png");
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//        // 定义数据类型
//        // 常见的类型 https://tool.oschina.net/commons
//        // 传递各种类型的图片 image/*
//        // application/octet-stream可以传递各种类型的文件
//        MediaType mediaType = MediaType.parse("application/octet-stream");
//        // 创建代表文件的实体
//        RequestBody fileBody = RequestBody.create(mediaType, photo);
//        // 创建表单实体，并将文件放入到表单实体中
//        FormBody.Builder builder = new FormBody.Builder();
//        RequestBody requestBody = new MultipartBody.Builder()
//                // 设置表单类型
//                .setType(MultipartBody.FORM)
//                // add方法都一样，都需要一个后台参数名、文件名和文件实体
//                // addPart  addFormDataPart
//                .addFormDataPart("multipartFile", "1.png", fileBody)
//                .build();
//        // 创建Request对象，post的形式发送文件到服务器
//        String url = "http://localhost:8080/rest/file/upTo";
//        Request request = new Request.Builder().url(url).post(requestBody).build();
//        Call call = client.newCall(request);
//        try {
//            Response response = call.execute();
//            System.out.println(response.body().string());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String url = "https://test.tianxingshuke.com/api/rest/police/identity?account=test_y8k5z&accessToken=c393f9cd6a1f4090b04e0fb358c25077&name=陈为&idCard=460003199010055212&mockType=SAME";
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new OKHttpInterceptor()).build();
        Request request = new Request.Builder().addHeader("name", "bobo").url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println(response.body().string());
                }
            }
        });
    }
}
