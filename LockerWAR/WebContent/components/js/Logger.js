/**
 * Logger Component
 *
 * Logs messages from JavaScript onto the app server's console using log4j.  Available
 * levels are DEBUG, INFO, WARN, ERROR, FATAL and NONE.  The LOG_LEVEL var sets the level.
 *
 * @param msg       The message to log.
 */
var LOG_DEBUG = 0;
var LOG_INFO  = 1;
var LOG_WARN  = 2;
var LOG_ERROR = 3;
var LOG_FATAL = 4;
var LOG_NONE  = 5;
var LOG_LEVEL = LOG_DEBUG;

var LOG = {
  debug : function(msg) {
    if(LOG_LEVEL<=LOG_DEBUG) this.send(LOG_DEBUG, msg);
  },
  info : function(msg) {
    if(LOG_LEVEL<=LOG_INFO) this.send(LOG_INFO, msg);   
  },
  warn : function(msg) {
    if(LOG_LEVEL<=LOG_WARN) this.send(LOG_WARN, msg);   
  },
  error : function(msg) {
    if(LOG_LEVEL<=LOG_ERROR) this.send(LOG_ERROR, msg);
  },
  fatal : function(msg) {
    if(LOG_LEVEL<=LOG_FATAL) this.send(LOG_FATAL, msg);
  },
  /**
   * Sends message to JSLogger action to log message using log4j
   */
  send : function(level, msg) {
    getURLAsText('/components/logger/JSLogger.sys?level='+level+'&msg='+msg);
  }
}