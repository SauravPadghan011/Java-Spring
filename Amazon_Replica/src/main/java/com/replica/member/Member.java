package com.replica.member;

import com.replica.Main;
import com.replica.User.User;
import com.replica.admin.ProductDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Member {
    static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .addAnnotatedClass(ProductDetail.class)
            .addAnnotatedClass(OrderDetail.class)
            .buildSessionFactory();
    static Session session = sessionFactory.getCurrentSession();

    private String memberName;

    private String productName;
    private Integer productPrice;
    private Integer productDiscount;
    private Integer productStock;

    private Integer priceAfterDis;
    private Integer totalCost;
    private Integer quantity;
    private String orderedBy;
    private String deliveryAddr;

    public void showMembersOptions(String memberName) {
        this.memberName = memberName;

        System.out.println("***************  Welcome " + memberName + "  ****************");
        System.out.println("1. Create New Order");
        System.out.println("2. View Order History");
        System.out.println("3. Update Profile");
        System.out.println("4. Logout");
        System.out.print("Select Operation: ");
        int pOption = Main.scan.nextInt();

        switch (pOption) {
            case 1 -> createNewOrder();
            case 2 -> viewOrderHistory();
            case 3 -> updateProfile();
        }

    }

    private void createNewOrder() {

        try {
            // Start the Transaction
            session.beginTransaction();

            List<ProductDetail> productDetailList =
                    session.createQuery("FROM ProductDetail").getResultList();
            for(ProductDetail productDetail: productDetailList){
                System.out.println(productDetail);
            }

            System.out.println();
            System.out.print("Enter Order Id: ");
            String orderId = Main.scan.next();
            List<ProductDetail> orderList =
                    session.createQuery("FROM ProductDetail p WHERE p.productId='"+orderId+"'" ).getResultList();
            for(ProductDetail productDetail: orderList){
                productName = productDetail.getProductName();
                productPrice = productDetail.getProductPrice();
                productDiscount = productDetail.getProductDiscount();
                productStock = productDetail.getProductStock();
//                System.out.println(productName+productPrice+productDiscount+productStock);
            }

            System.out.print("Quantity: ");
            quantity = Main.scan.nextInt();
            System.out.print("Name: ");
            Main.scan.nextLine();
            orderedBy = Main.scan.nextLine();
            System.out.print("Delivery Address: ");
            deliveryAddr = Main.scan.nextLine();

            priceAfterDis = productPrice - (productPrice * productDiscount/100);
            totalCost = priceAfterDis*quantity;


            OrderDetail orderDetail = new OrderDetail(orderId, productName, productPrice, productDiscount, priceAfterDis,
                    totalCost, quantity, orderedBy, deliveryAddr);

            // Write into DB
            session.save(orderDetail);

            session.createQuery("UPDATE ProductDetail p set p.productStock='"+(productStock-quantity)
                    +"' where p.productId='"+orderId+"'").executeUpdate();

            // Commit the Transaction
            session.getTransaction().commit();


        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        System.out.println("***************  Order Placed  ****************\n\n");

    }

    private void viewOrderHistory() {
        System.out.println("\n***************  Order History  ****************");
        try {
            // Start the Transaction
            session.beginTransaction();

            List<OrderDetail> orderDetailList =
                    session.createQuery("FROM OrderDetail p WHERE p.orderedBy='"+memberName+"' ").getResultList();
            for(OrderDetail productDetail: orderDetailList){
                System.out.println(productDetail);
            }
            System.out.println();

            // Commit the Transaction
            session.getTransaction().commit();


        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        showMembersOptions(memberName);
    }

    private void updateProfile() {

        System.out.println("\n***************  Update Information  ****************");
        System.out.println("1. Address");
        System.out.println("2. Password");
        System.out.print("Select Options to Update: ");
        int updateChoice = Main.scan.nextInt();

        System.out.print("Enter Change: ");
        Main.scan.nextLine();
        String changes = Main.scan.nextLine();

        System.out.print("Enter Email: ");
        String email = Main.scan.next();

        String whatToUpdate = null;
        if(updateChoice == 1)
            whatToUpdate = "fullAddress";
        else if(updateChoice == 2)
            whatToUpdate = "passwd";

        try {
            // Start the Transaction
            session.beginTransaction();

            // update into DB
            session.createQuery("UPDATE User u set u."+whatToUpdate+"='"+changes+"' where u.email='"+email+"'").executeUpdate();

            // Commit the Transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        System.out.println("***************  "+whatToUpdate+" Updated  ****************\n\n");
        showMembersOptions(memberName);
    }

}
