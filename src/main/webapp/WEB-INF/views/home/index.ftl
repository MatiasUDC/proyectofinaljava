    <@content for="title">Home</@content>

    <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
    </ol>

        <h1 class="text-center">Productos</h1>
        <div class="list-group">
            <#list productos as item>
            <@link_to class="list-group-item active" controller="producto" action="show" id=item.id>
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive"  src="${context_path}/${ path_imagen }${ item.imagen }" alt="${ item.imagen }" alt="${ item.nombre }" >
                    </figure>
                </div>
                <div class="col-md-6">
                    <h4 class="list-group-item-heading"> ${ item.nombre } </h4>
                    <p class="list-group-item-text">
                        ${ item.descripcion }
                    </p>
                </div>
                <div class="col-md-3 text-center">
                    <h2>precio:<small> ${ item.precio }</small></h2>
                    <button type="button" class="btn btn-default btn-lg btn-block"> Comprar </button>
                </div>
            </@link_to>
            </#list>
        </div>
 
           
    <a class="btn btn-default" href="producto">producto</a></br>
    <a class="btn btn-default" href="categoria">categoria</a></br>
    <@link_to controller="compra">compras</@link_to></br>
        
        
    <style>
        a.list-group-item {
            height:auto;
            min-height:220px;
        }
        a.list-group-item.active small {
            color:#fff;
        }
    </style>