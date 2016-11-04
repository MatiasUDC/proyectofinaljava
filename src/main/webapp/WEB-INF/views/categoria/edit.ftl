
<@content for="title">Modificar Categoria</@content>


<@form action="update" method="put" id="${ categoria.id }">
<div class="panel panel-success">
    <div class="panel-body">Modificar Categoria</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
            <input class="form-control"type="text" name="nombre" value="${ categoria.nombre }"required>
            <span class="error">${(flasher.errors.nombre)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="descripcion">Descripcion * : </label>
            <textarea class="form-control" rows="5" name="descripcion" id="descripcion">${categoria.descripcion}</textarea>
            <span class="error">${(flasher.errors.descripcion)!}</span>
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
                            <h4 class="modal-title" id="myModalLabel">Cancelar creacion de cliente</h4>
                            </div>
                        <div class="modal-body">
                            Se perderan todos los datos completados<br/>¿Esta seguro de continuar?
                            </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <a href="index" class="btn btn-danger">Continuar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</@form>
<script  type="text/javascript">
    $("#${ categoria.id }").validate({
        rules: {
            nombre: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            descripcion: {
                required: true,
                minlength: 10,
                maxlength: 175
            },
        },
        messages: {
            descripcion: {
                required: "Campo obligatorio",
                minlength: "Longitud minima 3 carácteres",
                maxlength: "Longitud maxima 20 carácteres"
            },
            apellido: {
                required: "Campo obligatorio",
                minlength: "Longitud minima 3 carácteres",
                maxlength: "Longitud maxima 20 carácteres"
            }
        }
    });
</script>