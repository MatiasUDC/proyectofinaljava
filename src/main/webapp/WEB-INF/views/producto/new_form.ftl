
<@content for="title">Crear Producto</@content>


<@form enctype="multipart/form-data" action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Agregar Producto</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
            <input class="form-control" type="text" name="nombre" value="${(flasher.params.nombre)!}"required>
            <span class="error">${(flasher.errors.nombre)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="descripcion">Descripcion * : </label>
            <textarea class="form-control" rows="5" name="descripcion" id="descripcion">${(flasher.params.descripcion)!}</textarea>
            <span class="error">${(flasher.errors.descripcion)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="precio">Precio * : </label>
            <input class="form-control"  type="text" name="precio" value="${(flasher.params.precio)!}" required>
            <span class="error">${(flasher.errors.precio)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="categoria">Categoria * : </label><br/><br/>
             <@select class="selectpicker show-menu-arrow" list=categorias> <option value="0"> Porfavor, seleccione una categoria </option> </@> 
             </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="stock">Stock * : </label>
            <input class="form-control" min="0" type="number" name="stock" value="${(flasher.params.stock)!}" required>
            <span class="error">${(flasher.errors.stock)!}</span>
        </div>
        <br/>
        <div class="form-group">
            <input type="file">
        </div>
        <div class="form-group">
            <button class="btn btn-default" type="submit">Guardar</button>
                <@link_to class="btn btn-danger" controller="producto">Cancelar</@link_to>
            </div>
        </div>
    </div>

</@form>

