package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.repository.CompanyDao;
import peaksoft.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Company> getAllCompany() {
        return manager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public void addCompany(Company company) {
        manager.persist(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return manager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company) {
        manager.merge(company);
    }

    @Override
    public void deleteCompany(Long id) {
        manager.remove(manager.find(Company.class,id));
    }
}
