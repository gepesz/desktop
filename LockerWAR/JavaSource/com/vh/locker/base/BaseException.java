/**
 * @file BaseException
 * @author peter.szocs
 * @version 1.0
 * 
 * BaseException that every non-service exception should extend.
 */


package com.vh.locker.base;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class BaseException extends Exception {

    public BaseException() {
        super("");
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String msg, Throwable cause) {
        super(msg + " - " + cause);
    }

    public BaseException(Throwable cause) {
        super(cause.toString());
    }
}
