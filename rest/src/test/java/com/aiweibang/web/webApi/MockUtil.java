package com.aiweibang.web.webApi;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by lianghongpeng on 2016/10/10.
 */
public class MockUtil {


    /**
     * build actions
     *
     * @param uri
     * @param json
     * @return
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    public static ResultActions build(MockMvc mvc, String uri, String json)
            throws UnsupportedEncodingException, Exception {

        return mvc
                .perform(
                        post(uri, "json").characterEncoding("UTF-8")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json));
    }

    /**
     * getContentAsString
     *
     * @param uri
     * @param json
     * @return
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    public static String getContentAsString(MockMvc mvc, String uri, String json)
            throws UnsupportedEncodingException, Exception {
        return build(mvc, uri, json).andReturn()
                .getResponse().getContentAsString();
    }

}