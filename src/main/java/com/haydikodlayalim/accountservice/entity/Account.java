package com.haydikodlayalim.accountservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter //tüm fieldlar için getter

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Table(value = "accounts")   // nasıl bi tabloya karşılık gelecek. Tablo belirlenir
public class Account implements Serializable {

    @PrimaryKey //bu field primary key dir. Import u cassandra dan gelmeli.
    private String Id = UUID.randomUUID().toString(); // bu nesne her instance oluşturuldugunda oluşturulsun

    @Setter
    @Column(value = "uname")
    private String userName;

    @Setter
    @Column(value = "email")
    private String email;

    @Setter
    @Column(value = "pwd")
    private String password;

    @Column(value = "created_at")
    private Date createdAt;

    @Column(value = "is_activated")
    private Boolean active;




}
