<!DOCTYPE html>
<html lang="en">
    <head>
        <#include "header.ftl" >
    </head>
    <body>
        <div class="container">
            <div class="row">
                <#include "nav-bar.ftl" >
                <div class="col-md-3">
                    <ul class="nav nav-pills nav-stacked">
                        <#if index_tienda ?? ><!-- active tienda -->
                        <li role="presentation" class="active"><@link_to action="#">Tienda</@link_to></li>
                        <#else>
                        <li role="presentation"><@link_to controller="/admin/home" action="index">Tienda</@link_to></li>
                        </#if>
                        <#if index_producto ?? ><!-- active producto -->
                        <li role="presentation" class="active"><@link_to controller="/admin/producto" action="index">Producto</@link_to></li>
                        <#else>
                        <li role="presentation"><@link_to controller="/admin/producto" action="index">Producto</@link_to></li>
                        </#if>
                        <#if index_categoria ?? ><!-- active categoria -->
                        <li role="presentation" class="active"><@link_to controller="/admin/categoria" action="index">Categorias</@link_to></li>
                        <#else>
                        <li role="presentation"><@link_to controller="/admin/categoria" action="index">Categorias</@link_to></li>
                        </#if>
                        <#if index_problema ?? ><!-- active problemas -->
                        <li role="presentation" class="active"><@link_to action="#">Problemas</@link_to></li>
                        <#else>
                        <li role="presentation"><@link_to controller="/admin/problema" action="index">Problemas</@link_to></li>
                        </#if>
                        <#if index_tipo ?? ><!-- active usuarios -->
                        <li role="presentation" class="active"><@link_to action="#">Tipos de Problemas</@link_to></li> 
                        <#else>
                        <li role="presentation"><@link_to controller="/admin/tipo" action="index" >Tipos de Problemas</@link_to></li> 
                        </#if>
                        <#if index_metodo ?? ><!-- active metodos de pagp -->
                        <li role="presentation" class="active"><@link_to action="#">Metodos de Pago</@link_to></li>
                        <#else>
                        <li role="presentation"><@link_to controller="/admin/metodo" action="index">Metodos de Pago</@link_to></li>
                        </#if>
                        <#if index_usuario ?? ><!-- active usuarios -->
                        <li role="presentation" class="active"><@link_to action="#">Usuarios</@link_to></li> 
                        <#else>
                        <li role="presentation"><@link_to controller="/admin/usuario" action="index" >Usuarios</@link_to></li> 
                        </#if>
                    </ul>
                </div>
                <div class="col-md-9">
                ${page_content}
                </div>
            </div>
        </div>
        
    </body>
    </html>
