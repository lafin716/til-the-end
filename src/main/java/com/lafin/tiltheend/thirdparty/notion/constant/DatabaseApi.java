package com.lafin.tiltheend.thirdparty.notion.constant;

public class DatabaseApi {
    private static final String BASE_PATH = "/databases";
    public static final String RETRIEVE = BASE_PATH+"/{databaseId}";
    public static final String QUERY = BASE_PATH+"/{databaseId}/query";
    public static final String LIST = BASE_PATH+"/{databaseId}/query";
}
