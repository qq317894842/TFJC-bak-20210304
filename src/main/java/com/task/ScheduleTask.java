package com.task;

import com.FlightBaseServiceListener;
import com.FlightServiceListener;
import com.MainApplication;
import com.aliyun.openservices.shade.com.alibaba.fastjson.JSONArray;
import com.caacitc.esb.client.EsbClient;
import com.caacitc.esb.dto.ProducerSendResult;
import com.utils.EquipmentUtils;

/**
 * @Auther: HuangRui
 * @Date: 2021/2/20 10:08
 * @Description:
 */
public class ScheduleTask implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                //接收航班信息
                EsbClient.getInstance.consumer("FLIGHT", new FlightServiceListener());
//        //接收航班基础信息
                EsbClient.getInstance.consumer("FLIGHT_BASE", new FlightBaseServiceListener());
                String url = "http://39.108.5.84:8088/test/getJson";//换成 mmis地址
                String jsonStr = MainApplication.doGet(url);
                System.out.println("获取的json： \n" + jsonStr);
                if (jsonStr == null || jsonStr.isEmpty()) {
                    return;
                }
                //模拟数据
                JSONArray jsonArray = JSONArray.parseArray(jsonStr);
                //封装<EQUIPMENT>数据。
                String equipMentXML = EquipmentUtils.parseEquipMentXML(jsonArray);
                //<meta>标签信息
                String xml = EquipmentUtils.packageXml(equipMentXML);
                //发送
//        EsbClient.getInstance.consumer("FLIGHT_REQE",new FlightREQEServiceListener());
                System.out.println("xml: \n" + xml);
                ProducerSendResult producer = EsbClient.getInstance.producer(xml);
                String sendState = producer.getSendState();
                System.out.println(sendState);
                String sendDesc = producer.getSendDesc();
                System.out.println(sendDesc);
                System.out.println("==> " + producer);
                Thread.sleep(60000L * 5L);//5分钟轮询一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
