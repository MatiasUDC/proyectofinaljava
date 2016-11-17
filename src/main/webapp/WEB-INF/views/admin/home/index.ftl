<@content for="title">Administracion</@content>

<@link_to class="btn btn-default" controller="/admin/home" action="edit">Editar</@link_to>
    
<@flash name="message"/>
 <br/><br/>
                    <blockquote>
                        <p>Nombre: ${tienda.nombre}</p>
                    </blockquote>
                    <blockquote>
                        <p>Telefono: ${tienda.telefono}</p>
                    </blockquote>
                    <blockquote>
                        <p>Email: ${tienda.email}</p>
                    </blockquote>
                    <blockquote>
                        <p>Direccion: ${tienda.direccion}</p>
                    </blockquote>
                    <blockquote>
                        <p>Facebook: ${tienda.facebook}</p>
                    </blockquote>
                   </a></p>

