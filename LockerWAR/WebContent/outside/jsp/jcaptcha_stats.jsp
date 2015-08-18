<%@ page import="com.octo.captcha.module.struts.CaptchaServicePlugin,
                 com.octo.captcha.service.ManageableCaptchaService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ManageableCaptchaService manageable = (ManageableCaptchaService)CaptchaServicePlugin.getInstance().getService();
    %>
    <h1>Captcha manageable service informations and statistics</h1>

  <p><a href="index.jsp">Home</a></p>

      <table border="1" align="center"  >
      <tr>
      <th>Name</th>
      <th>Value</th>
      </tr>
                                                   <tr>
      <td>Current engine class</td>
      <td><%=manageable.getCaptchaEngineClass()%></td>
      </tr>
         <tr>
      <td>Max Captcha Store Size</td>
      <td><%=manageable.getCaptchaStoreMaxSize()%></td>
      </tr>

      <tr>
      <td>Current Captcha Store Size</td>
      <td><%=manageable.getCaptchaStoreSize()%></td>
      </tr>



      <tr>
      <td>Captcha Store Size before garbage collection</td>
      <td><%=manageable.getCaptchaStoreSizeBeforeGarbageCollection()%></td>
      </tr>


            <tr>
            <td>Number of generated Captchas</td>
            <td><%=manageable.getNumberOfGeneratedCaptchas()%></td>
            </tr>



            <tr>
            <td>Number of passed captchas</td>
            <td><%=manageable.getNumberOfCorrectResponses()%></td>
            </tr>


            <tr>
            <td>Number of failed captchas</td>
            <td><%=manageable.getNumberOfUncorrectResponses()%></td>
            </tr>


            <tr>
            <td>Number of garbage collected Captchas</td>
            <td><%=manageable.getNumberOfGarbageCollectedCaptcha()%></td>
            </tr>



            <tr>
            <td>Number of garbage collectable Captchas</td>
            <td><%=manageable.getNumberOfGarbageCollectableCaptchas()%></td>
            </tr>
</table>
