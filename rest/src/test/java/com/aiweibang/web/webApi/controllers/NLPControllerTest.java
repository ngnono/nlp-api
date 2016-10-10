package com.aiweibang.web.webApi.controllers;

import com.aiweibang.web.common.utils.JsonUtils;
import com.aiweibang.web.webApi.BaseControllerTest;
import com.aiweibang.web.webApi.MockUtil;
import com.aiweibang.web.webApi.models.ParticipleModel;
import com.aiweibang.web.webApi.models.ParticipleRequest;
import com.aiweibang.web.common.models.StdResponseData;
import com.fasterxml.jackson.core.type.TypeReference;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import org.mockito.internal.matchers.NotNull;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lianghongpeng on 2016/10/10.
 */
public class NLPControllerTest extends BaseControllerTest {

    /**
     * 基本测试
     *
     * @throws Exception
     */
    @Test
    public void testParticiple() throws Exception {


        ParticipleRequest req = new ParticipleRequest();
        req.setContent("主演吐苦水：岳云鹏被热倒吊威亚空中才凉快\n" +
                "\n" +
                "对于印度的热，主演们纷纷表示有同感。白客“没有想到印度的天气那么热，那时高温50年一遇，听说宝莱坞都不拍戏了，我们还是努力完成。”\n" +
                "\n" +
                "岳云鹏也吐槽说“实在太热了，空气48度，我们都被干倒了，爬在地上都听到'次啦'一声，肉都熟了。导演给我们一人一个房车，房车里20度有空调，一出房车冰火两重天，又享受又痛苦。”“我们为了解暑煮绿豆汤，但印度人不喝，结果中暑的都是印度人”柳岩随之附和到。\n" +
                "\n" +
                "不过第一次吊威亚的小岳岳说只有在空中才凉快，都不觉得绳勒了。\n" +
                "\n" +
                "主创花式夸宝强：胜过科班导演，中国梦最好的体现\n" +
                "\n" +
                "虽然抱怨印度天气，但主演们对导演王宝强都是一片赞美。白客表示王宝强精力旺盛，白天拍戏，晚上盯片子，还能三四点起来晨练。岳云鹏也称导演要求高，爆料有场戏拍了30条。“我问导演你不怕浪费胶卷吗？结果宝强说早就不用胶卷了。”\n" +
                "\n" +
                "此外，光线总裁王长田现场盛赞王宝强，称其为中国电影而生，中国梦最好的体现。“我看过粗剪版，比很多科班导演的片子都强，现在在跟王宝强探讨下部电影的合作”。");

        req.setAnalyzer("nlp");
        List<String> filtering = new ArrayList<>();
        filtering.add("removeHtmlTag");
        req.setFiltering(filtering);

        List<String> filtered = new ArrayList<>();
        filtered.add("termNatures-w");
        filtered.add("termNatures-null");
        req.setFiltered(filtered);

        req.setHasTf(true);


        String json = JsonUtils.to(req);

        MockUtil.build(mockMvc, "/api/nlp/participle", json)
                .andDo(print())

                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))

                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data", NotNull.NOT_NULL));

    }

    /**
     * TOP 测试
     *
     * @throws Exception
     */
    @Test
    public void testParticiple4Top() throws Exception {

        ParticipleRequest req = new ParticipleRequest();
        req.setContent("主演吐苦水：岳云鹏被热倒吊威亚空中才凉快\n" +
                "\n" +
                "对于印度的热，主演们纷纷表示有同感。白客“没有想到印度的天气那么热，那时高温50年一遇，听说宝莱坞都不拍戏了，我们还是努力完成。”\n" +
                "\n" +
                "岳云鹏也吐槽说“实在太热了，空气48度，我们都被干倒了，爬在地上都听到'次啦'一声，肉都熟了。导演给我们一人一个房车，房车里20度有空调，一出房车冰火两重天，又享受又痛苦。”“我们为了解暑煮绿豆汤，但印度人不喝，结果中暑的都是印度人”柳岩随之附和到。\n" +
                "\n" +
                "不过第一次吊威亚的小岳岳说只有在空中才凉快，都不觉得绳勒了。\n" +
                "\n" +
                "主创花式夸宝强：胜过科班导演，中国梦最好的体现\n" +
                "\n" +
                "虽然抱怨印度天气，但主演们对导演王宝强都是一片赞美。白客表示王宝强精力旺盛，白天拍戏，晚上盯片子，还能三四点起来晨练。岳云鹏也称导演要求高，爆料有场戏拍了30条。“我问导演你不怕浪费胶卷吗？结果宝强说早就不用胶卷了。”\n" +
                "\n" +
                "此外，光线总裁王长田现场盛赞王宝强，称其为中国电影而生，中国梦最好的体现。“我看过粗剪版，比很多科班导演的片子都强，现在在跟王宝强探讨下部电影的合作”。");

        req.setAnalyzer("nlp");
        List<String> filtering = new ArrayList<>();
        filtering.add("removeHtmlTag");
        req.setFiltering(filtering);

        List<String> filtered = new ArrayList<>();
        filtered.add("termNatures-w");
        filtered.add("termNatures-null");
        req.setFiltered(filtered);

        req.setHasTf(true);

        boolean isAsc = false;

        int take = 50;
        req.setOrderBy(isAsc ? 1 : 2);
        req.setTake(take);


        String json = JsonUtils.to(req);

        String content = MockUtil.build(mockMvc, "/api/nlp/participle", json)
                .andDo(print())

                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))

                .andExpect(jsonPath("$.status", is(true)))
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.data", NotNull.NOT_NULL))
                .andReturn().getResponse().getContentAsString();
        //.andExpect(jsonPath("$.data[11]", IsInstanceOf.instanceOf(Exception.class)))

        System.out.println("****************************************************");
        System.out.println(content);
        System.out.println("****************************************************");

        StdResponseData<ArrayList<ParticipleModel>> obj = JsonUtils.from(content, new TypeReference<StdResponseData<ArrayList<ParticipleModel>>>() {
        });

        ArrayList<ParticipleModel> data = obj.getData();

        org.junit.Assert.assertEquals(data.size(), take);

        ParticipleModel p0 = data.get(0);
        ParticipleModel p9 = data.get(data.size() - 1);

//        org.junit.Assert.assertEquals(p0.getTf(), p9.getTf());

        org.junit.Assert.assertEquals(p0.getTf() <= p9.getTf(), isAsc);
    }
}
