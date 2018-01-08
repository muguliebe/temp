package com.skcc.start.entity.common;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String groupCode;
    String code;
    String value;
}
