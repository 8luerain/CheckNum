package test.bluerain.youku.com.checknum.imp;

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
public class UberCheck {
    public static final String URL = "https://get.uber.com.cn/validate_field/";

    public static void doRequset(final String phoneNum, final UberCheck.Callback uberCallback) {
        OkHttpClient client = new OkHttpClient();
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        formEncodingBuilder.add("field", "mobile");
        formEncodingBuilder.add("mobile", phoneNum);
        formEncodingBuilder.add("mobile_country_iso2", "CN");

        Request request = new Request.Builder().url(URL).post(formEncodingBuilder.build()).build();
        client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                uberCallback.onFailed(request.body().toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String responseString = response.body().string();
                if (null != responseString) {
                    if (responseString.contains("406")) {
                        uberCallback.onSuccess(phoneNum);

                    } else {
                        uberCallback.onFailed(responseString);
                    }

                } else {
                    uberCallback.onFailed("没有获得返回值");
                }
            }
        });
    }

    public interface Callback {
        void onSuccess(String phoneNum);

        void onFailed(String err);
    }
}
