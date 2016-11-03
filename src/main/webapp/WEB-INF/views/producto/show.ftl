    <@content for="title">${ producto.nombre }</@content>
    <ol class="breadcrumb">
        <li><@link_to controller="home" action="index">home</@link_to></li>
        <li><@link_to controller="categoria" action="index">${ categoria.nombre }</@link_to></li>
        <li><@link_to controller="producto" action="index">productos</@link_to></li>
        <li><a href="#">${producto.nombre}</a></li>
    </ol>