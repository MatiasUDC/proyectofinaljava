<@content for="title">Compras</@content>

<@flash name="message"/>
   
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Usuario</th>
                <th>Email</th>
                <th>Producto</th>
                <th>Tipo</th>
                <th>Descripcion</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <#list problemas as item>
            <tr>
                <th>${item.compra.usuarios.perfiles.nombre}</th>
                <th>${item.compra.usuarios.email}</th>
                <th>${item.compra.producto.nombre}</th>
                <th>${item.tipo_problema.nombre}</th>
                <th>${item.descripcion}</th>
                <th><@form  id=item.id action="responder" method="get" html_id=item.id><button class="btn btn-default" type="submit">Problema Resuelto</button></@form></th>
            </tr>
            </#list>
        </tbody>
    
  </table>
</div>
