package com.example.beerbar_webapp.command;

import lombok.Data;
public class CommandResult {

    private String page;
    private NavigationType type;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public NavigationType getType() {
        return type;
    }

    public void setType(NavigationType type) {
        this.type = type;
    }
}
