<@content for="title">Registrar Compra</@content>
    
    <header id="header"><!--header-->
        <div class="header_top"><!--header_top-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="contactinfo">
                            <ul class="nav nav-pills">
                                <li><a href="#"><i class="fa fa-phone"></i> 2945 589324</a></li>
				<li><a href="#"><i class="fa fa-envelope"></i> info@tienda_online.com</a></li>
                            </ul>
			</div>
                    </div>
                    <div class="col-sm-6">
                        <div class="social-icons pull-right">
                            <ul class="nav navbar-nav">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/header_top-->
    
	
        <div class="header-bottom"><!--header-bottom-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="logo pull-left">
                            <@link_to controller="home"><img src="${context_path}/bower_components/images/home/logo.png" alt="" /></@link_to>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/header-bottom-->
    </header><!--/header-->	
    <section>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 padding-right">
                    <div class="features_items"><!--features_items-->
                        <h2 class="title text-center">Nueva Compra</h2>
                    </div><!--features_items-->
                </div>
                <div class="col-sm-12">
                    <div class="left-sidebar">
                            <@form  action="create" method="post" html_id="formulario_compra">
                                        <input type="hidden" name="id_producto" value="${ producto.id }">
                                        <input type="hidden" id="montoreal" value="${ producto.precio}">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="nombre">Producto * : </label>
                                            <input class="form-control"type="text" name="nombre" disabled="true" value="${ producto.nombre }">
                                            <span class="error">${(flasher.errors.nombre)!}</span>
                                            
                                            </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="cantidad">Cantidad * : </label>
                                            <input class="form-control" min="1" id="cantidad" type="number" name="cantidad" value="1" onClick="" required>
                                            <br/><input type="button" class="btn btn-info" id="Costo" value="Costo">
                                            <span class="error">${(flasher.errors.cantidad)!}</span>
                                            </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="metodo">Metodo * : </label><br/><br/>
                                             <@select id="id_metodo" class="selectpicker show-menu-arrow" name="id_metodo" list=metodos> <option value="0">Seleccione un Metodo de Pago </option> </@> 
                                            <span class="error">${(flasher.errors.id_metodo)!}</span>
                                            </div>
                                        <div class="form-group" >
                                            <label class="col-sm-2 control-label" for="cuotas" >Cuotas * : </label><br/><br/>
                                            <select id="cuotas" placeholder="seleccione la cantidad de cuotas deseada" name="cuotas" class="contact_form">
                                                <option value="1">1</option>
                                                <option value="3">3</option>
                                                <option value="6">6</option>
                                                <option value="12">12</option>
                                                <option value="18">18</option>
                                                <option value="24">24</option>
                                                </select>
                                            </div>
                                        <span class="error">${(flasher.errors.cuotas)!}</span>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="monto">Monto Final * : </label>
                                            <input class="col-sm-2 control-label" name="monto" id="monto" value="${ producto.precio }" disabled> 
                                            <span class="error">${(flasher.errors.monto)!}</span>
                                            </div>

                                        <br/><br/>
                                        <div class="form-group">
                                            <button class="btn btn-default" type="submit">Registrar</button>
                                                <@link_to class="btn btn-danger" controller="home">Cancelar</@link_to>
                                         </div>
                            </@form>
                        	
                    </div>
                </div>
            </div>
        </div>
    </section>





<script>
        $(document).ready(function () {
        $("#Costo").click(function (e) {
            var num1 = $("#cantidad").val();
            var num2 = $("#montoreal").val();
            var resultado = parseInt(num1) * parseFloat(num2);
            $("#monto").val(parseFloat(resultado));
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

