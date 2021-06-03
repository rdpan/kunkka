package com.hhl.kunkka.core.context;

import com.hhl.kunkka.common.constants.ClientConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class RootContext {

    protected static final Logger logger = LoggerFactory.getLogger(RootContext.class);

    private static ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    public static void bindXID(String xid) {
        if (StringUtils.isEmpty(xid)) {
            throw new IllegalArgumentException("xid must be not empty");
        }
        logger.debug("bind thread={}, xid={}", Thread.currentThread(), xid);
        threadLocal.get().put(ClientConstant.KEY_XID, xid);
    }

    public static void unbindXID() {
        if (threadLocal.get().containsKey(ClientConstant.KEY_XID)) {
            logger.debug("unbindXID,thread={}", Thread.currentThread());
            threadLocal.get().remove(ClientConstant.KEY_XID);
        }
    }

    public static String getXID() {
        Object xid = threadLocal.get().get(ClientConstant.KEY_XID);
        if (xid == null) {
            return null;
        }
        return xid.toString();
    }
}
