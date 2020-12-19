package ru.sberbank.itgod.websocket.message.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@NoArgsConstructor
public class EndPoint {
    @SerializedName("Ip")
    private String ip;
    @SerializedName("Port")
    private int port;

    public EndPoint(final String ip, final int port) {
        if (ip == null) {
            throw new IllegalArgumentException("ip");
        }
        this.ip = ip;
        this.port = port;
    }
}
