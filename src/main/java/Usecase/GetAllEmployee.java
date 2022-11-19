package Usecase;

import Dao.AdminDao;
import Dao.AdminDaoImpl;

public class GetAllEmployee {

    public static void main(String[] args) {
        AdminDao dao=new AdminDaoImpl();
        try {
            dao.getAllEmployee();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
