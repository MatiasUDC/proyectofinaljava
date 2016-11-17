/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;


import app.models.Producto;

import java.util.List;
import org.javalite.activeweb.AppController;
import app.controllers.authorization.Protected;

import app.models.Rol;
import app.models.Usuario;
import java.util.Properties;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.*;
/**
 *
 * @author Matias
 */
@Protected
public class UsuarioController extends AppController{
    public void index(){
        List productos = Producto.lista_productos();
        view("productos",productos);
        view("index_usuario", true );

        List usuarios = Usuario.lista_usuario();
        view("users", usuarios);  
    }
    
    @GET
    public void newForm() {
        List roles = Rol.selectedRol();
        view("roles", roles);
        render().layout("layouts/form_layout");
    }
    
    @POST
    public void create() {
        Usuario u = new Usuario();
        u.fromMap(params1st());

        if (!Usuario.crear(u)) {
            flash("message", "No se ha podido guardar la categoria, revise los siguientes items");
            flash("errors", u.errors());
            flash("params", params1st());
            redirect(CategoriaController.class, "new_form");
        } else {
            flash("message", "Nueva usuario registrado: " + u.get("nombre"));
            redirect(UsuarioController.class);
        }
    }
    
    @GET
    public void edit() {
       
        Usuario u = (Usuario) Usuario.findById(getId());
        List roles = Rol.selectedRol(u.get("rol_id"));
        view("roles", roles);
        view("usuario", u);
        render().layout("layouts/form_layout");
    }
    
    public void signup() {
         // Recipient's email ID needs to be mentioned.
      final String username = "eje@asd.com";
      final String password = "eje";

      // Sender's email ID needs to be mentioned
      String from = "sdf@sdf.sdf.com";
      //creando la instancia de properties
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication
            getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
        }
    });
    try {
        //Creamos un nuevo mensaje, y le pasamos nuestra sesión iniciada en el paso anterior.
         Message message = new MimeMessage(session);
        //Seteamos la dirección desde la cual enviaremos el mensaje
         message.setFrom(new InternetAddress(from));
        //Seteamos el destino de nuestro mensaje
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(from));
        //Seteamos el asunto
        message.setSubject("Prueba Java Mail");
        //Y por ultimo el texto.
        message.setText("Estimado Typing Code, \nEstamos aprendiendo Java Mail.");
        //Esta orden envía el mensaje
         Transport.send(message);
        //Con esta imprimimos en consola que el mensaje fue enviado
         System.out.println("Mensaje Enviado");
     }catch (MessagingException e) {
        //Si existiera un error en el envío lo hacemos saber al cliente y lanzamos una excepcion.
         System.out.println("Hubo un error al enviar el mensaje.");
        throw new RuntimeException(e);
 }
        redirect(HomeController.class);
    }
    
}