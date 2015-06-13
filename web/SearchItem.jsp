<%-- 
    Document   : SearchItem
    Created on : Jun 6, 2015, 4:50:49 AM
    Author     : Feshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>IntelliGentz</title>
    </head>    
    <body>
         <h1>Sign up</h1>
            <form action="Search">
            <h2>Item Details</h2>
                Current Location <input type="text" name="locationText"/><br>
                Item Category <input type="text" name="categoryText"/><br>
                Item Model <input type="text" name="modelText"/><br>
                Item Description <input type="text" name="descriptionText"/><br>

            
            <input type="submit" value="Search"/>
        </form>
</html>
