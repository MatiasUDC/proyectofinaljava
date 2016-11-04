
<@content for="title">Registrar Compra</@content>

<div class="form-group" >
    <label lass="col-sm-2 control-label"> ${ producto.nombre } </label>
 </div>

<@form  action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Registrar Compra</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="stock">Cantidad * : </label>
            <input class="form-control" min="1" id="cantidad" type="number" name="cantidad" value="${(flasher.params.cantidad)!}" onClick="" required>
            <span class="error">${(flasher.errors.cantidad)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="metodo">Metodo * : </label><br/><br/>
             <@select class="selectpicker show-menu-arrow" name="id_metodo" list=metodos> <option value="0">Seleccione un Metodo de Pago </option> </@> 
            <span class="error">${(flasher.errors.metodos)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="monto">Monto * : </label>
            <label class="col-sm-2 control-label" id="monto"> ${ producto.precio } </label>
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
/*    
   
        function operaciones()
        {
            var num1 = document.getElementById("cantidad").value;
            var num2 = document.getElementById("monto").value;

        
        var resultado = (parseInt(num1) * parseInt(num2));
        return document.getElementById('monto').value = resultado;
1    */
</script>


