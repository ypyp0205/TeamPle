package Service;

import Dao.BookShoppingBasketDao;

public class BookShoppingBasketServiceImpl implements BookShoppingBasketService {
 public  BookShoppingBasketDao bookShoppingBasketDao=new BookShoppingBasketDao();
 @Override
 public void addBookShoppingBasket() {
  bookShoppingBasketDao.addBookShoppingBasket();
 }

 @Override
 public void bookShoppingBasketMenu() {
bookShoppingBasketDao.bookShoppingBasketMenu();
 }

 @Override
 public void removeBookName() {
bookShoppingBasketDao.removeBookName();
 }

 @Override
 public void bookShoppingBasketList() {
bookShoppingBasketDao.bookShoppingBasketList();
 }
}
