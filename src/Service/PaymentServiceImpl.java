package Service;

import Dao.PaymentDao;

public class PaymentServiceImpl implements PaymentService {
PaymentDao paymentDao=new PaymentDao();
    @Override
    public void payList() {
        paymentDao.payList();
    }

    @Override
    public void pay() {
        paymentDao.pay();
    }
}
