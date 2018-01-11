package com.skcc.fwk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonArea {
    String gid;
    String date;
    String time;
    String url;
    String ip;
    long   elapsed;
}
