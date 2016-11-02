<@content for="title">Metodos de Pago</@content>

<@link_to class="btn btn-default" action="new_form">Nuevo</@link_to>
    
<@flash name="message"/>
   
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Nombre</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <#list metodos as item>
            <tr>
                <th>${item.nombre}</th>
                <th><@link_to class="btn btn-default" action="edit" id=item.id>Editar</@link_to></th>
                <th><@form  id=item.id action="delete" method="delete" html_id=item.id><button class="btn btn-warning" type="submit">Eliminar</button></@form></th>
            </tr>
            </#list>
        </tbody>
    
  </table>
</div>

        
