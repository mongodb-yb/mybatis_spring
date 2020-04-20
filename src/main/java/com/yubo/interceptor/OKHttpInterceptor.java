package com.yubo.interceptor;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * @author yubo
 * @version V1.0
 * @description OKHttp的拦截器
 * @date 2020/4/15 14:40
 */
public class OKHttpInterceptor implements Interceptor {
    private static final Logger log = Logger.getLogger(OKHttpInterceptor.class);

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request originalRequest = chain.request();
        // 当请求体为null时，我们不用进行gzip
        // 如果请求体不为null，则判断header中的Content-Encoding是采用的哪种编码格式进行数据传输
        if (originalRequest.body() == null || originalRequest.header("Content-Encoding") != null) {
            return chain.proceed(originalRequest);
        }
        // 建立一个新的请求体，采用gzip编码格式，数据压缩后进行传输
        Request compressedRequest = originalRequest.newBuilder()
                .header("Content-Encoding", "gzip")
                .method(originalRequest.method(), gzip(originalRequest.body()))
                .build();
        return chain.proceed(compressedRequest);
    }
    /**
     * 压缩请求体数据
     *
     * @param body 原始请求体数据
     * @return
     */
    private RequestBody gzip(final RequestBody body) {
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return body.contentType();
            }

            @Override
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                // 将原始body的数据进行压缩
                BufferedSink gzipSink = Okio.buffer(new GzipSink(bufferedSink));
                // gzip将原始的请求体数据进行覆盖
                body.writeTo(gzipSink);
            }
        };
    }
}
