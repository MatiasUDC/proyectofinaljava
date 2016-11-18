/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import app.controllers.admin.ProductoController;
import app.models.Rol;
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
            flash("message", "Ingerse , email y contraseña");
            redirect();
        }else{
            List users = Usuario.getUsurio(param("email"), param("password"));
            if(users.isEmpty()){
                flash("message", "No se ha encontrado la combinacion de email y contraseña");
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
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ejemplo@gmail.ar", "contraseña");
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("de@gmail.ar"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("para@gmail.ar"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        redirect(HomeController.class);
    }
}