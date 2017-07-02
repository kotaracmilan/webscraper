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
public class CssSelector {

    String path;
    String name;
    
    public CssSelector(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
