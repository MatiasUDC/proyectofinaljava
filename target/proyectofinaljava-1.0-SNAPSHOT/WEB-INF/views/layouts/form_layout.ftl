<!DOCTYPE html>
<html lang="en">
    <head>
        <#include "header.ftl" >
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