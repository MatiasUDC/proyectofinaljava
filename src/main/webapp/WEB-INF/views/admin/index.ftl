<@content for="title">Administracion</@content>

<@link_to class="btn btn-default" controller="/admin/home/" action="edit">Editar</@link_to>
    
<@flash name="message"/>
		<div class="panel panel-success">
            <div class="panel-body">Usuario <small><?php echo $_SESSION['nombre_usuario']; ?></small></div>
                <div class="panel-footer">
                    <blockquote>
                        <p>Nombre: <c:out value="${tienda.nombre}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>Apellido: <c:out value="${tienda.telefono}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>DNI: <c:out value="${tienda.email}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>Fecha de Nacimiento: <c:out value="${tienda.facebook}"/></p>
                    </blockquote>
                   </a></p>
                </div>
            </div>
		</div>