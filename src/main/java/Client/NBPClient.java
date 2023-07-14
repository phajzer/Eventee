package Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nbp", url = "http://api.nbp.pl/api")
public interface NBPClient {
    @GetMapping("/exchangerates/tables/A?format=json")
    CurrencyTable getCurrencyTable();

    @GetMapping("/exchangerates/rates/a/{code}/?format=json")
    CurrencyTable getCurrency(@PathVariable("code") String code);
}

