package automation.csv.beans;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class LoginBean {

    @CsvBindByName(column = "Username")
    private String username;

    @CsvBindByName (column = "Password")
    private String password;

}
