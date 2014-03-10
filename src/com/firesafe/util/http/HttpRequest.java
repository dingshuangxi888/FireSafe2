/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firesafe.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author 双喜
 */
public class HttpRequest {

    private String defaultContentEncoding;
    private int timeout;

    public HttpRequest() {
        this.defaultContentEncoding = Charset.defaultCharset().name();
        this.timeout = 0;
    }

    public HttpRequest(int timeout) {
        this.defaultContentEncoding = Charset.defaultCharset().name();
        this.timeout = timeout;
    }

    public HttpResponse sendGet(String urlString) throws IOException {
        return this.send(urlString, "GET", "", null);
    }

    public HttpResponse sendGet(String urlString, Map<String, String> params) throws IOException {
        return this.send(urlString, "GET", params, null);
    }

    public HttpResponse sendGet(String urlString, Map<String, String> params, Map<String, String> propertys) throws IOException {
        return this.send(urlString, "GET", params, propertys);
    }

    public HttpResponse sendPost(String urlString) throws IOException {
        return this.send(urlString, "POST", "", null);
    }

    public HttpResponse sendPost(String urlString, Map<String, String> params) throws IOException {
        return this.send(urlString, "POST", params, null);
    }

    public HttpResponse sendPost(String urlString, String param) throws IOException {
        return this.send(urlString, "POST", param, null);
    }

    public HttpResponse sendPost(String urlString, Map<String, String> params, Map<String, String> propertys) throws IOException {
        return this.send(urlString, "POST", params, propertys);
    }

    public HttpResponse sendPost(String urlString, String param, Map<String, String> propertys) throws IOException {
        return this.send(urlString, "POST", param, propertys);
    }

    private HttpResponse send(String urlString, String method, String parameter, Map<String, String> propertys) throws IOException {
        HttpURLConnection urlConnection = null;
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod(method);
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setUseCaches(false);
        if (timeout != 0) {
            urlConnection.setConnectTimeout(timeout);
        }

        if (propertys != null) {
            for (String key : propertys.keySet()) {
                urlConnection.addRequestProperty(key, propertys.get(key));
            }
        }

        if ("POST".equalsIgnoreCase(method) && !"".equals(parameter)) {
            urlConnection.getOutputStream().write(parameter.getBytes());
            urlConnection.getOutputStream().flush();
            urlConnection.getOutputStream().close();
        }
        return this.makeContent(urlString, urlConnection);
    }

    private HttpResponse send(String urlString, String method, Map<String, String> parameters, Map<String, String> propertys) throws IOException {
        StringBuilder param = new StringBuilder();
        if ("GET".equalsIgnoreCase(method) && parameters != null) {

            int i = 0;
            for (String key : parameters.keySet()) {
                if (i == 0) {
                    param.append("?");
                } else {
                    param.append("&");
                    param.append(key).append("=").append(parameters.get(key));
                    i++;
                }
            }
            urlString += param;
        }

        if ("POST".equalsIgnoreCase(method) && parameters != null) {
            for (String key : parameters.keySet()) {
                param.append("&");
                param.append(key).append("=").append(parameters.get(key));
            }
        }
        return this.send(urlString, "POST", param.toString(), propertys);
    }

    private HttpResponse makeContent(String urlString, HttpURLConnection urlConnection) throws IOException {
        HttpResponse httpResponse = new HttpResponse();
        InputStream in = null;
        try {
            in = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            httpResponse.contentCollection = new Vector<String>();
            StringBuilder temp = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                httpResponse.contentCollection.add(line);
                temp.append(line).append("\r\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            String encode = urlConnection.getContentEncoding();
            if (encode == null) {
                encode = this.defaultContentEncoding;
            }

            httpResponse.urlString = urlString;

            httpResponse.defaultPort = urlConnection.getURL().getDefaultPort();
            httpResponse.file = urlConnection.getURL().getFile();
            httpResponse.host = urlConnection.getURL().getHost();
            httpResponse.port = urlConnection.getURL().getPort();
            httpResponse.path = urlConnection.getURL().getPath();
            httpResponse.protocol = urlConnection.getURL().getProtocol();
            httpResponse.query = urlConnection.getURL().getQuery();
            httpResponse.ref = urlConnection.getURL().getRef();
            httpResponse.userInfo = urlConnection.getURL().getUserInfo();

            httpResponse.content = new String(temp.toString().getBytes(), encode);
            httpResponse.contentEncoding = encode;
            httpResponse.code = urlConnection.getResponseCode();
            httpResponse.message = urlConnection.getResponseMessage();
            httpResponse.contentType = urlConnection.getContentType();
            httpResponse.method = urlConnection.getRequestMethod();
            httpResponse.connectTimeout = urlConnection.getConnectTimeout();
            httpResponse.readTimeout = urlConnection.getReadTimeout();

            return httpResponse;
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    public String getDefaultContentEncoding() {
        return defaultContentEncoding;
    }

    public void setDefaultContentEncoding(String defaultContentEncoding) {
        this.defaultContentEncoding = defaultContentEncoding;
    }
}
