package com.kdda.multiThreads.debug;


import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 核心频道VO
 */
@Data
@NoArgsConstructor
public class FirstScreenCoreChannelVO implements Serializable {
    /**
     * 广告标题
     */
    private String title;

    /**
     * 频道类型
     */
    private String channelType;
    /**
     * 广告图片
     */
    private String titleImgUrl;

    /**
     * 广告背景图片（百亿补贴）
     */
    private String titleBgImg;
    /**
     * 标语
     */
    private String slogan;
    /**
     * 标语文案颜色
     */
    private String sloganColor;

    /**
     * 跳转链接
     */
    private String link;
    /**
     * 扩展属性
     */
    private Map<String, Object> extMap = new HashMap<String, Object>();

    /**
     * 是否兜底数据
     */
    private boolean useBack;

    /**
     * 频道招手
     */
    private String iconUrl;


    public static void main(String[] args) {
        List<FirstScreenCoreChannelVO> firstScreenCoreChannelVOS = JSONArray.parseArray("[\n" +
                "    {\n" +
                "        \"title\": \"百亿补贴\",\n" +
                "        \"titleImg\": \"广告图片\",\n" +
                "        \"link\": \"跳转链接\",\n" +
                "        \"titleBgImg\": \"广告背景图片（百亿补贴才有）\",\n" +
                "        \"slogan\": \"利益点\",\n" +
                "        \"sloganColor\": \"利益点颜色\",\n" +
                "        \"flexibleDataList\": [\n" +
                "            {\n" +
                "                \"img\": \"图片1\",\n" +
                "                \"link\": \"跳转链接1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"img\": \"图片2\",\n" +
                "                \"link\": \"跳转链接2\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"iconUrl\": \"频道招手\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"京东秒杀\",\n" +
                "        \"titleImg\": \"广告图片\",\n" +
                "        \"link\": \"跳转链接\",\n" +
                "        \"titleBgImg\": \"广告背景图片（百亿补贴才有）\",\n" +
                "        \"slogan\": \"利益点\",\n" +
                "        \"sloganColor\": \"利益点颜色\",\n" +
                "        \"flexibleDataList\": [\n" +
                "            {\n" +
                "                \"img\": \"图片1\",\n" +
                "                \"link\": \"跳转链接1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"img\": \"图片2\",\n" +
                "                \"link\": \"跳转链接2\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"iconUrl\": \"频道招手\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"便宜包邮\",\n" +
                "        \"titleImg\": \"广告图片\",\n" +
                "        \"link\": \"跳转链接\",\n" +
                "        \"titleBgImg\": \"广告背景图片（百亿补贴才有）\",\n" +
                "        \"slogan\": \"利益点\",\n" +
                "        \"sloganColor\": \"利益点颜色\",\n" +
                "        \"flexibleDataList\": [\n" +
                "            {\n" +
                "                \"img\": \"图片1\",\n" +
                "                \"link\": \"跳转链接1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"img\": \"图片2\",\n" +
                "                \"link\": \"跳转链接2\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"iconUrl\": \"频道招手\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"京东直播\",\n" +
                "        \"titleImg\": \"广告图片\",\n" +
                "        \"link\": \"跳转链接\",\n" +
                "        \"titleBgImg\": \"广告背景图片（百亿补贴才有）\",\n" +
                "        \"slogan\": \"利益点\",\n" +
                "        \"sloganColor\": \"利益点颜色\",\n" +
                "        \"flexibleDataList\": [\n" +
                "            {\n" +
                "                \"img\": \"图片1\",\n" +
                "                \"link\": \"跳转链接1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"img\": \"图片2\",\n" +
                "                \"link\": \"跳转链接2\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"iconUrl\": \"频道招手\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"百宝箱\",\n" +
                "        \"titleImg\": \"广告图片\",\n" +
                "        \"link\": \"跳转链接\",\n" +
                "        \"titleBgImg\": \"广告背景图片（百亿补贴才有）\",\n" +
                "        \"slogan\": \"利益点\",\n" +
                "        \"sloganColor\": \"利益点颜色\",\n" +
                "        \"flexibleDataList\": [\n" +
                "            {\n" +
                "                \"img\": \"图片1\",\n" +
                "                \"link\": \"跳转链接1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"img\": \"图片2\",\n" +
                "                \"link\": \"跳转链接2\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"iconUrl\": \"频道招手\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"title\": \"灵活配置\",\n" +
                "        \"titleImg\": \"广告图片\",\n" +
                "        \"link\": \"跳转链接\",\n" +
                "        \"titleBgImg\": \"广告背景图片（百亿补贴才有）\",\n" +
                "        \"slogan\": \"利益点\",\n" +
                "        \"sloganColor\": \"利益点颜色\",\n" +
                "        \"flexibleDataList\": [\n" +
                "            {\n" +
                "                \"img\": \"图片1\",\n" +
                "                \"link\": \"跳转链接1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"img\": \"图片2\",\n" +
                "                \"link\": \"跳转链接2\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"iconUrl\": \"频道招手\"\n" +
                "    }\n" +
                "]", FirstScreenCoreChannelVO.class);
        List<FirstScreenCoreChannelVO> collect = firstScreenCoreChannelVOS.stream().map(ObjectUtil::cloneByStream).collect(Collectors.toList());
    }

}
