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
 *         &lt;element name="movieInfo" type="{http://www.concretepage.com/movie-ws}movieInfo"/&gt;
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
    "movieInfo"
})
@XmlRootElement(name = "getMovieByIdResponse")
public class GetMovieByIdResponse {

    @XmlElement(required = true)
    protected MovieInfo movieInfo;

    /**
     * Gets the value of the movieInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MovieInfo }
     *     
     */
    public MovieInfo getMovieInfo() {
        return movieInfo;
    }

    /**
     * Sets the value of the movieInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MovieInfo }
     *     
     */
    public void setMovieInfo(MovieInfo value) {
        this.movieInfo = value;
    }

}
