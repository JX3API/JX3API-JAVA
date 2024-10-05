package jx3api.api.http;

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
import jx3api.api.http.data.luck.*;
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
import jx3api.api.http.data.role.*;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关联请求地址和对应的返回值实体类
 *
 * @author Grafie
 * @since 1.0.0
 */
public enum MethodEnum {
    /**
     * 接口详见 https://jx3api.com
     */
    /**
     * FREE API
     */
    DATA_ACTIVE_CALENDAR("活动日历", "/data/active/calendar", ActiveCurrentData.class, null, Object.class),
    DATA_ACTIVE_LIST_CALENDAR("活动日历", "/data/active/list/calendar", ActiveCalendarData.class, null, Object.class),
    DATA_ACTIVE_CELEBS("行侠事件", "/data/active/celebs", ActiveCelebritiesData.class, null, List.class),
    DATA_EXAM_ANSWER("科举试题", "/data/exam/answer", ExamAnswerData.class, null, List.class),
    DATA_HOME_FURNITURE("家园装饰", "/data/home/furniture", HomeFurnitureData.class, null, Object.class),
    DATA_HOME_TRAVEL("器物图谱", "/data/home/travel", HomeTravelData.class, null, List.class),
    DATA_WEB_NEWS_ALLNEWS("新闻资讯", "/data/news/allnews", NewsAllNewsData.class, null, List.class),
    DATA_WEB_NEWS_ANNOUNCE("维护公告", "/data/news/announce", NewsAnnounceData.class, null, List.class),
    DATA_SERVER_MASTER("搜索区服", "/data/server/master", ServerMasterData.class, null, Object.class),
    DATA_SERVER_CHECK("开服检查", "/data/server/check", ServerCheckData.class, null, Object.class),
    DATA_SERVER_STATUS("查看状态", "/data/server/status", ServerStatusData.class, null, Object.class),
    DATA_HOME_FLOWER("鲜花价格", "/data/home/flower", Map.class, null, Object.class),

    /**
     * VIP1 API
     */
    DATA_SAVE_DETAILED("角色更新", "/data/save/detailed", SaveDetailedData.class, null, Object.class),
    DATA_ROLE_DETAILED("角色信息", "/data/role/detailed", RoleDetailedData.class, null, Object.class),
    DATA_SCHOOL_MATRIX("阵眼效果", "/data/school/matrix", SchoolMatrixData.class, null, Object.class),
    DATA_SCHOOL_FORCE("奇穴效果", "/data/school/force", SchoolForceData.class, null, List.class),
    DATA_SCHOOL_SKILL("技能效果", "/data/school/skills", SchoolSkillsData.class, null, List.class),
    DATA_TIEBA_RANDOM("八卦帖子", "/data/tieba/random", TiebaRandomData.class, null, List.class),
    DATA_ROLE_ATTRIBUTE("装备属性", "/data/role/attribute", RoleAttributeData.class, null, Object.class),
    DATA_ROLE_CDLIST("副本记录", "/data/role/teamCdList", RoleTeamCdListData.class, null, Object.class),
    DATA_LUCK_ADVENTURE("奇遇记录", "/data/luck/adventure", LuckAdventureData.class, null, List.class),
    DATA_LUCK_STATISTICAL("奇遇统计", "/data/luck/statistical", LuckStatisticalData.class, null, List.class),
    DATA_LUCK_SERVER_STATISTICAL("全服统计", "/data/luck/server/statistical", LuckServerStatisticalData.class, null, List.class),
    DATA_LUCK_COLLECT("奇遇汇总", "/data/luck/collect", LuckCollectData.class, null, List.class),
    DATA_ROLE_ACHIEVEMENT("成就百科", "/data/role/achievement", RoleAchievementData.class, null, Object.class),
    DATA_MATCH_RECENT("名剑战绩", "/data/match/recent", Map.class, null, Object.class),
    DATA_MATCH_AWESOME("名剑排行", "/data/match/awesome", MatchAwesomeData.class, null, List.class),
    DATA_MATCH_SCHOOLS("名剑统计", "/data/match/schools", MatchSchoolsData.class, null, List.class),
    DATA_MEMBER_RECRUIT("团队招募", "/data/member/recruit", MemberRecruitData.class, null, Object.class),
    DATA_MEMBER_TEACHER("师父列表", "/data/member/teacher", MemberTeacherData.class, null, Object.class),
    DATA_MEMBER_STUDENT("徒弟列表", "/data/member/student", MemberStudentData.class, null, Object.class),
    DATA_SERVER_SAND("沙盘信息", "/data/server/sand", ServerSandData.class, null, Object.class),
    DATA_SERVER_EVENT("阵营事件", "/data/server/event", ServerEventData.class, null, List.class),
    DATA_TRADE_DEMON("金币价格", "/data/trade/demon", TradeDemonData.class, null, List.class),
    DATA_TRADE_RECORD("物品价格", "/data/trade/records", TradeRecordData.class, null, Object.class),
    DATA_TIEBA_ITEM_RECORDS("贴吧记录", "/data/tieba/item/records", TiebaItemRecordsData.class, null, List.class),
    DATA_VALUABLES_STATISTICAL("掉落统计", "/data/valuables/statistical", ValuablesStatisticalData.class, null, List.class),
    DATA_VALUABLES_SERVER_STATISTICAL("全服掉落", "/data/valuables/server/statistical", ValuablesServerStatisticalData.class, null, List.class),
    DATA_SERVER_ANTIVICE("诛恶事件", "/data/server/antivice", ServerAntiviceData.class, null, List.class),
    DATA_RANK_STATISTICAL("风云榜单", "/data/rank/statistical", Map.class, null, List.class),
    DATA_RANK_SERVER_STATISTICAL("全服榜单", "/data/rank/server/statistical", Map.class, null, List.class),
    // v1.2新增
    DATA_TABLE_RECORDS("挂件效果", "/data/table/records", TableRecordsData.class, null, List.class),
    DATA_LUCK_UNFINISHED("未出奇遇", "/data/luck/unfinished", LuckUnfinishedData.class, null, List.class),

    /**
     * VIP2 API
     */
    DATA_ACTIVE_MONSTER("百战首领", "/data/active/monster", ActiveMonsterData.class, null, Object.class),
    DATA_HORSE_RECORDS("的卢统计", "/data/horse/records", HorseRecordsData.class, null, List.class),
    DATA_HORSE_EVENT("马场事件", "/data/horse/ranch", HorseRanchData.class, null, Object.class),
    DATA_WATCH_RECORD("烟花记录", "/data/firework/records", FireworkRecordData.class, null, List.class),
    DATA_WATCH_STATISTICAL("烟花统计", "/data/firework/statistical", FireworkStatisticalData.class, null, List.class),
    DATA_WATCH_COLLECT("烟花汇总", "/data/firework/collect", FireworkCollectData.class, null, List.class),
    DATA_WATCH_RANK_STATISTICAL("烟花排行", "/data/firework/rank/statistical", FireworkRankStatisticalData.class, null, List.class),
    // v1.2 新增
    DATA_ROLE_MONSTER("百战精耐", "/data/role/monster", RoleMonsterData.class, null, Object.class),
    DATA_AUCTION_RECORDS("拍卖记录", "/data/auction/records", AcutionRecordsData.class, null, List.class),
    DATA_ROLE_SHOW_CARD("角色名片", "/data/role/show/card", RoleShowCardData.class, null, Object.class),
    DATA_ROLE_SHOW_RANDOM("随机名片", "/data/role/show/random", RoleShowRandomData.class, null, Object.class),

    /**
     * VRF API
     */
    DATA_CHAT_MIXED("智障聊天", "/data/mixed/chat", ChatMixedData.class, null, Object.class),
    DATA_MUSIC_TENCENT("腾讯音乐", "/data/music/tencent", MusicTencentData.class, null, List.class),
    DATA_MUSIC_NETEASE("网易音乐", "/data/music/netease", MusicNeteaseData.class, null, List.class),
    DATA_MUSIC_KUGOU("酷狗音乐", "/data/music/kugou", MusicKugouData.class, null, List.class),
    DATA_FRAUD_DETAIL("骗子记录", "/data/fraud/detailed", FraudDetailData.class, "records", List.class),
    DATA_IDIOM_SOLITAIRE("成语接龙", "/data/idiom/solitaire", IdiomSolitaireData.class, null, Object.class),
    DATA_SAOHUA_RANDOM("撩人骚话", "/data/saohua/random", SaohuaRandomData.class, null, Object.class),
    DATA_SAOHUA_CONTENT("舔狗日记", "/data/saohua/content", SaohuaContentData.class, null, Object.class),
    DATA_SOUND_CONVERTER("语音合成", "/data/sound/converter", SoundConverterData.class, null, Object.class),
    ;
    /**
     * 请求名称
     */
    private final String methodName;
    /**
     * 请求地址
     */
    private final String methodPath;
    /**
     * 请求返回值类型
     */
    private final Class resultBeanClass;
    /**
     * 返回的json中的key
     */
    private final String jsonKey;
    /**
     * 返回值中的父级类型，比如外层包裹的是 List
     */
    private final Class pClass;

    MethodEnum(String methodName, String methodPath, Class resultBeanClass, String jsonKey, Class pClassName) {
        this.methodName = methodName;
        this.methodPath = methodPath;
        this.resultBeanClass = resultBeanClass;
        this.jsonKey = jsonKey;
        this.pClass = pClassName;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class getResultBeanClass() {
        return resultBeanClass;
    }

    public String getMethodPath() {
        return methodPath;
    }

    public String getJsonKey() {
        return jsonKey;
    }

    public Class getpClass() {
        return pClass;
    }

    public static void main(String[] args) {
        Map<String, String> pickedTimeMap = new HashMap<>();
        List<String> needCheckedList = new ArrayList<>();
        for (MethodEnum methodEnum : values()) {
            if (pickedTimeMap.containsKey(methodEnum.getMethodPath())) {
                needCheckedList
                        .add(methodEnum.getMethodPath());
            } else {
                pickedTimeMap.put(methodEnum.getMethodPath(), methodEnum.getMethodPath());
            }
        }
        if (!needCheckedList.isEmpty()) {
            System.out.println("------------------------存在重复数据，请检查------------------------");
            System.out.println(String.join(",", needCheckedList));
            System.out.println("------------------------存在重复数据，请检查------------------------");
        }
    }
}
