package br.com.south.system.utils;

import org.springframework.http.HttpHeaders;

public class HTTPUtils {

    public static HttpHeaders generateHttpHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "header");
        return headers;
    }
}
