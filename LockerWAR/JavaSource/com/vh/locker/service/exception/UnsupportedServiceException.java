/**
 * @file UnsupportedServiceException
 * @author peter.szocs
 * 
 * Thrown when a request comes to acquire/release a non-existing Service.
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
public class UnsupportedServiceException extends ServiceException {

    public UnsupportedServiceException() {
        super("");
    }

    public UnsupportedServiceException(String msg) {
        super(msg);
    }

    public UnsupportedServiceException(String msg, Throwable cause) {
        super(msg + " - " + cause);
    }

    public UnsupportedServiceException(Throwable cause) {
        super(cause.toString());
    }
}
