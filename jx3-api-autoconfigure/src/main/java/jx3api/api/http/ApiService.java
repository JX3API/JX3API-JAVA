package jx3api.api.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import jx3api.api.config.ApiProperties;
import jx3api.api.http.data.active.ActiveCelebritiesData;
import jx3api.api.http.data.active.ActiveCurrentData;
import jx3api.api.http.data.active.calendar.ActiveCalendarData;
import jx3api.api.http.data.active.monster.ActiveMonsterData;
import jx3api.api.http.data.acution.AcutionRecordsData;
import jx3api.api.http.data.chat.ChatMixedData;
import jx3api.api.http.data.detail.SaveDetailedData;
import jx3api.api.http.data.exam.ExamAnswerData;
import jx3api.api.http.data.firework.FireworkCollectData;
import jx3api.api.http.data.firework.FireworkRankStatisticalData;
import jx3api.api.http.data.firework.FireworkRecordData;
import jx3api.api.http.data.firework.FireworkStatisticalData;
import jx3api.api.http.data.fraud.detail.FraudDetailData;
import jx3api.api.http.data.home.HomeFurnitureData;
import jx3api.api.http.data.home.HomeTravelData;
import jx3api.api.http.data.horse.HorseRanchData;
import jx3api.api.http.data.horse.HorseRecordsData;
import jx3api.api.http.data.idiom.solitaire.IdiomSolitaireData;
import jx3api.api.http.data.luck.LuckAdventureData;
import jx3api.api.http.data.luck.LuckServerStatisticalData;
import jx3api.api.http.data.luck.LuckStatisticalData;
import jx3api.api.http.data.luck.collect.LuckCollectData;
import jx3api.api.http.data.luck.unfinished.LuckUnfinishedData;
import jx3api.api.http.data.match.MatchAwesomeData;
import jx3api.api.http.data.match.MatchSchoolsData;
import jx3api.api.http.data.member.recruit.MemberRecruitData;
import jx3api.api.http.data.member.student.MemberStudentData;
import jx3api.api.http.data.member.teacher.MemberTeacherData;
import jx3api.api.http.data.music.MusicKugouData;
import jx3api.api.http.data.music.MusicNeteaseData;
import jx3api.api.http.data.music.MusicTencentData;
import jx3api.api.http.data.news.NewsAllNewsData;
import jx3api.api.http.data.news.NewsAnnounceData;
import jx3api.api.http.data.role.RoleDetailedData;
import jx3api.api.http.data.role.RoleShowCardData;
import jx3api.api.http.data.role.RoleShowRandomData;
import jx3api.api.http.data.role.achievement.RoleAchievementData;
import jx3api.api.http.data.role.attribute.RoleAttributeData;
import jx3api.api.http.data.role.monster.RoleMonsterData;
import jx3api.api.http.data.role.teamcd.RoleTeamCdListData;
import jx3api.api.http.data.saohua.SaohuaContentData;
import jx3api.api.http.data.saohua.SaohuaRandomData;
import jx3api.api.http.data.school.force.SchoolForceData;
import jx3api.api.http.data.school.matirx.SchoolMatrixData;
import jx3api.api.http.data.school.skill.SchoolSkillsData;
import jx3api.api.http.data.server.*;
import jx3api.api.http.data.server.sand.ServerSandData;
import jx3api.api.http.data.sound.SoundConverterData;
import jx3api.api.http.data.table.TableRecordsData;
import jx3api.api.http.data.tieba.TiebaItemRecordsData;
import jx3api.api.http.data.tieba.TiebaRandomData;
import jx3api.api.http.data.trade.TradeDemonData;
import jx3api.api.http.data.trade.record.TradeRecordData;
import jx3api.api.http.data.valuables.ValuablesServerStatisticalData;
import jx3api.api.http.data.valuables.ValuablesStatisticalData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * api 服务类
 * 由于接口区分了 free vip1 vip2 ，需要根据token进行区分，具体请参考 {@link MethodEnum} 内关于不同类型的api的区分情况
 *
 * @author Grafie
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class ApiService {
    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
    private final WebClient webClient;
    /**
     * 相关api参数
     */
    private ApiProperties apiProperties;

    private ObjectMapper objectMapper;

    public ApiService(ApiProperties apiProperties, ObjectMapper objectMapper) {
        this.apiProperties = apiProperties;
        this.webClient = WebClient.builder().baseUrl(apiProperties.getApiUrl()).defaultHeader("token", apiProperties.getApiToken()).defaultHeader(HttpHeaders.USER_AGENT, "Nonebot2-jx3-bot").build();
        this.objectMapper = objectMapper;
    }

    /**
     * 活动日历
     * 只有 星期三、星期五、星期六、星期日 才有美人画图，星期三、星期五 才有世界首领，若非活动时间不返回相关键与值。
     *
     * @param num 预测时间，预测指定时间内的日常，默认值 : 15。
     * @return ActiveCalendarData
     */
    public BaseResult<ActiveCurrentData> activeCalendar(String server, Integer num) {
        MethodEnum methodEnum = MethodEnum.DATA_ACTIVE_CALENDAR;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("num", num);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 活动月历
     *
     * @param num 预测时间，预测指定时间内的日常，默认值 : 15。
     * @return ActiveCalendarData
     */
    public BaseResult<ActiveCalendarData> activeListCalendar(String server, Integer num) {
        MethodEnum methodEnum = MethodEnum.DATA_ACTIVE_LIST_CALENDAR;
        Map<String, Object> params = new HashMap<>();
        params.put("num", num);
        params.put("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 行侠事件
     *
     * @param name 指定名称，查询指定事件的记录。
     * @return ActiveCelebritiesData List
     */
    public BaseResult<List<ActiveCelebritiesData>> activeCelebrities(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_ACTIVE_CELEBS;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 科举试题
     * 说明:
     * 搜索科举试题的答案
     *
     * @param subject 科举题目，搜索目标题目答案
     * @param limit   单页数量，设置单页返回的数量；默认值 : 10。
     * @return ExamAnswerData
     */
    public BaseResult<List<ExamAnswerData>> examAnswer(String subject, int limit) {
        MethodEnum methodEnum = MethodEnum.DATA_EXAM_ANSWER;
        Map<String, Object> params = new HashMap<>();
        params.put("subject", subject);
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 鲜花价格
     *
     * @param server 区服名称，查找目标区服鲜花最高价格线路
     * @param flower 鲜花名称，筛选鲜花记录
     * @param map    地图名称，筛选地图记录
     * @return
     */
    public BaseResult<Map<String, Object>> homeFlower(String server, String flower, String map) {
        MethodEnum methodEnum = MethodEnum.DATA_HOME_FLOWER;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("flower", flower);
        params.put("map", map);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 家园装饰
     *
     * @param name 装饰名称，查找装饰的详细数据。
     * @return HomeFurnitureData
     */
    public BaseResult<HomeFurnitureData> homeFurniture(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_HOME_FURNITURE;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 器物图谱
     *
     * @param name 地图名称，查找目标地图产出家具。
     * @return HomeTravelData
     */
    public BaseResult<List<HomeTravelData>> homeTravel(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_HOME_TRAVEL;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }


    /**
     * 阵法效果
     *
     * @param name 心法名称，查找目标心法的阵法效果。
     * @return SchoolMatrixData
     */
    public BaseResult<SchoolMatrixData> schoolMatrix(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_SCHOOL_MATRIX;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 搜索区服
     *
     * @param name 区服别名，查找目标简称的服务器组。
     * @return ServerMasterData
     */
    public BaseResult<ServerMasterData> serverMaster(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_MASTER;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 开服检查
     *
     * @param server 区服名称，查找目标区服的状态。
     * @return ServerCheckData
     */
    public BaseResult<ServerCheckData> serverCheck(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_CHECK;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 查看状态
     *
     * @param server 区服名称，查找目标区服的状态。
     * @return ServerStatusData
     */
    public BaseResult<ServerStatusData> serverStatus(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_STATUS;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 新闻资讯
     *
     * @param limit 单页数量，单页返回的数量，默认值 : 10。
     * @return WebNewsAllNewsData
     */
    public BaseResult<List<NewsAllNewsData>> newsAllNews(Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_WEB_NEWS_ALLNEWS;
        Map<String, Object> params = new HashMap<>();
        if (limit == null) {
            limit = 10;
        }
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 维护公告
     *
     * @param limit 单页数量，单页返回的数量，默认值 : 10。
     * @return WebNewsAnnounceData
     */
    public BaseResult<List<NewsAnnounceData>> newsAnnounce(Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_WEB_NEWS_ANNOUNCE;
        Map<String, Object> params = new HashMap<>();
        if (limit == null) {
            limit = 10;
        }
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }


    /**
     * 撩人骚话
     *
     * @return SaohuaRandomData
     */
    public BaseResult<SaohuaRandomData> saohuaRandom() {
        MethodEnum methodEnum = MethodEnum.DATA_SAOHUA_RANDOM;
        Map<String, Object> params = new HashMap<>();
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 金币比例
     *
     * @param server 区服名称，查找目标区服的金价比例信息，
     * @param limit  单页数量，单页返回的数量，默认值 : 10
     * @return TradeDemonData List
     */
    public BaseResult<List<TradeDemonData>> tradeDemon(String server, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_TRADE_DEMON;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        if (limit == null) {
            limit = 10;
        }
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 奇遇记录
     *
     * @param server 区服名称，查找目标区服的数据，
     * @param name   角色名称，筛选角色记录，
     * @param ticket 推栏标识，检查并补充奇遇的完整性，
     * @return LuckAdventureData
     */
    public BaseResult<List<LuckAdventureData>> luckAdventure(String server, String name, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_LUCK_ADVENTURE;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 奇遇统计
     *
     * @param server 区服名称，查找目标区服的奇遇记录，
     * @param name   奇遇名称，筛选奇遇记录，
     * @param limit  单页数量，单页返回的数量，默认值 : 20，
     * @return 奇遇统计
     */
    public BaseResult<List<LuckStatisticalData>> luckStatistical(String server, String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_LUCK_STATISTICAL;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 奇遇汇总
     *
     * @param server 区服名称，查找目标区服的记录，
     * @param num    汇总时间，汇总指定天数内的奇遇记录，默认值 : 7，
     * @return LuckCollectData List
     */
    public BaseResult<List<LuckCollectData>> luckCollect(String server, Integer num) {
        MethodEnum methodEnum = MethodEnum.DATA_LUCK_COLLECT;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("num", num);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 全服统计
     *
     * @param name  奇遇名称，查找目标区服的奇遇记录，
     * @param limit 单页数量，单页返回的数量，默认值 : 20，
     * @return LuckServerStatisticalData list
     */
    public BaseResult<List<LuckServerStatisticalData>> luckServerStatistical(String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_LUCK_SERVER_STATISTICAL;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 名剑战绩,角色近期战绩记录
     *
     * @param server 指定区服，查找该区服的相关记录；
     * @param name   角色名称，查找该角色的相关记录；
     * @param mode   比赛模式，查找目标比赛模式的记录，默认值 : 33，
     * @param ticket 推栏标识，检查请求权限，
     * @return MatchAwesomeData List
     */
    public BaseResult<Map<String, Object>> matchRecent(String server, String name, Integer mode, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_MATCH_RECENT;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        params.put("mode", mode);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 名剑排行
     *
     * @param mode   比赛模式，查找目标比赛模式的记录，默认值 : 33，
     * @param limit  单页数量，单页返回的数量，默认值 : 20，
     * @param ticket 推栏标识，检查请求权限，
     * @return MatchAwesomeData List
     */
    public BaseResult<List<MatchAwesomeData>> matchAwesome(Integer mode, Integer limit, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_MATCH_AWESOME;
        Map<String, Object> params = new HashMap<>();
        params.put("limit", limit);
        params.put("mode", mode);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 名剑统计
     *
     * @param ticket 推栏标识，检查请求权限，
     * @param mode   比赛模式，查找目标比赛模式的记录，默认值 : 33，
     * @return MatchSchoolsData List
     */
    public BaseResult<List<MatchSchoolsData>> matchSchools(String ticket, Integer mode) {
        MethodEnum methodEnum = MethodEnum.DATA_MATCH_SCHOOLS;
        Map<String, Object> params = new HashMap<>();
        params.put("mode", mode);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 团队招募
     *
     * @param server  区服名称，查找目标区服的招募信息，
     * @param keyword 关键字，模糊匹配记录，用=关键字完全匹配记录，
     * @param table   指定表记录，1=本服+跨服，2=本服，3=跨服，默认值：1；
     * @return MemberRecruitData
     */
    public BaseResult<MemberRecruitData> memberRecruit(String server, String keyword, Integer table) {
        MethodEnum methodEnum = MethodEnum.DATA_MEMBER_RECRUIT;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("keyword", keyword);
        params.put("table", table);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 风云榜单
     * <p>
     * 必选的 [table] [name] 榜单类型与榜单名称，[table] 与 [name] 的关联：
     * [table] : 个人，[name] : [名士五十强 老江湖五十强 兵甲藏家五十强 名师五十强 阵营英雄五十强 薪火相传五十强 庐园广记一百强]，
     * [table] : 帮会，[name] : [浩气神兵宝甲五十强 恶人神兵宝甲五十强 浩气爱心帮会五十强 恶人爱心帮会五十强]，
     * [table] : 阵营，[name] : [赛季恶人五十强 赛季浩气五十强 上周恶人五十强 上周浩气五十强 本周恶人五十强 本周浩气五十强]，
     * [table] : 试炼，[name] : [万花 七秀 少林 纯阳 天策 五毒 唐门 明教 苍云 长歌 藏剑 丐帮 霸刀 蓬莱 凌雪 衍天 药宗 刀宗]
     * 各个table的数据结构不同，最终数据以返回为准。
     *
     * @param server 区服名称，查找目标区服的榜单，
     * @param table  1
     * @param name   2
     * @return RankStatisticalData List
     */
    public BaseResult<List<Map<String, Object>>> rankStatistical(String server, String table, String name) {
        MethodEnum methodEnum = MethodEnum.DATA_RANK_STATISTICAL;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("table", table);
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 角色信息
     *
     * @param server 区服名称，查找目标区服的记录，
     * @param name   角色名称，筛选记录，
     * @param ticket 推栏标识，检查请求权限
     * @return RoleDetailedData
     */
    public BaseResult<RoleDetailedData> roleDetailed(String server, String name, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_DETAILED;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 成就百科 角色成就进度
     *
     * @param server 区服名称，查找目标区服的记录，
     * @param role   角色名称，筛选记录，
     * @param name   成就/系列名称，查询指定成就/系列的完成进度，
     * @param ticket 推栏标识，检查请求权限，
     * @return RoleAchievementData
     */
    public BaseResult<RoleAchievementData> roleAchievement(String server, String role, String name, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_ACHIEVEMENT;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        params.put("role", role);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 装备属性
     *
     * @param server 区服名称，查找目标区服的角色属性记录，
     * @param name   角色名称，筛选记录
     * @param ticket 推栏标识，检查请求权限，
     * @return RoleAttributeData
     */
    public BaseResult<RoleAttributeData> roleAttribute(String server, String name, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_ATTRIBUTE;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 副本记录
     *
     * @param server 区服名称，查找目标区服的角色属性记录，
     * @param name   角色名称，筛选记录
     * @param ticket 推栏标识，检查请求权限，
     * @return RoleAttributeData
     */
    public BaseResult<RoleTeamCdListData> roleTeamCdList(String server, String name, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_CDLIST;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }


    /**
     * 角色更新
     *
     * @param server 区服名称，上传目标服务器的角色信息，
     * @param roleId 角色数字标识，上传指定角色的信息，
     * @param ticket 推栏标识，检查请求权限
     * @return SaveDetailedData
     */
    public BaseResult<SaveDetailedData> saveDetailed(String server, String roleId, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_SAVE_DETAILED;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("roleid", roleId);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }


    /**
     * 奇穴效果
     *
     * @param name 心法名称，查找目标心法的奇穴效果。
     * @return SchoolForceData list
     */
    public BaseResult<List<SchoolForceData>> schoolForce(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_SCHOOL_FORCE;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 技能效果
     *
     * @param name 心法名称，查找目标心法的技能详细效果。
     * @return SchoolSkillsData List
     */
    public BaseResult<List<SchoolSkillsData>> schoolSkills(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_SCHOOL_SKILL;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 沙盘信息
     *
     * @param server 区服名称，查找目标区服的沙盘信息，
     * @return ServerSandData
     */
    public BaseResult<ServerSandData> serverSand(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_SAND;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 全服阵营事件
     *
     * @param name  阵营名称，筛选记录
     * @param limit 单页数量，默认 : 100
     * @return ServerEventData List
     */
    public BaseResult<List<ServerEventData>> serverEvent(String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_EVENT;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }


    /**
     * 诛恶事件
     *
     * @param server 指定区服，查找该区服的相关记录；
     * @return ServerAntiviceData List
     */
    public BaseResult<List<ServerAntiviceData>> serverAntivice(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_SERVER_ANTIVICE;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 八卦帖子
     *
     * @param subclass 帖子分类，可选范围：818 616 鬼网三 鬼网3 树洞 记录 教程 街拍 故事 避雷 吐槽 提问
     * @param server   区服名称，查找目标区服的帖子，默认值：- 为全区服
     * @param limit    单页数量，单页返回的数量
     * @return TiebaRandomData List
     */
    public BaseResult<List<TiebaRandomData>> tiebaRandom(String subclass, String server, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_TIEBA_RANDOM;
        Map<String, Object> params = new HashMap<>();
        params.put("class", subclass);
        params.put("server", server);
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 物品价格
     * [sales] : [1 = 出售，2 = 收购，3 = 想出，4 = 想收，5 = 成交，6 = 正出，7 = 公示]
     * [data]结构共计7层, [0 = 电信点卡， 1 = 电信月卡，2 = 双线点卡，3 = 双线月卡，4 = 青梅煮酒 5 = 万宝楼·正售， 6 = 万宝楼·公示]
     *
     * @param server 指定区服，查找该区服的相关记录；
     * @param name   外观名称，查找目标外观的价格信息
     * @return TradeRecordData
     */
    public BaseResult<TradeRecordData> tradeRecord(String server, String name) {
        MethodEnum methodEnum = MethodEnum.DATA_TRADE_RECORD;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 贴吧物价
     *
     * @param name 外观名称，查找目标外观物价信息。
     * @return TiebaItemRecordsData List
     */
    public BaseResult<List<TiebaItemRecordsData>> tiebaItemRecords(String name, String server, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_TIEBA_ITEM_RECORDS;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("server", server);
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 百战首领
     *
     * @return ActiveMonsterData
     */
    public BaseResult<ActiveMonsterData> activeMonster() {
        MethodEnum methodEnum = MethodEnum.DATA_ACTIVE_MONSTER;
        Map<String, Object> params = new HashMap<>();
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 师父列表
     *
     * @param server  区服名称，查找目标区服的师傅列表，
     * @param keyword 关键字，筛选记录
     * @return MemberTeacherData
     */
    public BaseResult<MemberTeacherData> memberTeacher(String server, String keyword) {
        MethodEnum methodEnum = MethodEnum.DATA_MEMBER_TEACHER;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("keyword", keyword);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 徒弟列表
     *
     * @param server  区服名称，查找目标区服的徒弟列表
     * @param keyword 关键字，筛选记录
     * @return MemberStudentData
     */
    public BaseResult<MemberStudentData> memberStudent(String server, String keyword) {
        MethodEnum methodEnum = MethodEnum.DATA_MEMBER_STUDENT;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("keyword", keyword);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 全服榜单
     * 各个table的数据结构不同，最终数据以返回为准。
     *
     * @param table 榜单类型
     * @param name  榜单名称
     *              [table] 与 [name] 的关联：
     *              [table] : 个人，[name] : [名士五十强 老江湖五十强 兵甲藏家五十强 名师五十强 阵营英雄五十强 薪火相传五十强 庐园广记一百强]，
     *              [table] : 帮会，[name] : [浩气神兵宝甲五十强 恶人神兵宝甲五十强 浩气爱心帮会五十强 恶人爱心帮会五十强]，
     *              [table] : 阵营，[name] : [赛季恶人五十强 赛季浩气五十强 上周恶人五十强 上周浩气五十强 本周恶人五十强 本周浩气五十强]，
     *              [table] : 试炼，[name] : [万花 七秀 少林 纯阳 天策 五毒 唐门 明教 苍云 长歌 藏剑 丐帮 霸刀 蓬莱 凌雪 衍天 药宗 刀宗]
     * @return RankServerStatisticalData List
     */
    public BaseResult<List<Map<String, Object>>> rankServerStatistical(String table, String name) {
        MethodEnum methodEnum = MethodEnum.DATA_RANK_SERVER_STATISTICAL;
        Map<String, Object> params = new HashMap<>();
        params.put("table", table);
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }


    /**
     * 掉落统计
     *
     * @param server 区服名称，查找目标区服的掉落记录，
     * @param name   物品名称，筛选记录，
     * @param limit  单页数量，单页返回的数量，默认值：20，
     * @return ValuablesStatisticalData List
     */
    public BaseResult<List<ValuablesStatisticalData>> valuablesStatistical(String server, String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_VALUABLES_STATISTICAL;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }


    /**
     * 全服掉落
     *
     * @param name  物品名称，查找目标物品的掉落记录
     * @param limit 单页数量，单页返回的数量，默认值：30
     * @return ValuablesServerStatisticalData List
     */
    public BaseResult<List<ValuablesServerStatisticalData>> valuablesServerStatistical(String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_VALUABLES_SERVER_STATISTICAL;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 烟花记录
     *
     * @param server 区服名称，查找目标区服的烟花记录
     * @param name   角色名称，筛选记录
     * @return WatchRecordData List
     */
    public BaseResult<List<FireworkRecordData>> watchRecord(String server, String name) {
        MethodEnum methodEnum = MethodEnum.DATA_WATCH_RECORD;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 烟花统计
     *
     * @param server 区服名称，查找目标区服的烟花记录
     * @param name   烟花名称，筛选记录
     * @param limit  单页数量，单页返回的数量，默认值：20
     * @return WatchStatisticalData List
     */
    public BaseResult<List<FireworkStatisticalData>> watchStatistical(String server, String name, Integer limit) {
        MethodEnum methodEnum = MethodEnum.DATA_WATCH_STATISTICAL;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        params.put("limit", limit);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 烟花汇总
     *
     * @param server 区服名称，查找目标区服的烟花记录，
     * @param num    统计时间，默认值：7 天，
     * @return WatchCollectData List
     */
    public BaseResult<List<FireworkCollectData>> watchCollect(String server, Integer num) {
        MethodEnum methodEnum = MethodEnum.DATA_WATCH_COLLECT;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("num", num);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 烟花排行
     *
     * @param server   区服名称，查找目标区服的烟花记录
     * @param column   可选范围：[sender recipient name]，
     * @param thisTime 统计开始的时间，与结束的时间不得超过3个月，
     * @param thatTime 统计结束的时间，与开始的时间不得超过3个月，
     * @return RankStatisticalData List
     */
    public BaseResult<List<FireworkRankStatisticalData>> watchRankStatistical(String server, String column, long thisTime, long thatTime) {
        MethodEnum methodEnum = MethodEnum.DATA_WATCH_RANK_STATISTICAL;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("column", column);
        params.put("this_time", thisTime);
        params.put("that_time", thatTime);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 百战精耐
     *
     * @param server 区服名称
     * @param name   指定角色名称，查找目标角色的相关信息
     * @return RankStatisticalData List
     */
    public BaseResult<List<RoleMonsterData>> roleMonster(String server, String name) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_MONSTER;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 拍卖记录
     * 阵营拍卖记录。
     *
     * @param server 区服名称
     * @return RankStatisticalData List
     */
    public BaseResult<List<AcutionRecordsData>> auctionRecords(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_AUCTION_RECORDS;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 角色名片
     * 客户端的名片墙。
     *
     * @param server 区服名称
     * @param name   指定角色名称，查找目标角色的相关信息
     * @return RankStatisticalData List
     */
    public BaseResult<RoleShowCardData> roleShowCard(String server, String name) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_SHOW_CARD;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 角色名片
     * 客户端的名片墙。
     *
     * @param server 区服名称
     * @param body   指定角色体型，查找目标体型的相关信息；
     * @param force  指定门派名称，查找目标门派的相关信息
     * @return RankStatisticalData List
     */
    public BaseResult<RoleShowRandomData> roleShowRandom(String server, String body, String force) {
        MethodEnum methodEnum = MethodEnum.DATA_ROLE_SHOW_RANDOM;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        params.put("body", body);
        params.put("force", force);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 的卢统计
     *
     * @param server 区服名称，查找目标区服的记录
     * @return HorseRecordsData List
     */
    public BaseResult<List<HorseRecordsData>> horseRecords(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_HORSE_RECORDS;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 马场事件
     *
     * @param server 区服名称，查找目标区服的记录
     * @return HorseRecordsData List
     */
    public BaseResult<HorseRanchData> horseEvent(String server) {
        MethodEnum methodEnum = MethodEnum.DATA_HORSE_EVENT;
        Map<String, Object> params = new HashMap<>();
        params.put("server", server);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 智障聊天
     *
     * @param name 机器人的名称
     * @param text 聊天的完整内容
     * @return ChatMixedData
     */
    public BaseResult<ChatMixedData> chatMixed(String name, String text) {
        MethodEnum methodEnum = MethodEnum.DATA_CHAT_MIXED;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("text", text);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 成语接龙
     *
     * @param name 四字成语，核对成语的对应成语
     * @return IdiomSolitaireData
     */
    public BaseResult<IdiomSolitaireData> idiomSolitaire(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_IDIOM_SOLITAIRE;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 舔狗日记
     *
     * @return SaohuaContentData
     */
    public BaseResult<SaohuaContentData> saohuaContent() {
        MethodEnum methodEnum = MethodEnum.DATA_SAOHUA_CONTENT;
        Map<String, Object> params = new HashMap<>();
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 语音合成 阿里云语音合成（TTS）。
     *
     * @param appKey     阿里云身份识别
     * @param access     阿里云身份识别
     * @param secret     阿里云身份识别
     * @param voice      发音人[link <a href="https://help.aliyun.com/knowledge_detail/84435.html?spm=a2c4g.11186631.2.1.67045663WlpL4n">...</a>]，默认值 [Aitong]
     * @param format     编码格式，范围 [PCM] [WAV] [MP3]，默认值 [MP3]
     * @param sampleRate 采样率，默认值 [16000]
     * @param volume     音量，范围 [0～100]，默认值 [50]
     * @param speechRate 语速，范围 [-500～500]，默认值 [0]，
     * @param pitchRate  音调，范围 [-500～500]，默认值[0]。
     * @param text       合成的内容，
     * @return SoundConverterData
     */
    public BaseResult<SoundConverterData> soundConverter(String appKey, String access, String secret, String voice, String format, Long sampleRate, Integer volume, Integer speechRate, Integer pitchRate, String text) {
        MethodEnum methodEnum = MethodEnum.DATA_SOUND_CONVERTER;
        Map<String, Object> params = new HashMap<>();
        params.put("appKey", appKey);
        params.put("access", access);
        params.put("secret", secret);
        params.put("voice", voice);
        params.put("format", format);
        params.put("sample_rate", sampleRate);
        params.put("volume", volume);
        params.put("speech_rate", speechRate);
        params.put("pitch_rate", pitchRate);
        params.put("text", text);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * @see ApiService#soundConverter(String, String, String, String, String, Long, Integer, Integer, Integer, String)
     */
    public BaseResult<SoundConverterData> soundConverter(String appKey, String access, String secret, String text) {
        return soundConverter(appKey, access, secret, null, null, null, null, null, null, text);
    }

    /**
     * 腾讯音乐
     *
     * @param name 歌曲名称，查找腾讯音乐的音乐编号
     * @return MusicTencentData List
     */
    public BaseResult<List<MusicTencentData>> musicTencent(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_MUSIC_TENCENT;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);
    }

    /**
     * 网易音乐
     *
     * @param name 歌曲名称，查找网易音乐的音乐编号。
     * @return MusicNeteaseData List
     */
    public BaseResult<List<MusicNeteaseData>> musicNetease(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_MUSIC_NETEASE;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 酷狗音乐
     *
     * @param name 歌曲名称，查找酷狗音乐的音乐编号。
     * @return MusicKugouData List
     */
    public BaseResult<List<MusicKugouData>> musicKugou(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_MUSIC_KUGOU;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 骗子记录
     *
     * @param uin 用户QQ号，查找是否存在行骗记录；
     * @return FraudDetailData List
     */
    public BaseResult<List<FraudDetailData>> fraudDetail(Long uin) {
        MethodEnum methodEnum = MethodEnum.DATA_FRAUD_DETAIL;
        Map<String, Object> params = new HashMap<>();
        params.put("uin", uin);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 挂件效果
     * 查询挂件的效果以及获取方式。
     *
     * @param name 指定挂件名称，查找目标挂件的相关信息；
     * @return TableRecordsData List
     */
    public BaseResult<List<TableRecordsData>> tableRecords(String name) {
        MethodEnum methodEnum = MethodEnum.DATA_TABLE_RECORDS;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 未出奇遇
     *
     * @param name   指定角色名称，查找目标角色的相关信息；
     * @param server 指定目标区服，查找目标区服的相关信息；
     * @param ticket 推栏标识，检查并奇遇的完整性
     * @return LuckUnfinishedData List
     */
    public BaseResult<List<LuckUnfinishedData>> luckUnfinished(String server, String name, String ticket) {
        MethodEnum methodEnum = MethodEnum.DATA_LUCK_UNFINISHED;
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("server", server);
        params.put("ticket", ticket);
        RequestResult requestResult = doPostRequest(methodEnum.getMethodPath(), params);
        return getResultRealData(requestResult, methodEnum);

    }

    /**
     * 执行post请求
     *
     * @param path   请求地址
     * @param params 使用的参数
     * @return 返回内容
     */
    public RequestResult doPostRequest(String path, Map<String, Object> params) {
        params.put("token", apiProperties.getApiToken());
        logger.info("请求接口=>{},参数=>{}", path, params);
        Mono<RequestResult> mono = this.webClient.method(HttpMethod.POST)
                .uri(uriBuilder -> uriBuilder.path(path).build())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).bodyValue(params).retrieve().bodyToMono(RequestResult.class);
        return mono.block();
    }

    /**
     * 获取序列化后的返回值
     *
     * @param requestResult 返回值信息
     * @param methodEnum    请求枚举
     * @return 序列化后的返回值，根据 MethodEnum.resultBeanClass 进行序列化
     */
    public <T> BaseResult<T> getResultRealData(RequestResult requestResult, MethodEnum methodEnum) {
        if (requestResult == null) {
            logger.error("返回值不为空，请求名称=>{},请求地址=>{},返回值信息=>{}", methodEnum.getMethodName(), methodEnum.getMethodPath(), requestResult);
            BaseResult baseResult = new BaseResult();
            baseResult.setCode(500);
            baseResult.setMsg("服务器返回值为空");
            return baseResult;
        }
        if (HttpStatus.OK.value() != requestResult.getCode()) {
            logger.error("返回值不成功，请求名称=>{},请求地址=>{},返回值信息=>{}", methodEnum.getMethodName(), methodEnum.getMethodPath(), requestResult);
            BaseResult baseResult = new BaseResult();
            baseResult.setCode(requestResult.getCode());
            baseResult.setMsg(requestResult.getMsg());
            return baseResult;
        }
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(requestResult.getCode());
        baseResult.setMsg(requestResult.getMsg());
        // 根据枚举优先判断pClass类型，区分主体对象是不是List
        if (List.class.isAssignableFrom(methodEnum.getpClass())) {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType listType = typeFactory.constructCollectionType(List.class, methodEnum.getResultBeanClass());
            try {
                List<T> result = null;
                if (methodEnum.getJsonKey() == null) {
                    result = objectMapper.readValue(objectMapper.writeValueAsString(requestResult.getData()), listType);
                } else {
                    result = objectMapper.readValue(((Map<String, String>) requestResult.getData()).get(methodEnum.getJsonKey()), listType);
                }
                baseResult.setData(result);
            } catch (JsonProcessingException e) {
                logger.error("序列化参数时，出现异常，请求参数=>{}", requestResult.getData(), e);
                // 不想给调用方加thr了，换个runtime抛出去把
                throw new RuntimeException("序列化参数时，出现异常");
            }
        } else {
            if (methodEnum.getJsonKey() == null) {
                baseResult.setData(objectMapper.convertValue(requestResult.getData(), methodEnum.getResultBeanClass()));
            } else {
                baseResult.setData(objectMapper.convertValue(((Map<String, String>) requestResult.getData()).get(methodEnum.getJsonKey()), methodEnum.getResultBeanClass()));
            }
        }
        return baseResult;
    }


}

