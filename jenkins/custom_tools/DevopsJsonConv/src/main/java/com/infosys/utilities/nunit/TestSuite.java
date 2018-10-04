//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.02 at 08:54:42 PM IST 
//
package com.infosys.utilities.nunit;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "environment", "settings", "properties", "failure", "testCase", "testSuite" })
@XmlRootElement(name = "test-suite")
public class TestSuite {
	protected Environment environment;
	protected Settings settings;
	protected Properties properties;
	protected Failure failure;
	@XmlElement(name = "test-case")
	protected List<TestCase> testCase;
	@XmlElement(name = "test-suite")
	protected List<TestSuite> testSuite;
	@XmlAttribute(name = "asserts")
	protected Byte asserts;
	@XmlAttribute(name = "classname")
	protected String classname;
	@XmlAttribute(name = "duration")
	protected Float duration;
	@XmlAttribute(name = "end-time")
	protected String endTime;
	@XmlAttribute(name = "failed")
	protected Byte failed;
	@XmlAttribute(name = "fullname")
	protected String fullname;
	@XmlAttribute(name = "id")
	protected String id;
	@XmlAttribute(name = "inconclusive")
	protected Byte inconclusive;
	@XmlAttribute(name = "name")
	protected String name;
	@XmlAttribute(name = "passed")
	protected Byte passed;
	@XmlAttribute(name = "result")
	protected String result;
	@XmlAttribute(name = "runstate")
	protected String runstate;
	@XmlAttribute(name = "site")
	protected String site;
	@XmlAttribute(name = "skipped")
	protected Byte skipped;
	@XmlAttribute(name = "start-time")
	protected String startTime;
	@XmlAttribute(name = "testcasecount")
	protected Byte testcasecount;
	@XmlAttribute(name = "total")
	protected Byte total;
	@XmlAttribute(name = "type")
	protected String type;

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment value) {
		this.environment = value;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings value) {
		this.settings = value;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties value) {
		this.properties = value;
	}

	public Failure getFailure() {
		return failure;
	}

	public void setFailure(Failure value) {
		this.failure = value;
	}

	public List<TestCase> getTestCase() {
		if (testCase == null) {
			testCase = new ArrayList<TestCase>();
		}
		return this.testCase;
	}

	public List<TestSuite> getTestSuite() {
		if (testSuite == null) {
			testSuite = new ArrayList<TestSuite>();
		}
		return this.testSuite;
	}

	public Byte getAsserts() {
		return asserts;
	}

	public void setAsserts(Byte value) {
		this.asserts = value;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String value) {
		this.classname = value;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float value) {
		this.duration = value;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String value) {
		this.endTime = value;
	}

	public Byte getFailed() {
		return failed;
	}

	public void setFailed(Byte value) {
		this.failed = value;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String value) {
		this.fullname = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public Byte getInconclusive() {
		return inconclusive;
	}

	public void setInconclusive(Byte value) {
		this.inconclusive = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public Byte getPassed() {
		return passed;
	}

	public void setPassed(Byte value) {
		this.passed = value;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String value) {
		this.result = value;
	}

	public String getRunstate() {
		return runstate;
	}

	public void setRunstate(String value) {
		this.runstate = value;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String value) {
		this.site = value;
	}

	public Byte getSkipped() {
		return skipped;
	}

	public void setSkipped(Byte value) {
		this.skipped = value;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String value) {
		this.startTime = value;
	}

	public Byte getTestcasecount() {
		return testcasecount;
	}

	public void setTestcasecount(Byte value) {
		this.testcasecount = value;
	}

	public Byte getTotal() {
		return total;
	}

	public void setTotal(Byte value) {
		this.total = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}
}
