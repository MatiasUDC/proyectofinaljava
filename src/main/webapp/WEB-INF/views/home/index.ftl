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
                    <div class="col-sm-3">
                        <div class="search_box pull-right">
                            <input type="text" placeholder="Busqueda"/>
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
                    <div class="brands_products"><!--brands_products-->
                        <h2>Categoria</h2>
			<div class="brands-name">
                            <ul class="nav nav-pills nav-stacked">
                                <#list categorias as categoria>
                                    <li><a href="#"><a href="#">${ categoria.nombre}</a></li>
                                </#list>
                            </ul>
			</div>
                    </div><!--/brands_products-->
						
                </div>
            </div>
            <div class="col-sm-9 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">Elementos destacados</h2>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <#list productos as producto>
                                <div class="single-products">
                                    <div class="productinfo text-center">
                                        <img src="${context_path}/${ path_imagen }${ producto.imagen}" alt="${ producto.imagen}" height="190" width="130" />
					<h2>$ ${ producto.precio }</h2>
					<p>${ producto.nombre }</p>
					<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Comprar</a>
                                    </div>
                                    <div class="product-overlay">
                                        <div class="overlay-content">
                                            <h2>$ ${ producto.precio }</h2>
                                            <p>${ producto.nombre }</p>
                                            <@link_to controller="producto"  action="show" class="btn btn-default add-to-cart" id=producto.id>Ver Producto</@link_to>
                                            <@link_to controller="compra"  action="new_form" class="btn btn-default add-to-cart" id=producto.id>Comprar</@link_to>
                                            
                                            <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Comprar</a>
					</div>
                                    </div>
				</div>
                            </#list>
			</div>
                    </div>
		</div><!--features_items-->

		<div class="recommended_items"><!--recommended_items-->
                    <h2 class="title text-center">recomendados</h2>
                    	<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner">
                                <#list recomendados as recomendado>    
                                </#list>
                            </div>
                                <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
                                    <i class="fa fa-angle-left"></i>
                                </a>
                                <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
                                    <i class="fa fa-angle-right"></i>
                                </a> 
			</div>
                    </div><!--/recommended_items-->
		</div>
            </div>
	</div>
    </section>
    
 