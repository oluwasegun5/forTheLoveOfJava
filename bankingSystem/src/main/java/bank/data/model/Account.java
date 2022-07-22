package bank.data.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class Account {
    private int id;
    @NonNull
    private String Firstname;
    @NonNull
    private String Lastname;
    @NonNull
    private String email;
    @NonNull
    private int age;
}
