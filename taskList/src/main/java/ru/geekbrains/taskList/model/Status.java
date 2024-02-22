package ru.geekbrains.taskList.model;


import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Перечисление статусов задачи
 */
public enum Status {

    NOT_STARTED("1"),

    IN_PROGRESS("2"),

    COMPLETED("3");
    private String statCode;

    /**
     * Конструктор перечисления
     * @param statCode код статуса
     */
    Status(String statCode) {
        this.statCode = statCode;
    }

    public String getStatCode() {
        return statCode;
    }

    /**
     * Метод сопоставления кода статуса с его наименованием
     * @param value код статуса
     * @return наименование статуса
     */
    @JsonCreator
    public static Status getStatusFromCode(String value) {
        for (Status stat : Status.values()) {
            if (stat.getStatCode().equals(value)) {
                return stat;
            }
        }
        return null;
    }
}


