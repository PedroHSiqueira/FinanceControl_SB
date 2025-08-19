package dev.siqueira.financecontrol_sb.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updateAt;

    public UserModel() {
    }

    public UserModel(String username, String password, LocalDateTime createAt, LocalDateTime updateAt) {
        this.username = username;
        this.password = password;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
