<@content for="title">Crear Metodo de Pago</@content>

<@form  action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Registrar Problema</div>
    <div class="panel-footer">
        <div class="form-group">
            <input type="hidden" name="id_compra" value="${ compra.id}">
            <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Producto * : </label>
            <input class="form-control"type="text" name="producto" disabled="true" value="${ compra.producto.nombre }">
            <span class="error">${(flasher.errors.nombre)!}</span>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="metodo">Tipo de Problema * : </label><br/><br/>
             <@select id="tipo_id" class="selectpicker show-menu-arrow" name="tipo_id" list=tipos> <option value="0">Seleccione el Problema </option> </@> 
                <span class="error">${(flasher.errors.problemas)!}</span>
                </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="nombre">Descripcion * : </label>
                <input class="form-control" type="textarea" name="descripcion" value="${(flasher.params.descripcion)!}"required>
                <span class="error">${(flasher.errors.descripcion)!}</span>
                </div>
            <div class="form-group">
                <button class="btn btn-default" type="submit" >Guardar</button>
                </div>
            </div>
        </div>
</@form>