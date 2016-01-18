package test.bluerain.youku.com.checknum.imp;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Project: CheckNum.
 * Data: 2016/1/18.
 * Created by 8luerain.
 * Contact:<a href="mailto:8luerain@gmail.com">Contact_me_now</a>
 */
public class ZhifubaoCheck {
    static String URL = "https://accounts.alipay.com/console/checkMobile.json";
    static String Tocken = "5e08e61a5da64a4da7440067d8a64405GZ00";


    public static void deRequest(final String phoneNum, final ZhifubaoCheck.CallBack callBack) {
        OkHttpClient client = new OkHttpClient();
        FormEncodingBuilder encodingBuilder = new FormEncodingBuilder();
        encodingBuilder.add("mobile", phoneNum);
        encodingBuilder.add("sp", "1-modifyMobile-fullpage");
        encodingBuilder.add("json_tk", Tocken);
        encodingBuilder.add("_input_charset", "utf-8");
        encodingBuilder.add("ctoken", "L-42BYFfWkHZsTHM");
        final Request request = new Request.Builder().url(URL).post(encodingBuilder.build()).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String responseString = response.body().string();
                if (responseString.contains("ok")) {
                    callBack.onSuccess(phoneNum);
                } else {
                    callBack.onFail(responseString);
                }
            }
        });
    }

    public interface CallBack {
        void onSuccess(String phoneNum);

        void onFail(String errString);
    }
}
