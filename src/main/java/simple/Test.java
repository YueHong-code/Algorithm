/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package simple;/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huangyuehong01
 * @since 2021-07-13
 */
public class Test {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(6);

        list = list.subList(0, 6);
        System.out.println(list);



    }

    private void date() {
        Date lastUpdateTime = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2021-07-01 00:00:00").toDate();


        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        String dateS = formatter.print(new DateTime(lastUpdateTime));

        System.out.println(dateS);
    }

}
