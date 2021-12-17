package province_customer.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import province_customer.model.Province;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
