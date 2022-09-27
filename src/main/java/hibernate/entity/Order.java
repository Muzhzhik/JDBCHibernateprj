package hibernate.entity;

import jakarta.persistence.*;
import lombok.*;


/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_phone")
    private String clientPhone;

    @Column(name = "order_list")
    private String order;

    public Order(String clientName, String clientPhone, String order) {
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.order = order;
    }

    @Override
    public String toString() {
        return  "\033[0;36m" + id +
                " | Имя: '" + clientName + '\'' +
                " | Телефон: '" + clientPhone + '\'' +
                " | Заказ: '" + order + '\'' +
                ";\033[0m";
    }
}
