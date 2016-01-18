package test.bluerain.youku.com.checknum.imp;

import test.bluerain.youku.com.checknum.api.PingtaiApi;

/**
 * Project: CheckNum.
 * Data: 2016/1/18.
 * Created by 8luerain.
 * Contact:<a href="mailto:8luerain@gmail.com">Contact_me_now</a>
 */
public class Shenghua implements PingtaiApi {
    private static String TOKEN;
    public static String developerId = "1424844";
    private static final String ITEM_ZHIFUBAO = "7214"; //支付宝账户
    private static final String ITEM_ZHIFUBAO_QIYE = "7581"; //企业支付宝

    public static String getTOKEN() {
        return TOKEN;
    }

    public static void setTOKEN(String TOKEN) {
        Shenghua.TOKEN = TOKEN;
    }

    @Override
    public String getDescribe() {
        return "神话验证码";
    }

    @Override
    public String getHost() {
        return "www.shjmpt.com:9002";
    }

    @Override
    public String getUserName() {
        return this.USERNAME;
    }

    @Override
    public String getPassword() {
        return "shenhua2650122";
    }

    @Override
    public String logIn(String userName, String password) {
        //GET - GET方式调用实例：http://www.shjmpt.com:9002/pubApi/uLogin?uName=用户名&pWord=密码&Developer=开发者参数[注：请登录平台查看]
        return getHost() + "/pubApi/uLogin?" +
                "uName=" + userName + "&" +
                "pWord=" + password + "&" +
                "Developer=" + developerId;
    }

    @Override
    public String getPhoneNum(String itemId) {
        //pubApi/GetPhone?ItemId=项目ID&token=登陆token
        return getHost() + "/pubApi/GetPhone?" +
                "ItemId=" + itemId + "&" +
                "token=" + TOKEN;

    }

    @Override
    public String getCode(String num) {
        //GET - http://www.shjmpt.com:9002/pubApi/GetMessage?token=登陆token
        return getHost() + "/pubApi/GetMessage?" +
                "token=" + TOKEN;
    }

    @Override
    public String releaseNum(String num) {
        //GET - http://www.shjmpt.com:9002/pubApi/ReleasePhone?token=登陆token&phoneList=phone-itemId;phone-itemId;
        return getHost() + "/pubApi/ReleasePhone?" +
                "token=" + TOKEN+
                "phoneList="+num;
    }

    @Override
    public String addBlackList(String num) {
        //GET - http://www.shjmpt.com:9002/pubApi/AddBlack?token=登陆token&phoneList=itemId-phone,phone,phone;itemId-phone,phone;
        return getHost() + "/pubApi/AddBlack?" +
                "token=" + TOKEN+
                "phoneList="+num;
    }
}
