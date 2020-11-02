package com.tanyiqu.util;

import org.junit.Test;

import java.util.UUID;

public class IDUtil {

    public static String getUUid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Test
    public void testGetUUid(){
        System.out.println(IDUtil.getUUid());
        System.out.println(IDUtil.getUUid());
        System.out.println(IDUtil.getUUid());
        System.out.println(IDUtil.getUUid());
    }

}
