//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.04 at 04:27:01 PM IST 
//
package com.infosys.utilities.robot;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stat", propOrder = { "value" })
public class Stat {
	@XmlValue
	protected String value;
	@XmlAttribute(name = "fail")
	protected int fail;
	@XmlAttribute(name = "critical")
	protected String critical;
	@XmlAttribute(name = "pass")
	protected int pass;
	@XmlAttribute(name = "info")
	protected String info;
	@XmlAttribute(name = "links")
	protected String links;
	@XmlAttribute(name = "doc")
	protected String doc;
	@XmlAttribute(name = "combined")
	protected String combined;
	@XmlAttribute(name = "id")
	protected String id;
	@XmlAttribute(name = "name")
	protected String name;
	@XmlAnyAttribute
	private Map<QName, String> otherAttributes = new HashMap<QName, String>();

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getFail() {
		return fail;
	}

	public void setFail(int value) {
		this.fail = value;
	}

	public String getCritical() {
		return critical;
	}

	public void setCritical(String value) {
		this.critical = value;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int value) {
		this.pass = value;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String value) {
		this.info = value;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String value) {
		this.links = value;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String value) {
		this.doc = value;
	}

	public String getCombined() {
		return combined;
	}

	public void setCombined(String value) {
		this.combined = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public Map<QName, String> getOtherAttributes() {
		return otherAttributes;
	}
}
