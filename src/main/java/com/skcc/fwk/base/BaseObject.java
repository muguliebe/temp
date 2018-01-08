package com.skcc.fwk.base;

import com.skcc.fwk.entity.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@SuppressWarnings("SpringJavaAutowiringInspection")
public abstract class BaseObject {

    @Autowired
    protected ApplicationContext context;

    @Autowired
    protected Commons commons;
}
