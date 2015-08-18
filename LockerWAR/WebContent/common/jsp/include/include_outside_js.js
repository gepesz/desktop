<%@ page contentType="text/javascript" %>
<%@ include file="/common/jsp/include/include_tld.jsp" %>

<% /* JSON */ %>
<c:import url="/common/js/json/jsonrpc.js" />
<% /* JS global constants, global vars */ %>
<c:import url="/common/js/js_constants.jsp" />
<c:import url="/common/js/js_vars.js" />
<% /* Utility js files */ %>
<c:import url="/common/js/ajax.js" />
<c:import url="/common/js/blendtrans.js" />
<c:import url="/components/js/Logger.js" />
<c:import url="/common/js/validate.js" />
<% /* Outside specific js files: checkUserNameAvailability, F12 show bgFrame, focusOnUserName */ %>
<c:import url="/outside/js/outside.js" />