<@content for="title">Usuarios Registrados</@content>

<@link_to class="btn btn-default" action="new_form">Nuevo</@link_to>
<@flash name="message"/>
<h3>Administradores</h3>
<div class="table-responsive">
    <table class="table">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Rol</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <#list users as user>
            <tr>
                <th>${user.perfiles.nombre}</th>
                <th>${user.rol.nombre}</th>
                <th><@form  id=user.id action="delete" method="delete" html_id=user.id><button class="btn btn-danger" type="submit">Eliminar</button></@form></th>
            </tr>
            </#list>
        </tbody>
    
  </table>  
</div>
