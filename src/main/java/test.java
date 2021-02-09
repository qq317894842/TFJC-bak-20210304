import com.caacitc.esb.client.EsbClient;
import com.caacitc.esb.dto.ProducerSendResult;

public class test {
    public static void main(String[] args) {
        //文档除了消息类型为BASE的是FLIGHT_BASE,其余都是FLIGHT
        //接收航班信息
        EsbClient.getInstance.consumer("FLIGHT",new FlightServiceListener());
        //接收航班基础信息
        EsbClient.getInstance.consumer("FLIGHT_BASE",new FlightBaseServiceListener());
        //发送
//        EsbClient.getInstance.consumer("FLIGHT_REQE",new FlightREQEServiceListener());
//        ProducerSendResult producer = EsbClient.getInstance.producer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<MSG>\n" +
//                "    <META>\n" +
//                "        <SNDR>BTS</SNDR>\n" +//发送者
//                "        <RCVR></RCVR>\n" +//接收者  集成是FIMS 不写也可以
//                "        <SEQN>1</SEQN>\n" +//轮询序列
//                "        <DDTM>2020090923000</DDTM>\n" +//发送时间
//                "        <TYPE>REQE</TYPE>\n" +//消息类型
//                "        <STYP>RQDF</STYP>\n" +//子消息类型
//                "\t\t<MGID>A20121220234816RE7A97855BA84fd5B</MGID>\n" +//消息ID
//                "\t\t<RMID></RMID>\n" +//响应ID
//                "\t\t<APOT>ZUUU</APOT>\n" +//所属区域  ZUUU天府机场
//                "    </META>\n" +
//                "    <RQDF>\n" +
//                "        <BAPT>TSN</BAPT>\n" +//请求哪个机场 可多个，无此标签表示请求所有机场
//                "        <RQTP></RQTP>\n" + //FLID单条航班、DFTM时间段 为空整表请求
//                "\t\t\t\t<BAPT>ZUUU</BAPT>\n" +
//                "\t\t\t\t<BAPT>TSN</BAPT>\n" +
//                "    </RQDF>\n" +
//                "</MSG>\n");
//        String sendState = producer.getSendState();
//        System.out.println(sendState);
//        String sendDesc = producer.getSendDesc();
//        System.out.println(sendDesc);
//        System.out.println("==> "+producer);

    }
}
