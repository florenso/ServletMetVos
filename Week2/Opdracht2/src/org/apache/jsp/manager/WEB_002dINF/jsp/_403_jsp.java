/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspCServletContext/1.0
 * Generated at: 2017-05-22 09:04:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.manager.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _403_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\r\n<html>\r\n <head>\r\n  <title>403 Access Denied</title>\r\n  <style type=\"text/css\">\r\n    <!--\r\n    BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;font-size:12px;}\r\n    H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;}\r\n    PRE, TT {border: 1px dotted #525D76}\r\n    A {color : black;}A.name {color : black;}\r\n    -->\r\n  </style>\r\n </head>\r\n <body>\r\n   <h1>403 Access Denied</h1>\r\n   <p>\r\n    You are not authorized to view this page.\r\n   </p>\r\n   <p>\r\n    If you have already configured the Manager application to allow access and\r\n    you have used your browsers back button, used a saved book-mark or similar\r\n    then you may have triggered the cross-site request forgery (CSRF) protection\r\n    that has been enabled for the HTML interface of the Manager application. You\r\n    will need to reset this protection by returning to the\r\n    <a href=\"");
      out.print(request.getContextPath());
      out.write("/html\">main Manager page</a>. Once you\r\n    return to this page, you will be able to continue using the Manager\r\n    application's HTML interface normally. If you continue to see this access\r\n    denied message, check that you have the necessary permissions to access this\r\n    application.\r\n   </p>\r\n   <p>\r\n    If you have not changed\r\n    any configuration files, please examine the file\r\n    <tt>conf/tomcat-users.xml</tt> in your installation. That\r\n    file must contain the credentials to let you use this webapp.\r\n   </p>\r\n   <p>\r\n    For example, to add the <tt>manager-gui</tt> role to a user named\r\n    <tt>tomcat</tt> with a password of <tt>s3cret</tt>, add the following to the\r\n    config file listed above.\r\n   </p>\r\n<pre>\r\n&lt;role rolename=\"manager-gui\"/&gt;\r\n&lt;user username=\"tomcat\" password=\"s3cret\" roles=\"manager-gui\"/&gt;\r\n</pre>\r\n   <p>\r\n    Note that for Tomcat 7 onwards, the roles required to use the manager\r\n    application were changed from the single <tt>manager</tt> role to the\r\n    following four roles. You will need to assign the role(s) required for\r\n");
      out.write("    the functionality you wish to access.\r\n   </p>\r\n    <ul>\r\n      <li><tt>manager-gui</tt> - allows access to the HTML GUI and the status\r\n          pages</li>\r\n      <li><tt>manager-script</tt> - allows access to the text interface and the\r\n          status pages</li>\r\n      <li><tt>manager-jmx</tt> - allows access to the JMX proxy and the status\r\n          pages</li>\r\n      <li><tt>manager-status</tt> - allows access to the status pages only</li>\r\n    </ul>\r\n   <p>\r\n    The HTML interface is protected against CSRF but the text and JMX interfaces\r\n    are not. To maintain the CSRF protection:\r\n   </p>\r\n   <ul>\r\n    <li>Users with the <tt>manager-gui</tt> role should not be granted either\r\n        the <tt>manager-script</tt> or <tt>manager-jmx</tt> roles.</li>\r\n    <li>If the text or jmx interfaces are accessed through a browser (e.g. for\r\n        testing since these interfaces are intended for tools not humans) then\r\n        the browser must be closed afterwards to terminate the session.</li>\r\n   </ul>\r\n   <p>\r\n");
      out.write("    For more information - please see the\r\n    <a href=\"/docs/manager-howto.html\">Manager App HOW-TO</a>.\r\n   </p>\r\n </body>\r\n\r\n</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
