package kz.example.contact_manager_api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactModel {
    @NotNull(message = "Заполните имя")
    @Size(min = 1)
    private String name;
    @NotNull(message = "Заполните номер")
    @Size(min = 11, max = 11)
    private String number;
    @NotNull(message = "Заполните адрес почты")
    @Email
    private String email;
}
