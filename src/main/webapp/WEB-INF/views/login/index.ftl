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
                <div class="col-sm-4 col-sm-offset-1">
                    <div class="login-form"><!--login form-->
                        <h2>Login </h2>
			<@form action="login" method="post">
                            <form role="form">
                            <input type="email" name="email" placeholder="Email" />
                            <input type="password" name="password" placeholder="Contraseña" />
                            <button type="submit" class="btn btn-default">Login</button>
			</@form>
                        <@flash name="login"/>
                    </div><!--/login form-->
		</div>
                <div class="col-sm-1">
                    <h2 class="or">OR</h2>
                </div>
                <div class="col-sm-4">
                    <div class="signup-form"><!--sign up form-->
                        <h2>Signup!</h2>
                        <@form action="signup" method="post">
                            <input type="email" name="email" placeholder="Direción Email"/>
                            <input type="password" name="password" placeholder="Password"/>
                            <button type="submit" class="btn btn-default">Signup</button>
                        </@form>
                        <@flash name="signup"/>
                    </div><!--/sign up form-->
                </div>

                <div class="col-sm-3">
                    <div class="signup-form"><!--sign up form-->
                        <h2>Restaurar Contraseña</h2>
                        <@form action="restaurar" method="post">
                            <input type="email" name="email" placeholder="Direción Email"/>
                            <button type="submit" class="btn btn-default">Restaurar</button>
                        </@form>
                        <@flash name="restaurar"/>
                    </div><!--/sign up form-->
                </div>
            </div>
        </div>
    </section><!--/form-->