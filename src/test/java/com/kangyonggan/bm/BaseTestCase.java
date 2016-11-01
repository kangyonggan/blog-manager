package com.kangyonggan.bm;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author kangyonggan
 * @since 2016/11/1
 */
@ContextConfiguration(locations = {"classpath:app-core.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTestCase extends AbstractJUnit4SpringContextTests {

    protected Logger log = LogManager.getLogger();

}
