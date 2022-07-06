package com.example.beerbar_webapp.util;

import lombok.experimental.UtilityClass;

import java.util.ResourceBundle;

@UtilityClass
public class PageManager {
    private final ResourceBundle bundle = ResourceBundle.getBundle("pages");

    public String getPageURL(String key){
    return bundle.getString(key);
    }
}
