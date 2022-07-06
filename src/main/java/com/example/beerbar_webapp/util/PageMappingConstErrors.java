package com.example.beerbar_webapp.util;

public enum PageMappingConstErrors {
    EDIT_ERROR("page.editError"),
    PASSWORD_ERROR("page.password_edit_error");


    private String key;

    PageMappingConstErrors(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
