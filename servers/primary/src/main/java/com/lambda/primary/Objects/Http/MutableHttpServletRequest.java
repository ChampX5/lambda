package com.lambda.primary.Objects.Http;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.apache.catalina.LifecycleState;

import java.util.*;

public class MutableHttpServletRequest extends HttpServletRequestWrapper {

    private final Map<String, String> customHeaders;
    public MutableHttpServletRequest(HttpServletRequest request) {
        super(request);
        customHeaders = new HashMap<>();
    }

    public void setHeader(String key, String value){
        customHeaders.put(key, value);
    }


    public String getHeaderObject(String name) {
        String header = customHeaders.get(name);

        if(!Objects.isNull(header)){
            return header;
        }

        return super.getHeader(name);
    }


    @Override
    public String getHeader(String name) {
        try{
            String  header = customHeaders.get(name);

            if(header!=null){
                return header;
            }
        }catch (Exception ignore){}

        return super.getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        Set<String> headerNames = customHeaders.keySet();
        List<String> headerList = new ArrayList<>(headerNames);

        Enumeration<String> headerEnumeration = super.getHeaderNames();

        while(headerEnumeration.hasMoreElements()){
            headerList.add(headerEnumeration.nextElement());
        }

        return Collections.enumeration(headerList);

    }

    @Override
    public int getIntHeader(String name) {

        Integer headerInt;

        try{
            headerInt = Integer.parseInt(customHeaders.get(name));
        }catch (Exception ignore){
            return super.getIntHeader(name);
        }
        if (headerInt!=null){
            return headerInt;
        }

        return super.getIntHeader(name);
    }
}
