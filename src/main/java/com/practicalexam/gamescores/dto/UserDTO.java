package com.practicalexam.gamescores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String userName;
    private String email;
}


/*DTO's were created as a server-side optimization technique.
Instead of returning entire entity objects, using  DTOs (Data Transfer Objects)
we can return only the required data.
This reduces unnecessary data transfer.
* */