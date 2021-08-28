package com.kluev.catalogs.executors;

public interface Executor {
    void execute(String command, String json);

    Object deserialization(String json);
}
