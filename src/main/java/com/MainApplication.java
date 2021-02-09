package com;

import com.alibaba.fastjson.JSONArray;
import com.utils.EquipmentUtils;

/**
 * @Auther: HuangRui
 * @Date: 2021/2/9 13:30
 * @Description:
 */
public class MainApplication {
    public static void main(String[] args) {
        //模拟从MMIS返回的json数据
        String jsonStr = EquipmentUtils.getJsonStr();
//        System.out.println(jsonStr);
        //转XML数据
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
        String xmlStr = EquipmentUtils.parseEquipMentXML(jsonArray);
        System.out.println(xmlStr);
        String xml = EquipmentUtils.packageXml(xmlStr);
        System.out.println(xml);

    }


}
