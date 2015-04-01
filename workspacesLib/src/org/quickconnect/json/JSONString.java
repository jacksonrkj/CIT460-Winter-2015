/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quickconnect.json;

import java.io.Serializable;

/**
 *
 * @author jacksonrkj
 */
public class JSONString implements Serializable {
    public String jsonString = null;

    public JSONString(String jsonString) {
        this.jsonString = jsonString;
    }

    @Override
    public String toString() {
        return this.jsonString;
    }

    
}
