package model.entity;

import org.javalite.activejdbc.Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Image extends Model {

    static {
        validatePresenceOf("url");
    }

    public Image() {
    }

    public Image(String url) {
        setString("url", url);
    }

    public String getUrl() {
        return getString("url");
    }

    public String getCreate_time() {
        return getTimestamp("created_at").toLocalDateTime().toString();
    }

    public String getUsuario() {
        return parent(User.class).getNome();
    }
    
    public String getData(){
        return getTimestamp("created_at").toLocalDateTime().toString();
    }

}
