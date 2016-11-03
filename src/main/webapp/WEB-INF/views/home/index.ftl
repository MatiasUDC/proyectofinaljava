        <@content for="title">Home</@content>

        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
        </ol>
        
            <#list productos as item>
                <div class="row">
                  <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                      <img src="${context_path}/${ path_imagen }${ item.imagen }" alt="${ item.imagen }">
                      <div class="caption">
                        <h3></h3>
                        <p>${ item.descripcion }</p>
                        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                      </div>
                    </div>
                  </div>
                </div>
            </#list>

        <a class="btn btn-default" href="producto">producto</a></br>
        <a class="btn btn-default" href="categoria">categoria</a></br>
        <@link_to controller="compra">compras</@link_to></br>
        
        
