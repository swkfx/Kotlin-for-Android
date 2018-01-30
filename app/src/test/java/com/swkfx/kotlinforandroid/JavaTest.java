package com.swkfx.kotlinforandroid;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * <pre>
 *      author : test
 *      e-mail : fangx@hyxt.com
 *      time   : 2018/1/30
 *      desc   :
 * </pre>
 */

public class JavaTest {


    @Test
    public void javaTest() throws Exception {
        String data = "2018.01.30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");

        try {
            sdf.parse(data);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof ParseException);
            // e.printStackTrace();
        }
    }
}
