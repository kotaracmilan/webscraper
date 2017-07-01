/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kotaracmilan.crawler.interfaces;

import java.net.URL;
import java.util.HashMap;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author radni
 */
public abstract class WebScraper {
    
    private Predmet predmet;
    private URL url;
    private Document soupPage;
    private static String userAgent;
    private static int timeout;
    private HashMap<String, String> parms;
    private HashMap<String, String> cookie;

    public WebScraper() {
    parms = new HashMap<>();
    cookie = new HashMap<>();
    }
    
    
    public abstract Predmet scrape();
    
    public void connect(){
        Connection conn = Jsoup.connect(url.toString()).userAgent(userAgent);
        if(!parms.isEmpty())
            conn.data(parms);
        if(!cookie.isEmpty());
            conn.cookies(cookie);
        conn.timeout(timeout);
    }
    
    public void setParm(String s1, String s2){
            parms.put(s2, s2);
    }
    public String getParm(String key){
        return parms.get(key);
    }
    
    public void setCookie(String s1, String s2){
            cookie.put(s2, s2);
    }
    public String getCookie(String key){
        return cookie.get(key);
    }

    public static String getUserAgent() {
        return userAgent;
    }

    public static void setUserAgent(String userAgent) {
        WebScraper.userAgent = userAgent;
    }

    public static int getTimeout() {
        return timeout;
    }

    public static void setTimeout(int timeout) {
        WebScraper.timeout = timeout;
    }
    
    
}
