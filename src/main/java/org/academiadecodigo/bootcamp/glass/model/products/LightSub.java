package org.academiadecodigo.bootcamp.glass.model.products;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Light")
public class LightSub extends Products {

    public LightSub(){
        super();
        super.setDescription("Light Sub");
        super.setPrice(15);
    }

}
