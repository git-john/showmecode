package com.john.showmecode.logback;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: kangq
 * @Date: 2019/7/4 16:19
 */
public class MyRequestWrapper extends HttpServletRequestWrapper {

    private final Map<String, String> customHeaders;

    public MyRequestWrapper(HttpServletRequest request) {
        super(request);
        this.customHeaders = new HashMap<String, String>();
    }

    public void putHeader(String name, String value){
        this.customHeaders.put(name, value);
    }


    @Override
    public String getHeader(String name) {
        String headerValue = customHeaders.get(name);

        if (headerValue != null){
            return headerValue;
        }
        // else return from into the original wrapped object
        return ((HttpServletRequest) getRequest()).getHeader(name);
    }

}
