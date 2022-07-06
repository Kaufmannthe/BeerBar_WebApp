package com.example.beerbar_webapp.command.impl.profile_changers;

import com.example.beerbar_webapp.command.Command;
import com.example.beerbar_webapp.command.CommandResult;
import com.example.beerbar_webapp.command.NavigationType;
import com.example.beerbar_webapp.util.PageManager;
import com.example.beerbar_webapp.util.PageMappingConst;

import javax.servlet.http.HttpServletRequest;

public class PasswordEditorImpl implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request) {
        CommandResult commandResult = new CommandResult();
        String page;

        page = request.getContextPath() + PageManager.getPageURL(PageMappingConst.PASSWORD_UPDATE.getKey());
        commandResult.setPage(page);
        commandResult.setType(NavigationType.REDIRECT);

        return commandResult;
    }
}
