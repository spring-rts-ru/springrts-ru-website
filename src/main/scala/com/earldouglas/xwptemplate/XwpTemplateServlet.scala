package com.earldouglas.xwptemplate

import javax.servlet.http.HttpServlet

class XwpTemplateServlet extends HttpServlet {

  import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {

    response.setContentType("text/html")
    response.setCharacterEncoding("UTF-8")

    val responseBody = "<html><body><h1>Hello, world!</h1></body></html>"
    response.getWriter.write(responseBody)
  }
}