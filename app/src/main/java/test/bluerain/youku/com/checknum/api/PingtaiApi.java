package test.bluerain.youku.com.checknum.api;

/**
 * Project: CheckNum.
 * Data: 2016/1/18.
 * Created by 8luerain.
 * Contact:<a href="mailto:8luerain@gmail.com">Contact_me_now</a>
 */
public interface PingtaiApi {
    String USERNAME = "mxh222";

    String getDescribe();

    String getHost();

    String getUserName();

    String getPassword();

    String logIn(String userName ,String password);

    String getPhoneNum(String itemId);

    String getCode(String num);

    String releaseNum(String num);

    String addBlackList(String num);

}
