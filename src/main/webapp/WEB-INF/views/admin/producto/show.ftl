    <@content for="title">${ producto.nombre }</@content>
<ol class="breadcrumb">
    <li><@link_to  action="index">home</@link_to></li>
    <li><@link_to controller="/admin/categoria" action="index">${ categoria.nombre }</@link_to></li>
    <li><@link_to controller="/admin/producto" action="index">productos</@link_to></li>
    <li><a href="#">${producto.nombre}</a></li>
    </ol>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">${producto.nombre}</h3>
        </div>
        <div class="panel-body">
            <div class="media col-md-3">
                <figure class="pull-left">
                    <img class="media-object img-rounded img-responsive"  src="${context_path}/${ path_imagen }${ producto.imagen }" alt="${ producto.imagen }" >
                </figure>
            </div>
            <div class="col-md-6" text-center>
                <p class="list-group-item-text">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">
                      Cambiar imagen
                    </button>
                </p>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Cambiar Imagen</h4>
                  </div>
                  <div class="modal-body">
                    <@form action="imagen" controller="/admin/producto" method="post" id="${producto.id}" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="control-label"><span class="glyphicon glyphicon-picture" aria-hidden="true"> Imagen : </label>
                            <input name="imagen" id="input-repl-1a" type="file" class="file-loading" accept="image/*">
                        </div>
                    </@form>
                  </div>
                </div>
              </div>
            </div>
            <br/>
            <div class="col-md-6">
                Descripcion:
                <textarea class="form-control" rows="4" id="comment" disabled="true">${producto.descripcion}</textarea>
            </div>
            <div class="col-md-6">Categoria: ${categoria.nombre}</div>
            <div class="col-md-6">Stock: ${producto.stock}</div>
            <div class="col-md-6">Precio: ${producto.precio}</div>
            
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Comentarios</h3>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table  class="table">
                    <#list comentarios as comentario>
                    <tr>
                        <td>
                            <ul>
                                <li><i class="fa fa-user"></i>${comentario.usuario.perfiles.nombre}</li>
                                <li><i class="fa fa-calendar-o"></i>${comentario.fecha_alta}</li>
                            </ul>
                            <p>${comentario.comentario}</p> 
                        </td>
                        <td>
                            <@form  id=comentario.id controller="comentario" action="delete" method="delete">
                            <button class="btn btn-default" type="submit"data-toggle="tooltip" data-placement="left" title="Eliminar"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></button>
                            </@form>
                        </td>
                    </tr>
                </#list>
                </table>
            </div>
        </div>
    </div>
<script>
$("#input-repl-1a").fileinput({
    autoReplace: false,
    overwriteInitial: true,
    showUploadedThumbs: false,
    maxFileCount: 1,
    initialPreview: [
        "<img style='height:160px' src='${ context_path }/${ path_imagen }${ producto.imagen }'>",
    ],
    initialCaption: '${ producto.imagen }',
    initialPreviewShowDelete: false,
    showRemove: false,
    showClose: false,
    layoutTemplates: {actionDelete: ''}, // disable thumbnail deletion
    allowedFileExtensions: ["jpg", "png", "gif"]
});
</script>