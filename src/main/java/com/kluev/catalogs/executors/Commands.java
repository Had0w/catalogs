package com.kluev.catalogs.executors;

public enum Commands {
    ADD("Добавление"),
    EDIT("Изменение"),
    DELETE("Удаление");

    private final String commandName;

    Commands(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
