package de.seven.user.domain.model;

import lombok.Getter;

@Getter
public enum Type {
    USER("User"),
    GEWERBLICHER_VERMIETER("Gewerbliche:r Vermierter"),
    PRIVATER_GASTGEBER("Private:r Gastgeber:in");

    Type(String type) {
        this.type = type;
    }

    private final String type;

}
