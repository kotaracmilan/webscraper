/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kotaracmilan.crawler.interfaces;

/**
 *
 * @author radni
 */
public interface Predmet {
    public <T> void setData(T t);
    public <T extends Object> T getData();
    
}
