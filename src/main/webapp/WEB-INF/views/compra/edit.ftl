
<@content for="title">Editar Compra</@content>

<@form  action="create" method="post" id="${compra.id}" html_id="formulario_compra">
<div class="panel panel-success">
    <div class="panel-body">Editar Compra</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Producto * : </label>
            <input class="form-control"type="text" name="nombre" disabled="true" value="${ compra.producto.nombre }">
            <span class="error">${(flasher.errors.nombre)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="cantidad">Cantidad * : </label>
            <input class="form-control" min="1" id="cantidad" type="number" name="cantidad" value="${(compra.cantidad)!}" onClick="" required>
            <input type="button" id="Costo" value="Costo">
            <span class="error">${(flasher.errors.cantidad)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="metodo">Metodo * : </label><br/><br/>
             <@select id="metodos" class="selectpicker show-menu-arrow" name="id_metodo" list=metodos> <option value="${(compra.id_metodo)}">${(compra.metodos.nombre)}</option> </@> 
            <span class="error">${(flasher.errors.metodos)!}</span>
            </div>
        <div class="form-group" id="cuota" style="display:none" >
            <label class="col-sm-2 control-label" for="cuotas" >Cuotas * : </label><br/><br/>
            <select id="cuotas" placeholder="seleccione la cantidad de cuotas deseada" name="cuotas" class="contact_form">
                <option value="0">1</option>
                <option value="1">3</option>
                <option value="2">6</option>
                <option value="3">12</option>
                <option value="4">18</option>
                <option value="5">24</option>
                </select>
            </div>
    
        <div class="form-group" id="token" style="display:none">
            <label class="col-sm-2 control-label" for="token">Token * : </label><br/><br/>
             <@select id="id_token" class="selectpicker show-menu-arrow" name="id_token" list=token> <option value="0">Codigo de Pago </option> </@>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="monto">Monto Final * : </label>
            <input class="col-sm-2 control-label" name="monto" id="monto" value="${ compra.monto }"> 
            <input class="col-sm-2 control-label" name="monto real" id="montoreal" value="${compra.producto.precio}" type="hidden">
            <span class="error">${(flasher.errors.monto)!}</span>
            </div>

        <br/>
             <div class="form-group">
                <button class="btn btn-default" type="submit">Guardar</button>
                <@link_to class="btn btn-default" controller="/admin/producto">Cancelar</@link_to>
            </div>
        </div>
    </div>
</@form>
<script>
        $(document).ready(function () {
        $("#Costo").click(function (e) {
            var num1 = $("#cantidad").val();
            var num2 = $("#montoreal").val();
            var resultado = parseInt(num1) * parseFloat(num2);
            $("#monto").val(resultado);
        });
        });
            
    </script>   
<script>
    $(document).ready(function () {
    $("#metodos").change(function (evento) {
            if (($("#metodos").val() == 3)||($("#metodos").val() == 4)){
                 $("#cuota").show();
            }else{
                 $("#cuota").hide();
                 $("#cuotas").val() == 0;
            }
            if (($("#metodos").val() == 1)||($("#metodos").val() == 2)){
                 $("#token").show();
            }else{
                 $("#token").hide();
                 $("#id_token").val() == 1;
            }
    });
    });  
    </script>
    <script type="text/javascript">
        $().ready(function () {
/*
            jQuery.validator.addMethod('selectcheck', function (value) {
                return (value != '0');
            }, "Campo obligatorio");
*/                
            $("#formulario_compra").validate({
                rules: {
                    monto: {
                      required: true,
                      number: true
                    },
                    id_metodo: {
                        selectcheck: true
                    },
                    cantidad: {
                        required: true,
                        digits: true    
                    }
                },
                messages: {
                    monto: {
                        required: "Campo obligatorio",
                        number: "El campo no es valido"
                    },
                    cantidad: {
                        required: "Campo obligatorio",
                        digits: "El campo no es valido",
                        number: "El campo no es valido"
                    }
                }
            });
        });
    </script>