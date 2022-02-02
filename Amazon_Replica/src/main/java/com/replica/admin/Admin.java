package com.replica.admin;

import com.replica.Main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Admin {

    static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(ProductDetail.class)
            .buildSessionFactory();
    static Session session = sessionFactory.getCurrentSession();

    private String productId;
    private String productName;
    private String manufacturerName;
    private Integer productPrice;
    private Integer productDiscount;
    private Integer productStock;
    private String createdBy;


    public void showAdminOptions(String adminName) {
        this.createdBy = adminName;

        System.out.println("***************  Welcome " + createdBy + "  ****************");
        System.out.println("1. Create Product");
        System.out.println("2. View Product List");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Logout");
        System.out.print("Select Operation: ");
        int pOption = Main.scan.nextInt();

        switch (pOption) {
            case 1 -> createProduct();
            case 2 -> viewProductList();
            case 3 -> updateProduct();
            case 4 -> deleteProduct();
            case 5 -> Main.operations();
        }

    }


    public void createProduct() {
        getProductDetails();

        try {
            ProductDetail productDetail = new ProductDetail(productId, productName, manufacturerName, productPrice,
                    productDiscount, productStock, createdBy);

            // Start the Transaction
            session.beginTransaction();

            // Write into DB
            session.save(productDetail);

            // Commit the Transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        System.out.println("***************  Product Added  ****************\n\n");
        showAdminOptions(createdBy);
    }

    public void getProductDetails() {
        System.out.println();
        System.out.print("Product Id: ");
        productId = Main.scan.next();

        System.out.print("Product Name: ");
        Main.scan.nextLine();
        productName = Main.scan.nextLine();

        System.out.print("Product Manufacturer: ");
        manufacturerName = Main.scan.nextLine();

        System.out.print("Product Price: ");
        productPrice = Main.scan.nextInt();

        System.out.print("Product Discount: ");
        productDiscount = Main.scan.nextInt();

        System.out.print("Product Stock: ");
        productStock = Main.scan.nextInt();
//        System.out.println(productId + " " + productName + " " + manufacturerName + " " + productPrice + " " + productDiscount + " " + productStock + " " + createdBy);
    }

    private void viewProductList() {

        try {
            // Start the Transaction
            session.beginTransaction();

            System.out.println("\n***************  Product List  ****************");
            List<ProductDetail> userList =
                    session.createQuery("FROM ProductDetail p WHERE p.createdBy='"+createdBy+"'" ).getResultList();
            for(ProductDetail productDetail: userList){
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
        Main.operations();
    }

    private void updateProduct() {

        try {
            // Start the Transaction
            session.beginTransaction();

            System.out.println("\n***************  Product List  ****************");
            List<ProductDetail> userList =
                    session.createQuery("FROM ProductDetail p WHERE p.createdBy='"+createdBy+"'" ).getResultList();
            for(ProductDetail productDetail: userList){
                System.out.println(productDetail);
            }
            System.out.println();

            System.out.println();
            System.out.println("1. Product Name");
            System.out.println("2. Manufacturer Name");
            System.out.println("3. Price");
            System.out.println("4. Discount");
            System.out.println("5. Stock");
            System.out.print("Select Options to Update: ");
            int updateChoice = Main.scan.nextInt();

            System.out.print("Enter Change: ");
            Main.scan.nextLine();
            String changes = Main.scan.nextLine();

            System.out.print("Enter Product Id: ");
            String productId = Main.scan.next();

            String whatToUpdate = null;
            if(updateChoice == 1)
                whatToUpdate = "productName";
            else if(updateChoice == 2)
                whatToUpdate = "manufacturerName";
            else if(updateChoice == 3)
                whatToUpdate = "productPrice";
            else if(updateChoice == 4)
                whatToUpdate = "productDiscount";
            else if(updateChoice == 5)
                whatToUpdate = "productStock";

            // update into DB
            session.createQuery("UPDATE ProductDetail p set p."+whatToUpdate+"='"+changes+"' where p.productId='"+productId+"'").executeUpdate();

            // Commit the Transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        System.out.println("***************  Product Updated  ****************\n\n");
    }

    private void deleteProduct() {

        System.out.print("Enter Product Id: ");
        String productId = Main.scan.next();

        try {
            // Start the Transaction
            session.beginTransaction();

            // update into DB
            session.createQuery("DELETE FROM ProductDetail p where p.productId='"+productId+"' ").executeUpdate();

            // Commit the Transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        System.out.println("***************  Product Deleted  ****************\n\n");
    }
}