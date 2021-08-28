package com.kluev.catalogs.servises;

/**
 * Сервис парсит полученную строку, определяя таблицу, команду и Json
 */
public class RequestService {
    public static String[] parseRequest(String str) {
        String[] operations = str.split(" ", 3);
        operations[1] = operations[1].substring(0, operations[1].length() - 1);
        return operations;
    }
}
