<@content for="title">Categorias</@content>

<@link_to class="btn btn-default" action="new_form">Nuevo</@link_to>
    
<@flash name="message"/>
   
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Nombre</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <#list categorias as item>
            <tr>
                <th>${item.nombre}</th>
                <th><@link_to class="btn btn-default" action="edit" id=item.id>Editar</@link_to></th>
            </tr>
            </#list>
        </tbody>
    
  </table>
</div>

        
        