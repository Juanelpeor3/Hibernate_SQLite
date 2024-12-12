import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("¿Que tabla quiere consultar?\n\t" +
                "1:Tabla customers\n\t" +
                "2:Tabla departments\n\t" +
                "3:Tabla employee_projects\n\t" +
                "4:Tabla employees_realistic\n\t" +
                "5:Tabla order_items\n\t" +
                "6:Tabla orders\n\t" +
                "7:Tabla projects\n\t" +
                "8:Consulta Costos salariales (punto c)\n\t" +
                "9:Consulta Combinar presupuestos (punto d)\n\t" +
                "0:Consulta Calcular fraccion (punto e)");
        Scanner scanner = new Scanner(System.in);
        // Igualo una variable al scanner
        int opcion = scanner.nextInt();
        // Menu de opciones
        if (opcion == 1) {
            verTablaCustomers();
        }
        if (opcion == 2) {
            verTablaDepartments();
        }
        if (opcion == 3) {
            verTablaEmployeeProjects();
        }
        if (opcion == 4) {
            verTablaEmployeeRealistic();
        }
        if (opcion == 5) {
            verTablaOrderItems();
        }
        if (opcion == 6) {
            verTablaOrders();
        }
        if (opcion == 7) {
            verTablaProjects();
        }
        if (opcion == 8) {
            verConsultaC();
        }
        if (opcion == 9) {
            verConsultaD();
        }
        if (opcion == 0) {
            verConsultaE();
        }

    }

    public static void verTablaCustomers() {
        // Mostrar tabla listada
        System.out.println("Tabla Customers");

        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Customers.class) // Añadir la clase de entidad Customers
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los customers
            String hql = "FROM Customers";
            Query<Customers> query = session.createQuery(hql, Customers.class);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Customers> customersList = query.getResultList();

            // Mostrar los datos de los customers
            for (Customers customer : customersList) {
                System.out.println(customer.getCustomerId() + " | " + customer.getCustomerName() + " | " + customer.getContactEmail() + " | " + customer.getContactPhone());
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    public static void verTablaDepartments() {
        // Mostrar tabla listada
        System.out.println("Tabla Departments");

        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Departments.class) // Añadir la clase de entidad departments
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los departments
            String hql = "FROM Departments";
            Query<Departments> query = session.createQuery(hql, Departments.class);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Departments> departmentsList = query.getResultList();

            // Mostrar los datos de los departments
            for (Departments departments : departmentsList) {
                System.out.println(departments.getDepartmentId() + " | " + departments.getDepartmentName() + " | " + departments.getManagerId());
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    public static void verTablaEmployeeProjects() {
        // Mostrar tabla listada
        System.out.println("Tabla Employeee_Projects");

        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Employee_projects.class) // Añadir la clase de entidad employee_projects
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los employee_projects
            String hql = "FROM Employee_projects";
            Query<Employee_projects> query = session.createQuery(hql, Employee_projects.class);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Employee_projects> Employee_pList = query.getResultList();

            // Mostrar los datos de los employee_projects
            for (Employee_projects employee_projects : Employee_pList) {
                System.out.println(employee_projects.getEmployeeId() + " | " + employee_projects.getProyectId() + " | " + employee_projects.getHoursWorked());
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    public static void verTablaEmployeeRealistic() {
        // Mostrar tabla listada
        System.out.println("Tabla Employeee_Realistic");

        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Employee_realistic.class) // Añadir la clase de entidad employee_realistic
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los employee_realistic
            String hql = "FROM Employee_realistic";
            Query<Employee_realistic> query = session.createQuery(hql, Employee_realistic.class);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Employee_realistic> Employee_rList = query.getResultList();

            // Mostrar los datos de los employee_realistic
            for (Employee_realistic employee_realistic : Employee_rList) {
                System.out.println(employee_realistic.getEmployeeId() + " | " + employee_realistic.getFirstName() + " | " + employee_realistic.getLastName() + " | " + employee_realistic.getDepartmentId() + " | " + employee_realistic.getHireDate() + " | " + employee_realistic.getSalary() + " | " + employee_realistic.getPosition());
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    public static void verTablaOrders() {
        // Mostrar tabla listada
        System.out.println("Tabla Orders");

        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Orders.class) // Añadir la clase de entidad orders
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los orders
            String hql = "FROM Orders";
            Query<Orders> query = session.createQuery(hql, Orders.class);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Orders> orderList = query.getResultList();

            // Mostrar los datos de los orders
            for (Orders orders : orderList) {
                System.out.println(orders.getOrderId() + " | " + orders.getCustomerId() + " | " + orders.getOrderDate() + " | " + orders.getAmount());
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    public static void verTablaOrderItems() {
        // Mostrar tabla listada
        System.out.println("Tabla Order_Items");

        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Order_items.class) // Añadir la clase de entidad orderitems
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los orderitems
            String hql = "FROM Order_items";
            Query<Order_items> query = session.createQuery(hql, Order_items.class);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Order_items> orderItemsList = query.getResultList();

            // Mostrar los datos de los orderitems
            for (Order_items order_items : orderItemsList) {
                System.out.println(order_items.getOrderItemId() + " | " + order_items.getOrderId() + " | " + order_items.getProductName() + " | " + order_items.getQuantity() + " | " + order_items.getPrice());
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    public static void verTablaProjects() {
        // Mostrar tabla listada
        System.out.println("Tabla Projects");

        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Projects.class) // Añadir la clase de entidad projects
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los projects
            String hql = "FROM Projects";
            Query<Projects> query = session.createQuery(hql, Projects.class);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Projects> projectsList = query.getResultList();

            // Mostrar los datos de los projects
            for (Projects projects : projectsList) {
                System.out.println(projects.getProjectId() + " | " + projects.getProjectName() + " | " + projects.getDepartmentId() + " | " + projects.getBudget() + " | " + projects.getStartDate() + " | " + projects.getEndDate());
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    public static void verConsultaC(){
        System.out.println("Consulta C");
        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Employee_realistic.class) // Añadir la clase de entidad EmployeeRealistic
                .addAnnotatedClass(Employee_projects.class) // Añadir la clase de entidad EmployeeProjects
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los orderitems
            String hql = "Select er.firstName,((er.salary/1900)*ep.hoursWorked) as costo_salarial " +
                    "From Employee_realistic er " +
                    "join Employee_projects ep on er.employeeId = ep.employeeId";
            Query<Object[]> query = session.createQuery(hql);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Object[]> orderItemsList = query.getResultList();

            // Mostrar los datos de los orderitems
            for (Object[] objects : orderItemsList) {
                String firstName = (String) objects[0];
                String costoSalarial = (String) objects[1];
                System.out.println(firstName + " | " + costoSalarial);
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    public static void verConsultaD(){
        System.out.println("Consulta D");
        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Employee_realistic.class) // Añadir la clase de entidad EmployeeRealistic
                .addAnnotatedClass(Employee_projects.class) // Añadir la clase de entidad EmployeeProjects
                .addAnnotatedClass(Projects.class) //Añadir la clase de entidad Projects
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los orderitems
            String hql = "Select p.projectName,SUM((er.salary/1900)*ep.hoursWorked) as costo_salarial,p.budget as presupuesto " +
                    "From Employee_realistic er " +
                    "join Employee_projects ep on er.employeeId = ep.employeeId " +
                    "join Projects p on p.projectId=ep.proyectId "+
                    "group by p.projectName, p.budget";
            Query<Object[]> query = session.createQuery(hql);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Object[]> orderItemsList = query.getResultList();

            // Mostrar los datos de los orderitems
            for (Object[] objects : orderItemsList) {
                String firstName = (String) objects[0];
                BigDecimal costoSalarial = (BigDecimal) objects[1];
                String costoSalarialStr = costoSalarial.toString();

                String budget = (String) objects[2];
                System.out.println(firstName + " | " + costoSalarialStr+" | "+budget);
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

    }
    public static void verConsultaE(){
        System.out.println("Consulta E");
        // Crear la SessionFactory y obtener una Session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Employee_realistic.class) // Añadir la clase de entidad EmployeeRealistic
                .addAnnotatedClass(Employee_projects.class) // Añadir la clase de entidad EmployeeProjects
                .addAnnotatedClass(Projects.class) //Añadir la clase de entidad Projects
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Consulta HQL para obtener todos los orderitems
            String hql = "Select p.projectName,SUM((er.salary/1900)*ep.hoursWorked) as costo_salarial,p.budget as presupuesto,((SUM((er.salary/1900)*ep.hoursWorked)))/p.budget as fraccion " +
                    "From Employee_realistic er " +
                    "join Employee_projects ep on er.employeeId = ep.employeeId " +
                    "join Projects p on p.projectId=ep.proyectId "+
                    "group by p.projectName, p.budget";
            Query<Object[]> query = session.createQuery(hql);

            // Ejecutar la consulta el resultado se listara en la lista
            List<Object[]> orderItemsList = query.getResultList();

            // Mostrar los datos de los orderitems
            for (Object[] objects : orderItemsList) {
                String firstName = (String) objects[0];
                BigDecimal costoSalarial = (BigDecimal) objects[1];
                String costoSalarialStr = costoSalarial.toString();

                String budget = (String) objects[2];
                String fraccion = (String) objects[3];
                System.out.println(firstName + " | " + costoSalarialStr+" | "+budget+" | "+fraccion);
            }

            // Hacer commit de la transaccion
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}


