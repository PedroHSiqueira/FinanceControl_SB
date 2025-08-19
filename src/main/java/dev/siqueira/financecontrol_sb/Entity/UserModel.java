package dev.siqueira.financecontrol_sb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private LocalDateTime createAt;
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
