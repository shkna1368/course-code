package com.mohammad.car.hib;


import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "pet.findAll", query = "from Pet pet"),
        @NamedQuery(name = "pet.findByName",
                query = "from Pet pet where pet.title=:title"),
})

@Entity
@Table(name = "tbl_pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Long id;


    public Pet() {
    }

    @Column(name = "color")
 private String color;


      @Column(name = "title")
 private String title;

    public Pet( String color, String title) {
        this.color = color;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
