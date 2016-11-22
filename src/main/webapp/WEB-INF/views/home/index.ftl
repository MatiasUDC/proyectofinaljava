    <@content for="title">Home</@content>
    
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
    
        <div class="header-middle"><!--header-middle-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="logo pull-left">
                            <@link_to controller="home"><img src="${context_path}/bower_components/images/home/logo.png" alt="" /></@link_to>
                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="shop-menu pull-right">
                            <ul class="nav navbar-nav">
                                <#if usuario??>
                                <li><a href="#"><i class="fa fa-shopping"></i> Lista de Compras</a></li>
                                <li><@link_to controller="login" action="logout" ><i class="fa fa-lock"></i> Cerrar sesión</@link_to></li>
                                <#else>
                                <li><@link_to controller="login"><i class="fa fa-lock"></i> Iniciar sesión</@link_to></li>
                                </#if>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div><!--/header-middle-->
	
        <div class="header-bottom"><!--header-bottom-->
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-5">
                        <form>
                            <input id="busqueda" type="text" placeholder="Busqueda"/>
                            <button id="buscar" class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                        </form>
                    </div>
                </div>
            </div>
        </div><!--/header-bottom-->
    </header><!--/header-->
	
    <section>
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="left-sidebar">
                        <h2>Categoria</h2>
                        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                        <#list categorias as categoria>   
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <@link_to controller="categoria"  action="show"  id=categoria.id>
                                        ${categoria.nombre}
                                        </@link_to>
                                    </h4>
                                </div>
                            </div>
                        </#list>
                        </div><!--/category-products-->				
                    </div>
                </div>
                <div class="col-sm-9 padding-right">
                    <div id="prod" class="features_items"><!--features_items-->
                        <h2 class="title text-center">Productos</h2>
                        <p><@flash name="message"/></p>
                        <#list productos as producto>
                            <div class="col-sm-3">
                                <div  class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="${context_path}/${ path_imagen }${ producto.imagen}" alt="${ producto.imagen}" height="190" width="130" />
                                            <h2>$ ${ producto.precio }</h2>
                                            <p>${ producto.nombre }</p>
                                            <@link_to controller="producto"  action="show" class="btn btn-default add-to-cart" id=producto.id>Ver Producto</@link_to>
                                                <@link_to controller="compra"  action="new_form" class="btn btn-default add-to-cart" id=producto.id><i class="fa fa-shopping-cart"></i>Comprar</@link_to>
                                        </div>
                                        <div class="product-overlay">
                                            <div class="overlay-content">
                                                <h2>$ ${ producto.precio }</h2>
                                                <p>${ producto.nombre }</p>
                                                <@link_to controller="producto"  action="show" class="btn btn-default add-to-cart" id=producto.id>Ver Producto</@link_to>
                                                <@link_to controller="compra"  action="new_form" class="btn btn-default add-to-cart" id=producto.id><i class="fa fa-shopping-cart"></i>Comprar</@link_to>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div><!--features_items-->

                    <div class="recommended_items"><!--recommended_items-->
                        <h2 class="title text-center">recomendados</h2>
                        <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner">
                                <#list recomendados as recomendado>    
                                    <div class="item active">
                                        <div class="col-sm-3">
                                            <div class="product-image-wrapper">
                                                <div class="single-products">
                                                    <div class="productinfo text-center">
                                                        <img src="${context_path}/${ path_imagen }${ recomendado.imagen }" alt="${ recomendado.imagen }" height="195" width="135"/>
                                                        <h2>$ ${ recomendado.precio }</h2>
                                                        <p>${ recomendado.nombre }</p>
                                                        <@link_to controller="producto"  action="show" class="btn btn-default add-to-cart" id=recomendado.id>Ver Producto</@link_to>
                                                        <@link_to controller="compra"  action="new_form" class="btn btn-default add-to-cart" id=recomendado.id><i class="fa fa-shopping-cart"></i>Comprar</@link_to>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </#list>
                            </div>
                        </div>
                    </div><!--/recommended_items-->
                </div>
            </div>
        </div>
    </section>
<script>
    $(function() {
	$('#buscar').click(function(event) {
            var busqueda = $('#busqueda').val();
            $("#prod").load('home/busqueda', { busqueda : busqueda },function(responseTxt, statusTxt, xhr){});
	});
    });
</script>