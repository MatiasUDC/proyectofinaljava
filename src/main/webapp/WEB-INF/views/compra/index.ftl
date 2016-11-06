<@content for="title">Productos</@content>

<@link_to class="btn btn-default" action="new_form">Nuevo</@link_to>
    
<@flash name="message"/>
   
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Usuario</th>
                <th>Producto</th>
                <th>Monto</th>
                <th>Cantidad</th>
                <th>Metodo</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <#list compras as item>
            <tr>
                <th></th>
                <th>${item.id_producto}</th>
                <th>${item.cantidad}</th>
                <th>${item.id_metodo}</th>
                <th>${item.monto}</th>
                <th><@link_to class="btn btn-default" action="edit" id=item.id>Editar</@link_to></th>
                <th><@form  id=item.id action="delete" method="delete" html_id=item.id><button class="btn btn-default" type="submit">Eliminar</button></@form></th>
            </tr>
            </#list>
        </tbody>
    
  </table>
</div>

        
        
        

