package com.example.beerbar_webapp.util;

public enum PageMappingConst {

    PAGE_REGISTRATION ("page.registration"),
    PAGE_LOGIN ("page.login"),
    PAGE_PROFILE("page.profile"),
    PAGE_SUCCESS_UPDATE("page.successUpdate"),
    PAGE_LANDING("page.landing"),
    PROFILE_EDIT("page.profileEdit"),
    PASSWORD_UPDATE("page.password_update");


    private String key;

    PageMappingConst(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
