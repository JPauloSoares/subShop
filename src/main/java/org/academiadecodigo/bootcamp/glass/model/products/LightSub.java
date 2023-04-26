package org.academiadecodigo.bootcamp.glass.model.products;

import org.academiadecodigo.bootcamp.glass.model.products.options.LightSubOptions;
import org.academiadecodigo.bootcamp.glass.model.products.options.MaxSubOptions;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Light")
public class LightSub extends Subscriptions {

    public static int value = 15;
    public LightSub(){
        super();
        super.setPrice(15);
    }

    @Override
    public void setOption1(LightSubOptions option1) {
        super.setOption1(option1);
    }

    @Override
    public void setOption2(LightSubOptions option2) {
        super.setOption2(option2);
    }
}
