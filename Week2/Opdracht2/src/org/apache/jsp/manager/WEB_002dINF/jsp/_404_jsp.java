/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: JspCServletContext/1.0
 * Generated at: 2017-05-22 09:04:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.manager.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.catalina.util.RequestUtil;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\r\n<html>\r\n <head>\r\n  <title>404 Not found</title>\r\n  <style type=\"text/css\">\r\n    <!--\r\n    BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;font-size:12px;}\r\n    H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;}\r\n    PRE, TT {border: 1px dotted #525D76}\r\n    A {color : black;}A.name {color : black;}\r\n    -->\r\n  </style>\r\n </head>\r\n <body>\r\n   <h1>404 Not found</h1>\r\n   <p>\r\n    The page you tried to access\r\n    (");
      out.print(RequestUtil.filter((String) request.getAttribute(
            "javax.servlet.error.request_uri")));
      out.write(")\r\n    does not exist.\r\n   </p>\r\n   <p>\r\n    The Manager application has been re-structured for Tomcat 7 onwards and some\r\n    of URLs have changed. All URLs used to access the Manager application should\r\n    now start with one of the following options:\r\n   </p>\r\n    <ul>\r\n      <li>");
      out.print(request.getContextPath());
      out.write("/html for the HTML GUI</li>\r\n      <li>");
      out.print(request.getContextPath());
      out.write("/text for the text interface</li>\r\n      <li>");
      out.print(request.getContextPath());
      out.write("/jmxproxy for the JMX proxy</li>\r\n      <li>");
      out.print(request.getContextPath());
      out.write("/status for the status pages</li>\r\n    </ul>\r\n   <p>\r\n    Note that the URL for the text interface has changed from\r\n    &quot;");
      out.print(request.getContextPath());
      out.write("&quot; to\r\n    &quot;");
      out.print(request.getContextPath());
      out.write("/text&quot;.\r\n   </p>\r\n   <p>\r\n    You probably need to adjust the URL you are using to access the Manager\r\n    application. However, there is always a chance you have found a bug in the\r\n    Manager application. If you are sure you have found a bug, and that the bug\r\n    has not already been reported, please report it to the Apache Tomcat team.\r\n   </p>\r\n </body>\r\n</html>\r\n");
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
