package org.academiadecodigo.bootcamp.glass.model.products;

import org.academiadecodigo.bootcamp.glass.model.products.options.LightSubOptions;
import org.academiadecodigo.bootcamp.glass.model.products.options.MediumSubOptions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Medium")
public class MediumSub extends Subscriptions {

    public static int value = 40;
    private MediumSubOptions option3;
    private MediumSubOptions option4;
    private MediumSubOptions option5;
    public MediumSub() {
        super();
        super.setPrice(40);

        //default options for a medium package, concerning the light subscription
        setOption1(LightSubOptions.LIGHT_1);
        setOption2(LightSubOptions.LIGHT_2);
    }

    @Override
    public String toString() {
        return "MediumSub{" + super.toString() +
                ", option3=" + option3 +
                ", option4=" + option4 +
                ", option5=" + option5 +
                '}';
    }

    public MediumSubOptions getOption3() {
        return option3;
    }

    public void setOption3(MediumSubOptions option3) {
        this.option3 = option3;
    }

    public MediumSubOptions getOption4() {
        return option4;
    }

    public void setOption4(MediumSubOptions option4) {
        this.option4 = option4;
    }

    public MediumSubOptions getOption5() {
        return option5;
    }

    public void setOption5(MediumSubOptions option5) {
        this.option5 = option5;
    }
}
