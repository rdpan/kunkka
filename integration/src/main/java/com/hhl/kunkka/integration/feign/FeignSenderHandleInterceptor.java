package com.hhl.kunkka.integration.feign;

import com.hhl.kunkka.common.constants.ClientConstant;
import com.hhl.kunkka.core.context.RootContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeignSenderHandleInterceptor implements RequestInterceptor {

    protected static final Logger logger = LoggerFactory.getLogger(FeignSenderHandleInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (RootContext.getXID() != null) {
            requestTemplate.header(ClientConstant.KEY_XID, RootContext.getXID());
        }
    }
}
