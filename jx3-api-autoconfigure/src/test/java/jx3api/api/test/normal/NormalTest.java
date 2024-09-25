package jx3api.api.test.normal;

import jx3api.api.config.ApiProperties;
import jx3api.api.http.ApiService;
import jx3api.api.http.BaseResult;
import jx3api.api.http.data.*;
import jx3api.api.ws.action.WsActionDataManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 普通测试类
 *
 * @author Grafie
 * @since 1.0.0
 */
public class NormalTest {
    @Test
    void wsActionManager() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        WsActionDataManager wsActionDataManager = new WsActionDataManager();
        List<String> backPackageNames = new ArrayList<>();
        backPackageNames.add("jx3api.api.ws");
        wsActionDataManager.init(backPackageNames);
        WsActionDataManager.getWsDataByAction(1001);
    }

    private String ticket = "";
    private ApiService apiService;

    @BeforeEach
    void initApiProperties() {
        ticket = getTicket();
        apiService = new ApiService(getApiProperties());
    }

    private String getTicket() {
        return System.getenv("ticket");
    }

    private ApiProperties getApiProperties() {
        ApiProperties apiProperties = new ApiProperties();
        apiProperties.setApiToken(System.getenv("token"));
        apiProperties.setApiUrl("https://www.jx3api.com");
        return apiProperties;
    }


    /*
     *
     * FREE API
     */
    @Test
    void activeCalendar() {
        BaseResult<ActiveCurrentData> activeCurrentData = apiService.activeCalendar("长安城", 0);
        assertDataResult(activeCurrentData);
    }

    @Test
    void activeListCalendar() {
        BaseResult<ActiveCalendarData> activeCurrentData = apiService.activeListCalendar("长安城", 7);
        assertDataResult(activeCurrentData);
    }

    @Test
    void activeCelebrities() {
        BaseResult<List<ActiveCelebritiesData>> result = apiService.activeCelebrities("楚天社");
        assertDataResult(result);
    }

    @Test
    void examAnswer() {
        BaseResult<List<ExamAnswerData>> baseResult = apiService.examAnswer("古琴有几根弦", 1);
        assertDataResult(baseResult);
    }

    @Test
    void homeFurniture() {
        BaseResult<HomeFurnitureData> baseResult = apiService.homeFurniture("龙门香梦");
        assertDataResult(baseResult);
    }

    @Test
    void homeTravel() {
        BaseResult<List<HomeTravelData>> baseResult = apiService.homeTravel("七秀");
        assertDataResult(baseResult);
    }

    @Test
    void newsAllNews() {
        BaseResult<List<NewsAllNewsData>> baseResult = apiService.newsAllNews(1);
        assertDataResult(baseResult);
    }

    @Test
    void newsAnnounce() {
        BaseResult<List<NewsAnnounceData>> result = apiService.newsAnnounce(2);
        assertDataResult(result);
    }

    @Test
    void serverMaster() {
        BaseResult<ServerMasterData> result = apiService.serverMaster("双梦镇");
        assertDataResult(result);
    }

    @Test
    void serverCheck() {
        BaseResult<ServerCheckData> result = apiService.serverCheck("长安城");
        assertDataResult(result);
    }

    @Test
    void serverStatus() {
        BaseResult<ServerStatusData> result = apiService.serverStatus("长安城");
        assertDataResult(result);
    }

    @Test
    void homeFlower() {
        BaseResult<Map<String, Object>> baseResult = apiService.homeFlower("梦江南", "绣球花", "九寨沟·镜海");
        assertDataResult(baseResult);
    }


    private void assertDataResult(BaseResult o) {
        Assert.notNull(o, "测试失败，返回值为空");
        Assert.isTrue(o.getCode() == 200, String.format("服务器返回值不为成功 200, 提示消息=>%s", o.getMsg()));
    }


    /*
     * V1 API
     */
    @Test
    void saveDetailed() {
        BaseResult<SaveDetailedData> baseResult = apiService.saveDetailed("乾坤一掷", "5715151", ticket);
        assertDataResult(baseResult);
    }

    @Test
    void roleDetailed() {
        BaseResult<RoleDetailedData> baseResult = apiService.roleDetailed("唯我独尊", "夜温言@长安城", ticket);
        assertDataResult(baseResult);
    }

    @Test
    void schoolMatrix() {
        BaseResult<SchoolMatrixData> baseResult = apiService.schoolMatrix("冰心诀");
        assertDataResult(baseResult);
    }

    @Test
    void schoolForce() {
        BaseResult<List<SchoolForceData>> baseResult = apiService.schoolForce("冰心诀");
        assertDataResult(baseResult);
    }

    @Test
    void schoolSkill() {
        BaseResult<List<SchoolSkillsData>> baseResult = apiService.schoolSkills("冰心诀");
        assertDataResult(baseResult);
    }

    @Test
    void tiebaRandom() {
        BaseResult<List<TiebaRandomData>> baseResult = apiService.tiebaRandom("818", null, 1);
        assertDataResult(baseResult);
    }

    @Test
    void roleTeamCdList() {
        BaseResult<RoleTeamCdListData> result = apiService.roleTeamCdList("唯我独尊", "夜温言@长安城", ticket);
        assertDataResult(result);
    }

    @Test
    void luckAdventure() {
        BaseResult<List<LuckAdventureData>> baseResult = apiService.luckAdventure("梦江南", "狸嫁", ticket);
        assertDataResult(baseResult);
    }

    @Test
    void luckStatistical() {
        BaseResult<List<LuckStatisticalData>> baseResult = apiService.luckStatistical("长安城", "阴阳两界", 1);
        assertDataResult(baseResult);
    }

    @Test
    void luckServerStatistical() {
        BaseResult<List<LuckServerStatisticalData>> baseResult = apiService.luckServerStatistical("阴阳两界", 1);
        assertDataResult(baseResult);
    }

    @Test
    void luckCollect() {
        BaseResult<List<LuckCollectData>> baseResult = apiService.luckCollect("长安城", 1);
        assertDataResult(baseResult);
    }

    @Test
    void roleAchievement() {
        BaseResult<RoleAchievementData> baseResult = apiService.roleAchievement("唯我独尊", "夜温言@长安城", "阴阳两界", ticket);
        assertDataResult(baseResult);
    }

    @Test
    void matchRecent() {
        BaseResult<Map<String, Object>> baseResult = apiService.matchRecent("梦江南", "有所依", 33, ticket);
        assertDataResult(baseResult);
    }

    @Test
    void matchAwesome() {
        BaseResult<List<MatchAwesomeData>> baseResult = apiService.matchAwesome(33, 1, ticket);
        assertDataResult(baseResult);
    }

    @Test
    void matchSchools() {
        BaseResult<List<MatchSchoolsData>> baseResult = apiService.matchSchools(ticket, 33);
        assertDataResult(baseResult);
    }

    @Test
    void memberRecruit() {
        BaseResult<MemberRecruitData> baseResult = apiService.memberRecruit("梦江南", "英雄九龙峰", 1);
        assertDataResult(baseResult);
    }

    @Test
    void memberTeacher() {
        BaseResult<MemberTeacherData> baseResult = apiService.memberTeacher("长安城", "徒弟");
        assertDataResult(baseResult);
    }

    @Test
    void memberStudent() {
        BaseResult<MemberStudentData> baseResult = apiService.memberStudent("长安城", "师父");
        assertDataResult(baseResult);
    }

    @Test
    void serverSand() {
        BaseResult<ServerSandData> baseResult = apiService.serverSand("梦江南");
        assertDataResult(baseResult);
    }

    @Test
    void serverEvent() {
        BaseResult<List<ServerEventData>> baseResult = apiService.serverEvent("浩气盟", 1);
        assertDataResult(baseResult);
    }

    @Test
    void tradeDemo() {
        BaseResult<List<TradeDemonData>> baseResult = apiService.tradeDemon("梦江南", 1);
        assertDataResult(baseResult);
    }

    @Test
    void tradeRecord() {
        BaseResult<TradeRecordData> baseResult = apiService.tradeRecord("梦江南", "狐金");
        assertDataResult(baseResult);
    }

    @Test
    void tiebaItemRecord() {
        BaseResult<List<TiebaItemRecordsData>> result = apiService.tiebaItemRecords("狐金", "长安城", 1);
        assertDataResult(result);
    }

    @Test
    void valuablesStatistical() {
        BaseResult<List<ValuablesStatisticalData>> baseResult = apiService.valuablesStatistical("长安城", "太一玄晶", 1);
        assertDataResult(baseResult);
    }

    @Test
    void valuablesServerStatistical() {
        BaseResult<List<ValuablesServerStatisticalData>> baseResult = apiService.valuablesServerStatistical("太一玄晶", 15);
        assertDataResult(baseResult);
    }

    @Test
    void serverAntivice() {
        BaseResult<List<ServerAntiviceData>> baseResult = apiService.serverAntivice("梦江南");
        assertDataResult(baseResult);
    }

    @Test
    void rankStatistical() {
        BaseResult<List<Map<String, Object>>> baseResult = apiService.rankStatistical("梦江南", "个人", "名士五十强");
        assertDataResult(baseResult);
    }

    @Test
    void rankServerStatistical() {
        BaseResult<List<Map<String, Object>>> baseResult = apiService.rankServerStatistical("个人", "名士五十强");
        assertDataResult(baseResult);
    }

    @Test
    void tableRecords() {
        BaseResult<List<TableRecordsData>> baseResult = apiService.tableRecords("夜幕星河");
        assertDataResult(baseResult);
    }

    @Test
    void luckUnfinished() {
        BaseResult<List<LuckUnfinishedData>> baseResult = apiService.luckUnfinished("乾坤一掷", "琉枫", ticket);
        assertDataResult(baseResult);
    }
    /*
     *
     * V2 API
     * */

    @Test
    void activeMonster() {
        BaseResult<ActiveMonsterData> baseResult = apiService.activeMonster();
        assertDataResult(baseResult);
    }

    @Test
    void horseRecords() {
        BaseResult<List<HorseRecordsData>> result = apiService.horseRecords("乾坤一掷");
        assertDataResult(result);
    }

    @Test
    void horseEvent() {
        BaseResult<HorseRanchData> baseResult = apiService.horseEvent("梦江南");
        assertDataResult(baseResult);
    }

    @Test
    void watchRecord() {
        BaseResult<List<FireworkRecordData>> baseResult = apiService.watchRecord("乾坤一掷", "琉枫");
        assertDataResult(baseResult);
    }

    @Test
    void watchStatistical() {
        BaseResult<List<FireworkStatisticalData>> baseResult = apiService.watchStatistical("唯我独尊", "真橙之心", 1);
        assertDataResult(baseResult);
    }

    @Test
    void watchCollection() {
        BaseResult<List<FireworkCollectData>> baseResult = apiService.watchCollect("唯我独尊", 1);
        assertDataResult(baseResult);
    }

    @Test
    void watchRankStatistical() {
        BaseResult<List<FireworkRankStatisticalData>> baseResult = apiService.watchRankStatistical("唯我独尊", "sender", 1640285289, 1640687624);
        assertDataResult(baseResult);
    }

    @Test
    void roleMonster() {
        BaseResult<List<RoleMonsterData>> baseResult = apiService.roleMonster("唯我独尊", "夜温言@长安城");
        assertDataResult(baseResult);
    }

    @Test
    void auctionRecords() {
        BaseResult<List<AcutionRecordsData>> baseResult = apiService.auctionRecords("唯我独尊");
        assertDataResult(baseResult);
    }

    @Test
    void roleShowCard() {
        BaseResult<RoleShowCardData> baseResult = apiService.roleShowCard("唯我独尊", "夜温言@长安城");
        assertDataResult(baseResult);
    }

    @Test
    void roleShowRandom() {
        BaseResult<RoleShowRandomData> baseResult = apiService.roleShowRandom("唯我独尊", "萝莉", "万花");
        assertDataResult(baseResult);
    }

    @Test
    void roleAttribute() {
        BaseResult<RoleAttributeData> roleAttributeDataBaseResult = apiService.roleAttribute("唯我独尊", "夜温言@长安城", ticket);
        assertDataResult(roleAttributeDataBaseResult);
    }

    /*
     * VRF API 由于涉及到多个平台要注册，故对于需要平台信息的，都没有进行自测
     * */
    @Test
    void fraudDetail() {
        BaseResult<List<FraudDetailData>> result = apiService.fraudDetail(123456L);
        assertDataResult(result);
    }

    @Test
    void mixedChat() {
        BaseResult<ChatMixedData> baseResult = apiService.chatMixed("萌萌", "你叫什么啊");
        assertDataResult(baseResult);
    }

    @Test
    void idiomSolitaire() {
        BaseResult<IdiomSolitaireData> baseResult = apiService.idiomSolitaire("三心二意");
        assertDataResult(baseResult);
    }

    @Test
    void saohuaRandom() {
        BaseResult<SaohuaRandomData> baseResult = apiService.saohuaRandom();
        assertDataResult(baseResult);
    }

    @Test
    void saohuaContent() {
        BaseResult<SaohuaContentData> baseResult = apiService.saohuaContent();
        assertDataResult(baseResult);
    }

    @Test
    void musicTencent() {
        BaseResult<List<MusicTencentData>> baseResult = apiService.musicTencent("业火苍云歌");
        assertDataResult(baseResult);
    }

    @Test
    void musicNetease() {
        BaseResult<List<MusicNeteaseData>> baseResult = apiService.musicNetease("业火苍云歌");
        assertDataResult(baseResult);
    }

    @Test
    void musicKugou() {
        BaseResult<List<MusicKugouData>> baseResult = apiService.musicKugou("业火苍云歌");
        assertDataResult(baseResult);
    }
}
