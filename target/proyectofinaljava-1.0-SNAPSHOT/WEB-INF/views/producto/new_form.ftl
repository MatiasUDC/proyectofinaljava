
<!DOCTYPE html>
<html>
    <head>
        <@content for="title">Crear Producto</@content>
    </head>
    <body>
        <@form action="create" method="post">
                <div class="panel panel-success">
                    <div class="panel-body">Agregar Producto</div>
                    <div class="panel-footer">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
                            <input class="form-control"type="text" name="nombre" <#if flasher??> value=" ${flasher.params.nombre}"</#if> required>
                            <span class="error">${(flasher.errors.nombre)!}</span>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="descripcion">Descripcion * : </label>
                            <textarea class="form-control" rows="5" name="descripcion" id="descripcion" requiered></textarea>
                            <span class="error">${(flasher.errors.descripcion)!}</span>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="precio">Precio * : </label>
                            <input class="form-control"  type="text" name="precio" <#if flasher??> value=" ${flasher.params.precio}"</#if> required>
                            <span class="error">${(flasher.errors.precio)!}</span>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="stock">Stock * : </label>
                            <input class="form-control" min="0" type="number" name="stock" <#if flasher??> value=" ${flasher.params.stock}"</#if> required>
                            <span class="error">${(flasher.errors.stock)!}</span>
                        </div>

                        <br/>
                        <div class="form-group">
                            <button class="btn btn-default" type="submit">Guardar</button>
                            <@link_to class="btn btn-danger" controller="producto">Cancelar</@link_to>
                        </div>
                    </div>
                </div>

        </@form>
    </body>
</html>
