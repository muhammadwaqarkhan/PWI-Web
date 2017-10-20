package com.pwi.rest.product;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.rest.product.dto.RestProductSizeDTO;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.product.ProductService;
import com.pwi.services.product.dto.ProductDTO;
import com.pwi.services.product.dto.ProductOutDTO;
import com.pwi.services.ui.pageHandlers.base.BasePageHandler;
import com.pwi.spring.SpringApplicationContext;
@Path("/Products")
public class RestProductService 
{
	
	@POST
	 @Produces(MediaType.TEXT_XML)
	 @Path("/addProduct") 

	public String addProduct(@QueryParam("productName") String productName,
			@QueryParam("productType") String productType, 
			@QueryParam("MOQ") String MOQ,
			@QueryParam("size") String size,
			@QueryParam("postalCode") String postalCode,
			@QueryParam("QPB") String QPB) 
	{
		
		MOQ = MOQ==null ?"0": MOQ;
		QPB = QPB==null ?"0": QPB;
		size = size==null?"0" :size;
		
		ProductDTO dto = new ProductDTO();

		dto.setMOQ(Integer.valueOf(MOQ));
		dto.setProductName(productName);
		dto.setProductType(productType);
		dto.setQPB(Integer.valueOf(QPB));
		dto.setSize(Integer.valueOf(size));
	
		
		ServiceBase base = new ProductService();
		Object object = getExecutor().callService(base, "SaveProduct",dto);
		
		if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
		{
			return "<success>true</success>";
		}

		return "<success>false</success>";
	}
	
	@POST
	@Produces(MediaType.TEXT_XML)
	@Path("/updateProduct") 
	public String updateProduct(@QueryParam("productName") String productName,
			@QueryParam("productType") String productType, 
			@QueryParam("MOQ") String MOQ,
			@QueryParam("size") String size,
			@QueryParam("postalCode") String postalCode,
			@QueryParam("QPB") String QPB,
			@QueryParam("productID") String productID) throws IOException {
		
		
		
		MOQ = MOQ==null ?"0": MOQ;
		QPB = QPB==null ?"0": QPB;
		size = size==null?"0" :size;
		productID = productID==null?"-1" :productID;
		
		ProductDTO dto = new ProductDTO();

		dto.setMOQ(Integer.valueOf(MOQ));
		dto.setProductName(productName);
		dto.setProductType(productType);
		dto.setQPB(Integer.valueOf(QPB));
		dto.setSize(Integer.valueOf(size));
		dto.setProductID(Long.valueOf(productID));
	
		
		ServiceBase base = new ProductService();
		Object object = getExecutor().callService(base, "UpdateProduct", dto);
		
		if(object instanceof IResponseHandler && ((IResponseHandler)object).getErrorCode() ==FrameworkReasonCodes.ERROR_NO )
		{
			return "<success>true</success>";
		}

		return "<success>false</success>";
	}
	
	@POST
	@Produces(MediaType.TEXT_XML)
	@Path("/productSize") 
	public String productSize(@QueryParam("productName") String productName,	
			@QueryParam("productID") String productID) {
		
		productID = productID==null	?	"-1" :productID;
		
		ProductDTO inDTO = new ProductDTO();	
		inDTO.setProductName(productName);
		inDTO.setProductID(Long.valueOf(productID));
		
		
		ServiceBase base = new ProductService();
		Object object = getExecutor().callService(base, "WebServiceFetchProduct", inDTO);
		
		return new RestProductSizeDTO().assemble((ProductOutDTO)object);
		
	}
	private ServiceExecutor getExecutor()
	{
		return  (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
	}

}
