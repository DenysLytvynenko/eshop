package com.eshop.store.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    public String id;

    public String login;
    public String firstName;
    public String lastName;
    public String password;
    public String name;

}
