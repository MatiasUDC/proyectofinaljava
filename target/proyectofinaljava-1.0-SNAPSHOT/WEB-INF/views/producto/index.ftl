    <@content for="title">Productos</@content>
   
<@flash name="message"/>
 <#list productos as item>
        <p>   ${ item.nombre }
        <@confirm text="Esta seguro de eliminar el producto: " + item.nombre + "?" form=item.id class="btn btn-warning">Eliminar</@confirm>
        <@form  id=item.id action="delete" method="delete" html_id=item.id />
    </#list>
    <@link_to class="btn btn-default" controller="home">Inicio</@link_to>
    <@link_to class="btn btn-default" action="new_form">Nuevo</@link_to>