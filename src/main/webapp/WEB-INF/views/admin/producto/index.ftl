<@content for="title">Productos</@content>

<@link_to class="btn btn-default" action="new_form">Nuevo</@link_to>
<@flash name="message"/>
   
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Stock</th>
                <th>Precio</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <#list productos as item>
            <tr>
                <th>${item.nombre}</th>
                <th>${item.descripcion}</th>
                <th>${item.stock}</th>
                <th>${item.precio}</th>
                <th><@link_to class="btn btn-success" action="show" id=item.id>ver</@link_to></th>
                <th><@link_to class="btn btn-warning" action="edit" id=item.id>Editar</@link_to></th>
                <th><@form  id=item.id action="delete" method="delete" html_id=item.id><button class="btn btn-danger" type="submit">Eliminar</button></@form></th>
            </tr>
            </#list>
        </tbody>
    
  </table>
</div>

        
        
        

