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
<title>CpWebCase_Index</title>
</head>
<body>
	<table style="width:100%;">
		<tr>
			<td width="10%" valign="top">
				<div id="menuPosi"></div>
			</td>
			<td valign="top">
				<fieldset>
					<table>
						<tr>
							<td valign="top">
								<span style="font-size:20px;">testArea01</span>
								<form id="idForm" action="OOO.action" method="post">
									<input name="s1" value="v1">
									<input name="s2" value="v2">
									<input name="s3" value="v3">
								</form>
							</td>
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
	</table>
</body>
</html>