<%@include file="topo.jsp" %>
<%@include file="barraesq.jsp" %>
<div id="content">
<TABLE>
<TR>
  <TD COLSPAN=2><jsp:include page="Header.jsp" flush="true"/></TD>
</TR>
<TR>
  <TD><jsp:include page="Menu.jsp" flush="true"/></TD>
  <TD VALIGN="TOP">
<%
  String categoryId = request.getParameter("categoryId");
  if (categoryId!=null && !categoryId.trim().equals("")) {
%>
    <TABLE>
    <TR>
      <TD><FONT FACE="Verdana" SIZE="3"><B>Name</B></FONT></TD>
      <TD><FONT FACE="Verdana" SIZE="3"><B>Description</B></FONT></TD>
      <TD><FONT FACE="Verdana" SIZE="3"><B>Price</B></FONT></TD>
      <TD><FONT FACE="Verdana" SIZE="3"><B>Details</B></FONT></TD>
    </TR>
<%
    ArrayList products = dbBean.getProductsInCategory(categoryId);
    Iterator iterator = products.iterator();
    while (iterator.hasNext()) {
      Product product = (Product) iterator.next();
%>
    <TR>
      <TD><FONT FACE="Verdana" SIZE="2"><%=product.name%></FONT></TD>
      <TD><FONT FACE="Verdana" SIZE="2"><%=product.description%></FONT></TD>
      <TD><FONT FACE="Verdana" SIZE="2"><%=product.price%></FONT></TD>
      <TD><A HREF="?acao=detalhes&productId=<%=product.id%>">
      <FONT FACE="Verdana" SIZE="2">Details</FONT></A></TD>
    </TR>
<%
    }
  }
  else
    out.println("Invalid category.");
%>
  </TD>
</TR>
</TABLE>
</BODY>
</HTML>

