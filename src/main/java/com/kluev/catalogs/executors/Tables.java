package com.kluev.catalogs.executors;

public enum Tables {
    EDUC_YEAR("EDUC_YEAR"),
    CITIZENSHIP("CITIZENSHIP"),
    SEX("SEX");

    private final String tableName;

    Tables(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
