package com.example.beerbar_webapp.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    CommandResult execute (HttpServletRequest request);

}
