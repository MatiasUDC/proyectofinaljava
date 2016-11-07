
<@content for="title">Registrar Compra</@content>

<@form  action="create" method="post">
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
             <@select class="selectpicker show-menu-arrow" name="id_metodo" list=metodos> <option value="0">Seleccione un Metodo de Pago </option> </@> 
            <span class="error">${(flasher.errors.metodos)!}</span>

            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="monto">Monto Final * : </label>
            <input class="col-sm-2 control-label" name="monto" id="monto" value="${ producto.precio }"> 
            <span class="error">${(flasher.errors.monto)!}</span>
            </div>
       
        <br/>
        <div class="form-group">
            <button class="btn btn-default" type="submit">Registrar</button>
                <@link_to class="btn btn-danger" controller="compra">Cancelar</@link_to>
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


