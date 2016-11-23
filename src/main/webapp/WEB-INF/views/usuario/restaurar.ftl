    <@content for="title">Login</@content>

    <header id="header"><!--header-->
        <div class="header_top"><!--header_top-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="contactinfo">
                            <ul class="nav nav-pills">
                                <li><a href=""><i class="fa fa-phone"></i> +2945 586598</a></li>
				<li><a href=""><i class="fa fa-envelope"></i> info@tienda_onalie.com</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="social-icons pull-right">
                            <ul class="nav navbar-nav">
                                <li><a href=""><i class="fa fa-facebook"></i></a></li>
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
                </div>
            </div>
        </div><!--/header-middle-->
    </header><!--/header-->
	
    <section id="form"><!--form-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4 ">
                    <div class="login-form"><!--login form-->
                        <h2>Nueva Contraseña </h2>
			<@form action="contrasenia" method="post">
                            <form role="form">
                            <input type="password" name="password" placeholder="Contraseña" />
                            <button type="submit" class="btn btn-default">Login</button>
			</@form>
                        <@flash name="password"/>
                    </div><!--/login form-->
		</div>
            </div>
        </div>
    </section><!--/form-->