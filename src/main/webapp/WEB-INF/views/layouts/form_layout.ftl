<!DOCTYPE html>
<html lang="en">
    <head>
        <#include "header.ftl" >
        <link href="${context_path}/select/dist/css/bootstrap-select.css" rel="stylesheet" type="text/css"/>
        <script src="${context_path}/select/dist/js/bootstrap-select.js" type="text/javascript"></script>
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