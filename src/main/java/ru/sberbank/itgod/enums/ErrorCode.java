package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Перечисление возможных ошибок
 */
public enum ErrorCode {

    @SerializedName("999")
    UNDEFINED(999),
    @SerializedName("1000")
    USER_NOT_FOUND(1000),
    @SerializedName("1001")
    BOT_NOT_FOUND(1001),
    @SerializedName("1002")
    MAP_NOT_FOUND(1002),
    @SerializedName("1003")
    USER_WITH_SUCH_NAME_ALREADY_EXISTS(1003),
    @SerializedName("1004")
    PLAYER_WITH_SUCH_NAME_ALREADY_EXISTS(1004),
    @SerializedName("1005")
    USER_IS_LOCKED(1005),
    @SerializedName("1006")
    WRONG_PASSWORD(1006),
    @SerializedName("1007")
    THERE_IS_NO_AVAILABLE_GAME_SERVERS(1007),
    @SerializedName("1008")
    PLAYERS_COUNT_NOT_SUPPORTED_ON_THIS_MAP(1008),
    @SerializedName("1009")
    WRONG_TOKEN(1009),
    @SerializedName("1010")
    PLAYER_NOT_FOUND(1010),
    @SerializedName("1011")
    GAME_NOT_FOUND(1011),
    @SerializedName("1012")
    GAME_LOGS_NOT_READY(1012),
    @SerializedName("1013")
    THERE_IS_NO_AVAILABLE_BOT_SERVERS(1013),
    @SerializedName("1014")
    MAP_WITH_SUCH_NAME_ALREADY_EXISTS(1014),
    @SerializedName("1015")
    MAP_MUST_SUPPORT_MINIMUM_TWO_PLAYERS(1015),
    @SerializedName("1016")
    REQUEST_CONTAINS_DUPLICATE_PLAYERS(1016),
    @SerializedName("1017")
    DEBUG_GAME_IS_ONLY_FOR_BOTS(1017),
    @SerializedName("1018")
    USER_WITH_SUCH_EMAIL_ALREADY_EXISTS(1018),
    @SerializedName("1019")
    REQUEST_HAS_NO_CONTENT_TYPE(1019),
    @SerializedName("1020")
    EMBLEM_NOT_FOUND(1020),
    @SerializedName("1021")
    ACCESS_DENIED(1021),
    @SerializedName("1022")
    FEEDBACK_IS_EMPTY(1022),
    @SerializedName("1024")
    TOURNAMENT_IN_PROGRESS(1024),
    @SerializedName("1025")
    TOURNAMENT_IS_NOT_IN_PROGRESS(1025),
    @SerializedName("1026")
    EMAIL_IS_FORBIDDEN(1026),
    @SerializedName("1027")
    EMBLEMS_UPLOAD_IS_NOT_ALLOWED(1027),
    @SerializedName("1028")
    MATCH_NOT_FOUND(1028),
    @SerializedName("1029")
    MATCH_START_NOT_ALLOWED_BY_TIME_FRAME(1029),
    @SerializedName("1030")
    MATCH_START_NOT_ALLOWED_TO_CURRENT_USER(1030),
    @SerializedName("1031")
    MATCH_START_DATE_GREATER_THAN_END_DATE(1031),
    @SerializedName("1032")
    MATCH_GAME_OVER(1032),
    @SerializedName("1033")
    EMBLEM_WITH_SUCH_ID_ALREADY_EXISTS(1033),
    @SerializedName("1034")
    SPECIFYING_EMBLEM_ID_IS_NOT_ALLOWED(1034),
    @SerializedName("1035")
    BOT_SCRIPT_ERROR(1035),
    @SerializedName("1036")
    BOT_COMPILATION_ERROR(1036),
    @SerializedName("1037")
    WRONG_CONTENT_TYPE(1037),
    @SerializedName("1038")
    USER_EMAIL_CANT_BE_CHANGED(1038),
    @SerializedName("1039")
    USER_EMAIL_CONFIRMATION_REQUIRED(1039),
    @SerializedName("1040")
    EMAIL_FORMAT_IS_NOT_VALID(1040),
    @SerializedName("1041")
    MAIL_SERVICE_IS_UNAVAILABLE(1041),
    @SerializedName("1042")
    USER_ACHIEVEMENT_NOT_FOUND(1042),
    @SerializedName("1043")
    CODE_EXPIRED(1043),
    @SerializedName("1044")
    USER_LOGIN_EXCEEDS_THIRTEEN_SYMBOLS(1044),
    @SerializedName("1045")
    NEWS_NOT_FOUND(1045),
    @SerializedName("1046")
    TOURNAMENT_PARTICIPANT_TYPE_NOT_SUPPORTED(1046),
    @SerializedName("1047")
    TOURNAMENT_NOT_FOUND(1047),
    @SerializedName("1048")
    TOURNAMENT_USER_ALREADY_REGISTERED(1048),
    @SerializedName("1049")
    TOURNAMENT_BOT_ID_NOT_SPECIFIED(1049),
    @SerializedName("1050")
    TOURNAMENT_PLAYER_TYPE_CHANGE_FORBIDDEN(1050),
    @SerializedName("1051")
    TOURNAMENT_REGISTRATION_IS_CLOSED(1051),
    @SerializedName("1052")
    TOURNAMENT_REGISTRATION_IS_OPEN_CHANGE_FORBIDDEN(1052),
    @SerializedName("1053")
    TOURNAMENT_STAGE_MUST_CONTAIN_AT_LEAST_TWO_PLAYERS(1053),
    @SerializedName("1054")
    TOURNAMENT_STAGE_NOT_ALL_GAMES_FINISHED(1054),
    @SerializedName("1055")
    TOURNAMENT_STAGE_NOT_FOUND(1055),
    @SerializedName("1056")
    TOURNAMENT_STAGE_NO_MATCHES_TO_SCHEDULE(1056),
    @SerializedName("1057")
    TOURNAMENT_NOTIFICATIONTURNED_OFF_FOR_PLAYER_TYPE(1057),
    @SerializedName("1058")
    TOURNAMENT_STAGE_NO_MATCHES_TO_NOTIFY(1058),
    @SerializedName("1059")
    VERSION_NUMBER_WRONG_FORMAT(1059),
    @SerializedName("1060")
    VERSION_NOT_FOUND(1060),
    @SerializedName("1061")
    TOURNAMENT_USER_NOT_REGISTERED(1061),
    @SerializedName("1062")
    TOURNAMENT_STAGE_NOT_ALL_BOTS_REGISTERED(1062),
    @SerializedName("1063")
    TOURNAMENT_BOT_EDITING_IS_NOT_ALLOWED(1063),
    @SerializedName("1064")
    TOURNAMENT_PLAYER_NOT_FOUND(1064),
    @SerializedName("1065")
    TOURNAMENT_BOT_REGISTRATION_IS_CLOSED(1065),
    @SerializedName("1066")
    TOURNAMENT_WORK_REGISTRATION_IS_CLOSED(1066),
    @SerializedName("1067")
    TOURNAMENT_WORK_CONTENT_EXCEEDED_FIVE_MEGABYTES(1067),
    @SerializedName("1068")
    TOURNAMENT_WORK_ALREADY_ADDED(1068),
    @SerializedName("1069")
    TOURNAMENT_WORK_NOT_FOUND(1069),
    @SerializedName("1070")
    TOURNAMENT_WORK_TOURNAMENT_ID_CHANGE_IS_FORBIDDEN(1070),
    @SerializedName("1071")
    TOURNAMENT_WORK_VOTE_ALREADY_ADDED(1071),
    @SerializedName("1072")
    TOURNAMENT_WORK_VOTE_NOT_FOUND(1072),
    @SerializedName("1073")
    TOURNAMENT_WORK_VOTE_TOURNAMENT_ID_CHANGE_IS_FORBIDDEN(1073),
    @SerializedName("1074")
    TOURNAMENT_WORK_VOTE_DISABLED(1074);

    private static final ErrorCode[] ALL_VALUES = values();
    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static ErrorCode getByCode(final int code) {
        for (final ErrorCode errorCode : ALL_VALUES) {
            if (errorCode.code == code)
                return errorCode;
        }
        return UNDEFINED;
    }
}
