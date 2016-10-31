
<@content for="title">Crear Producto</@content>

<div class="form-group" >
    <label lass="col-sm-2 control-label"> ${ producto.nombre } </label>
    </div>

<@form  action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Agregar Producto</div>
    <div class="panel-footer">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="metodo">Metodo * : </label><br/><br/>
             <@select class="selectpicker show-menu-arrow" name="id_metodo" list=metodos> <option value="0">Seleccione un Metodo de Pago </option> </@> 
            <span class="error">${(flasher.errors.metodos)!}</span>
            </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="monto">Stock * : </label>
            <input class="form-control" min="0" type="number" name="stock" value="${(flasher.params.monto)!}" required>
            <span class="error">${(flasher.errors.stock)!}</span>
            </div>
        <br/>
        <div class="form-group">
            <button class="btn btn-default" type="submit">Guardar</button>
                <@link_to class="btn btn-danger" controller="producto">Cancelar</@link_to>
            </div>
        </div>
    </div>
</@form>
