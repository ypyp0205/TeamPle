package Service;

import Dao.BusinessDao;

public class BusinessServiceImpl implements  BusinessService{
    public BusinessDao businessDao=new BusinessDao();
    @Override
    public void addTrade() {
        businessDao.addTrade();

    }

    @Override
    public void deleteTrade() {
        businessDao.deleteTrade();
    }

    @Override
    public void showTradeHistory() {
        businessDao.showTradeHistory();
    }
}
