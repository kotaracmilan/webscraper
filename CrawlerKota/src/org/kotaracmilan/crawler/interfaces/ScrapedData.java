/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kotaracmilan.crawler.interfaces;

/**
 *
 * @author Milan
 */
public interface ScrapedData {
    public void setScrapedPair(String s1, String s2);
    public String getData(String key);
}
