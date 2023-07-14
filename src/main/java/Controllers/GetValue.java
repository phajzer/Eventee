package Controllers;

import Utils.Currency;
import lombok.Data;

@Data
public class GetValue {
    private Currency currency;
    private String name;
}
