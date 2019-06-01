package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountNumber;
    private Long balance;
    private int freeFunds;
    @Enumerated(EnumType.STRING)
    private Currency currency;

//    @ManyToOne (fetch = FetchType.LAZY)
//    private User owner;
}
