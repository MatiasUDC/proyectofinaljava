<!DOCTYPE html>
<html lang="en">
    <head>
        <#include "header.ftl" >
        <link href="${context_path}/bower_components/css/font-awesome.min.css" rel="stylesheet">
        <link href="${context_path}/bower_components/css/prettyPhoto.css" rel="stylesheet">
        <link href="${context_path}/bower_components/css/price-range.css" rel="stylesheet">
        <link href="${context_path}/bower_components/css/animate.css" rel="stylesheet">
	<link href="${context_path}/bower_components/css/main.css" rel="stylesheet">
	<link href="${context_path}/bower_components/css/responsive.css" rel="stylesheet">
       
        <script src="${context_path}/bower_components/jquery-validation/dist/jquery.validate.js" type="text/javascript"></script>
    </head>
    <body>
        ${page_content}
        <!-- include scripts -->
	<script src="${context_path}/bower_components/js/jquery.scrollUp.min.js"></script>
	<script src="${context_path}/bower_components/js/price-range.js"></script>
        <script src="${context_path}/bower_components/js/jquery.prettyPhoto.js"></script>
        <script src="${context_path}/bower_components/js/main.js"></script>
    </body>
</html>