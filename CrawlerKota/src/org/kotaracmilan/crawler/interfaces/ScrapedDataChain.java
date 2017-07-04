/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kotaracmilan.crawler.interfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;

/**
 *
 * @author radni
 */
public abstract class ScrapedDataChain<T> {
    private ConcurrentMap<T,Map<String, String>> chain;
    private int count;
    
    public ScrapedDataChain() {
        chain = new ConcurrentHashMap<>();
    }
    
    public void iterate(BiConsumer bc){
        chain.forEach(bc);
    }
    
    public synchronized void push(T t){
        chain.put(t, new HashMap<>());
    }
    
    
    
}
