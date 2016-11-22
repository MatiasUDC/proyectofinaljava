
    <@content for="title">Modificar Producto</@content>


    <@form action="update" method="post" id="${perfil.id}" html_id="formulario_modificaion">
    <div class="panel panel-success">
        <div class="panel-body">Modificar Perfil de Usuario</div>
        <div class="panel-footer">
            <div class="form-group">
                <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
                <input class="form-control"type="text" name="nombre" value="${ perfil.nombre }"required>
                <span class="error">${(flasher.errors.nombre)!}</span>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="apellido">Apellido * : </label>
                <input class="form-control"type="text" name="apellido" value="${ perfil.nombre }"required>
                <span class="error">${(flasher.errors.apellido)!}</span>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="telefono">Direccion * : </label>
                <input class="form-control"type="text" name="direccion" value="${ perfil.direccion }"required>
                <span class="error">${(flasher.errors.direccion)!}</span>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="telefono">Telefono * : </label>
                <input class="form-control"type="text" name="telefono" value="${ perfil.telefono }"required>
                <span class="error">${(flasher.errors.nombre)!}</span>
                </div>
            <div class="form-group">
                <button class="btn btn-default" type="submit">Guardar</button>
                <@link_to class="btn btn-default" controller="perfil">Cancelar</@link_to>
            </div>
            </div>
        </div>

    </@form>


    <script type="text/javascript">
        $().ready(function () {
            jQuery.validator.addMethod('selectcheck', function (value) {
                return (value != '0');
            }, "Campo obligatorio");

            $("#formulario_modificaion").validate({
                rules: {
                    nombre: {
                        required: true,
                        minlength: 5,
                        maxlength: 45
                    },
                    apellido: {
                        required: true,
                        minlength: 5,
                        maxlength: 45
                    },
                    direccion: {
                        required: true,
                        minlength: 5,
                        maxlength: 45
                    },
                    telefono: {
                        required: true,
                        minlength: 5,
                        maxlength: 45
                    }
                },
                messages: {
                    nombre: {
                        required: "Campo obligatorio",
                        minlength: "Longitud minima 5 carácteres",
                        maxlength: "Longitud maxima 45 carácteres"
                    },
                    apellido: {
                        required: "Campo obligatorio",
                        minlength: "Longitud minima 5 carácteres",
                        maxlength: "Longitud maxima 45 carácteres"
                    },
                    direccion: {
                        required: "Campo obligatorio",
                        minlength: "Longitud minima 5 carácteres",
                        maxlength: "Longitud maxima 45 carácteres"
                    },
                    telefono: {
                        required: "Campo obligatorio",
                        minlength: "Longitud minima 5 carácteres",
                        maxlength: "Longitud maxima 45 carácteres"
                    }
                }
            });
        });
    </script>