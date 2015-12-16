package com.shenny.test.util;


public final class Constants {

	// =================================================
	// Class Variables
	// =================================================

	public static final String UTF8 = "UTF-8";

	// httpConnection Configuration
	public static final int CONNECTION_TIMEOUT = 15000;
	public static final int CONNECTION_SO_TIMEOUT = 15000;
	public static final int RETRY_ATTEMPTS = 0;

	// response format
	public static final String FORMAT_XML = "xml";
	public static final String FORMAT_JSON = "json";

	// split character
	public static final String SPLIT_CHARACTER = ",";
	public static final String OPEN_BRACE = "(";
	public static final String CLOSE_BRACE = ")";
	public static final String OPEN_SQUARE_BRACKET = "[";
	public static final String CLOSE_SQUARE_BRACKET = "]";

	// topic Type
	public static final int OFFICIAL = 1;
	public static final int UNOFFICIAL = 0;
	public static final int KNOWLEDGE_BOOKMARK = 2;

	// Active level
	public static final int ACTIVE_LEVEL0 = 0;
	public static final int ACTIVE_LEVEL1 = 1;
	public static final int ACTIVE_LEVEL2 = 2;
	public static final int ACTIVE_LEVEL3 = 3;
	public static final int ACTIVE_LEVEL4 = 4;
	public static final int ACTIVE_LEVEL5 = 5;
	public static final int ACTIVE_LEVEL6 = 6;
	public static final int ACTIVE_LEVEL7 = 7;
	
	// report type
	public static final int REPORT_TYPE_DAILY_NEW_USER = 1;
	public static final int REPORT_TYPE_DAILY_ACTIVE_USER = 2;
	public static final int REPORT_TYPE_MONTHLY_NEW_USER = 3;
	public static final int REPORT_TYPE_MONTHLY_NEW_KNOWLEDGE = 4;
	public static final int REPORT_TYPE_MONTHLY_NEW_POST = 5;
	
	//postType
	public static final String MY_POST = "myPost";
	public static final String MY_REPLY = "myReply";
	
	//display default number 
	public static final int DEFAULT_DISPLAY_ITEM_NUM = 500;
	
	//
	public static final String SECRETKEY = "communityApp";
	
	//
	public static final String GET_NICKNAME_URL = "http://10.155.1.3/HaierServer/user/getUserdata/getUserNickname";
	//
	public static final String GET_NICKNAME_TOKEN = "MWI0YmUyNzctNmY1ZC00MmFiLTgyNzQtOTUxHJghhjghjGY63";
	
	// point
	public static final int REGISTER_POINT = 10;//注册10积分
	public static final int LOGIN_POINT = 5;//每日登录5积分
	public static final int POST_POINT = 3;//发帖成功3积分前5
	public static final int LIKE_POINT = 1;//帖子点赞1积分
	public static final int USERNAME_POINT=10;//完善信息获得相应积分
	public static final int NICKNAME_POINT=10;
	public static final int GENDER_POINT=10;
	public static final int TEL_POINT=10;
	public static final int EMAIL_POINT=20;
	public static final int CITY_POINT=20;
	public static final int BIRTHDAY_POINT=20;
	public static final int REPLY_QUESTION_POINT=5;
	
	public static final int S24_SECONDS_ANSWER_TOPIC_ID = 2572;
	
	
	public static final String USER_KEY = "loginUser";
	
	public static final int USER_MaxInactiveInterval = 3*60*60;
	public static final int MSG_MaxInactiveInterval = 3*60;
	public static final String CTIVITY_USER_ID = "activityUserId";
	
	public static final String QUICKREGISTER_TOKEN = "74c8b8d2e316f65db9e0eea7ada040a5";
	public static final String QUICKREGISTER_CHANNEL = "HaierService";
	public static final String QUICKREGISTER_SOURCE = "callcenter";
	public static final String QUICKREGISTER_ACTIVE = "DHZX_"+"callcenter";
	
	public static final String YES = "Y";
	public static final String NO = "N";
	
	//积分类型
	public static final String REGISTER_POINT_TYPE = "5";//5为注册
	public static final String  LOGIN_POINT_TYPE = "4";//4表示登录
	public static final String POST_POINT_TYPE = "1";//发帖类型是1
	public static final String LIKE_POINT_TYPE = "2";//2表示点赞
	public static final String REPLY_POINT_TYPE = "3";//3表示点赞
	public static final int REPLY_POINT = 0;//回复没有积分
	public static final String INFO_POINT_TYPE="6";//6表示完善信息获取积分
	public static final String REPLY_QUESTION_TYPE="7";//7回答“我要提问”
	
	public static final String DEFAULT_PASSWORD = "222222";
	
	//短信发送类型
	public static final int SMS_DEFAULT_TYPE = 15;
	
	//【我要提问】话题ID
	public static final String TOPIC_ID_OF_QUESTION="3368";
	
	//【测水质】话题ID
	public static final String TOPIC_ID_OF_WATER="5146";
	
	//测水质话题名称
	public static final String TOPIC_NAME_OF_WATER="五湖四海聊水质";
	
	public static final String MSG_OF_WATER="小海提醒：有海粉关注您的水质检测结果，快去认识一下吧。";
	
	public static final String MSG_OF_QUESTION="拇指哥提醒：您在拇指帮微社区的提问，已有人解答，快快前去查看吧。";
	
	//微信消息推送
	public static final String MSG_BY_WX_URL="http://10.155.1.3/HaierServer/groupSend/sendMsg/sendMsgByCustomForOthers";
	
	public static final String MSG_BY_WX_TOKEN="MWI0YmUyNzctNmY1ZC00MmFiLTgyNzQtOTUxHJghhjghjGY63";
	
	public static final long MILLISECOND_OF_DAY=1000*3600*24;
	
	public static final String[] SERVER_STATUS_REMIND_PHONE={"18669418671","18500132370"};
	
	public static final String BIGDATA_REMIND_PHONE="18500132370";
	
	public static final String SERVER_STATUS_REMIND_URL="http://10.155.1.151:8080/communityApp/getServerStatus.json";

}
