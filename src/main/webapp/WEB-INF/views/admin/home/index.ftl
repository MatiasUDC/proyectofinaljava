<@content for="title">Administracion</@content>

<@link_to class="btn btn-default" controller="/admin/home" action="edit">Editar</@link_to>
    
<@flash name="message"/>
            <div class="panel panel-success">
                <div class="panel-footer">
                    <blockquote>
                        <p>Nombre: <c:out value="${tienda.nombre}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>Telefono: <c:out value="${tienda.telefono}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>Email: <c:out value="${tienda.email}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>Direccion: <c:out value="${tienda.direccion}"/></p>
                    </blockquote>
                    <blockquote>
                        <p>Facebook: <c:out value="${tienda.facebook}"/></p>
                    </blockquote>
                   </a></p>
                </div>
            </div>
