/**
 * @file ConnectionFactory
 * @author peter.szocs
 * 
 * This file contains helper methods to establish and release connection,
 * preparedStatement and ResultSet objects using VHDataSource.
 */


package com.vh.locker.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.vh.locker.service.exception.ServiceException;

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
public class ConnectionFactory {


  private static Logger log=Logger.getLogger(ConnectionFactory.class);
  private static DataSource mDataSource = null;



 /**
  * This is a utility method that returns the datasource
  */
  public static DataSource getDataSource() throws ServiceException {
    if(mDataSource==null) {
      try {
        InitialContext mContext = new InitialContext();
        mDataSource = (DataSource) mContext.lookup(Constants.DATASOURCE);      	
      } catch (Exception e) {
        log.error("Error while trying to lookup AppianDataSource: "+e.toString());
        throw new ServiceException("Error while trying to lookup AppianDataSource: "+e.getMessage());
      }
    }
    return mDataSource;	
  }


 /**
  * This is a utility method that creates a connection
  */
  public static Connection getConnection() throws ServiceException {
    try {    	
      return getDataSource().getConnection();
    } catch (Exception e) {
      log.error("An error occured while creating Connection: "+e.toString());
      throw new ServiceException("An error occured while creating Connection: "+e.getMessage());
    }
  }


 /**
  * This is a utility method that creates a prepared statement
  * @param pCon the connection
  * @param pQry the sql query
  */
  public static PreparedStatement getStatement(Connection pCon, String pQry) throws ServiceException {
    try {
      return pCon.prepareStatement(pQry);
    } catch (Exception e) {
      log.error("An error occured while creating PreparedStatement: "+e.toString());
      throw new ServiceException("An error occured while creating PreparedStatement: "+e.getMessage());
    }
  }


 /**
  * This is a utility method that disposes of a result set
  */
  public static void close(ResultSet pRS) {
    try {
      pRS.close();
    } catch (Exception ignored) {}
  }


 /**
  * This is a utility method that disposes of a statement
  */
  public static void close(Statement pStmt) {
    try {
      pStmt.close();
    } catch (Exception ignored) {}
  }


 /**
  * This is a utility method that disposes of a connection
  */
  public static void close(Connection pCon) {
    try {
      pCon.close();
    } catch (Exception ignored) {}
  }

}
