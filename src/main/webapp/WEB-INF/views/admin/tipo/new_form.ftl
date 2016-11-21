
<@content for="title">Crear Tipo de Problema</@content>

<@form  action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Tipo de Problema</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
            <input class="form-control" type="text" name="nombre" value="${(flasher.params.nombre)!}"required>
            <span class="error">${(flasher.errors.nombre)!}</span>
        </div>
        <button class="btn btn-default" type="submit" >Guardar</button>
        <@link_to class="btn btn-danger" controller="/admin/tipo">Cancelar</@link_to>
    </div>
</div>
</@form>