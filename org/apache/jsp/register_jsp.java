/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.66
 * Generated at: 2021-07-12 07:44:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Calendar");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("        <link href=\"css/custom.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("        <title>User Registration</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"margin-top: 5%;\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"\"> \n");
      out.write("                 <img class=\"avatar\" src=\"img/user1.png\">\n");
      out.write("                \n");
      out.write("                    <form action=\"register\" method=\"post\" style=\"margin-top: 0%;\">\n");
      out.write("                        <div class=\"panel panel-body login-form\">\n");
      out.write("                            <div class=\"text-center\">\n");
      out.write("                                <div class=\"title\">New User Registration</div>\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div>First Name<b style=\"color:red;\"> *</b>F</div>\n");
      out.write("                            <div  class=\"form-group has-feedback has-feedback-left\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" minlength=\"2\" maxlength=\"40\" id=\"fname\" name=\"fname\" placeholder=\"First Name\"  required=\"true\">\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div>Middle Name<b style=\"color:red;\"> *</b>M</div>\n");
      out.write("                            <div  class=\"form-group has-feedback has-feedback-left\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"mname\" name=\"mname\" placeholder=\"Middle Name\">\n");
      out.write("                            </div>\n");
      out.write("                            <div>Sur/Last Name<b style=\"color:red;\"> *</b>L</div>\n");
      out.write("                            <div  class=\"form-group has-feedback has-feedback-left\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"lname\" name=\"lname\" minlength=\"2\" maxlength=\"40\" placeholder=\"Last/Sur Name\"  required=\"true\">\n");
      out.write("                            </div>\n");
      out.write("                            <div>Email Address<b style=\"color:red;\"> *</b>E</div>\n");
      out.write("                            <div  class=\"form-group has-feedback has-feedback-left\">\n");
      out.write("                                <input type=\"email\" class=\"form-control\" minlength=\"17\" maxlength=\"50\" id=\"email\" name=\"email\" placeholder=\"Organizational Email Address\"  required=\"true\">\n");
      out.write("                            </div>\n");
      out.write("                            <div>Phone Number<b style=\"color:red;\"> *</b>N</div>\n");
      out.write("                            <div  class=\"form-group has-feedback has-feedback-left\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\"minlength=\"10\" maxlength=\"10\" id=\"phone\" name=\"phone\" maxlength=\"10\" placeholder=\"Phone Number\" onkeypress='return numbers(event)' required=\"true\"> \n");
      out.write("                            </div>\n");
      out.write("                            <div>Password<b style=\"color:red;\"> *</b>P</div>\n");
      out.write("                            <div  class=\"form-group has-feedback has-feedback-left\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" minlength=\"3\" maxlength=\"20\" oninput=\"checkPasswords()\" id=\"pass1\" name=\"pass1\" placeholder=\"Password\"  required=\"true\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,}\" title=\"Must contain at least one number and one uppercase and lowercase letter, and at least 5 or more characters\">\n");
      out.write("                            </div>\n");
      out.write("                            <div>Repeat Password<b style=\"color:red;\"> *</b>R</div>\n");
      out.write("                            <div  class=\"form-group has-feedback has-feedback-left\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"pass2\" minlength=\"3\" oninput=\"checkPasswords()\" maxlength=\"20\" name=\"pass2\" placeholder=\"Repeat Password\" required=\"true\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,}\" title=\"Must contain at least one number and one uppercase and lowercase letter, and at least 5 or more characters\">\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"form-group\" style=\"width: 100%;\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary btn-block\">Register User </button>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                <div class=\"form-group login-options\">\n");
      out.write("                    <b>Already have an Account?</b><span> <a href=\"index.jsp\"><b>Login Here</b></a></span>\n");
      out.write("                    <br style=\"margin-top:2px;\">  \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

                    Calendar cal = Calendar.getInstance();  
                    int year= cal.get(Calendar.YEAR);    
                                            
                
      out.write(" \n");
      out.write("           \n");
      out.write("            <div class=\"footer text-muted text-center\">\n");
      out.write("                    <p align=\"center\"> &copy <a href=\"#\" title=\"Version 0.1\">Gilbert</a> GILBERT, ayoma ");
      out.print(year);
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                 ");

                     try{
                         if(session.getAttribute("message")!=null){
                             String mess =session.getAttribute("message").toString();
                             out.print(mess);
                         }else{
                             session.removeAttribute("message");
                         }
                         
                     }catch(Exception e){
                         out.print(e.getMessage());
                         
                     }
                 
      out.write("\n");
      out.write("             \n");
      out.write("               \n");
      out.write("                \n");
      out.write("    </body>\n");
      out.write("     <script type=\"text/javascript\" language=\"en\">\n");
      out.write("   function numbers(evt){\n");
      out.write("var charCode=(evt.which) ? evt.which : event.keyCode\n");
      out.write("if(charCode > 31 && (charCode < 48 || charCode>57))\n");
      out.write("return false;\n");
      out.write("return true;\n");
      out.write("}\n");
      out.write("//-->\n");
      out.write("</script>\n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write("    \n");
      out.write("            function checkPasswords() {\n");
      out.write("                var password = document.getElementById('pass1');\n");
      out.write("                var conf_password = document.getElementById('pass2');\n");
      out.write("\n");
      out.write("                if (password.value != conf_password.value) {\n");
      out.write("                    conf_password.setCustomValidity('Passwords do not match');\n");
      out.write("                } else {\n");
      out.write("                    conf_password.setCustomValidity('');\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("          \n");
      out.write("        \n");
      out.write("            }\n");
      out.write("    \n");
      out.write("    </script>\n");
      out.write("</html>\n");
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
