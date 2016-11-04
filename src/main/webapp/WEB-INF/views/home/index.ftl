    <@content for="title">Home</@content>

    <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
    </ol>

        <h1 class="text-center">Productos</h1>
        <div class="list-group">
            <#list productos as item>
            <@link_to class="list-group-item active" action="#">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive"  src="${context_path}/${ path_imagen }${ item.imagen }" alt="${ item.imagen }" alt="${ item.nombre }" height="210" width="180">
                    </figure>
                </div>
                <div class="col-md-6">
                    <h4 class="list-group-item-heading"> ${ item.nombre } </h4>
                    <p class="list-group-item-text">
                        ${ item.descripcion }
                    </p>
                </div>
                <div class="col-md-3 text-center">
                    <h2><small> Precio: <span class="glyphicon glyphicon-usd" aria-hidden="true"></span>${ item.precio }</small></h2>
                    <button type="button" class="btn btn-default btn-lg btn-block"> <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Comprar </button>
                </div>
            </@link_to>
            </#list>
        </div>
 
      <@link_to class="btn btn-default" controller="producto">producto</@link_to></br>
        <@link_to class="btn btn-default" controller="categoria">categoria</@link_to></br>
    <@link_to class="btn btn-default" controller="compra">compras</@link_to></br>
        
        
    <style>
        a.list-group-item {
            height:auto;
            min-height:230px;
        }
        a.list-group-item.active small {
            color:#fff;
        }
    </style>