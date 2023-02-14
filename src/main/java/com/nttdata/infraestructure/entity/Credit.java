package com.nttdata.infraestructure.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Credit")
public class Credit extends PanacheEntity {
  private String numberDocument;
  private String dateStart;
  private double share;
  private String datePay;
  private double balanceStart;
  private double amount;
  private String balanceEnd;
  private String created_datetime;
  private String updated_datetime;
  private String active;
}
