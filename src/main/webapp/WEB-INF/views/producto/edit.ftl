
    <@content for="title">Modificar Producto</@content>


    <@form action="update" method="post" id="${producto.id}" html_id="formulario_modificaion">
    <div class="panel panel-success">
        <div class="panel-body">Modificar Producto</div>
        <div class="panel-footer">
            <div class="form-group">
                <label class="col-sm-2 control-label" for="nombre">Nombre * : </label>
                <input class="form-control"type="text" name="nombre" value="${ producto.nombre }"required>
                <span class="error">${(flasher.errors.nombre)!}</span>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="descripcion">Descripcion * : </label>
                <textarea class="form-control" rows="5" name="descripcion" id="descripcion">${producto.descripcion}</textarea>
                <span class="error">${(flasher.errors.descripcion)!}</span>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="categoria">Categoria * : </label><br/><br/>
                 <@select class="selectpicker show-menu-arrow" name="categoria_id" list=categorias> <option value="0">Seleccione una categoria </option> </@> 
                 <span class="error">${(flasher.errors.categoria_id)!}</span>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="precio">Precio * : </label>
                <input class="form-control"  type="text" name="precio" value=" ${producto.precio}" required>
                <span class="error">${(flasher.errors.precio)!}</span>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="stock">Stock * : </label>
                <input class="form-control" min="0" type="number" name="stock" value="${producto.stock}" required>
                <span class="error">${(flasher.errors.stock)!}</span>
            </div>
            <div class="form-group">
                <button class="btn btn-default" type="submit">Guardar</button>
                    <@link_to class="btn btn-danger" controller="producto">Cancelar</@link_to>
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