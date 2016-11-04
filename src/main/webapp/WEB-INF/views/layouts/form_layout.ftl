<!DOCTYPE html>
<html lang="en">
    <head>
        <#include "header.ftl" >
        <link href="${context_path}/bower_components/select/dist/css/bootstrap-select.css" rel="stylesheet" type="text/css"/>
        <script src="${context_path}/bower_components/select/dist/js/bootstrap-select.js" type="text/javascript"></script>
              
        <link href="${context_path}/bower_components/fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />

        <script src="${context_path}/bower_components/fileinput/js/fileinput.js" type="text/javascript"></script>
        <script src="${context_path}/bower_components/fileinput/js/fileinput_locale_es.js" type="text/javascript"></script>
        <script src="${context_path}/bower_components/jquery-validation/dist/jquery.validate.js.js" type="text/javascript"></script>
        <style>
            .error{
                width: 400px;
                padding: 5px;
                border-radius: 5px;
                font-family: Arial;
                font-size: 11px;
                text-transform: uppercase;
                color: rgb(211, 0, 0);
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <span>
                    <@flash name="message"/>
                </span>
            ${page_content}
            </div>
        </div>
        
    </body>
    </html>