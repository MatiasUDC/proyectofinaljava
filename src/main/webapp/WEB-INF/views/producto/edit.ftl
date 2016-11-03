
<@content for="title">Modificar Producto</@content>


<@form action="update" method="put">
<div class="panel panel-success">
    <div class="panel-body">Modificar Producto</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
            <input class="form-control"type="text" name="nombre" value="${ producto.nombre }"required>
            <span class="error">${(flasher.errors.nombre)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="descripcion">Descripcion * : </label>
            <textarea class="form-control" rows="5" name="descripcion" id="descripcion">${producto.descripcion}</textarea>
            <span class="error">${(flasher.errors.descripcion)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="categoria">Categoria * : </label><br/><br/>
             <@select class="selectpicker show-menu-arrow" name="categoria_id" list=categorias> <option value="0">Seleccione una categoria </option> </@> 
             <span class="error">${(flasher.errors.categoria_id)!}</span>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="precio">Precio * : </label>
            <input class="form-control"  type="text" name="precio" value=" ${producto.precio}" required>
            <span class="error">${(flasher.errors.precio)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="stock">Stock * : </label>
            <input class="form-control" min="0" type="number" name="stock" value="${producto.stock}" required>
            <span class="error">${(flasher.errors.stock)!}</span>
        </div>
        <div class="form-group">
                <label class="control-label">Selecione una Imagen: </label>
                <input id="input-repl-1a" type="file" class="file-loading" accept="image/*">
        </div>

        <div class="form-group">
            <button class="btn btn-default" type="submit">Guardar</button>
                <@link_to class="btn btn-danger" controller="producto">Cancelar</@link_to>
            </div>
        </div>
    </div>

</@form>


<script>
$("#input-repl-1a").fileinput({
    uploadUrl: "/file-upload-batch/2",
    autoReplace: true,
    overwriteInitial: true,
    showUploadedThumbs: false,
    maxFileCount: 1,
    initialPreview: [
        "<img style='height:160px' src='${ context_path }/${ path_imagen }${ producto.imagen }'>",
    ],
    initialCaption: 'Initial-Image.jpg',
    initialPreviewShowDelete: false,
    showRemove: false,
    showClose: false,
    layoutTemplates: {actionDelete: ''}, // disable thumbnail deletion
    allowedFileExtensions: ["jpg", "png", "gif"]
});
</script>