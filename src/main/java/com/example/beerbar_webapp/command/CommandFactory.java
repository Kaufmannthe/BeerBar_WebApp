package com.example.beerbar_webapp.command;

import com.example.beerbar_webapp.command.impl.CommandType;
import lombok.experimental.UtilityClass;

import java.util.Locale;

@UtilityClass
public class CommandFactory {

    public Command defineCommand(String name) {
        return CommandType.valueOf(name.toUpperCase(Locale.ROOT)).getCommand();
    }
}
