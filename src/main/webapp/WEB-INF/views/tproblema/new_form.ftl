
<@content for="title">Crear Metodo de Pago</@content>

<@form  action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Crear Metodo de Pago</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
            <input class="form-control" type="text" name="nombre" value="${(flasher.params.nombre)!}"required>
            <span class="error">${(flasher.errors.nombre)!}</span>
            </div>
        <button class="btn btn-default" type="submit" >Guardar</button>
    </div>
</div>
</@form>