
<@content for="title">Crear Categoria</@content>

<@form  action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Crear Categoria</div>
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
        <button class="btn btn-default" type="submit" >Guardar</button>
    </div>
</div>
</@form>