<@form action="update" method="put" id="${ tienda.id }">
<div class="panel panel-success">
    <div class="panel-body">Modificar Informacion de Tienda</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
            <input class="form-control"type="text" name="nombre" value="${ tienda.nombre }"required>
            <span class="error">${(flasher.errors.nombre)!}</span>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="email">Email * : </label>
            <input class="form-control"type="email" name="email" value="${ tienda.email }"required>
            <span class="error">${(flasher.errors.email)!}</span>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="telefono">Telefono * : </label>
            <input class="form-control"type="text" name="telefono" value="${ tienda.telefono }"required>
            <span class="error">${(flasher.errors.telefono)!}</span>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="direccion">Direccion * : </label>
            <input class="form-control"type="text" name="direccion" value="${ tienda.direccion }"required>
            <span class="error">${(flasher.errors.direccion)!}</span>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="facebook">Facebook * : </label>
            <input class="form-control"type="text" name="facebook" value="${ tienda.facebook }"required>
            <span class="error">${(flasher.errors.facebook)!}</span>
        </div>
        <div class="form-group">
            <button class="btn btn-default" type="submit">Guardar</button>

            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">Cancelar</button>

                                             <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Cancelar edicion de la Informacion</h4>
                            </div>
                            <div class="modal-body">
                                Se perderan todos los datos completados<br/>¿Esta seguro de continuar?
                                </div>
                            <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <@link_to class="btn btn-danger" controller="/admin/home">Continuar</@link_to>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</@form>