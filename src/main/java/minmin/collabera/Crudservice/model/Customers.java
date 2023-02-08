package minmin.collabera.Crudservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Customers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Customers {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String customerType;

}
