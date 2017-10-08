package xf.mvp.com.mvp_framework.network;

import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * 作者 :fanenqian
 * 时间：2017-10-7 11:29:19
 * okhttp3.0以后不自动保存cookies 需要手动保存
 */
public class CookiesManager implements CookieJar {
    private HashMap<String, List<Cookie>> cookiesStore = new HashMap<>();

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        cookiesStore.put(url.host(), cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return cookiesStore.get(url);
    }
}