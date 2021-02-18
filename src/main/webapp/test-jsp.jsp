<%@ page import="java.time.LocalDateTime" %>
<!doctype html>
<html>
  <head>
    <title>JSP page</title>
  </head>

  <body>
    <h1>This is JSP Page</h1>
    <p>Current time after update this page:</p>
    <%= LocalDateTime.now()  %>
  </body>
</html>
