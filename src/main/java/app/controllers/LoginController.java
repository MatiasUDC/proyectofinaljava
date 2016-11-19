/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import app.controllers.admin.ProductoController;
import app.models.Perfil;
import app.models.Rol;
import app.models.Tienda;
import app.models.Usuario;
import app.utils.PropertiesFile;
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
                if (user.parent(Rol.class).getString("nombre").equals("admin")){
                    session("user", "admin");
                    session("id_user", user.get("id").toString());
                    redirect(ProductoController.class);
                } else if (user.parent(Rol.class).getString("nombre").equals("usuario")){
                    session("userName", user.parent(Perfil.class).getString("nombre"));
                    session("id_user", user.getInteger("id").toString());
                    redirect(HomeController.class);
                }
            }
        }
    }

    public void logout(){
        session().invalidate();
        redirect(HomeController.class);
    }
    
    @POST
    public void signup() {
        Usuario newUser = new Usuario();
        newUser.fromMap(params1st());
        if(Usuario.crear(newUser)){
            final Properties propsEmail = PropertiesFile.getPropertiesMail();
            final Properties propsAuthen = PropertiesFile.getPropertiesAuthentication();

            List tienda = Tienda.getTienda();
            final Tienda t = (Tienda) tienda.get(0);
            Session session = Session.getDefaultInstance(propsAuthen,
                    new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(propsEmail.getProperty("email"), propsEmail.getProperty("password"));
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
                        "en: http://localhost:8084/tienda_online/usuario/verificar?key="+newUser.getString("token")+"\n\n"+
                        "Si usted no se ha registrado, porfavor ingrese \n\n"
                                + "en: http://localhost:8084/tienda_online/usuario/baja?key="+newUser.getString("token"));

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