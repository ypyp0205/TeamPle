package Service;

import Dao.PartnerCompanyDao;

public class PartnerCompanyManagementServiceImpl implements PartnerCompanyManagementService {
PartnerCompanyDao partnerCompanyDao=new PartnerCompanyDao();
    @Override
    public void addPartnerCompany() {
       // partnerCompanyDao.addPartnerCompany();
    }

    @Override
    public void deletePartnerCompany() {
        partnerCompanyDao.deletePartnerCompany();
    }

    @Override
    public void getPartnerList() {
        partnerCompanyDao.getPartnerList();
    }
}
