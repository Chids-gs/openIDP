//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.04 at 04:27:01 PM IST 
//
package com.infosys.utilities.robot;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "errors", propOrder = { "msg" })
public class Errors {
	protected List<Msg> msg;

	public List<Msg> getMsg() {
		if (msg == null) {
			msg = new ArrayList<Msg>();
		}
		return this.msg;
	}
}
