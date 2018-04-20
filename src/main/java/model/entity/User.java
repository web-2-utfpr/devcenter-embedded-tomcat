package model.entity;

import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("usuario")
public class User extends Model {

    static {
        validatePresenceOf("nome", "senha", "email");
    }

    public User() {
    }

    public User(String nome, String senha, String email) {
        setString("nome", nome);
        setString("senha", senha);
        setString("email", email);
    }

    public String getNome() {
        return getString("nome");
    }

    public String getEmail() {
        return getString("email");
    }

    public LazyList getPhotos() {
        return Image.where("id_usuario = ?", get("id")).orderBy("create_time desc");
        //return getAll(Image.class).orderBy("create_time desc");
    }

}
