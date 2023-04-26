package org.academiadecodigo.bootcamp.glass.model.products;

import org.academiadecodigo.bootcamp.glass.model.products.options.LightSubOptions;
import org.academiadecodigo.bootcamp.glass.model.products.options.MaxSubOptions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Max")
public class MaxSub extends Subscriptions {
    public static int value = 100;
    private MaxSubOptions option7;
    private MaxSubOptions option8;
    private MaxSubOptions option9;
    public MaxSub() {
        super();
        super.setPrice(100);
        //default options for a Max package, concerning the light subscription
        setOption1(LightSubOptions.LIGHT_1);
        setOption2(LightSubOptions.LIGHT_2);
    }

    @Override
    public String toString() {
        return "MaxSub{" + super.toString() +
                "option7=" + option7 +
                ", option8=" + option8 +
                ", option9=" + option9 +
                '}';
    }

    public MaxSubOptions getOption7() {
        return option7;
    }

    public void setOption7(MaxSubOptions option7) {
        this.option7 = option7;
    }

    public MaxSubOptions getOption8() {
        return option8;
    }

    public void setOption8(MaxSubOptions option8) {
        this.option8 = option8;
    }

    public MaxSubOptions getOption9() {
        return option9;
    }

    public void setOption9(MaxSubOptions option9) {
        this.option9 = option9;
    }
}
