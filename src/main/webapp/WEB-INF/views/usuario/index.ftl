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
    
	
        <div class="header-bottom"><!--header-bottom-->
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
                                <li><@link_to controller="login" action="logout" ><i class="fa fa-lock"></i> Cerrar sesión</@link_to></li>
                                <#else>
                                <li><@link_to controller="login"><i class="fa fa-lock"></i> Iniciar sesión</@link_to></li>
                                </#if>
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
                        <h2>Opciones</h2>
                        <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                        <ul class="nav nav-pills nav-stacked">
                            <li role="presentation"><@link_to controller="usuario"  action="compra">Compras</@link_to></li>
                            <li role="presentation"><@link_to controller="usuario"  action="comentario">Comentarios</@link_to></li>
                            <li role="presentation"><@link_to controller="usuario"  action="problema">Problemas</@link_to></li>
                            <li role="presentation"><@link_to controller="usuario"  action="perfil">Perfil</@link_to></li>
                            </ul>

                        </div><!--/category-products-->				
                    </div>
                </div>
                <div class="col-sm-9 padding-right">
                    <div class="features_items"><!--features_items-->
                        <h2 class="title text-center">Inicio</h2>
                    </div><!--features_items-->

                    
                </div>
            </div>
        </div>
    </section>
