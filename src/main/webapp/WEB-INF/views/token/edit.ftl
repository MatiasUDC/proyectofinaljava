
<@content for="title">Modificar Metodo de Pago</@content>


<@form action="update" method="put" id="${ tokens.id }">
<div class="panel panel-success">
    <div class="panel-body">Modificar Token de pago</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Codigo * : </label>
            <input class="form-control"type="number" min="10000000" name="codigo" value="${ tokens.codigo }"required>
            <span class="error">${(flasher.errors.nombre)!}</span>
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
    $("#${ tokens.id }").validate({
        rules: {
            codigo: {
                    required: true,
                    digits: true    
                }
            },
            
        },
        messages: {
            cantidad: {
                    required: "Campo obligatorio",
                    digits: "El campo no es valido",
                    number: "El campo no es valido"
                }
        }
    });
</script>