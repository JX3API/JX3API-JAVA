package org.jx3api.startertest;

import jakarta.annotation.Resource;
import jx3api.api.config.EnableJX3Api;
import jx3api.api.http.ApiService;
import jx3api.api.ws.CustomWebSocketHandler;
import jx3api.api.ws.IWsDataPushService;
import jx3api.api.ws.WebSocketClientInitializer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * 需要修改 {@link StarterTestApplication}类中的@Enablexx注解，否则spring注入会存在问题
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class StarterTestApplicationTests {
    @Autowired
    private WebSocketClientInitializer webSocketClientInitializer;
    @Resource
    private IWsDataPushService iWsDataPushService;
    @Autowired
    private ApiService apiService;

    @Test
    void wsTest() throws Exception {
        // 创建模拟的 WebSocketSession
        WebSocketSession mockSession = createMockWebSocketSession();
        CustomWebSocketHandler customWebSocketHandler = new CustomWebSocketHandler(webSocketClientInitializer,
                iWsDataPushService);
        // 在 mockSession 上模拟收到一条消息
        TextMessage message = new TextMessage("{\n" +
                "  \"action\": 1001,\n" +
                "  \"data\": {\n" +
                "    \"zone\": \"电信五区\",\n" +
                "    \"server\": \"斗转星移\",\n" +
                "    \"name\": \"莫问归时@梦 江南\",\n" +
                "    \"event\": \"惜往日\",\n" +
                "    \"level\": 1,\n" +
                "    \"time\": 1640438124\n" +
                "  }\n" +
                "}");
        customWebSocketHandler.handleMessage(mockSession, message);

        message = new TextMessage("{\n" +
                "  \"action\": 2004,\n" +
                "  \"data\": {\n" +
                "    \"subclass\": \"818\",\n" +
                "    \"server\": \"梦江南\",\n" +
                "    \"name\": \"双梦镇\",\n" +
                "    \"title\": \"【818】问一问现在团里有需求还玄晶外拍是可以的吗\",\n" +
                "    \"url\": \"https://tieba.baidu.com/p/8437009794\",\n" +
                "    \"date\": \"2023-05-30\"\n" +
                "  }\n" +
                "}");
        customWebSocketHandler.handleMessage(mockSession,message);
    }

    private WebSocketSession createMockWebSocketSession() {
        // 创建模拟的 WebSocketSession
        return Mockito.mock(WebSocketSession.class);
    }

    @Test
    void apiTest() {
//        System.out.println(apiService.activeCalendar("长安城", 7));
        System.out.println(apiService.activeCalendar("长安城",0));
//        System.out.println(apiService.examAnswer("古琴有几根弦", 10));
    }
}
