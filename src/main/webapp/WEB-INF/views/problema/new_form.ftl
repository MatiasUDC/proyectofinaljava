
<@content for="title">Crear Metodo de Pago</@content>

<@form  action="create" method="post">
<div class="panel panel-success">
    <div class="panel-body">Crear Metodo de Pago</div>
    <div class="panel-footer">
        <div class="form-group">
            <div class="form-group">
            <label class="col-sm-2 control-label" for="nombre">Producto * : </label>
            <input class="form-control"type="text" name="nombre" disabled="true" value="${ problemas.compra.producto.nombre }">
            <span class="error">${(flasher.errors.nombre)!}</span>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="metodo">Tipo de Problema * : </label><br/><br/>
             <@select id="problemas" class="selectpicker show-menu-arrow" name="id_problema" list=problemas> <option value="0">Seleccione el Problema </option> </@> 
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