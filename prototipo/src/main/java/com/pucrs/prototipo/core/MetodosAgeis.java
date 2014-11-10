package com.pucrs.prototipo.core;

public enum MetodosAgeis {

    XP("Xp"), KANBAN("Kanban"), SCRUM("Scrum"), OTHER("");

    private String value;

    private MetodosAgeis(String value) {
	this.value = value;
    }

    public  void setValue(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }

}
