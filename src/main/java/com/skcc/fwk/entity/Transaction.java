package com.skcc.fwk.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Transaction {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   int id;

   String day;
   String time;
   String ip;
   String url;
   String status;
   long elapsed;
}
