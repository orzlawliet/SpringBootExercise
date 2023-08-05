package com.lawliet.web.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * @author Lawliet
 * @Description
 * @create 2023-07-23 下午 02:59
 */
public class MyYamlHttpMessageConverters extends AbstractHttpMessageConverter<Object> {

    private ObjectMapper objectMapper = null; //把對象轉成yaml
    public MyYamlHttpMessageConverters(){
        //告訴SpringBoot這個MessageConverter支持哪種媒體類型  //媒體類型
        super(new MediaType("text","yaml", Charset.forName("UTF-8")));

        YAMLFactory fctory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        this.objectMapper = new ObjectMapper(fctory);

    }

    @Override
    protected boolean supports(Class<?> clazz) {
        //只要是對象類型，不是基本類型
        return true;
    }

    @Override //@RequestBody
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override //@ResponseBody //把對象寫出去
    protected void writeInternal(Object methodReturnValue, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //try-with寫法，自動關流
        try(OutputStream os = outputMessage.getBody()){
            this.objectMapper.writeValue(os,methodReturnValue);
        }

    }
}
