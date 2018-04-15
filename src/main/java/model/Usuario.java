package model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("usuario")
public class Usuario extends Model {

    static {
        validatePresenceOf("nome", "senha", "email");
    }

    public Usuario() {
    }

    public Usuario(String nome, String senha, String email) {
        setString("nome", nome);
        setString("senha", senha);
        setString("email", email);
    }

    public String getNome() {
        return getString("nome");
    }

}
