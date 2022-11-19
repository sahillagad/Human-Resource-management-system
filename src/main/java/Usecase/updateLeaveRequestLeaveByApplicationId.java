package Usecase;

import Dao.AdminDao;
import Dao.AdminDaoImpl;

import java.util.Scanner;

public class updateLeaveRequestLeaveByApplicationId {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Application Id");
        int applicationId= sc.nextInt();

        AdminDao dao=new AdminDaoImpl();
        try {
            String s=dao.updateLeaveRequestLeaveApplicationId(applicationId);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
