package com.zxin.louvre.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.zxin.louvre.facade.LouvreFacade;

@Service(version = "1.0.0")
public class LouvreFacadeImpl implements LouvreFacade {

    private static final Logger logger = LoggerFactory.getLogger(LouvreFacadeImpl.class);

    @Override
    public String get() {
        logger.info("louvre get ..");
        return "louvre";
    }
    
}
