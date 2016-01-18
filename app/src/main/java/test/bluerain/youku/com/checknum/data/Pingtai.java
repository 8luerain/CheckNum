package test.bluerain.youku.com.checknum.data;

/**
 * Project: CheckNum.
 * Data: 2016/1/18.
 * Created by 8luerain.
 * Contact:<a href="mailto:8luerain@gmail.com">Contact_me_now</a>
 */
public enum Pingtai {
    SHENHUA("http://www.shjmpt.com:9002",
            "神话验证码",
            "mxh222",
            "shenhua2650122"),
    ;


    private String url;
    private String descriub;
    private String userName;
    private String passWord;

    Pingtai(String url, String descriub, String userName, String passWord) {
        this.url = url;
        this.descriub = descriub;
        this.userName = userName;
        this.passWord = passWord;
    }
}
