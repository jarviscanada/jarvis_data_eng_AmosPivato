package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {

    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
                "hplussport", "postgres", "password");
        try {
            Connection connection = dcm.getConnection();
            //challenge question
            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1000);
            System.out.println(order);

            //CustomerDAO customerDAO = new CustomerDAO(connection);

            /*Customer customer = new Customer(); //this block creates a dto for a new customer, adds it to the db, updates it and then deletes it through the dao
            customer.setFirstName("John");
            customer.setLastName("Adams");
            customer.setPhone("(555) 555-9845");
            customer.setEmail("jadams.wh.gov");
            customer.setAddress("1234 Main St");
            customer.setCity("Arlington");
            customer.setState("VA");
            customer.setZipCode("01234");

            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            dbCustomer.setEmail("john.adams@wh.gov");
            dbCustomer = customerDAO.update((dbCustomer));
            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());*/

            /*Customer customer = customerDAO.findById(10000); //this dto is created to check entry field data and then update it using its DAO update statem and sto set method
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());
            customer.setEmail("gwashington@wh.gov");
            customer = customerDAO.update(customer);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " + customer.getEmail());*/

            /*Customer customer = customerDAO.findById(1000);  //this block finds a customer by its id by passing the customer dto through the dao
            System.out.println(customer.getFirstName() + " " +customer.getLastName());*/

            /*Customer customer = new Customer(); //block writes data to database using dto customer to send inthrough the DAO to the db
            customer.setFirstName("George");
            customer.setLastName("Washington");
            customer.setEmail("george.washington@wh.gove");
            customer.setPhone("(555) 555-6543");
            customer.setAddress("1234 Main st");
            customer.setCity("Mount Vernon");
            customer.setState("VA");
            customer.setZipCode("222121");
            customerDAO.create(customer);*/

            /*Statement statement = connection.createStatement(); //this block just connects to db and counts all entries in table
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                }*/
            }catch (SQLException e){
                e.printStackTrace();
        }
    }
}
