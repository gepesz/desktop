/**
 * @file PreparePicker
 * @author peter.szocs
 * @version 1.0
 * 
 * Puts pickerForm into request for the Picker component.
 */


package com.vh.locker.action.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vh.locker.base.BaseInsideAction;
import com.vh.locker.bean.components.PickerForm;
import com.vh.locker.bean.components.PickerItemForm;
import com.vh.locker.ejb.Album;
import com.vh.locker.ejb.Artist;
import com.vh.locker.ejb.Contact;
import com.vh.locker.ejb.Genre;
import com.vh.locker.ejb.Mixes;
import com.vh.locker.ejb.MusicFile;
import com.vh.locker.ejb.Photo;
import com.vh.locker.ejb.PhotoAlbum;
import com.vh.locker.service.ContactService;
import com.vh.locker.service.MusicService;
import com.vh.locker.service.PhotoService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class PreparePicker extends BaseInsideAction implements Constants {

  private static Logger log = Logger.getLogger(PreparePicker.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //if(IS_DEBUG) log.debug("inside");

    //initialize local vars
    int pickerType = Integer.parseInt(request.getParameter("pt"));
    String hiddenIds = request.getParameter("hi");
    Long userId = ActionUtils.getUserId(request);
    
    //the PickerForm is used by picker search box ONLY    
    PickerForm f = (PickerForm) form;
    f.setPickerType(pickerType);
    f.setSearchString("");
    request.setAttribute("pickerForm", f);

    Collection avalColl = getAvailableCollection(pickerType, userId);
    Collection selColl = getSelectedCollection(pickerType, hiddenIds, avalColl);

    if(IS_DEBUG && (avalColl!=null)) log.debug("avalColl size="+avalColl.size());
    if(IS_DEBUG && (selColl!=null)) log.debug("selColl size="+selColl.size());    
    request.setAttribute("avalColl", avalColl);
    request.setAttribute("selColl", selColl);
            
    return mapping.findForward("success");
  }
  
  
  /**
   * Pulls the available collection from db.
   * This is the collection that will be displayed on the left select box of the picker.
   * 
   * @param pickerType
   * @param userId
   * @return Collection
   * @throws Exception
   */
  private Collection getAvailableCollection(int pickerType, Long userId) throws Exception {
    Collection rawColl = null;
    ArrayList avalColl = new ArrayList();
    Iterator it = null;

    ContactService cos = null;
    MusicService mcs = null;
    PhotoService phs = null;
    switch(pickerType) {
      case TYPE_ALBUM: 
            if(IS_DEBUG) log.debug("PickerType: TYPE_ALBUM");
            mcs = (MusicService) getService(SERVICEKEY_MUSIC);
            rawColl = mcs.findAlbumByUser(userId);
            releaseService(SERVICEKEY_MUSIC, mcs);
            it = rawColl.iterator();
            while(it.hasNext()) {
              Album next = (Album)it.next();
              avalColl.add(new PickerItemForm(pickerType, next.getId(), next.getDesc()));
            }
            break;
      case TYPE_ARTIST: 
            if(IS_DEBUG) log.debug("PickerType: TYPE_ARTIST");
            mcs = (MusicService) getService(SERVICEKEY_MUSIC);
            rawColl = mcs.findArtistByUser(userId);
            releaseService(SERVICEKEY_MUSIC, mcs);
            it = rawColl.iterator();
            while(it.hasNext()) {
              Artist next = (Artist)it.next();
              avalColl.add(new PickerItemForm(pickerType, next.getId(), next.getDesc()));
            }
            break;
      case TYPE_CONTACT: 
            if(IS_DEBUG) log.debug("PickerType: TYPE_CONTACT");
            cos = (ContactService) getService(SERVICEKEY_CONTACT);
            rawColl = cos.findContactByUser(userId);
            releaseService(SERVICEKEY_CONTACT, cos);
            it = rawColl.iterator();
            while(it.hasNext()) {
              Contact next = (Contact)it.next();
              avalColl.add(new PickerItemForm(pickerType, next.getId(), next.getNickName()));
            }
            break;
      case TYPE_GENRE: 
            if(IS_DEBUG) log.debug("PickerType: TYPE_GENRE");
            mcs = (MusicService) getService(SERVICEKEY_MUSIC);
            rawColl = mcs.findGenreByUser(userId);
            releaseService(SERVICEKEY_MUSIC, mcs);
            it = rawColl.iterator();
            while(it.hasNext()) {
              Genre next = (Genre)it.next();
              avalColl.add(new PickerItemForm(pickerType, next.getId(), next.getDesc()));
            }
            break;
      case TYPE_MIX: 
            if(IS_DEBUG) log.debug("PickerType: TYPE_MIX");
            mcs = (MusicService) getService(SERVICEKEY_MUSIC);
            rawColl = mcs.findMixesByUser(userId);
            releaseService(SERVICEKEY_MUSIC, mcs);
            it = rawColl.iterator();
            while(it.hasNext()) {
              Mixes next = (Mixes)it.next();
              avalColl.add(new PickerItemForm(pickerType, next.getId(), next.getTitle()));
            }
            break;
      case TYPE_PHOTO: 
            if(IS_DEBUG) log.debug("PickerType: TYPE_PHOTO, finder findPhotoByUser(userId) not yet implemented!!");
            /*
            phs = (PhotoService) getService(SERVICEKEY_PHOTO);
            rawColl = phs.findPhotoByUser(userId);
            releaseService(SERVICEKEY_PHOTO, phs);
            it = rawColl.iterator();
            while(it.hasNext()) {
              Photo next = (Photo)it.next();
              avalColl.add(new PickerItemForm(pickerType, next.getId(), next.getDesc()));
            }
            */
            break;
      case TYPE_PHOTOALBUM: 
            if(IS_DEBUG) log.debug("PickerType: TYPE_PHOTOALBUM");
            phs = (PhotoService) getService(SERVICEKEY_PHOTO);
            rawColl = phs.findPhotoAlbumByUser(userId);
            releaseService(SERVICEKEY_PHOTO, phs);
            it = rawColl.iterator();
            while(it.hasNext()) {
              PhotoAlbum next = (PhotoAlbum)it.next();
              avalColl.add(new PickerItemForm(pickerType, next.getId(), next.getTitle()));
            }
            break;
      case TYPE_SONG:
            if(IS_DEBUG) log.debug("PickerType: TYPE_SONG");
            mcs = (MusicService) getService(SERVICEKEY_MUSIC);
            rawColl = mcs.findMusicFileByUser(userId);
            releaseService(SERVICEKEY_MUSIC, mcs);
            it = rawColl.iterator();
            while(it.hasNext()) {
              MusicFile next = (MusicFile)it.next();
              avalColl.add(new PickerItemForm(pickerType, next.getId(), next.getSongTitle()));
            }
            break;
      default:
            log.warn("PickerType: NOT SET!");
            rawColl = null; 
            break;
    }
    return avalColl;  
  }


  /**
   * Creates the selected collection.
   * This is the collection that will be displayed on the right select box of the picker.
   * While creating the selected collection, the method also removes items from the available
   * collection so that they won't be available for picking (ie same thing cannot be picked 2x).
   *  
   * @param pickerType
   * @param hiddenIds
   * @param avalColl
   * @return
   * @throws Exception
   */
  private Collection getSelectedCollection(int pickerType, String hiddenIds, Collection avalColl) throws Exception {
    ArrayList selColl = new ArrayList();
    if((hiddenIds!=null) && (!"".equals(hiddenIds)) && (avalColl!=null) && (avalColl.size()>0)) {
      StringTokenizer t = new StringTokenizer(hiddenIds, ",");
      while(t.hasMoreElements()) {
        long nextId = Long.parseLong(t.nextToken());
        boolean found = false;
        Iterator it = avalColl.iterator();
        while(it.hasNext() && !found) {
          PickerItemForm item = (PickerItemForm) it.next();
          if(nextId==item.getId().longValue()) {
            found=true;
            selColl.add(item);
            it.remove();
          }
        }
      }
    }
    return selColl;
  }

}