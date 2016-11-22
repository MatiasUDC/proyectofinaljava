
<@content for="title">Crear Metodo de Pago</@content>

<@form  action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Crear Metodo de Pago</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
            <input class="form-control" type="text" name="codigo" value="${(flasher.params.codigo)!}"required>
            <span class="error">${(flasher.errors.codigo)!}</span>
            </div>
        <button class="btn btn-default" type="submit" >Guardar</button>
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