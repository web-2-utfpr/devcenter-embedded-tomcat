package model.entity;

import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;

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
        return getAll(Image.class).orderBy("created_at desc");
    }

}
