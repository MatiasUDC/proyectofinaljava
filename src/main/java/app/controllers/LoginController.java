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
import app.utils.PropertiesFile;
import java.util.Date;
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
                if(user.getBoolean("verificado")){//si la cuenta esta verificada
                    session().put("user",user);
                    if (user.parent(Rol.class).getString("nombre").equals("admin")){ 
                        redirect(ProductoController.class);
                    } else {
                        redirect(HomeController.class);
                    }
                } else {
                    flash("login", "Se ha registrado pero na ha verificado su cuenta, \n\ningrese a su correo y valide su cuenta");
                    redirect();
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
        if(Usuario.crear(newUser, true)){
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
                message.setText("Gracias por registrarse en ," + t.getString("nombre") 
                        + "\n\n Ingrese en el siguiente enlace para verificar su cuenta y poder ingresar\n\n" +
                        "en: http://localhost:8084/tienda_online/usuario/verificar?key="+newUser.getString("token")+"\n\n"+
                        "Si usted no se ha registrado, porfavor ingrese\n"
                                + "en: http://localhost:8084/tienda_online/usuario/baja?key="+newUser.getString("token"));

                Transport.send(message);

                flash("signup", "Ingrese a su correo para validar su cuenta");
                
            } catch (MessagingException e) {
                flash("signup", "No se ha podido enviar el correo de validacion de cuenta!.");
            }
        } else { 
            flash("signup", "No se ha podido registar, revise los siguientes items");
            flash("errors", newUser.errors());
            flash("params", params1st());
        }
        redirect(LoginController.class);
    }
    @POST
    public void restaurar() {

        Usuario usuario = (Usuario) Usuario.getUsurioEmail(param("email"));
        if(usuario != null){
            final Properties propsEmail = PropertiesFile.getPropertiesMail();
            final Properties propsAuthen = PropertiesFile.getPropertiesAuthentication();
            /* genero otro token */
            String token = usuario.getString("email");
            Date fecha = new Date();
            token = token.concat("" + fecha.getTime());
            
            usuario.set("token", Usuario.generarToken(token));
            
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
                        InternetAddress.parse(usuario.getString("email")));
                message.setSubject("Restaurar contraseña de " + t.getString("nombre"));
                message.setText( "Ingrese en el siguiente enlace para restaurar su contraseña y poder ingresar\n\n" +
                        "en: http://localhost:8084/tienda_online/usuario/restaurar?key="+usuario.getString("token")+"\n\n"+
                        "Si usted no se ha registrado, porfavor ingrese\n"
                                + "en: http://localhost:8084/tienda_online/usuario/baja?key="+usuario.getString("token"));

                Transport.send(message);

                flash("restaurar", "Ingrese a su correo para resturar su contraseña");
                
            } catch (MessagingException e) {
                flash("restaurar", "No se ha podido enviar el correo de restauracion de contraseña!.");
            }
        } else { 
            flash("restaurar", "No se encuentra registrado el email!!");
        }
        redirect(LoginController.class);
    }
}