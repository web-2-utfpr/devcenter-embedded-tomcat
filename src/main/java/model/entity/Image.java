package model.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

@Table("imagem")
@BelongsTo(parent = User.class, foreignKeyName = "id_usuario")
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
        Duration d = Duration.between(getTimestamp("create_time").toLocalDateTime(), LocalDateTime.now());

        if (d.toMillis() < 60000) {
            return d.toMillis() / 1000 + " segundos atras";
        }
        if (d.toMinutes() < 60) {
            return d.toMinutes() + (d.toMinutes() == 1 ? " minuto atras" : " minutos atras");
        }
        if (d.toHours() < 24) {
            return d.toHours() + (d.toHours() == 1 ? " hora atras." : " horas atras");
        }
        if (d.toDays() < 7) {
            return d.toDays() + (d.toDays() == 1 ? " dia atras." : " dias atras");
        }
        if (d.toDays() < 365) {
            return d.toDays() / 7 + (d.toDays() / 7 == 1 ? " semana atras." : " semanas atras");
        }
        return d.toDays() / 365 + (d.toDays() / 365 == 1 ? " ano atras." : " anos atras");
    }

    public String getUsuario() {
        return parent(User.class).getNome();
    }

}
