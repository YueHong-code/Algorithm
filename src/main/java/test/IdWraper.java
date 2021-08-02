/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package test;

import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;

/**
 * id包装器
 * Created by wangfen01 on 2020/5/26.
 */
public class IdWraper {
    /**
     * 当前时间
     */
    private Date currentTime;

    /**
     * 机器ip
     */
    private String address;

    /**
     * uuid
     */
    private String uuid;


    public IdWraper(Date currentTime) {
        super();
        this.currentTime = currentTime;
        try {
//            this.address = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.uuid = UUID.randomUUID().toString();
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 返回值最大长度为10位
     *
     * @return
     */
    @Override
    public int hashCode() {
        // 31是个神奇的数字，任何数n*31都可以被jvm优化为(n<<5)-n，移位和减法的操作效率比乘法的操作效率高很多！
        final int prime = 31;
        int result = 1;
        result = prime * result + ((currentTime == null) ? 0 : currentTime.hashCode());
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        if (result < 0) {
            return -result;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        IdWraper other = (IdWraper) obj;
        if (address == null) {
            if (other.address != null) {
                return false;
            }
        } else if (!address.equals(other.address)) {
            return false;
        }
        if (currentTime == null) {
            if (other.currentTime != null) {
                return false;
            }
        } else if (!currentTime.equals(other.currentTime)) {
            return false;
        }
        if (uuid == null) {
            if (other.uuid != null) {
                return false;
            }
        } else if (!uuid.equals(other.uuid)) {
            return false;
        }
        return true;
    }
}