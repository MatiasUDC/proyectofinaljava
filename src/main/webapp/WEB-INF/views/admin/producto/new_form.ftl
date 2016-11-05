
    <@content for="title">Crear Producto</@content>


    <@form action="create" method="post" html_id="formulario_alta" enctype="multipart/form-data"  >

    <div class="panel panel-success">
        <div class="panel-body">Agregar Producto</div>
        <div class="panel-footer">
            <ul class="list-group">
                <div class="form-group">
                    <label class="control-label" for="nombre">Nombre * : </label>
                    <input class="form-control" type="text" name="nombre" value="${(flasher.params.nombre)!}" required>
                    <span class="error">${(flasher.errors.nombre)!}</span>
                </div>
                <div class="form-group">
                    <label class="control-label" for="descripcion">Descripcion * : </label>
                    <textarea class="form-control" rows="5" name="descripcion" id="descripcion">${(flasher.params.descripcion)!}</textarea>
                    <span class="error">${(flasher.errors.descripcion)!}</span>
                </div>
                <div class="form-group">
                    <label class="control-label" for="precio">Precio * : </label>
                    <input class="form-control"  type="text" name="precio" value="${(flasher.params.precio)!}" required>
                    <span class="error">${(flasher.errors.precio)!}</span>
                </div>
                <div class="form-group">
                    <label class="control-label" for="categoria_id">Categoria * : </label><br/>
                     <@select class="selectpicker show-menu-arrow" name="categoria_id" list=categorias > <option value="0">Seleccione una categoria </option> </@>
                     <span class="error">${(flasher.errors.categoria_id)!}</span>
                </div>
                <div class="form-group">
                    <label class="control-label" for="stock">Stock * : </label>
                    <input class="form-control" min="0" type="number" name="stock" value="${(flasher.params.stock)!}" required>
                    <span class="error">${(flasher.errors.stock)!}</span>
                </div>
                <br/>
                <div class="form-group">
                    <label class="control-label" for="imagen">Selecione una Imagen</label>
                    <input name="imagen" id="file-21" class="file" type="file" accept="image/*"><br/>
                </div>
                <div class="form-group">
                    <button class="btn btn-default" type="submit" >Guardar</button>
                    <@link_to class="btn btn-danger" controller="/admin/producto">Cancelar</@link_to>
                </div>
            </ul>
        </div>
    </div>
    </@form>
    <script type="text/javascript">
        $(document).on('ready', function() {
            $("#input-21").fileinput({
                previewFileType: "image",
                browseClass: "btn btn-success",
                browseLabel: "Pick Image",
                browseIcon: "<i class=\"glyphicon glyphicon-picture\"></i> ",
                removeClass: "btn btn-danger",
                removeLabel: "Delete",
                removeIcon: "<i class=\"glyphicon glyphicon-trash\"></i> ",
            });
        });
        $().ready(function () {
            jQuery.validator.addMethod('selectcheck', function (value) {
                return (value != '0');
            }, "Campo obligatorio");

            $("#formulario_alta").validate({
                rules: {
                    nombre: {
                        required: true,
                        minlength: 3,
                        maxlength: 20
                    },
                    descripcion: {
                        required: true,
                        minlength: 3,
                        maxlength: 175
                    },
                    precio: {
                      required: true,
                      number: true
                    },
                    categoria_id: {
                        selectcheck: true
                    },
                    stock: {
                        required: true,
                        digits: true    
                    }
                },
                messages: {
                    nombre: {
                        required: "Campo obligatorio",
                        minlength: "Longitud minima 3 carácteres",
                        maxlength: "Longitud maxima 20 carácteres"
                    },
                    descripcion: {
                        required: "Campo obligatorio",
                        minlength: "Longitud minima 3 carácteres",
                        maxlength: "Longitud maxima 175 carácteres"
                    },
                    precio: {
                        required: "Campo obligatorio",
                        number: "El campo no es valido"
                    },
                    stock: {
                        required: "Campo obligatorio",
                        digits: "El campo no es valido",
                        number: "El campo no es valido"
                    }
                }
            });
        });
    </script>