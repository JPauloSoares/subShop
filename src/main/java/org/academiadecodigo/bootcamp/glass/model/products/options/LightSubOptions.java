package org.academiadecodigo.bootcamp.glass.model.products.options;

public enum LightSubOptions {
    LIGHT_1("light_sub1"),
    LIGHT_2("light_sub2"),
    LIGHT_3("light_sub3"),
    LIGHT_4("light_sub4"),
    LIGHT_5("light_sub5");

    public String description;
    LightSubOptions(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
