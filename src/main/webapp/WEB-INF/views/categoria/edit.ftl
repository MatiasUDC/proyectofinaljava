
<@content for="title">Modificar Categoria</@content>


<@form action="update" method="put">
<div class="panel panel-success">
    <div class="panel-body">Modificar Categoria</div>
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
            <button class="btn btn-default" type="submit">Guardar</button>
                <@link_to class="btn btn-danger" controller="producto">Cancelar</@link_to>
            </div>
        </div>
    </div>
</div>
</@form>