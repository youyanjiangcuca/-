{\rtf1\ansi\ansicpg936\cocoartf1504\cocoasubrtf830
{\fonttbl\f0\fnil\fcharset0 Monaco;\f1\fnil\fcharset134 PingFangSC-Regular;}
{\colortbl;\red255\green255\blue255;\red255\green83\blue8;\red255\green255\blue255;\red216\green216\blue216;
}
{\*\expandedcolortbl;;\csgenericrgb\c100000\c32549\c3137;\csgenericrgb\c100000\c100000\c100000;\csgenericrgb\c84706\c84706\c84706;
}
\paperw11900\paperh16840\margl1440\margr1440\vieww16340\viewh12140\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs28 \cf2 \cb3 \ul \ulc4 package com.java2017;\
\
import java.util.ArrayList;\
import java.util.HashMap;\
\
public class Translate \{\
	   public static HashMap<String, String> numMap = new HashMap<>();\
       public static void main(String[] args) \{\
    	   //numMap = new HashMap<>();\
    	   numMap.put("1", "
\f1 \'d2\'bc
\f0 ");\
    	   numMap.put("2", "
\f1 \'b7\'a1
\f0 ");\
    	   numMap.put("3", "
\f1 \'c8\'fe
\f0 ");\
    	   numMap.put("4", "
\f1 \'cb\'c1
\f0 ");\
    	   numMap.put("5", "
\f1 \'ce\'e9
\f0 ");\
    	   numMap.put("6", "
\f1 \'c2\'bd
\f0 ");\
    	   numMap.put("7", "
\f1 \'c6\'e2
\f0 ");\
    	   numMap.put("8", "
\f1 \'b0\'c6
\f0 ");\
    	   numMap.put("9", "
\f1 \'be\'c1
\f0 ");\
    	   numMap.put("0", "
\f1 \'c1\'e3
\f0 ");\
    	   //getFrontString("101111");\
    	   \
    	   System.out.println(translate("101111.01"));\
		\
	\} \
      public static StringBuilder translate(String text) \{\
    	  \
		if (text.contains(".")) \{\
			\
		  String[] stringArray = text.split("\\\\.");\
		  \
		  StringBuilder frontStr = getFrontString(stringArray[0]);\
		  StringBuilder endStr = getEndString(stringArray[1]);\
		  \
		  if (frontStr.equals("
\f1 \'c1\'e3\'d4\'aa
\f0 ")) \{\
			if (endStr.length() > 0) \{\
				if (endStr.substring(0,1).equals("
\f1 \'c1\'e3
\f0 ")) \{\
					return new StringBuilder(endStr.substring(1));\
				\}\
				else \{\
					return endStr;\
				\}\
			\}\
			else \{\
				return frontStr;\
			\}\
		  \}\
		  else \{\
			return  frontStr.append(endStr);\
		  \}\
		\}\
		else \{\
			\
			return new StringBuilder(getFrontString(text)+"
\f1 \'d5\'fb
\f0 ");\
		\}\
	\}\
      public static StringBuilder getEndString(String endStr) \{\
		 StringBuilder jiaoStr = new StringBuilder();\
		 String[] unitArray = \{"
\f1 \'bd\'c7
\f0 ","
\f1 \'b7\'d6
\f0 "\};\
		 if (endStr.length() > 2) \{\
			endStr = endStr.substring(0, 2);\
		\}\
		 if (!endStr.equals("00")) \{\
			for (int i = 0; i < endStr.length(); i++) \{\
				String partStr = endStr.substring(i, i+1);\
				//System.out.println(partStr);\
				if (!partStr.equals("0")) \{\
					jiaoStr.append(numMap.get(partStr)+unitArray[i]);\
				\}\
				else \{\
					jiaoStr.append(numMap.get(partStr));\
				\}\
			\}\
			String fianlStr = jiaoStr.substring(jiaoStr.length()-1);\
			if (fianlStr.equals("
\f1 \'c1\'e3
\f0 ")) \{\
				jiaoStr.delete(jiaoStr.length() - 1, jiaoStr.length());\
			\}\
		\}\
		 System.out.println(jiaoStr);\
		 return jiaoStr;\
	\}\
      \
    public static StringBuilder getFrontString(String frontStr) \{\
		\
    	int group = (frontStr.length() - 1)/4 + 1;\
    	StringBuilder allString = new StringBuilder();\
    	\
    	for (int i = 1; i <= group; i++) \{\
    		\
			String str = "";\
			\
			if (i<group) \{\
				str = frontStr.substring(frontStr.length()-i*4, frontStr.length()-i*4+4);\
			\}\
			else \{\
				str = frontStr.substring(0,frontStr.length()-(i-1)*4);\
			\}\
			\
			boolean isZero = false;\
			StringBuilder groupString = new StringBuilder();\
			\
			for (int j = 1; j <= str.length(); j++) \{\
				\
				String num = str.substring(str.length()-j, str.length()-j+1);\
				if (num.equals("0")) \{\
					if (isZero) \{\
						\
					\}\
					else \{\
						isZero = true;\
						groupString.insert(0, numMap.get(num));\
					\}\
				\}\
				else \{\
					isZero = false;\
					groupString.insert(0, numMap.get(num));\
					groupString.insert(1, getStatus(j));\
				\}\
			\}\
			int length = groupString.length();\
			String lastStr = groupString.substring(length - 1);\
			if (lastStr.equals("
\f1 \'c1\'e3
\f0 ")) \{\
				\
				groupString.delete(length - 1, length);\
				\
			\}\
			if (length > 0 ) \{\
				groupString.append(getGroupUnit(i));\
			\}\
			else \{\
				if (!getGroupUnit(i).equals("
\f1 \'cd\'f2
\f0 ")) \{\
					groupString.append(getGroupUnit(i));\
				\}\
			\}\
			allString.insert(0, groupString);\
		\
		\}\
    	if (!allString.equals("
\f1 \'c1\'e3
\f0 ")) \{\
			String first = allString.substring(0,1);\
			if (first.equals("
\f1 \'c1\'e3
\f0 ")) \{\
				allString.delete(0, 1);\
			\}\
		\}\
    	else \{\
			allString.append("
\f1 \'d4\'aa
\f0 ");\
		\}\
    	System.out.println(allString);\
    	return allString;\
	\}\
    \
    public static String getStatus(int num) \{\
		if (num == 2) \{\
			return "
\f1 \'ca\'b0
\f0 ";\
		\}\
		else if (num == 3) \{\
			return "
\f1 \'b0\'db
\f0 ";\
		\}\
		else if (num == 4) \{\
			return "
\f1 \'c7\'aa
\f0 ";\
		\}\
		return "";\
	\}\
    public static String getGroupUnit(int group) \{\
    	\
    	if (group == 1) \{\
            return "
\f1 \'d4\'aa
\f0 ";\
        \}\
        else if (group == 2) \{\
            return "
\f1 \'cd\'f2
\f0 ";\
        \}\
        else if (group == 3) \{\
            return "
\f1 \'d2\'da
\f0 ";\
        \}\
        if (group%2 == 0) \{\
            return "
\f1 \'cd\'f2
\f0 ";\
        \}\
        else if (group%2 == 1)\
        \{\
            return "
\f1 \'d2\'da
\f0 ";\
        \}\
        \
        return "";\
	\}\
      public static void test(String testStr) \{\
		for (int i = 0; i < testStr.length(); i++) \{\
			String partStr = testStr.substring(i, i+1);\
			System.out.println(partStr);\
		\}\
	\}\
\}}