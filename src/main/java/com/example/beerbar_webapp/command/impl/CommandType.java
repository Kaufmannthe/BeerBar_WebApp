package com.example.beerbar_webapp.command.impl;

import com.example.beerbar_webapp.command.Command;
import com.example.beerbar_webapp.command.impl.profile_changers.UpdateProfileImpl;

public enum CommandType {
    REGISTRATION(new RegistrationCommandImpl()),
    LOGIN(new LoginCommandImpl()),
    LOGOUT(new SessionInvalidateImpl()),
    UPDATE_PROFILE(new UpdateProfileImpl());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
