<@content for="title">Crear usuario</@content>

<@form  action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Crear usuario</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="email">Email * : </label>
            <input class="form-control" type="email" name="email" value="${(flasher.params.email)!}" required>
            <span class="error">${(flasher.errors.email)!}</span>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="password">Contraseña * : </label>
            <input class="form-control" type="password" name="password" value="${(flasher.params.password)!}" required>
            <span class="error">${(flasher.errors.password)!}</span>
        </div>
        <button class="btn btn-default" type="submit" >Guardar</button>
        <@link_to class="btn btn-danger" controller="/admin/usuario">Cancelar</@link_to>
    </div>
</div>
</@form>