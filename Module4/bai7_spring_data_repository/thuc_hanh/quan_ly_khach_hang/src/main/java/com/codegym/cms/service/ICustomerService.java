package province_customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import province_customer.model.Customer;
import province_customer.model.Province;

@Service
public interface ICustomerService extends IGeneralService<Customer, Long>{
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByProvince(Province province, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);

}
