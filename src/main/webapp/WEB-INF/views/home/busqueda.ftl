            <h2 class="title text-center">Productos</h2>
            ${ message }
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
                            <@link_to controller="compra"  action="new_form" class="btn btn-default add-to-cart" id=producto.id><i class="fa fa-shopping-cart"></i>Comprar</@link_to>
                        </div>
                    </div>
		</div>
            </#list>