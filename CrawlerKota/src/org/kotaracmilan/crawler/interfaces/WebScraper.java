/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kotaracmilan.crawler.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author radni
 */
public abstract class WebScraper implements Predikat{
    
    private Predmet predmet;
    private URL url;
    private Document soupPage;
    private static String userAgent;
    private static int timeout;
    private HashMap<String, String> parms;
    private HashMap<String, String> cookie;

    public WebScraper(URL u) {
    parms = new HashMap<>();
    cookie = new HashMap<>();
    this.url = u;
    }
    
    
    public abstract Predmet scrape();
    @Override
    public abstract ScrapedData work();
    @Override
    public abstract ScrapedData workOnEach();
    
    private Connection connect(){
        Connection conn = Jsoup.connect(url.toString());
        if(userAgent != null && !userAgent.equals(""))
            conn.userAgent(userAgent);
        if(!parms.isEmpty())
            conn.data(parms);
        if(!cookie.isEmpty())
            conn.cookies(cookie);
        if(timeout != 0)
            conn.timeout(timeout);
        return conn;
    }
    public void get() throws IOException{
       soupPage = connect().get();
    }
    public void post() throws IOException{
        soupPage = connect().post();
    }
    /*Search Jsoup Document elements by css selector expression
    / @param expression - jspup css selector expression
    / @return elements - Elements
    /
    */
    private Elements search(CssSelector term) throws ParsingException{
         if(soupPage == null)
             throw new ParsingException("No documents fatched");
        return soupPage.select(term.getPath());
         
    }
    /*Search Jsoup Document elements by textual value
    / @param text - text that should be contained in Elements
    / @return elements - Elements
    /
    */
    private Elements search(String text) throws ParsingException{
         if(soupPage == null)
             throw new ParsingException("No documents fatched");
        return soupPage.getElementsContainingText(text);
         
    }
    
    //geter and setter
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
