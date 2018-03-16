package com.ggcrm.util.system;

/**
 * 公共数组 - 用单例模式
 * @author PyePye
 * 2014.12.18
 */
public class CommArray {
	/** 
	 * 私有化构造方法 
	 */
	private CommArray() {} 
	/** 
     * 静态初始化器，线程安全 
     */ 
	public static final CommArray instance = new CommArray();
	
	public static CommArray getInstance(){
		return instance;  
	}

	//推送运营商
	public String[] arr_PushServiceType = {"","中国移动","中国联通","中国电信","全部"};
	//推送消息状态
	public String[] arr_PushStatus = {"排队中","发送中","发送完成","发送失败","消息被撤销","消息过期","筛选结果为空","定时任务尚未开始处理"};
	//动作类型
	public String[] arr_Action = {"","积分","信用","虚拟币"};
	//登录方式
	public String[] arr_LoginType = {"普通","QQ","微信"};
	//删除状态
	public String[] arr_Delflag = {"正常","删除"};
	//启用状态
	public String[] arr_Isuse = {"停用","启用"};
	//后台角色
	public String[] arr_RoleType = {"","普通管理员","超级管理员"};
	//反馈状态
	public String[] arr_IsReply = {"未回复","已回复"};
	//订单成交状态
	public String[] arr_Orderstatus = {"未成交","已成交"};
	//状态
	public String[] arr_YesNo = {"否", "是" };
	//状态
	public String[] arr_UserType = {"普通", "微信", "QQ" ,"系统用户"};
	
	/**
	 * 服务台取书时间 
	 * 单位：分钟 默认30分钟
	 */
	public int fetchTime=30;

	public int getFetchTime() {
		return fetchTime;
	}

	public void setFetchTime(int fetchTime) {
		this.fetchTime = fetchTime;
	}

	public String[] getArr_PushServiceType() {
		return arr_PushServiceType;
	}

	public void setArr_PushServiceType(String[] arr_PushServiceType) {
		this.arr_PushServiceType = arr_PushServiceType;
	}

	public String[] getArr_PushStatus() {
		return arr_PushStatus;
	}

	public void setArr_PushStatus(String[] arr_PushStatus) {
		this.arr_PushStatus = arr_PushStatus;
	}

	public String[] getArr_Action() {
		return arr_Action;
	}

	public void setArr_Action(String[] arr_Action) {
		this.arr_Action = arr_Action;
	}

	public String[] getArr_LoginType() {
		return arr_LoginType;
	}

	public void setArr_LoginType(String[] arr_LoginType) {
		this.arr_LoginType = arr_LoginType;
	}

	public String[] getArr_Delflag() {
		return arr_Delflag;
	}

	public void setArr_Delflag(String[] arr_Delflag) {
		this.arr_Delflag = arr_Delflag;
	}

	public String[] getArr_Isuse() {
		return arr_Isuse;
	}

	public void setArr_Isuse(String[] arr_Isuse) {
		this.arr_Isuse = arr_Isuse;
	}

	public String[] getArr_RoleType() {
		return arr_RoleType;
	}

	public void setArr_RoleType(String[] arr_RoleType) {
		this.arr_RoleType = arr_RoleType;
	}

	public String[] getArr_IsReply() {
		return arr_IsReply;
	}

	public void setArr_IsReply(String[] arr_IsReply) {
		this.arr_IsReply = arr_IsReply;
	}

	public String[] getArr_Orderstatus() {
		return arr_Orderstatus;
	}

	public void setArr_Orderstatus(String[] arr_Orderstatus) {
		this.arr_Orderstatus = arr_Orderstatus;
	}

	public String[] getArr_YesNo() {
		return arr_YesNo;
	}

	public void setArr_YesNo(String[] arr_YesNo) {
		this.arr_YesNo = arr_YesNo;
	}

	public String[] getArr_UserType() {
		return arr_UserType;
	}

	public void setArr_UserType(String[] arr_UserType) {
		this.arr_UserType = arr_UserType;
	}

	/**
	 * 管理员类型
	 *
	 */
	public static enum AdminType {
		_100("超级管理员"),
		_10("普通管理员");

		public final String name;
		AdminType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 终端类型
	 *
	 */
	public static enum DeviceType {
		Android("Android"),
		windows_pc("windows_pc"),
		iphone("iPhone OS"),
		ios("iOS"),
		H5("H5"),
		wechat("wechat");

		public final String name;
		DeviceType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 错误状态
	 * @author
	 *
	 */
	public static enum ReturnStatus {
		 _101("类型错误"),
		 _102("非法客户端访问"),
		 _103("参数错误"),
		 _104("保存失败"),
		 _105("删除失败"),
		 _106("您当前版本过低，请更新版本"),
		 _200("操作成功"),
		 _201("用户名密码不正确"),
		 _202("同一账号不能同时登入超过五个设备"),
		 _203("用户名密码错误"),
		 _204("用户未通过验证或已被锁定"),
		 _205("该用户名已被占用,请更换用户名"),
		 _206("该邮箱已被占用，请更换邮箱"),
		 _207("该手机已被占用，请更换手机号注册"),
		 _208("验证码发送失败,请重新获取"),
		 _2081("验证码发送失败"),
		 _2082("图形验证码获取失败"),
		 _2083("图形验证码校验失败"),
		 _209("验证码验证失败,请重新填写"),
		 _210("登录已失效"),
		 _211("操作失败"),
		 _212("验证码已失效"),
		 _213("手机号码填写不正确"),
		 _214("你已经收藏过了"),
		 _215("登录失败"),
		 _216("昵称已被占用"),
		 _217("手机号码为当前号码,请重新填写"),
		 _218("旧密码填写不正确"),
		 _223("邮箱填写不正确"),
		 _224("密码不能为纯数字或纯字母，且长度要大于6位"),
		 _225("手机号码已经存在"),
		 _226("昵称已存在"),
		 _227("您已报名，请重新刷新页面查看"),
		 _228("该手机号码已有绑定的微信号"),
		 _229("该手机号码已有绑定的QQ号"),
		 _230("注册成功"),
		 _231("注册失败"),
		 _301("没有查询到商品"),
		 _302("优惠不存在"),
		 _303("订单查询失败"),
		 _304("订单已失效"),
		 _305("商品已兑换"),
		 _306("还没领取优惠券"),
		 _307("支付渠道未开通"),
		 _308("支付审核中"),
		 _309("充值卡已被其他人充值"),
		 _310("您已充值过该充值卡"),
		 _311("充值卡号不存在"),
		 _312("充值密码不正确"),
		 _313("充值卡已过期"),
		 _314("没有结算记录"),
		 _315("礼品已被抢光"),
		 _316("网络繁忙,请稍后再试"),
		 _317("积分不足"),
		 _318("商品不存在或商品已下架"),
		 _319("商品库存不足"),
		 _320("活动已结束"),
		 _321("未找到活动"),
		 _322("活动已报满，下次早点来哦!"),
		 _323("存在已报名用户"),
		 _324("参与活动的手机号重复"),
		 _325("没有可取消的报名"),
		 _326("您没有取消报名权限，仅报名人可以取消"),
		 _327("您当前报名状态不符合取消报名规则，请刷新查看您的报名状态"),
		 _328("可退款的订单不存在"),
		 _329("订单金额有误"),
		 _330("您已申请过退款"),
		 _331("活动报名人数有误，请刷新页面"),
		 _332("订单信息与活动报名信息不一致"),
		 _333("已超过退款时间"),
		 _334("配书功能已关闭，请刷新页面"),
		 _335("您的付款金额小于配书服务最低限额，无法享受此优惠，请刷新页面"),
		 _336("超出申请退款次数"),
		 _401("请求参数错误"),
		 _402("已有该优惠卷,无需重复领取"),
		 _403("优惠卷已过期,不可领取"),
		 _404("优惠券已经被领完"),
		 _405("未找到书店"),
		 _501("当前没有默认地址"),
		 _601("用户未注册"),
		 _602("用户名或卡号错误"),
		 _604("会员卡已被绑定"),
		 _606("会员卡绑定失败"),
		 _603("会员过期"),
		 _701("微信支付退款失败"),
		 _702("支付宝退款失败"),
		 _703("此商品已申请过退货"),
		 _704("支付时间过期，请重新报名"),
		 _705("图片不是本人上传"),
		 _801("此地区暂时未开放,详情请咨询客服人员"),
		 _802("快递功能尚未开启,详情请咨询客服人员"),
		 _803("快递尚未发货"),
		 _804("快递已被签收"),
		 _805("快递服务与大客户服务不能同时选择，请重新选择您所需的服务");
		 public final String msg;
		ReturnStatus(String msg) {
			this.msg = msg;
		}

		public String toString() {
			return super.toString().replace("_", "");
		}
		public String getMsg() {
			return this.msg;
		}
	}

	
	/**
	 * 订单类型
	 *
	 */
	public static enum GoodsLogType {
		_ORDER("1"),
		_PRESENT("2"),
		_DISCOUNT("3");

		public final String value;
		GoodsLogType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * rsa秘钥类型
	 *
	 */
	public static enum RSAKeyType {
		_免费("free");

		public final String value;
		RSAKeyType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 用户操作日志
	 * @author debbie
	 *
	 */
	public static enum UserstatType{
		_浏览("free"),
		_下载("dowload"),
		_试读("sample"),
		_评论("comment"),
		_收藏("favorite"),
		_购买("buy");

		public final String value;
		UserstatType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 推送类型
	 *
	 */
	public static enum PushReleType {
		_焦点图(1),
		_优惠(2),
		_活动(3),
		_新闻公告(4);

		public final int value;
		PushReleType(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	/**
	 * 积分规则类型
	 */
	public static enum Creditruletype {
		_登录("login"),
		_评论("comment"),
		_签到("signin"),
		_注册("registered"),
		_兑换("change");

		public final String value;
		Creditruletype(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 重置密码发送信息类型
	 *
	 */
	public static enum SendResetPwdMsgType {
		_邮箱("4"),
		_短信("5");

		public final String value;
		SendResetPwdMsgType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 用户搜索类型
	 *
	 */
	public static enum UserSearchType {
		_用户名("username"),
		_ID("id"),
		_电子邮件("email"),
		_手机号码("phone"),
		_昵称("nickname");
		

		public final String value;
		UserSearchType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 内容推荐终端类型
	 *
	 */
	public static enum ContentDeviceType {
		_windows_pc("PC门户"),
		_phone("Phone_2C端"),
		_H5("H5");

		public final String name;
		ContentDeviceType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			String value = super.toString();
			value = value.substring(1, value.length());
			return value;
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 广告链接类型
	 *
	 */
	public static enum AdLinkType {
		_sysnews("资讯详情"),
		_ebook("书籍详情"),
		_thirdpage("第三方网页"),
		_theme("主题首页"),
		_top("榜单");

		public final String name;
		AdLinkType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 关于广购文章类型
	 *
	 */
	public static enum AboutType {
		_about("关于"),
		_parking("停车指南"),
		_pickupgoods("书单提货指南");

		public final String name;
		AboutType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 订单类型
	 *
	 */
	public static enum OrderType {
		_购买("buy"),
		_赠送("give"),
		_促销赠送("promotions"),
		_注册赠送("reggive"),
		_定价包("dj"),
		_折扣包("zk"),
		_微信渠道赠送("wechatgive"),
		_月租("yz"),
		_包月("by"),
		_赠书卡("giftcard"),
		_2B购买("enterprise");

		public final String value;
		OrderType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 购买类型
	 *
	 */
	public static enum BuyType {
		_0("购买"), 
		_promotions("促销赠送"), 
		_by("包月"),
		_bypackage("包月套餐"),
		_30("月租"), 
		_reg("注册赠送"),
		_package("定价包"),
		_discountpackage("折扣包"),
		_wechatreg("微信渠道赠送"),
		_giftcard("赠书卡赠送"),
		_2B("2B购买");

		public final String name;
		BuyType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 系统信息类型
	 *
	 */
	public static enum SystemInfoType {
		_about("关于"),
		_imageinfo("图文消息");

		public final String name;
		SystemInfoType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 焦点图文章类型
	 *
	 */
	public static enum BannerType {
		_content("信息发布"),
		_apply("报名"),
		_preferential("优惠"),
		_realdiscount("实体优惠卷"),
		_thirdpage("第三方网页");

		public final String name;
		BannerType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 活动回顾链接类型
	 * @author Administrator
	 *
	 */
	public static enum ActivityReviewLinkType {
		_content("信息发布"),
		_thirdpage("第三方网页");

		public final String name;
		ActivityReviewLinkType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 回顾类型
	 * @author Administrator
	 *
	 */
	public static enum ActivityReviewType {
		_activityreview("活动回顾"),
		_sellerbook("书榜");

		public final String name;
		ActivityReviewType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 新闻信息类型
	 * @author Administrator
	 *
	 */
	public static enum NewsInfoType {
		_imageinfo("信息发布"),
		_thirdpage("第三方网页");

		public final String name;
		NewsInfoType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 活动类型
	 *
	 */
	public static enum ActivityType {
		_apply("报名"),
		_preferential("优惠");

		public final String name;
		ActivityType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 动作类型
	 */
	public static enum Actiontype {
		_login("登录");

		public final String value;
		Actiontype(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 用户收藏类型
	 */
	public static enum UserFavType {
		_活动("activity"),
		_优惠("preferential"),
		_名店("bookshop"),
		_资讯("info");

		public final String value;
		UserFavType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 焦点图跳转url类型
	 */
	public static enum JumpType {
		_活动("openItem://activitydetail?id="),
		_优惠("openItem://discountdetail?id="),
		_实体优惠("openItem://realdiscountdetail?id="),
		_自定义图文("openItem://imageinfo?id="),
		_新闻公告("openItem://newsinfo?id="),
		_活动回顾图文("openItem://activityimageinfo?id="),
		_书城名店("openItem://bookstoredetail?id=");

		public final String value;
		JumpType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 用户字典类型
	 */
	public static enum UserDictionaryType {
		_性别("sex"),
		_学历("education"),
		_职业("professional"),
		_收入("income"),
		_婚姻状况("marriage");

		public final String value;
		UserDictionaryType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 订单状态
	 */
	public static enum OrderStatus {
		_已取消(-1),
		_未支付(0),
		_已支付(1),
		_已完成(2),
		_已退款(3);

		public final int value;
		OrderStatus(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	
	/**
	 * 订单相关时间
	 */
	public static enum SystemOrderTime {
		_领书等待时间(30),
		_订单失效时间(24);

		public final int value;
		SystemOrderTime(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	/**
	 * 支付类型
	 */
	public static enum PayType {
		_order("订单支付"),
		_activity("活动支付");

		public final String value;
		PayType(String value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public String getValue() {
			return this.value;
		}
	}
	
	/**
	 * 系统资讯类型
	 *
	 */
	public static enum StstemMsgType {
		_scan("扫码购"),
		_service("线上购"),
		_self("自助取书流程"),
		_user("用户协议"),
		_score("积分商城"),
		_aftersales("售后服务");

		public final String name;
		StstemMsgType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 广告图分辨率
	 */
	public static enum ScreenResolution {
		_qHD(540),
		_HD(720),
		_FHD(1080),
		_QHD(1440);

		public final int name;
		ScreenResolution(int name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public int getName() {
			return this.name;
		}
	}
	
	/**
	 * APP启动图类型
	 *
	 */
	public static enum AppStartImageType {
		_ad("APP广告图片"),
		_start("APP启动图片"),
		_bootpage("APP引导页图片");
		
		public final String name;
		AppStartImageType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 支付方式
	 */
	public static enum PaymentType {
		_支付宝(1),
		_微信支付(2);
		
		public final int name;
		PaymentType(int name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public int getName() {
			return this.name;
		}
	}
	
	/**
	 * 支付方式支付状态
	 */
	public static enum PayStatus {
		_未支付(0),
		_已支付(1);
		
		public final int name;
		PayStatus(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 积分商品兑换状态
	 */
	public static enum ScorelogStatus {
		_待领取(0),
		_确认收货(1),
		_已领取(2);
		
		public final int name;
		ScorelogStatus(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	
	/**
	 * 积分商品领取放式
	 */
	public static enum ScorelogPostage {
		_现场领取(0),
		_邮费到付(1);
		
		public final int name;
		ScorelogPostage(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 分享链接
	 */
	public static enum ShareUrl {
		_活动("/mobile/activityDetail.html?id="),
		_优惠("/mobile/discountDetail.html?id="),
		_实体优惠("/mobile/realdiscountDetail.html?id="),
		_新闻("/mobile/newDetail.html?id=");
		
		public final String name;
		ShareUrl(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	
	/**
	 * 优惠券状态
	 */
	public static enum DiscountCodeStatus {
		_未使用(0),
		_已使用(1),
		_已过期(2);
		
		public final int name;
		DiscountCodeStatus(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	/**
	 * 优惠卷类型
	 */
	public static enum DiscountCodeType {
		_普通优惠卷(0),
		_实体优惠卷(1);
		
		public final int name;
		DiscountCodeType(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 提书方式
	 */
	public static enum GetBookType {
		_全部隐藏(-1),
		_全部显示(0),
		_隐藏自助取书(1),
		_隐藏服务台取书(2);
		
		public final int name;
		GetBookType(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 后台提书方式显示
	 */
	public static enum GetadminBookType {
		_自助取书(1),
		_服务台取书(2),
		_快递配书(3);
		
		public final int name;
		GetadminBookType(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 动态配置
	 */
	public static enum DynamicConfig {
		_取书等待时间("waitingtime"),
		_隐藏取书类型("getbooktype");
		
		public final String name;
		DynamicConfig(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 第三方登录类型
	 */
	public static enum ThirdLoginType {
		_qq(1),
		_wechat(2);
		
		public final int name;
		ThirdLoginType(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 个人活动状态
	 *
	 */
	public static enum PersonActivityStatus {
		_未审核(0),
		_审核通过(1),
		_审核不通过(2);

		public final int name;
		PersonActivityStatus(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 渠道类型
	 * @author Administrator
	 *
	 */
	public static enum ChannelType {
		_App(1),
		_晴川(2),
		_gg1994(3),
		_微店(4);

		public final int value;
		ChannelType(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	/**
	 * 图库图片所属类型
	 * @author Administrator
	 *
	 */
	public static enum ImageDepotType {
		_积分商品图片("scoreshop"),
		_活动图片("activity");
		
		public final String name;
		ImageDepotType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 商品退货类型
	 */
	public static enum GoodsRefundType {
		_订单("order"),
		_商品("goods"),
		_优惠订单("discountorder"),
		_活动商品("activitygoods"),
		_活动订单("activityorder");
		
		public final String name;
		GoodsRefundType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 退货状态
	 */
	public static enum RefundStatus {
		_退货申请("0"),
		_已退货("1"),
		_已退款("2");
		
		public final String name;
		RefundStatus(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 订单退货状态
	 */
	public static enum OrderRefundStatus {
		_没退货(0),
		_已申请退货(1),
		_完成退货(2);
		
		public final int name;
		OrderRefundStatus(int name) {
			this.name = name;
		}
		
		public int getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 帖子状态
	 * @author 
	 *
	 */
	public static enum NotesStatus {
		_启用(0),
		_禁用(1);

		public final int value;
		NotesStatus(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	/**
	 * 优惠类型
	 * @author 
	 *
	 */
	public static enum DiscountType {
		_图书(0),
		_有料(1),
		_商户(2);

		public final int value;
		DiscountType(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	/**
	 * 关键字类型
	 */
	public static enum KeywordsType {
		_系统关键字("system");
		
		public final String name;
		KeywordsType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 晴川积分同步类型
	 */
	public static enum QcMemberScoreRecType {
		_消费("零售记录"),
		_兑换("兑换积分"),
		_赠送("赠送积分");
		
		public final String name;
		QcMemberScoreRecType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 系统配置
	 */
	public static enum SystemConfig {
		_取书方式("getbooktype"),
		_等待时间("waitingtime"),
		_最小会员卡号("mincardno"),
		_最大会员卡号("maxcardno"),
		_活动评论回复数("activityreplynum"),
		_省内邮费("snpostage"),
		_省外邮费("swpostage"),
		_免邮价格("nopostage"),
		_服务台取书价格("selfbookprice");
		
		public final String name;
		SystemConfig(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 退款申请类型
	 */
	public static enum ApplyForType {
		_APP("1"),
		_管理员("2");
		
		public final String name;
		ApplyForType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 支付宝支付状态
	 */
	public static enum AlipayQueryType {
		_等待买家付款("WAIT_BUYER_PAY"),
		_未付款交易超时关闭或支付完成后全额退款("TRADE_CLOSED"),
		_交易支付成功("TRADE_SUCCESS"),
		_交易结束不可退款("TRADE_FINISHED");
		
		public final String name;
		AlipayQueryType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	/**
	 * 微信支付支付状态
	 */
	public static enum WechatpayQueryType {
		_支付成功("SUCCESS"),
		_转入退款("REFUND"),
		_未支付("NOTPAY"),
		_已关闭("CLOSED"),
		_已撤销("REVOKED"),
		_用户支付中("USERPAYING"),
		_支付失败("PAYERROR");
		
		public final String name;
		WechatpayQueryType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return this.name;
		}
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
	}
	
	
	/**
	 * 活动报名状态
	 */
	public static enum ActivityApplyStatus {
		_已取消(0),
		_已报名(1),
		_报名成功(2),
		_已签到(3);

		public final int value;
		ActivityApplyStatus(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	/**
	 * 取消报名类型
	 */
	public static enum CancelActivityApplyType {
		_activity("取消活动报名"),
		_apply("取消活动单个报名");
		public final String name;
		CancelActivityApplyType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 活动退款状态
	 */
	public static enum ActivityApplyRefundmark {
		_未申请(0),
		_审核中(1),
		_已退款(2),
		_审核未通过(3);

		public final int value;
		ActivityApplyRefundmark(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	
	/**
	 * 系统资讯类型
	 *
	 */
	public static enum AppMsgType {
		_checkoutprompt("收银台提示"),
		_scanprompt("扫码购提示"),
		_memberboosprompt("会员配书提示"),
		_packbooksmsmsg("会员配书时短信"),
		_packbooksmsmsg1("会员配书完成时短信"),
		_freightsmsmsg("快递发货时短信");

		public final String name;
		AppMsgType(String name) {
			this.name = name;
		}
		
		public String getValue() {
			return super.toString().replace("_", "").toString();
		}
		public String getName() {
			return this.name;
		}
	}
	
	/**
	 * 服务台取书（会员配书）状态
	 * @author Administrator
	 *
	 */
	public static enum DeskOrderStatus {
		_待配书(0),
		_配书中(1),
		_待领取(2),
		_已领取(3);
		public final int value;
		DeskOrderStatus(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	/**
	 * 快递状态
	 */
	public static enum FreightStatus {
		_待发货(0),
		_已发货(1),
		_已签收(2),
		_申请退款(3),
		_退款通过(4),
		_线下处理(5);

		public final int value;
		FreightStatus(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
	/**
	 * 快递退款类型
	 */
	public static enum RefundFreightType {
		_整单退含运费(1),
		_整单退不含运费(2),
		_单个退含运费(3),
		_单个退不含运费(4);

		public final int value;
		RefundFreightType(int value) {
			this.value = value;
		}
		
		public String getName() {
			return super.toString().replace("_", "").toString();
		}
		public int getValue() {
			return this.value;
		}
	}
	
}
