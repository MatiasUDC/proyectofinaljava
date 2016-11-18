/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import app.controllers.admin.ProductoController;
import app.models.Rol;
import app.models.Tienda;
import app.models.Usuario;
import java.util.List;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author universidad
 */
public class LoginController extends AppController {


    public void index(){
        render().layout("layouts/public_layout");
    }

    @POST
    public void login(){

        if(blank("email", "password")){
            flash("login", "Ingerse , email y contraseña");
            redirect();
        }else{
            List users = Usuario.getUsurio(param("email"), param("password"));
            if(users.isEmpty()){
                flash("login", "No se ha encontrado la combinacion de email y contraseña");
                redirect();
            } else {
                Usuario user = (Usuario) users.get(0);
                if (user.parent(Rol.class).get("nombre").equals("admin")){
                    session("user", "admin");
                    session("id_user", user.get("id").toString());
                    redirect(ProductoController.class);
                } else if (user.parent(Rol.class).get("nombre").equals("user")){
                    session("user", param("email"));
                    session("id_user", user.get("id").toString());
                    redirect(HomeController.class);
                }
            }
        }
    }

    public void logout(){
        session().invalidate();
        redirect(HomeController.class);
    }
    
    public void signup() {
        Usuario newUser = new Usuario();
        newUser.set(params());
        if(Usuario.crear(newUser)){
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            List tienda = Tienda.getTienda();
            final Tienda t = (Tienda) tienda.get(0);
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(t.getString("email"), "contraseña");
                }
            });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(t.getString("email")));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(newUser.getString("email")));
                message.setSubject("Verificacion de cuenta de " + t.getString("nombre"));
                message.setText("Se ha registrado en ," + t.getString("nombre") 
                        + "\n\n Ingrese en el siguiente enlace para validar su cuenta y poder ingresar\n\n" +
                        "en: http://localhost:8084/tinda_java/usuario/verificar?key="+newUser.getString("token"));

                Transport.send(message);

                flash("singup", "Ingrese a su correo para validar su cuenta");
                
            } catch (MessagingException e) {
                flash("singup", "No se ha podido enviar el correo de validacion de cuenta!.");
            }
        } else { 
            flash("singup", "No se ha podido registar, revise los siguientes items");
            flash("errors", newUser.errors());
            flash("params", params1st());
        }
        redirect(LoginController.class);
    }
}