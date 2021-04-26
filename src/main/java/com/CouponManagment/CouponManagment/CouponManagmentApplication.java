package com.CouponManagment.CouponManagment;

import java.util.GregorianCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.CouponManagment.CouponManagment.dto.Company;
import com.CouponManagment.CouponManagment.dto.Coupon;
import com.CouponManagment.CouponManagment.dto.Customer;
import com.CouponManagment.CouponManagment.dto.TypeEnum;
import com.CouponManagment.CouponManagment.repository.CompanyDAO;
import com.CouponManagment.CouponManagment.repository.CouponDAO;
import com.CouponManagment.CouponManagment.repository.CustomerDAO;
import com.CouponManagment.CouponManagment.services.AdminFacade;
import com.CouponManagment.CouponManagment.services.ClientType;
import com.CouponManagment.CouponManagment.services.CompanyFacade;


@SpringBootApplication
public class CouponManagmentApplication {
	
	
	public static void main(String[] args) {
		
	ApplicationContext ctx =SpringApplication.run(CouponManagmentApplication.class, args);
CouponSystem	cs= ctx.getBean(CouponSystem.class);
//	AdminFacade	 af=(AdminFacade) cs.login("admin","1234" , ClientType.ADMIN);

	

	
     // CustomerFacade cf = (CustomerFacade) cs.login("dan ron", "rondan4", ClientType.CUSTOMER);
        
        CompanyFacade cof = (CompanyFacade) cs.login("koput", "kupot123", ClientType.COMPANY);
         CustomerDAO cud = ctx.getBean(CustomerDAO.class);
        
         CompanyDAO cd = ctx.getBean(CompanyDAO.class);
         
         long millis=System.currentTimeMillis(); 
         java.util.Date ds=new java.util.Date(millis); 
         java.util.Date de =  new GregorianCalendar(2020,0, 12).getTime();
     //   System.out.println(ds);
     //   System.out.println(de);
         
       Company co =cd.findCompany(15);
        Customer cu = cud.findCustomer(17);
   //    System.out.println(cof.getAllCoupons());
           Coupon c = new Coupon();
       //   System.out.println(c);
          c.setCustomer(cu);
           c.setCompany(co);
          c.setAMOUNT(5000); 
           c.setMESSAGE("mm");
           c.setPRICE(20000.0);
         c.setTITLE("watch");
           c.setTYPE(TypeEnum.ELECTRICITY);
             c.setIMAGE("watch.jpg");
           c.setSTART_DATE(ds);
         c.setEND_DATE(de);
        
        
          
             cof.createCoupon(c);
         //  c.setID((long) 14);
       //    cof.updateCoupon(c);
       //    cof.removeCoupon(c);
      
      //System.out.println(cf.getAllPurchasedCoupons());
   //  System.out.println( cd.findCompany(4));
  //    c.setMESSAGE("sdfsffsdf");
 //    cf.purchaseCoupon(c);
//Customer cust = new Customer();
	//cust.setCUST_NAME("ben val");
	//cust.setPASSWORD("val23");
	//cust.setID((long) 7);
	//af.createCustomer(cust);
      //af.removeCustomer(cust);
		 //	System.out.println(	af.getCompany(4));
		 	//System.out.println(	af.getCustomer(6));

		//CompanyDAO repo= context.getBean(CompanyDAO.class);
	//	CustomerDAO repoCust = context.getBean(CustomerDAO.class);
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
	//	repo.deleteCompany(3);
	//repo.updateCompany(4,c);
	//System.out.println(repo.findCompany(4));
	//repoCust.updateCustomer(6, cust);
	
	}

}
