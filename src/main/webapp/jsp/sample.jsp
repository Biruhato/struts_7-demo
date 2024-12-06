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
<script src="<s:url value="/js/sample.js"/>"></script>
<title>CpSample</title>
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
								<font>Frame Sample , Please do not to edit this function !</font>
								<br>
								<font>If you need to create a new Function , you can copy syntax of this Frame Sample !</font>
							</td>
						</tr>
						<s:form action="./sample_request.action" method="post">
							<div>
								<input name="var1" type="text" title="test" value="${var1}">
							</div>
							<div>
								<input name="var2" type="text" value="${var2}">
							</div>
							<div>
								<input name="var3" type="text" value="${var3}">
							</div>
							<div>
								<s:textfield name="map"></s:textfield>
							</div>
							<div>
								<s:textfield name="tmpmap"></s:textfield>
							</div>
							<div>
								<input name="sub" type="submit">
							</div>
						</s:form>
						<s:form>
							<s:iterator value="map" var="varOfMap">
								<li>${varOfMap}</li>
							</s:iterator>
						</s:form>
					</table>
				</fieldset>
			</td>
		</tr>
	</table>

</body>
</html>