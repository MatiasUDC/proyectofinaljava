    <@content for="title">Producto</@content>
    
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
                            <a href="#"><img src="${context_path}/bower_components/images/home/logo.png" alt="" /></a>
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
                    <div class="col-sm-9">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
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
                    <div class="product-details"><!--product-details-->
                        <div class="col-sm-5">
                            <div class="view-product">
                                <img src="${context_path}/${ path_imagen }${ producto.imagen }" alt="${ producto.nombre }" height="340" width="240"/>
                            </div>
                        </div>
			<div class="col-sm-7">
                            <div class="product-information"><!--/product-information-->
                                <h2>${ producto.nombre }</h2>
				<p>Web ID: ${ producto.id }</p>
				<span>
                                    <span>$ ${ producto.precio }</span>
                                    <@link_to class="btn btn-fefault cart" controller="compra" action="new_form" id=producto.id>
                                        <i class="fa fa-shopping-cart"></i>
					Comprar
                                    </@link_to>
				</span>
				<p><b>Descripcion de Producto </b>${ producto.descripcion }</p>
				<p><b>Stock</b> ${ producto.stock }</p>
                            </div><!--/product-information-->
			</div>
                    </div><!--/product-details-->
					
                    <div class="category-tab shop-details-tab"><!--category-tab-->
                        <div class="col-sm-12">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#reviews" data-toggle="tab">Comentarios (${comentarios?size})</a></li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade active in" id="reviews" >
                                <div class="col-sm-12">
                                    <div class="table-responsive">
                                    <table  class="table">
                                    <#list comentarios as comentario>
                                    <tr>
                                        <td>
                                            <ul>
                                                <li><a href=""><i class="fa fa-user"></i>${comentario.usuario.perfiles.nombre}</a></li>
                                                <li><a href=""><i class="fa fa-calendar-o"></i>${comentario.fecha_alta}</a></li>
                                            </ul>
                                            <p>${comentario.comentario}</p> 
                                        </td>
                                        <td>
                                            <#if usuario??>
                                            <#if usuario.id == comentario.usuarios_id>
                                            <@form  id=comentario.id controller="comentario" action="delete" method="delete">
                                                <button class="btn btn-default" type="submit"data-toggle="tooltip" data-placement="left" title="Eliminar"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></button>
                                            </@form>
                                            </#if>
                                            </#if>
                                        </td>
                                    </tr>
                                    </#list>
                                    </table>
                                
                                    <p><b>Escribe un comentario</b></p>
                                    <@form controller="comentario" action="create" method="post">
                                        <input type="hidden" name="productos_id" value="${ producto.id}">
                                        <textarea id="comentario" name="comentario" >${(flasher.params.comentario)!}</textarea>
                                        <span class="error">${(flasher.errors.comentario)!}</span>
                                        <button type="submit" class="btn btn-default pull-right">
                                            Comentar
                                        </button>
                                    </@form>
                                    <@flash name="comentario"/>
                                </div>
                            </div>
                        </div>
                    </div><!--/category-tab-->

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
$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})
</script>