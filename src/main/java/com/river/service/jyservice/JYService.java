package com.river.service.jyservice;

import com.river.entity.JY;
import com.river.service.JyService;
import com.sun.tools.internal.ws.wsdl.document.http.HTTPOperation;
import javafx.beans.binding.When;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/9.
 */
@Service
public class JYService {

    @Autowired
    private JyService jyService;
    public Connection.Response getDocument(int page) {
        Document document = null;
        Connection.Response response = null;
        Map<String, String> params = new HashMap<>();
        params.put("sex", "f");
        params.put("stc", "2:22.28,3:160.0");
        params.put("sn", "default");
        params.put("sv", "1");
        params.put("p", String.valueOf(page));
        params.put("f", "select");
        params.put("listStyle", "bigPhoto");
        params.put("pri_uid", "169132239");
        params.put("jsversion", "v5");
        try {
            response = Jsoup.connect("http://search.jiayuan.com/v2/search_v2.php").data(params)
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8")
                    .header("Cache-Control", "max-age=0")
                    .header("Connection", "Connection")
                    .header("Host", "search.jiayuan.com")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("Cookie", "guider_quick_search=on; SESSION_HASH=a0ff282e5940b2417d79326eb5fbc61b52a3830d; user_access=1; save_jy_login_name=13246833110; sl_jumper=%26cou%3D17; last_login_time=1507724893; upt=Nbn1FvzB%2AalgyaN1dV1FH%2AFKDUVRgrjDvpw8oZL1wR9oz-5Zdp5avk5SqiLt%2AesJNV5kx8iqlvAaf7KJnyNF; user_attr=000000; pclog=%7B%22169132239%22%3A%221507724887398%7C1%7C0%22%7D; PHPSESSID=f25f43ec801a3171f58c5156ae4628e7; stadate1=168132239; myloc=44%7C4401; myage=24; PROFILE=169132239%3AJackieRiver%3Am%3Aat1.jyimg.com%2F07%2F07%2F814b6e985f42b25396e91d18baa3%3A1%3A%3A1%3A814b6e985_1_avatar_p.jpg%3A1%3A1%3A80%3A10; mysex=m; myuid=168132239; myincome=40; mylevel=2; main_search:169132239=%7C%7C%7C00; RAW_HASH=MHvmu3CERiwGnIvb-4J0SG5aLPYYEU2pJjDbHE0z-3M69JRrnfrlWZ1xPVtpQtrGX81AXN-Scoan1lvIajPetsqd9cE6GW8PydQHr%2A8SCP0-qKc.; COMMON_HASH=07814b6e985f42b25396e91d18baa307; pop_time=1507725646392; IM_CS=1; IM_ID=9; IM_CON=%7B%22IM_TM%22%3A1507725728614%2C%22IM_SN%22%3A8%7D; IM_S=%7B%22IM_CID%22%3A1669534%2C%22IM_SV%22%3A%22123.59.161.3%22%2C%22svc%22%3A%7B%22code%22%3A0%2C%22nps%22%3A0%2C%22unread_count%22%3A%220%22%2C%22ocu%22%3A0%2C%22ppc%22%3A0%2C%22jpc%22%3A0%2C%22regt%22%3A%221507114996%22%2C%22using%22%3A%22115%2C40%2C%22%2C%22user_type%22%3A%2210%22%2C%22uid%22%3A169132239%7D%2C%22m%22%3A0%2C%22f%22%3A0%2C%22omc%22%3A0%7D; is_searchv2=1; IM_M=%5B%5D; IM_TK=1507725745294").execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    //得到当前页的所有用户url
    public List<String> getUserUrls(Document document) {
        List<String> userUrlList = new ArrayList<>();
        for (int page = 2; page < 10000; page++) {
            Elements prePageItems = document.select("fixed_heigh search_userHead a.openBox os_stat");
            for (Element element : prePageItems) {
                String href = element.attr("href");
                userUrlList.add(href);
            }
        }
        return userUrlList;
    }

    //翻页方法
    public void nextPage(int page) {
        String prenextPageUrl = "http://search.jiayuan.com/v2/index.php?sex=f&key=&stc=2%3A22.28%2C3%3A160.0&sn=default&sv=1&p=";
        String fixnextPageUrl = "&f=select&listStyle=bigPhoto&pri_uid=169132239&jsversion=v5";
    }

    public void test() {
        for (int page = 1; page < 10000; page++) {
            try {
                String body = getDocument(page).body();
                JY jy = new JY();
                jy.setInfo(body);

                if (page%500 ==0){
                    Thread.sleep(5000);
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        jyService.insert(jy);
                    }
                }).start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
