/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package test;

import java.util.Date;
import java.util.UUID;

public class IdGenerater {

    public static String TEN_ZERO_STR = "0000000000";

    /**
     * 获取非自增分布式唯一id
     * 前8位为精确到天的显式时间,后10位为ip地址+当前时间+uuid的正数hashcode
     *
     * @return
     */
    public  Long getIdWithUnIcreasing() {
        IdWraper idWraper = new IdWraper(new Date());
        return 1000L + idWraper.hashCode();
    }

    public static void main(String[] args) {
        IdGenerater idGenerater = new IdGenerater();
        long h = idGenerater.getIdWithUnIcreasing();

        System.out.println(h);
    }
}