//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.20 at 06:00:26 PM CET 
//


package com.concretepage.gs_ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cinemaInfo" type="{http://www.concretepage.com/cinema-ws}cinemaInfo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cinemaInfo"
})
@XmlRootElement(name = "getCinemaByIdResponse", namespace = "http://www.concretepage.com/cinema-ws")
public class GetCinemaByIdResponse {

    @XmlElement(namespace = "http://www.concretepage.com/cinema-ws", required = true)
    protected CinemaInfo cinemaInfo;

    /**
     * Gets the value of the cinemaInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CinemaInfo }
     *     
     */
    public CinemaInfo getCinemaInfo() {
        return cinemaInfo;
    }

    /**
     * Sets the value of the cinemaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CinemaInfo }
     *     
     */
    public void setCinemaInfo(CinemaInfo value) {
        this.cinemaInfo = value;
    }

}
