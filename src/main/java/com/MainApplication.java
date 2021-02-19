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
        System.out.println("获取的json： \n"+jsonStr);
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);

        //封装<EQUIPMENT>数据
        String equipMentXML = EquipmentUtils.parseEquipMentXML(jsonArray);
        //<meta>标签信息
        String xml = EquipmentUtils.packageXml(equipMentXML);
        System.out.println("转化后的xml：\n"+xml);

    }


}
