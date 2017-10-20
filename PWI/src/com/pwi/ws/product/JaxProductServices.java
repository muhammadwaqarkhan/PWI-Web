package com.pwi.ws.product;

import java.util.ArrayList;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.pwi.constants.FrameworkReasonCodes;
import com.pwi.header.Header;
import com.pwi.interfaces.IResponseHandler;
import com.pwi.services.base.ServiceBase;
import com.pwi.services.framework.ServiceExecutor;
import com.pwi.services.product.ProductService;
import com.pwi.services.product.dto.ProductDTO;
import com.pwi.services.product.dto.ProductOutDTO;
import com.pwi.spring.SpringApplicationContext;
import com.pwi.ws.product.dto.JaxDeleteProductDTO;
import com.pwi.ws.product.dto.JaxProductDTO;
import com.pwi.ws.product.dto.JaxProductSizeDTO;
import com.pwi.ws.product.dto.JaxProductSizeOutDTO;

@WebService(targetNamespace = "com.pwi.ws.JaxProductServices")
@HandlerChain(file = "JAXSoapServiceHandler.xml")
public class JaxProductServices implements IJaxProductServices {

	@Override
	public String addProduct(JaxProductDTO input) {

		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new ProductService();
		Object object = executor.callService(base, "SaveProduct", input.assemble());

		if (object instanceof IResponseHandler
				&& ((IResponseHandler) object).getErrorCode() == FrameworkReasonCodes.ERROR_NO) {
			return "success";
		}

		return "failure";
	}

	@Override
	public String updateProduct(JaxProductDTO input) {

		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new ProductService();
		Object object = executor.callService(base, "UpdateProduct", input.assemble());

		if (object instanceof IResponseHandler
				&& ((IResponseHandler) object).getErrorCode() == FrameworkReasonCodes.ERROR_NO) {
			return "success";
		}

		return "failure";
	}

	@Override
	public String deleteProduct(JaxDeleteProductDTO input) {

		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new ProductService();
		Object object = executor.callService(base, "DeleteProduct", input.assemble());

		if (object instanceof IResponseHandler
				&& ((IResponseHandler) object).getErrorCode() == FrameworkReasonCodes.ERROR_NO) {
			return "success";
		}

		return "failure";
	}

	@Override
	public ProductOutDTO getProduct(Header header) {
		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new ProductService();
		Object object = executor.callService(base, "FetchProduct", new ProductDTO());

		if (object instanceof ProductOutDTO) {
			return (ProductOutDTO) object;
		}

		return new ProductOutDTO();

	}

	@Override
	public List<JaxProductSizeOutDTO> productSize(JaxProductSizeDTO input) {

		ServiceExecutor executor = (ServiceExecutor) SpringApplicationContext.getBean("serviceExecutor");
		ServiceBase base = new ProductService();
		Object object = executor.callService(base, "WebServiceFetchProduct", input.assemble());

		List<JaxProductSizeOutDTO> output = new ArrayList<JaxProductSizeOutDTO>();
		if (object instanceof ProductOutDTO) {
			for (ProductDTO dto : ((ProductOutDTO) object).getProducts()) {
				JaxProductSizeOutDTO jaxDto = new JaxProductSizeOutDTO();
				jaxDto.setProductName(dto.getProductName());
				jaxDto.setProductID(dto.getProductID());
				jaxDto.setSize(dto.getSize());
				output.add(jaxDto);
			}
		}

		return output;
	}
}
