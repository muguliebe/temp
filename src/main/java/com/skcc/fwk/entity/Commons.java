package com.skcc.fwk.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component(value = "commons")
public class Commons {
    CommonArea area;
}
