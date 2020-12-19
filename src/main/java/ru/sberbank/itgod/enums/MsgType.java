package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum MsgType {
    @SerializedName("-1")
    EMPTY(-1),
    @SerializedName("0")
    GAME_CREATE(0), // Создание игры. Посылается API сервером
    @SerializedName("1")
    BOT_CREATE(1), // Создание создание ботов для игры. Посылается API сервером
    @SerializedName("2")
    GAME_STARTED(2), // Игра началась. Посылается игровым сервером
    @SerializedName("3")
    GAME_ACTIONS(3), // Действия игрока. Посылается бот сервером, игроками.
    @SerializedName("4")
    GAME_STATE(4), // Состояние игры. Посылается игровым сервером.
    @SerializedName("5")
    GAME_CANCEL(5), // Отмена игры. Посылается игровым сервером, игроками
    @SerializedName("6")
    GAME_OVER(6), // Игра завершилась. Посылается игровым сервером.
    @SerializedName("7")
    GAME_PAUSE(7), // Пауза игры. Посылается игроками.
    @SerializedName("8")
    PLAYER_CONNECT(8), // Подсоединение игрока. Посылается бот сервером, игроками
    @SerializedName("9")
    PLAYER_DISCONNECT(9), // Отсоединение игрока. Посылается API сервером, когда сокет отвалился.
    @SerializedName("10")
    GAME_ALL_PLAYERS_CONNECTED(10), // Все игроки подсоединились. Посылается игровым сервером.
    @SerializedName("11")
    PLAYER_PREPARED(11), // Игрок готов. Посылается игроком.
    @SerializedName("12")
    GAME_ALL_PLAYERS_PREPARED(12), // Все игроки готовы. Посылается игровым сервером.
    @SerializedName("13")
    PLAYER_READY(13), // Игрок готов к началу игры
    @SerializedName("14")
    GAME_ALL_PLAYERS_READY(14), // Все игроки готовы к началу игры
    @SerializedName("15")
    GAME_CREATED(15), // Игра создана
    @SerializedName("16")
    BOT_INITIALIZED(16), // Бот инициализирован
    @SerializedName("17")
    PLAYER_REQUEST_GAME_PARAMETERS(17), // Игрок запрашивает игру к которой надо подсоединяться
    @SerializedName("18")
    PLAYER_RESPONSE_GAME_PARAMETERS(18), // Сервер возвращает запрошенную игру игроку
    @SerializedName("21")
    INIT_BOT(21), // Сообщить боту об инициализации
    @SerializedName("22")
    PLAYER_CHANGE_HERO_TYPE(22), // Сообщение об изменении выбора игрока
    @SerializedName("23")
    PLAYER_CHANGE_COLOR(23), // Сообщение об изменении выбора игрока
    @SerializedName("24")
    LOBBY_CHANGED(24), // Сообщение об изменении лобби
    @SerializedName("25")
    COMPLETE_CONNECTION(25), // Завершение подсоединения
    @SerializedName("26")
    HAND_SHAKE(26), // Рукопожатие
    @SerializedName("27")
    ERROR_REPORT(27), // Отчет об ошибках
    @SerializedName("28")
    LOAD_REPORT(28); // Отчет о нагрузке


    private int value;

    MsgType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
