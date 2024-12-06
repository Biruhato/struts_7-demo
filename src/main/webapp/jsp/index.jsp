<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<s:url value="/css/jQuery/jquery-ui-1.10.3.custom.css"/>" rel="stylesheet" type="text/css" />
<link href="<s:url value="/css/GeneralEnv.css"/>" rel="stylesheet" type="text/css" />
<script src="<s:url value="/js/jQuery/jquery-1.9.1.js"/>"></script>
<script src="<s:url value="/js/jQuery/jquery-ui-1.10.3.custom.js"/>"></script>
<script src="<s:url value="/js/commons.js"/>"></script>
<title>dynamicwebwithmaven_Index</title>
</head>
<body>
	<table style="width: 100%;">
		<tr>
			<td width="10%" valign="top">
				<div id="menuPosi"></div>
			</td>
			<td valign="top">
				<fieldset>
					<table>
						<tr>
							<td valign="top">
								<span style="font-size: 20px;">Welcome!</span>
							</td>
						</tr>
					</table>
					<div>
						<div>struts 7 form submit test</div>
						<s:form name="actionform" namespace="/foo" action="sample_request" method="post">
							<div>
								<div>textfield:</div>
								<div>
									<s:textfield name="var1" value="hello"></s:textfield>
								</div>
							</div>
							<div>
								<!-- struts interceptor regex規則現不予許有在action帶入有符號的變數名稱 -->
								<!-- mapping to map object approach -->
								<div>textfield, mapping to map object:</div>
								<div>
									<s:textfield name="map.var" value="var - test 1"></s:textfield>
								</div>
								<div>
									<s:textfield name="map['var']" value="var - test 2"></s:textfield>
								</div>
								<!-- unavailable to mapping -->
								<%--<s:textfield name="#map.kk" value="hello form - map"></s:textfield> --%>
								<%--<s:textfield name="map" value="hello form - map 2"></s:textfield> --%>
								<%--<s:textfield name="tmpmap" value="hello form - map 3"></s:textfield> --%>
								<%--<s:textfield name="map[var]" value="hello form - map"></s:textfield> --%>
								<%--<s:textfield name="#map[#var]" value="hello form - map"></s:textfield> --%>
							</div>
							<div>
								<s:submit>submit</s:submit>
							</div>
						</s:form>
					</div>
					<div>
						<div>used struts stream type</div>
						<form action="./report_stream">
							<input type="submit" name="test">
						</form>
					</div>
					<div>
						<div>used struts jasper type</div>
						<form action="./report_jasper">
							<input type="submit" name="var2">
						</form>
					</div>
					<script type="text/javascript">
						window.open('http://localhost:8080/test/test.pdf');
					</script>
				</fieldset>
			</td>
		</tr>
	</table>
</body>
</html>