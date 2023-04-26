package org.academiadecodigo.bootcamp.glass.model.products;

import org.academiadecodigo.bootcamp.glass.model.products.options.LightSubOptions;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "subType")
@Table(name = "subs")
public abstract class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double price;
    private LightSubOptions option1;
    private LightSubOptions option2;

    public LightSubOptions getOption1() {
        return option1;
    }

    public void setOption1(LightSubOptions option1) {
        this.option1 = option1;
    }

    public LightSubOptions getOption2() {
        return option2;
    }

    public void setOption2(LightSubOptions option2) {
        this.option2 = option2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Subscriptions{" +
                "id=" + id +
                ", price=" + price +
                ", option1=" + option1 +
                ", option2=" + option2 +
                '}';
    }
}
