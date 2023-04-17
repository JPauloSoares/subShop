package org.academiadecodigo.bootcamp.glass.model.products;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Max")
public class MaxSub extends Products {

    public MaxSub() {
        super();
        super.setDescription("Max Sub");
        super.setPrice(100);
    }
}
