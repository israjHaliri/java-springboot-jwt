package com.haliri.israj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by israjhaliri on 8/30/17.
 */
public class AppUtils {

    public static AppUtils INSTANCE = null;

    public static AppUtils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppUtils();
        }
        return INSTANCE;
    }

    public static Logger getLogger(Object o) {
        return LoggerFactory.getLogger(o.getClass());
    }
}
