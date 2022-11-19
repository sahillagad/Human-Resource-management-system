package Usecase;

import Dao.AdminDao;
import Dao.AdminDaoImpl;

public class GetAllDepartment {
    public static void main(String[] args) {

        AdminDao dao=new AdminDaoImpl();

        try {
            dao.getAllDepartment();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
