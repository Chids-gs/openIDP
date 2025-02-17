/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
package com.infosys.convertor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.infosys.json.CodeAnalysis;
import com.infosys.utilities.findbugs.BugCollection;
import com.infosys.utilities.findbugs.BugInstance;
import com.infosys.utilities.findbugs.BugInstance.Method;

public class ConvertFindbugs {
	private static int major;
	private static int minor;
	private static int blocker;
	private static int critical;
	private static int info;
	private static final Logger logger = LogManager.getLogger(ConvertFindbugs.class);

	private ConvertFindbugs() {
	}

	public static List<CodeAnalysis> convert(String inputPath, Map<String, String> ruleToValue,
			String prefixForId) {
		List<CodeAnalysis> ca = new ArrayList<>();
		try {
			EditDocType.edit(inputPath);
			File file = new File(inputPath);
			JAXBContext jaxbContext = JAXBContext.newInstance(BugCollection.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			BugCollection c = (BugCollection) jaxbUnmarshaller.unmarshal(file);
			final String successMsg = "Report Converted Successfully..!!";
			if (c.getBugInstance() == null) {
				logger.info(successMsg);
				return ca;
			}
			List<BugInstance> instance = c.getBugInstance();
			for (BugInstance i : instance) {
				if (i.getClazz() == null)
					continue;
				List<BugInstance.Class> clsList = i.getClazz();
				final String noDesc = "No description available at this time";
				final String bugCategory = "findbugs";
				final String medSeverity = "medium";
				iterateClass(i, ca, clsList, ruleToValue, bugCategory, noDesc, prefixForId);
				List<BugInstance.Method> listMet;
				if (i.getMethod() != null && (listMet = i.getMethod()) != null)
					iterateMethod(i, listMet, ca, ruleToValue, bugCategory, medSeverity, noDesc, prefixForId);
				if (i.getSourceLine() != null)
					iterateSourceLines(i, ca, bugCategory, ruleToValue, noDesc, prefixForId);
			}
			logger.info(successMsg);
			return ca;
		} catch (Exception e) {
			logger.error("Conversion error for " + inputPath + "Error: " + e);
		}
		return ca;
	}

	private static void iterateSourceLines(BugInstance i, List<CodeAnalysis> ca, String bugCategory,
			Map<String, String> ruleToValue, String noDesc, String prefixForId) {
		List<BugInstance.SourceLine> slList = i.getSourceLine();
		for (BugInstance.SourceLine sl : slList) {
			CodeAnalysis bug = getCodeAnalysisObject();
			bug.setMessage(i.getCategory());
			bug.setId(prefixForId + sl.getClassname().replace(".", "_"));
			setSeverityByPriority(i, bug);
			bug.setLine(sl.getStart().toString());
			bug.setcategory(bugCategory);
			bug.setruleName(i.getCategory());
			bug.setRecommendation(
					(ruleToValue.get(i.getCategory())) == null ? noDesc : ruleToValue.get(i.getCategory()));
			addCA(ca, bug);
		}
	}

	private static void addCA(List<CodeAnalysis> ca, CodeAnalysis bug) {
		int flag = 0;
		if (!ca.isEmpty()) {
			for (CodeAnalysis j : ca) {
				if (j.getId().equals(bug.getId()) && j.getMessage().equals(bug.getMessage())) {
					flag = 1;
					break;
				}
			}
		}
		if (flag == 0) {
			ca.add(bug);
		}
	}

	private static void iterateMethod(BugInstance i, List<Method> listMet, List<CodeAnalysis> ca,
			Map<String, String> ruleToValue, String bugCategory, String medSeverity, String noDesc,
			String prefixForId) {
		for (BugInstance.Method m : listMet) {
			BugInstance.Method.SourceLine sl = m.getSourceLine();
			CodeAnalysis bug = getCodeAnalysisObject();
			bug.setMessage(i.getCategory());
			bug.setId(prefixForId + sl.getClassname().replace(".", "_"));
			// Dashboard Summary for FindBugs
			if (i.getPriority() == 1)
				major++;
			if (i.getPriority() == 2)
				minor++;
			if (i.getPriority() == 3)
				info++;
			if (i.getPriority() <= 2) {
				bug.setSeverity("complex");
			} else if (i.getPriority() == 3) {
				bug.setSeverity(medSeverity);
			} else if (i.getPriority() > 3) {
				bug.setSeverity("low");
			}
			bug.setcategory(bugCategory);
			bug.setLine(sl.getStart().toString());
			bug.setruleName(i.getCategory());
			bug.setRecommendation(
					(ruleToValue.get(i.getCategory())) == null ? noDesc : ruleToValue.get(i.getCategory()));
			addCA(ca, bug);
		}
	}

	private static void iterateClass(BugInstance i, List<CodeAnalysis> ca, List<BugInstance.Class> clsList,
			Map<String, String> ruleToValue, String bugCategory, String noDesc, String prefixForId) {
		for (BugInstance.Class cls : clsList) {
			BugInstance.Class.SourceLine sl = cls.getSourceLine();
			CodeAnalysis bug = getCodeAnalysisObject();
			bug.setMessage(i.getShortMessage());
			bug.setLine(sl.getStart().toString());
			bug.setruleName(i.getCategory());
			bug.setRecommendation(
					(ruleToValue.get(i.getCategory())) == null ? noDesc : ruleToValue.get(i.getCategory()));
			bug.setId(prefixForId + sl.getClassname().replace(".", "_"));
			bug.setcategory(bugCategory);
			setSeverityByPriority(i, bug);
			int flag = 0;
			if (!ca.isEmpty())
				flag = iterateCA(bug, ca);
			if (flag == 0 && bug.getLine() != null && bug.getruleName() != null)
				ca.add(bug);
		}
	}

	private static CodeAnalysis getCodeAnalysisObject() {
		return new CodeAnalysis();
	}

	private static int iterateCA(CodeAnalysis bug, List<CodeAnalysis> ca) {
		int flag = 0;
		for (CodeAnalysis j : ca) {
			if (j.getId().equals(bug.getId()) && j.getMessage().equals(bug.getMessage())) {
				flag = 1;
				break;
			}
		}
		return flag;
	}

	private static void setSeverityByPriority(BugInstance i, CodeAnalysis bug) {
		// Dashboard Summary for FindBugs
		if (i.getPriority() != null) {
			if (i.getPriority() <= 2) {
				bug.setSeverity("high");
			} else if (i.getPriority() == 3) {
				bug.setSeverity("medium");
			} else if (i.getPriority() > 3) {
				bug.setSeverity("low");
			}
		} else {
			bug.setSeverity("low");
		}
	}

	public static List<Integer> getFindBugsSeverity() {
		List<Integer> severityCount = new ArrayList<>();
		severityCount.add(critical);
		severityCount.add(blocker);
		severityCount.add(major);
		severityCount.add(minor);
		severityCount.add(info);
		critical = 0;
		blocker = 0;
		major = 0;
		minor = 0;
		info = 0;
		return severityCount;
	}
}
