/**
 * @file UndeclaredException
 * @author peter.szocs
 * 
 * Thrown when an unexpected exception occurs from within a service method.
 */


package com.vh.locker.service.exception;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights
 * reserved.  Copying or reproduction without prior written 
 * approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class UndeclaredException extends ServiceException {

    public UndeclaredException() {
        super("");
    }

    public UndeclaredException(String msg) {
        super(msg);
    }

    public UndeclaredException(String msg, Throwable cause) {
        super(msg + " - " + cause);
    }

    public UndeclaredException(Throwable cause) {
        super(cause.toString());
    }
}
