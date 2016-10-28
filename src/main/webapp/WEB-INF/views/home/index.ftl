
<!DOCTYPE html>
<html lang="en">
    <head>
        <@content for="title">Home</@content>
    </head>
    <body>
        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
        </ol>
            <#list productos as item>
                <p>   ${ item.nombre }   </p>
            </#list>

        <@link_to controller="producto">productos</@link_to></br>
        
        <a class="btn btn-default" href="producto">otro tipo de enlace a producto</a>
        
        
        </body>
    </html>