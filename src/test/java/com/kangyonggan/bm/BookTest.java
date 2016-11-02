package com.kangyonggan.bm;

import com.kangyonggan.bm.util.BookHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kangyonggan
 * @since 2016/11/1
 */
public class BookTest extends BaseTestCase {

    @Test
    public void testParseBook() {
        Assert.assertTrue(BookHelper.parse("ntxs"));
    }

}
