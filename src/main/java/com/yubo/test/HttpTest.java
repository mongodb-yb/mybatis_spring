package com.yubo.test;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yubo
 * @version V1.0
 * @description
 * @date 2020/4/14 14:13
 */
public class HttpTest {
    public static void main(String[] args) {

        // HttpUrlConnection
        String host = "http://localhost:8080/rest/traffic/violationV2?account=test_vigbu&accessToken=d4a8288f611e48c2ac8b6d8dd43da286&carNumber=浙AW78N6&carCode=LSGKE52H9FW058161&carDriveNumber=150805199&cityCode=ZJ_NB";
        try {
            URL url = new URL(host);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int code = httpURLConnection.getResponseCode();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader isr = new InputStreamReader(httpURLConnection.getInputStream(), "utf-8");
                int i = 0;
                String content = "";
                while ((i = isr.read()) != -1) {
                    content = content + (char) i;
                }
                isr.close();
                System.out.println(content);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
