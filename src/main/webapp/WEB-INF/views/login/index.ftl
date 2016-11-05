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
				<li><a href=""><i class="fa fa-twitter"></i></a></li>
				<li><a href=""><i class="fa fa-linkedin"></i></a></li>
				<li><a href=""><i class="fa fa-dribbble"></i></a></li>
				<li><a href=""><i class="fa fa-google-plus"></i></a></li>
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
                            <a href="#"><img src="images/home/logo.png" alt="" /></a>
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
                                <li><a href="#">Home</a></li>
				<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="#">Productos</a></li>
					<li><a href="#">Categorias</a></li> 
					<li><a href="#">Marcas</a></li> 
                                    </ul>
                                </li> 
				<li><a href="#">Contacto</a></li>
                            </ul>
			</div>
                    </div>
                    <div class="col-sm-3">
                        <div class="search_box pull-right">
                            <input type="text" placeholder=""/>
			</div>
                    </div>
		</div>
            </div>
	</div><!--/header-bottom-->
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
                    </div><!--/login form-->
		</div>
                <div class="col-sm-1">
                    <h2 class="or">OR</h2>
                </div>
                <div class="col-sm-4">
                    <div class="signup-form"><!--sign up form-->
                        <h2>Signup!</h2>
                        <form action="#">
                            <input type="text" name="name" placeholder="Nombre"/>
                            <input type="email" name="email" placeholder="Direción Email"/>
                            <input type="password" name="password" placeholder="Password"/>
                            <button type="submit" class="btn btn-default">Signup</button>
                        </form>
                    </div><!--/sign up form-->
                </div>
            </div>
        </div>
    </section><!--/form-->
	<div class="footer-widget">
            <div class="container">
            	<div class="row">
                    <div class="col-sm-2">
                        <div class="single-widget">
                            <h2>Service</h2>
                            <ul class="nav nav-pills nav-stacked">
				<li><a href="">Online Help</a></li>
				<li><a href="">Contact Us</a></li>
				<li><a href="">Order Status</a></li>
				<li><a href="">Change Location</a></li>
				<li><a href="">FAQ’s</a></li>
                            </ul>
			</div>
                    </div>
                    <div class="col-sm-2">
                        <div class="single-widget">
                            <h2>Quock Shop</h2>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="">T-Shirt</a></li>
				<li><a href="">Mens</a></li>
				<li><a href="">Womens</a></li>
				<li><a href="">Gift Cards</a></li>
				<li><a href="">Shoes</a></li>
                            </ul>
			</div>
                    </div>
                    <div class="col-sm-2">
                        <div class="single-widget">
                            <h2>Policies</h2>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="">Terms of Use</a></li>
				<li><a href="">Privecy Policy</a></li>
				<li><a href="">Refund Policy</a></li>
				<li><a href="">Billing System</a></li>
				<li><a href="">Ticket System</a></li>
                            </ul>
			</div>
                    </div>
                    <div class="col-sm-2">
                        <div class="single-widget">
                            <h2>About Shopper</h2>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="">Company Information</a></li>
				<li><a href="">Careers</a></li>
				<li><a href="">Store Location</a></li>
				<li><a href="">Affillate Program</a></li>
				<li><a href="">Copyright</a></li>
                            </ul>
			</div>
                    </div>
                    <div class="col-sm-3 col-sm-offset-1">
                        <div class="single-widget">
                            <h2>About Shopper</h2>
                            <form action="#" class="searchform">
                                <input type="text" placeholder="Your email address" />
				<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
				<p>Get the most recent updates from <br />our site and be updated your self...</p>
                            </form>
			</div>
                    </div			
		</div>
            </div>
	</div>
    </footer><!--/Footer-->