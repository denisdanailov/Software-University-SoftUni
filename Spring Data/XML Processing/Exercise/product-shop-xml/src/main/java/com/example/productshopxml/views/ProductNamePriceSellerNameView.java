package com.example.productshopxml.views;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.PROPERTY)
public interface ProductNamePriceSellerNameView {

   @XmlAttribute(name = "name")
   String getName();

   @XmlAttribute(name = "price")
   BigDecimal getPrice();

   @XmlAttribute(name = "seller")
   String getSellerFullName();
}
