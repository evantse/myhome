package com.aliabab.aliweibo.db;

public class DBInfo {

    public static class DB {

        /**
         * 数据库名称
         */
        public static final String DB_NAME = "ali_weibo.db";

        /**
         * 数据库版本
         */
        public static final int VERSION = 3;
    }

    public static class Table {
        /**
         * 表名
         */
        public static final String USER_INFO_TB_NAME = "userinfo";
        /**
         * 建表语句
         */
        public static final String USER_INFO_CREATE = "CREATE TABLE IF NOT EXISTS  "
                + USER_INFO_TB_NAME
                + " ( _id INTEGER PRIMARY KEY autoincrement,personId TEXT, nickName TEXT, token TEXT,icon BLOB)";
        /**
         * 删除表空间语句
         */
        public static final String USER_INFO_DROP = "DROP TABLE "+ USER_INFO_TB_NAME;
    }
    
}
