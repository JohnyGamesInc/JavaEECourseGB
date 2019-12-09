package gb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Field should not be empty")
    private String name;

    @Column(name = "price", scale = 2, precision = 10)
    @NotNull(message = "Field should not be empty")
    private double price;

    @Column(name = "count")
    private int count;

    @Column(name= "description", length = 255)
    @Size(min = 10, max = 100, message = "Поле должно содержать от 4 до 100 символов")
    private String description;

    @Column(name = "active")
    private boolean active;

}
