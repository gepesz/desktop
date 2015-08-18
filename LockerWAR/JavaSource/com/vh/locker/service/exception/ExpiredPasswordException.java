/**
 * @file ExpiredPasswordException
 * @author peter.szocs
 * 
 * Thrown when the user needs to change their password.
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
public class ExpiredPasswordException extends ServiceException {

    public ExpiredPasswordException() {
        super("");
    }

    public ExpiredPasswordException(String msg) {
        super(msg);
    }

    public ExpiredPasswordException(String msg, Throwable cause) {
        super(msg + " - " + cause);
    }

    public ExpiredPasswordException(Throwable cause) {
        super(cause.toString());
    }

}
