package model;

import java.sql.Timestamp;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("imagem")
public class Imagem extends Model {

    static {
        validatePresenceOf("id_usuario", "url");
    }

    public Imagem() {
    }

    public Imagem(long id_usuario, String url) {
        setLong("id_usuario", id_usuario);
        setString("url", url);
    }

    public String getUrl() {
        return getString("url");
    }

    public Timestamp getCreate_time() {
        return getTimestamp("create_time");
    }


}
