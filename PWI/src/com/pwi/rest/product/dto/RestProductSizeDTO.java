package com.pwi.rest.product.dto;

import java.util.ArrayList;
import java.util.List;

import com.pwi.services.product.dto.ProductDTO;
import com.pwi.services.product.dto.ProductOutDTO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class RestProductSizeDTO {
	
	@XStreamAlias("RestProductSize")
	List<productSizeDTO> productSize = new ArrayList<productSizeDTO>();
	public List<productSizeDTO> getProductSize() {
		return productSize;
	}
	public void setProductSize(List<productSizeDTO> productSize) {
		this.productSize = productSize;
	}
	
	public String assemble(ProductOutDTO outDTO)
	{
		for(ProductDTO dto :outDTO.getProducts())
			getProductSize().add(new productSizeDTO().assemble(dto));
		
		
		XStream xstream = new XStream (new StaxDriver ());
		xstream.processAnnotations (RestProductSizeDTO.class);
		String xml = xstream.toXML (this);

		return xml;
	}
	
	public class productSizeDTO
	{
		@XStreamAlias("productID")
		private Long productID;
		
		@XStreamAlias("productName")
		private String productName;
		
		@XStreamAlias("size")
		private Integer size;

		public Long getProductID() {
			return productID;
		}
		public void setProductID(Long productID) {
			this.productID = productID;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		
		
		
		public Integer getSize() {
			return size;
		}
		public void setSize(Integer size) {
			this.size = size;
		}
		public productSizeDTO assemble(ProductDTO dto)
		{
			this.productName=dto.getProductName();
			this.size=dto.getSize();
			this.productID=dto.getProductID();
			return this;
		}
	}
}
