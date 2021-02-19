import com.aliyun.openservices.shade.com.alibaba.fastjson.JSONArray;
import com.caacitc.esb.client.EsbClient;
import com.caacitc.esb.dto.ProducerSendResult;
import com.utils.EquipmentUtils;

public class Test {
    public static void main(String[] args) {
        //文档除了消息类型为BASE的是FLIGHT_BASE,其余都是FLIGHT
        //接收航班信息
//        EsbClient.getInstance.consumer("FLIGHT",new FlightServiceListener());
//        //接收航班基础信息
//        EsbClient.getInstance.consumer("FLIGHT_BASE",new FlightBaseServiceListener());

        //模拟数据
        String jsonStr = EquipmentUtils.getJsonStr();
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
        //封装<EQUIPMENT>数据
        String equipMentXML = EquipmentUtils.parseEquipMentXML(jsonArray);
        //<meta>标签信息
        String xml = EquipmentUtils.packageXml(equipMentXML);
        //发送
//        EsbClient.getInstance.consumer("FLIGHT_REQE",new FlightREQEServiceListener());
        System.out.println("xml: \n"+xml);
        ProducerSendResult producer = EsbClient.getInstance.producer(xml);
        String sendState = producer.getSendState();
        System.out.println(sendState);
        String sendDesc = producer.getSendDesc();
        System.out.println(sendDesc);
        System.out.println("==> "+producer);

    }
}
