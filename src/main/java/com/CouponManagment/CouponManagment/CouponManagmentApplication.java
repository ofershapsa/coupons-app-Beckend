package com.CouponManagment.CouponManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CouponManagmentApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(CouponManagmentApplication.class, args);
	//	CouponSystem cs = ctx.getBean(CouponSystem.class);
//	AdminFacade	 af=(AdminFacade) cs.login("admin","1234" , ClientType.ADMIN);
	//	Customer customer = new Customer();
	//	customer.setCustomerName("ofer shapsa");
	//	customer.setPassword("ofer123");
		// af.createCustomer(customer);
//		System.out.println(af.getCustomer(1L));
	//	Company company = new Company();
	//	company.setCompanyName("kupot");
	//	company.setPassword("kupot123");
	//	company.setEmail("kupot@gmail.com");
		// af.createCompany(company);
	//System.out.println(	af.getCompany(3L));
		//CompanyDAO cd = ctx.getBean(CompanyDAO.class);
		// company = cd.findCompany(5L);
//	af.removeCompany(company);

		// CustomerFacade cf = (CustomerFacade) cs.login("ofer shapsa",
		// "$2a$10$nIAx35ValBVOlKUArz1KxetlcsFcFNnC7WjkSTHn8SJLCyodGsvlm",
		// ClientType.CUSTOMER);

		//CompanyFacade cof = (CompanyFacade) cs.login("kupot",
			//	"$2a$10$JCTc5zHRzmZYsjuXT2TKC.Z5pyk2N1Z//bZXVCTXBs0rZrWZf7qwy", ClientType.COMPANY);
	//	CustomerDAO cud = ctx.getBean(CustomerDAO.class);
	//	CouponDAO coup = ctx.getBean(CouponDAO.class);

	//	long millis = System.currentTimeMillis();
	//	java.util.Date ds = new java.util.Date(millis);
	//	java.util.Date de = new GregorianCalendar(2022, 0, 12).getTime();
		// System.out.println(ds);
		// System.out.println(de);

		//Company co = cd.findCompany(4L);
		//Customer cu = cud.findCustomer(1L);
		// System.out.println(cof.getAllCoupons());
		// Coupon c = new Coupon();
		// c = coup.findCoupon(6);
		// System.out.println(c);
		// c.setCustomer(cu);
		// c.setCompany(co);
		// c.setAmount(5000);
		// c.setMessage("mm");
		// c.setPrice(20000.0);
		// c.setTitle("watch");
		// c.setType(TypeEnum.ELECTRICITY);
		// c.setImage("watch.jpg");
		// c.setStartDate(ds);
		// c.setEndDate(de);

		// cof.createCoupon(c);
		// c.setID((long) 14);
		// cof.updateCoupon(c);
		// cof.removeCoupon(c);

		// System.out.println(cf.getAllPurchasedCoupons());
		// System.out.println( cd.findCompany(4));
		// c.setMESSAGE("sdfsffsdf");
		// cf.purchaseCoupon(c);
//Customer cust = new Customer();
		// cust.setCUST_NAME("ben val");
		// cust.setPASSWORD("val23");
		// cust.setID((long) 7);
		// af.createCustomer(cust);
		// af.removeCustomer(cust);
		// System.out.println( af.getCompany(4));
		// System.out.println( af.getCustomer(6));

		// CompanyDAO repo= context.getBean(CompanyDAO.class);
		// CustomerDAO repoCust = context.getBean(CustomerDAO.class);
//		System.out.println("its working!!!!!!!!!!!!!!!!");
//		repo.selectAllCompanies().forEach(e->System.out.println(e.getID()+" "+e.getCOMP_NAME()+" "+e.getPASSWORD()+" "+e.getEMAIL()));
//		Company c = new Company();
////	     c.setCOMP_NAME("kupot");
//		c.setPASSWORD("kupot123");
//	c.setEMAIL("kupot@gmail.com");
//	Customer cust = new Customer();
//	cust.setCUST_NAME("dan ron");
//	cust.setPASSWORD("rondan4");
//	//	repo.addCompany(c);
		// repo.deleteCompany(3);
		// repo.updateCompany(4,c);
		// System.out.println(repo.findCompany(4));
		// repoCust.updateCustomer(6, cust);

	}

}
