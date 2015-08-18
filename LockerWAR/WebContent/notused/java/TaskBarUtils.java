/**
 * @file TaskBarUtils
 * @author peter.szocs
 * @version 1.0
 * 
 * Tab pane and left navigation pane related methods.
 */



package com.vh.locker.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.vh.locker.bean.TaskBean;
import com.vh.locker.bean.TaskBarBean;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  Peter.Szocs
 * @version 1.0
 */
public class TaskBarUtils {

  private static Logger log = Logger.getLogger(TaskBarUtils.class);
  private static int[] TaskBar;
  

  /*
  public static void createTabs(TaskBean[] tabs, int leftNavPos, int tabPos, HttpServletRequest req){
    TaskBarBean tnb = getTabNavBean(req);
    tnb.setTabs(tabs);
    tnb.setLeftNavPos(leftNavPos);
    tnb.setTabPos(tabPos);
    setTabNavBean(req, tnb);
  }
  */

  /**
   * This is the topmost utility method in TaskBarUtils.  It
   * either sets the focus in taskbar to appIndex (if the task
   * is already present in the taskbar), or adds a new task to
   * the taskbar.
   * 
   * @param int appIndex The application index.  See Constants.
   * @param HttpServletRequest request The request
   */
  public static void handleTask(int appIndex, HttpServletRequest req) throws Exception {
    if(TaskBar[appIndex]!=-1) {
      setActiveTask(TaskBar[appIndex], req);
      if(log.isDebugEnabled()) log.debug("Task already in taskbar, changing taskbar focus to "+TaskBar[appIndex]);
    } 
    else {
      TaskBean tb;
      switch (appIndex) {
        case Constants.APPINDEX_BILLS:  tb = new TaskBean(Constants.APPINDEX_BILLS,  "/modules/bills/img/kwallet_footer.gif",      MessageUtils.getMessage(Constants.LABELS, "com.vh.label.Bills",     req), "/bills/StartBills.bg?c=content&c2=footer",   MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.billsmain",  req), true); break;
        case Constants.APPINDEX_EMAIL:  tb = new TaskBean(Constants.APPINDEX_EMAIL,  "/modules/email/img/email_footer.gif",        MessageUtils.getMessage(Constants.LABELS, "com.vh.label.Email",     req), "/email/StartEmail.bg?c=content&c2=footer",   MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.emailmain",  req), true); break;
        case Constants.APPINDEX_FILES:  tb = new TaskBean(Constants.APPINDEX_FILES,  "/modules/files/img/folder_footer.gif",       MessageUtils.getMessage(Constants.LABELS, "com.vh.label.Files",     req), "/files/StartFiles.bg?c=content&c2=footer",   MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.filesmain",  req), true); break;
        case Constants.APPINDEX_HTML:   tb = new TaskBean(Constants.APPINDEX_HTML,   "/modules/html/img/favorites_footer.gif",     MessageUtils.getMessage(Constants.LABELS, "com.vh.label.HTML",      req), "/html/StartHTML.bg?c=content&c2=footer",     MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.htmlmain",   req), true); break;
        case Constants.APPINDEX_IM:     tb = new TaskBean(Constants.APPINDEX_IM,     "/modules/im/img/kuser_footer.gif",           MessageUtils.getMessage(Constants.LABELS, "com.vh.label.IM",        req), "/im/StartIM.bg?c=content&c2=footer",         MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.immain",     req), true); break;
        case Constants.APPINDEX_MUSIC:  tb = new TaskBean(Constants.APPINDEX_MUSIC,  "/modules/music/img/kmix_footer.gif",         MessageUtils.getMessage(Constants.LABELS, "com.vh.label.Music",     req), "/music/StartMusic.bg?c=content&c2=footer",   MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.mymusic",    req), true); break;
        case Constants.APPINDEX_NOTES:  tb = new TaskBean(Constants.APPINDEX_NOTES,  "/modules/notes/img/korganizer_footer.gif",   MessageUtils.getMessage(Constants.LABELS, "com.vh.label.Notes",     req), "/notes/StartNotes.bg?c=content&c2=footer",   MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.notesmain",  req), true); break;
        case Constants.APPINDEX_PHONE:  tb = new TaskBean(Constants.APPINDEX_PHONE,  "/modules/phone/img/sms_protocol_footer.gif", MessageUtils.getMessage(Constants.LABELS, "com.vh.label.Phone_SMS", req), "/phone/StartPhone.bg?c=content&c2=footer",   MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.phonemain",  req), true); break;
        case Constants.APPINDEX_PHOTOS: tb = new TaskBean(Constants.APPINDEX_PHOTOS, "/modules/photos/img/camera_footer.gif",      MessageUtils.getMessage(Constants.LABELS, "com.vh.label.Photos",    req), "/photos/StartPhotos.bg?c=content&c2=footer", MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.photosmain", req), true); break;
        case Constants.APPINDEX_TRASH:  tb = new TaskBean(Constants.APPINDEX_TRASH,  "/modules/trash/img/trashcan_small.gif",      MessageUtils.getMessage(Constants.LABELS, "com.vh.label.Trash_Can", req), "/trash/StartTrash.bg?c=content&c2=footer",   MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.trashcan",   req), true); break;
        default: tb = new TaskBean(Constants.APPINDEX_FILES, "/modules/files/img/folder_footer.gif", MessageUtils.getMessage(Constants.LABELS, "com.vh.label.Files", req), "/files/StartFiles.bg?c=content&c2=footer", MessageUtils.getMessage(Constants.LABELS, "com.vh.title.jsp.startfiles", req), true); break;
      }
      addTask(tb, req);
      if(log.isDebugEnabled()) log.debug("New task added to taskbar at index "+TaskBar[appIndex]);
    }
  }


  /**
   * Sets the active task in taskbar.
   * The leftmost task has index 0.
   * 
   * @param int pos The active tab position, starts with 0.
   * @param HttpServletRequest request The request
   */
  public static void setActiveTask(int pos, HttpServletRequest req) {
    TaskBarBean tbb = getTaskNavBeanFromSession(req);
    tbb.setActivePos(pos);
    setTaskNavBeanIntoSession(req, tbb);
  }


  /**
   * Add new task to taskbar (new task started).
   * New task will become active task on taskbar.
   * 
   * @param TaskBean tb The TaskBean to be added.
   * @param HttpServletRequest request The request
   */
  public static void addTask(TaskBean tb, HttpServletRequest req) {
    TaskBarBean tbb = getTaskNavBeanFromSession(req);
    tbb.getTasks().add(tb);
    int index = tbb.getTasks().size()-1;
    tbb.setActivePos(index);
    TaskBar[tb.getId()]=index;
    setTaskNavBeanIntoSession(req, tbb);
  }


  /**
   * Remove active task from taskbar (close currently open application).
   * Active task will be set to -1, ie show desktop.
   * 
   * @param TaskBean tb The TaskBean to be added.
   * @param HttpServletRequest request The request
   */
  public static void removeTask(HttpServletRequest req) {
    TaskBarBean tbb = getTaskNavBeanFromSession(req);
    int activeTask = tbb.getActivePos();    
    //rewrite remaining task indexes
    for(int i=0;i<TaskBar.length;i++) if(TaskBar[i]>activeTask) TaskBar[i]--;
    TaskBar[((TaskBean)tbb.getTasks().get(activeTask)).getId()]=-1;
    tbb.getTasks().remove(activeTask);
    tbb.setActivePos(-1);
    setTaskNavBeanIntoSession(req, tbb);
    if(log.isDebugEnabled()) log.debug("Removed task from taskbar at index "+activeTask);
  }


  /**
   * Initializes taskbar.
   * This method should be called only once for each user upon login!
   * 
   * @param HttpServletRequest The request
   */
  public static void initTaskBar(HttpServletRequest req) {
    TaskBarBean tbb = new TaskBarBean(-1, new ArrayList());
    TaskBar = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    setTaskNavBeanIntoSession(req, tbb);
  }


  /**
   * Returns the TaskBarBean object from session.
   */
  private static TaskBarBean getTaskNavBeanFromSession(HttpServletRequest req) {
    // Note: if the attribute name is changed from "tnb", need
    // to change it also in setTaskNavBean and tabs.jsp.
    return (TaskBarBean)req.getSession().getAttribute(Constants.TASKBAR_KEY);
  }


  /**
   * Puts the TaskBarBean object into session.
   */
  private static void setTaskNavBeanIntoSession(HttpServletRequest req, TaskBarBean tbb) {
    req.getSession().setAttribute(Constants.TASKBAR_KEY, tbb);
  }

}
