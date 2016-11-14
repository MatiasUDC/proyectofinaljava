<@content for="title">Compras</@content>

<@link_to class="btn btn-default" action="new_form">Nuevo</@link_to>
    
<@flash name="message"/>
   
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Usuario</th>
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
                <th>${item.compra.id_usuario}</th>
                <th>${item.compra.producto.nombre}</th>
                <th>${item.tipoproblema.nombre}</th>
                <th>${item.descripcion}</th>
                <th><@form  id=item.id action="delete" method="delete" html_id=item.id><button class="btn btn-default" type="submit">Problema Resuelto</button></@form></th>
            </tr>
            </#list>
        </tbody>
    
  </table>
</div>
