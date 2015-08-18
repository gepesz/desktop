/**
 * This file contains ALL global javascript variables.
 *
 * @author peter.szocs
 * @since Sep 2005
 */

/**
 * All java calls on the server are made through this global var.  Needed for JSON.
 */
var server = null;
/**
 * This global constant holds the id of the desktop div.
 */
var desktopDivId = 'desktop';
/**
 * This global constant holds the id of the footer div.
 */
var footerDivId = 'footer';
/**
 * This global constant holds the id of the taskbar div.
 */
var taskbarDivId = 'taskbar';
/**
 * This global variable holds the id of the currently active div.
 * Defaults to the desktopDiv, which is shown right after login.
 */
var activeDivId = null;
/**
 * This global variable holds the following information about each available application:
 *   'id'        : The appId of the app [the id of the app in the Application table in the database]
 *   'desc'      : The name of the app
 *   'icon'      : The icon of the app
 *   'targetUrl' : The URL of the application that this app starts
 * Login.do pulls info from database, and desktop.jsp populates this var.
 *
 * Note: appsArray MUST have an element at the 0th index.  This is because all the apps
 *       have id 1, 2, 3 etc, and therefore app 0 doesn't exist in the database!
 */
var appsArray = [ null ];
/**
 * This global variable holds the info whether autoSaveShortcuts should be executed.
 * All major shortcut operations (create/update/delete) must set this var to true!
 * Then the autoSaveShortcuts() method sets its value back to false after saving is done.
 *
 * Defaults to false;
 */
var isAutoSaveShortcuts = false;