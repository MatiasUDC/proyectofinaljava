
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
                <div class="row">
                  <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                      <img src="..." alt="...">
                      <div class="caption">
                        <h3></h3>
                        <p>${ item.descripcion }</p>
                        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                      </div>
                    </div>
                  </div>
                </div>
            </#list>

        <@link_to controller="producto">productos</@link_to></br>
        
        <a class="btn btn-default" href="producto">otro tipo de enlace a producto</a>
        

        </body>
    </html>