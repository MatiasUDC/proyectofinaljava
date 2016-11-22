
<@content for="title">Registrar Compra</@content>

<@form  action="create" method="post" html_id="formulario_compra">
<div class="panel panel-success">
    <div class="panel-body">Registrar Compra</div>
    <div class="panel-footer">
        <input type="hidden" name="id_producto" value="${ producto.id}">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Producto * : </label>
            <input class="form-control"type="text" name="nombre" disabled="true" value="${ producto.nombre }">
            <span class="error">${(flasher.errors.nombre)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="cantidad">Cantidad * : </label>
            <input class="form-control" min="1" id="cantidad" type="number" name="cantidad" value="${(flasher.params.cantidad)!}" onClick="" required>
            <input type="button" id="Costo" value="Costo">
            <span class="error">${(flasher.errors.cantidad)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="metodo">Metodo * : </label><br/><br/>
             <@select id="metodos" class="selectpicker show-menu-arrow" name="id_metodo" list=metodos> <option value="0">Seleccione un Metodo de Pago </option> </@> 
            <span class="error">${(flasher.errors.metodos)!}</span>
            </div>
        <div class="form-group" id="coutas" style="display:none">
            <label class="col-sm-2 control-label" for="cuotas" >Cuotas * : </label><br/><br/>
            <select id="cuota" placeholder="seleccione la cantidad de cuotas deseada" name="cuotas" class="contact_form">
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
            <input class="col-sm-2 control-label" name="monto" id="monto" value="${ producto.precio }"> 
            <span class="error">${(flasher.errors.monto)!}</span>
            </div>

        <br/>
        <div class="form-group">
            <button class="btn btn-default" type="submit">Registrar</button>
                <@link_to class="btn btn-danger" controller="home">Cancelar</@link_to>
            </div>
        </div>
    </div>
</@form>


<script>
        $(document).ready(function () {
        $("#Costo").click(function (e) {
            var num1 = $("#cantidad").val();
            var num2 = $("#monto").val();
            var resultado = parseInt(num1) * parseFloat(num2);
            $("#monto").val(resultado);
        });
        });
            
    </script>   
<script>
    $(document).ready(function () {
    $("#metodos").change(function (evento) {
       if (($("#metodos").val() == 3)||($("#metodos").val() == 4)){
            $("#cuotas").show();
       }else{
            $("#cuotas").hide();
            $("#cuota").val() == 0;
       }
        if (($("#metodos").val() == 1)||($("#metodos").val() == 2)){
            $("#token").show();
       }else{
            $("#token").hide();
            $("#id_token").val() == 0;
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

