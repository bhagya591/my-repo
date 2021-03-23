package com.bpg.palindrome.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Palindrome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String input;

    @Column
    private String palindrome;


    public  Palindrome(String input){
        this.input=input;
    }
}
