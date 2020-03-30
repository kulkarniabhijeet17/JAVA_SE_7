package com.javase7.validator;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Validator {
	private static final Logger LOG = Logger.getLogger("Validator");

	public Validator(String filePath, String className, String methodWithExcptn) {
		validateStructure(filePath, className, methodWithExcptn);
	}

	protected final void validateStructure(String filePath, String className, String methodWithExcptn) {
		if (validateClassName(className)) {
			validateMethodSignature(methodWithExcptn, className);
		}
	}

	protected final boolean validateClassName(String className) {
		boolean iscorrect = false;
		try {
			Class.forName(className);
			iscorrect = true;
			LOG.info("Class Name is correct");
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, "You have changed either the " + "class name/package. Use the default package "
					+ "and class name as provided in the skeleton");
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					"There is an error in validating the " + "Class Name. Please manually verify that the "
							+ "Class name is same as skeleton before uploading");
		}

		return iscorrect;
	}

	protected final void validateMethodSignature(String methodWithExcptn, String className) {
		Class cls;
		try {
			String[] actualmethods = methodWithExcptn.split(",");
			boolean errorFlag = false;
			String[] methodSignature;
			String methodName = null;
			String returnType = null;

			for (String singleMethod : actualmethods) {
				boolean foundMethod = false;
				methodSignature = singleMethod.split(":");

				methodName = methodSignature[0];
				returnType = methodSignature[1];
				cls = Class.forName(className);
				Method[] methods = cls.getMethods();
				for (Method findMethod : methods) {
					if (methodName.equals(findMethod.getName())) {
						foundMethod = true;
						if ((findMethod.getExceptionTypes().length != 1)) {
							LOG.log(Level.SEVERE, "You have added/removed " + "Exception from '" + methodName
									+ "' method. " + "Please stick to the skeleton provided");
						}
						if (!(findMethod.getReturnType().getName().equals(returnType))) {
							errorFlag = true;
							LOG.log(Level.SEVERE, " You have changed the " + "return type in '" + methodName
									+ "' method. Please stick to the " + "skeleton provided");
						}
					}
				}
				if (!foundMethod) {
					errorFlag = true;
					LOG.log(Level.SEVERE, " Unable to find the given public method " + methodName
							+ ". Do not change the " + "given public method name. " + "Verify it with the skeleton");
				}
			}

			if (!errorFlag) {
				LOG.info("Method signature is valid");
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE,
					" There is an error in validating the " + "method structure. Please manually verify that the "
							+ "Method signature is same as the skeleton before uploading");
		}
	}
}