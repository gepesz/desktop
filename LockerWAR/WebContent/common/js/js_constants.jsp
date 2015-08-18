<%@ include file="/common/jsp/include/include_tld.jsp" %>

<c:set var="user" value="${sessionScope['com.vh.locker.USER']}" />

<% /* Holds the value of the current context */ %>
var CONTEXT_PREFIX = '';
var WELCOME_FILE = '/index.jsp';

<% /* JSON */ %>
var JSON_URL = '/JSON-RPC';

<% /* User */ %>
var USER_ID = '<c:out value="${user.id}"/>';
var USER_USERNAME = '<c:out value="${user.userName}"/>';

<% /* Component labels:  labels used by components */ %>
var LABEL_OK = '<b:message key="com.vh.label.OK" bundle="resources" />';
var LABEL_CANCEL = '<b:message key="com.vh.label.Cancel" bundle="resources" />';
var LABEL_YES = '<b:message key="com.vh.label.Yes" bundle="resources" />';
var LABEL_NO = '<b:message key="com.vh.label.No" bundle="resources" />';
var LABEL_CLOSE = '<b:message key="com.vh.label.Close" bundle="resources" />';
var LABEL_SELECT = '<b:message key="com.vh.label.Select" bundle="resources" />';

<% /* Component: etc. constants */ %>
var CLOSE_IMG = '/components/img/close.gif';

<% /* Java constants */ %>
var HEADER_HEIGHT = <%=com.vh.locker.util.Constants_UI.HEADER_HEIGHT%>;
var FOOTER_HEIGHT = <%=com.vh.locker.util.Constants_UI.FOOTER_HEIGHT%>;
var DEFAULT_FOOTER_HEIGHT = FOOTER_HEIGHT; <% /* Used after FOOTER_HEIGHT is set to 0 (reshowing footer) */ %>

<% /* Keyboard constants */ %>
var BACKSPACE_KEY = 8;
var DELETE_KEY    = 46;
var DOWN_KEY      = 40;
var ENTER_KEY     = 13;
var ESC_KEY       = 27;
var F2_KEY        = 113;
var F9_KEY        = 120;
var F12_KEY       = 123;
var LEFT_KEY      = 37;
var RIGHT_KEY     = 39;
var UP_KEY        = 38;

<% /* Validation constants, data caps */ %>
var FIELD_INT_MIN      = 1900;
var FIELD_INT_MAX      = 2000;
var FIELD_MAX_LENGTH   = 250;
var FIELD_MIN_LENGTH_5 = 5;

<% /* Canvas */ %>
var SHORTCUT_DIV_WIDTH  = <%=com.vh.locker.util.Constants_UI.SHORTCUT_DIV_WIDTH%>;
var SHORTCUT_DIV_HEIGHT = <%=com.vh.locker.util.Constants_UI.SHORTCUT_DIV_HEIGHT%>;
var SHORTCUT_TEXTAREA_MAX_COLS   = 15;
var SHORTCUT_TEXTAREA_MAX_LENGTH = 105;
var SHORTCUT_TEXTAREA_MAX_DISPLAY_LENGTH = 33; <% /* Trim textarea after this length: add '...' */ %>
var CANVAS_LEFT_MARGIN = <%=com.vh.locker.util.Constants_UI.CANVAS_LEFT_MARGIN%>;   <% /* Left margin of canvas when lining up shortcuts */ %>
var CANVAS_TOP_MARGIN  = <%=com.vh.locker.util.Constants_UI.CANVAS_TOP_MARGIN%>;    <% /* Top margin of canvas when lining up shortcuts  */ %>

<% /* Picker types */ %>
var TYPE_ALBUM = <%=com.vh.locker.util.Constants.TYPE_ALBUM%>;
var TYPE_ARTIST = <%=com.vh.locker.util.Constants.TYPE_ARTIST%>;
var TYPE_CONTACT = <%=com.vh.locker.util.Constants.TYPE_CONTACT%>;
var TYPE_GENRE = <%=com.vh.locker.util.Constants.TYPE_GENRE%>;
var TYPE_MIX = <%=com.vh.locker.util.Constants.TYPE_MIX%>;
var TYPE_PHOTO = <%=com.vh.locker.util.Constants.TYPE_PHOTO%>;
var TYPE_PHOTOALBUM = <%=com.vh.locker.util.Constants.TYPE_PHOTOALBUM%>;
var TYPE_SONG = <%=com.vh.locker.util.Constants.TYPE_SONG%>;
var TYPE_LOOKUP = [ '<b:message key="com.vh.label.Album"        bundle="resources" />',
				    '<b:message key="com.vh.label.Artist"       bundle="resources" />',
					'<b:message key="com.vh.label.Contact"      bundle="resources" />',
					'<b:message key="com.vh.label.Genre"        bundle="resources" />',
					'<b:message key="com.vh.label.Mixes"        bundle="resources" />',
					'<b:message key="com.vh.label.Photos"       bundle="resources" />',
					'<b:message key="com.vh.label.Photo_Album"  bundle="resources" />',
					'<b:message key="com.vh.label.Songs"        bundle="resources" />' ];
