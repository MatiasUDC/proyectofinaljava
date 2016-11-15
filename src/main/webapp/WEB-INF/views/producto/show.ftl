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
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
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
                                <li><a href="#"><i class="fa fa-shopping"></i> Lista de Compras</a></li>
                                <li><@link_to controller="login"><i class="fa fa-lock"></i> Iniciar sesión</@link_to></li>
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
                        <div class="mainmenu pull-left">
                            <ul class="nav navbar-nav collapse navbar-collapse">
                                <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="#">Productos</a></li>
                                    <li><a href="#">Categorias</a></li> 
                                </ul>
                                <li><a href="#">Contacto</a></li>
                            </ul>
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
                                    <h4 class="panel-title"><a href="#">${categoria.nombre}</a></h4>
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
                                    <label>Catidad:</label>
                                    <input type="text" value="3" />
                                    <button type="button" class="btn btn-fefault cart">
                                        <i class="fa fa-shopping-cart"></i>
					Comprar
                                    </button>
				</span>
				<p><b>Disponible</b> En stock</p>
				<p><b>Stock</b> ${ producto.stock }</p>
				<p><b>Condicion:</b> Nuevo</p>
				<p><b>Marca:</b> E-SHOPPER</p>
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
                                    <#list comentarios as comentario>
                                    <ul>
                                        <li><a href=""><i class="fa fa-user"></i>${comentario.usuario.nombre}</a></li>
                                        <li><a href=""><i class="fa fa-calendar-o"></i>${comentario.fecha_alta}</a></li>
                                    </ul>
                                    <p>${comentario.comentario}</p>
                                    </#list>
                                    <p><b>Escribe un comentario</b></p>
                                    <@form  id=producto.id controller="comentario" action="crear" method="post" html_id=producto.id>
                                        <span>
                                            <input type="text" placeholder="Ingrese su Nombre"/>
                                            <input type="email" placeholder="Direccion de Email"/>
                                        </span>
                                        <textarea name="" ></textarea>
                                        <button type="submit" class="btn btn-default pull-right">
                                            Comentar
                                        </button>
                                    </@form>
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