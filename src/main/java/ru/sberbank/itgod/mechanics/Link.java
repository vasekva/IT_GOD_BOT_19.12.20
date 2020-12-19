package ru.sberbank.itgod.mechanics;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Класс, описывающий путь между двумя строениями
 */
@Slf4j
@Data
public class Link {

    // В каком строении начинается связь
    @SerializedName("From")
    private Integer from;

    // В каком строении заканчивается связь
    @SerializedName("To")
    private Integer to;

    // Список позиций, представляющий данную связь
    @SerializedName("Vectors")
    private List<Vector3> vectors;

    public Link(final Integer from, final Integer to, final List<Vector3> vectors) {
        this.from = from;
        this.to = to;
        this.vectors = vectors;
    }
}