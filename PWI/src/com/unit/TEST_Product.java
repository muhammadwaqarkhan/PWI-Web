package com.unit;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.branch.dto.BranchOutDTO;
import com.pwi.services.hibernate.HibernateUtil;
import com.pwi.services.product.ProductService;
import com.pwi.services.product.dto.ProductDTO;
import com.pwi.spring.SpringApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/beans.xml", "file:src/hibernate.cfg.xml" })
public class TEST_Product {
	@Mock
	static SessionFactory factory;
	ProductService productService;
	static Session session;
	static Transaction transcation;

	@Before
	public void setUp() {
		SpringApplicationContext.getInstance();
		factory = HibernateUtil.getSessionFactory();

		session = factory.openSession();
		transcation = session.beginTransaction();
		productService = new ProductService();
		productService.setSession(session);
	}

	@Test
	public void saveBranch() throws Exception {

		ProductDTO dto = SpringApplicationContext.getApplicationContext().getBean(ProductDTO.class);

		dto.setProductName("Vantiboli");
		dto.setProductType("20ML");
		dto.setMOQ(100);
		dto.setQPB(100);
		dto.setSize(100);

		IResponseHandler response = productService.saveProduct(dto);

		assertTrue(response.getErrorCode() == 0);
	}

	@Test
	public void updateBranch() throws Exception {
		ProductDTO dto = SpringApplicationContext.getApplicationContext().getBean(ProductDTO.class);

		dto.setProductName("Vantiboli");
		dto.setProductType("20ML");
		dto.setMOQ(100);
		dto.setQPB(100);
		dto.setSize(100);

		IResponseHandler response = productService.updateProduct(dto);

		assertTrue(response.getErrorCode() == 0);
	}

	@Test
	public void getBranch() throws Exception {

		IResponseHandler response = productService.fetchProduct();

		assertTrue(response.getErrorCode() == 0 && ((BranchOutDTO) response).getBranches().size() > 0);
	}

	@Test
	public void deleteBranch() throws Exception {
		ProductDTO dto = SpringApplicationContext.getApplicationContext().getBean(ProductDTO.class);

		dto.setProductID(Long.valueOf(5));
		IResponseHandler response = productService.deleteProduct(dto);

		assertTrue(response.getErrorCode() == 0 && ((BranchOutDTO) response).getBranches().size() > 0);
	}

	@After
	public void tearDown() throws Throwable {
		transcation.rollback();
	}
}
