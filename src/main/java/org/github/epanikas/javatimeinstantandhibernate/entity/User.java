package org.github.epanikas.javatimeinstantandhibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcType;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @SequenceGenerator(name = "idgen", sequenceName = "MY_ID_SEQUENCE")
    private long id;

    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "TIMESTAMP_VAL")
    private Instant timestampVal;

    @Column(name = "DATE_VAL"/*, columnDefinition = "DATE"*/)
    @JdbcTypeCode(Types.TIMESTAMP)
    private Instant dateVal;

    public User() {
        //
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.timestampVal = Instant.now();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateVal=" + timestampVal +
                '}';
    }
}