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
                            <li><@link_to controller="usuario" action="index" ><i class="glyphicon glyphicon-user"></i> Perfil</@link_to></li>
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
                            <li role="presentation" class="active"><@link_to controller="usuario"  action="problema">Problemas</@link_to></li>
                            <li role="presentation"><@link_to controller="usuario"  action="perfil">Perfil</@link_to></li>

                            </ul>

                        </div><!--/category-products-->				
                    </div>
                </div>
            <div class="col-sm-9 padding-right">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Producto</th>
                                <th>Tipo</th>
                                <th>Descripcion</th>
                                </tr>
                            </thead>
                        <tbody>
                            <#list problemas as item>
                                <tr>
                                    <th>${item.compra.producto.nombre}</th>
                                    <th>${item.tipo_problema.nombre}</th>
                                    <th>${item.descripcion}</th>
                                    </tr>
                            </#list>
                        </tbody>

                        </table>
                    </div>

                </div>
            </div>
        </div>
    </section>

