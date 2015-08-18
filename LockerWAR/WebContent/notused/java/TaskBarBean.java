/**
 * @file TaskBarBean
 * @author peter.szocs
 * @version 1.0
 * 
 * Stores all necessary data to display any page's taskbar.
 */


package com.vh.locker.bean;

import java.util.ArrayList;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class TaskBarBean {
	
	//active task index
	private int activePos;
	
	//the tasks
	private ArrayList tasks;
	
  

	/**
	 * 
	 */
	public TaskBarBean(int activePos, ArrayList tasks) {
		this.activePos = activePos;
        this.tasks = tasks;
	}

	/**
	 * @return
	 */
	public int getActivePos() {
		return activePos;
	}

	/**
	 * @return
	 */
	public ArrayList getTasks() {
		return tasks;
	}

	/**
	 * @param i
	 */
	public void setActivePos(int i) {
		activePos = i;
	}

	/**
	 * @param list
	 */
	public void setTasks(ArrayList list) {
		tasks = list;
	}

}
