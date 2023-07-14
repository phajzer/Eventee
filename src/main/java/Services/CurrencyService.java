package Services;

import Client.CurrencyTable;
import Client.NBPClient;
import Utils.Currency;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CurrencyService {
    private NBPClient nbpClient;

    public Double getUserCurrencyValue(Currency currency, String userName) {
        CurrencyTable currencyTable = nbpClient.getCurrencyTable();
        return findCurrencyValue(currency, currencyTable);
    }

    private Double findCurrencyValue(Currency currency, CurrencyTable currencyTable) {
        try {
            return currencyTable.rates.stream()
                    .filter(x -> x.code.equals(currency.toString()))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Currency not found in the table"))
                    .mid;
        } catch (Exception e) {
            e.printStackTrace(); // Przykładowa obsługa błędu
            return null; // lub inna wartość domyślna, która wskazuje na brak wyniku
        }

    }
}


