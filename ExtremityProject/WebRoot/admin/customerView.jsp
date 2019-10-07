<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/tld/jmesa.tld" prefix="jmesa"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'view.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-1.2.2.pack.js" /></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-1.3.min.js" /></script>

		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery.validate.min.js" /></script>
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/jquery-ui.css"
			type="text/css">
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/jmesa.css" type="text/css">

		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-1.8.2.js" /></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-ui.js" /></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jmesa.js" /></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery.jmesa.js" /></script>
			
			<script type="text/javascript">
			
			function getValue()
			{
			var pid=$("#pid").val();
		
		alert(pid);
		}
			</script>
			<script type="text/javascript">
			
			function loadProducts(){
	popUpWithServerData("/ExtremityProject/addCustomer.action", "ADD Customer",450,550);
}
function updateProducts(){
var busId=$("#pid").val();
	alert('pid='+busId);	
alert('update');
	popUpWithServerData("/ExtremityProject/updateProduct.action?product.pid="+$("#pid").val(),"Update Product",450,550);
}

function deleteProducts(){
var busId=$("#pid").val();
	alert('pid='+busId);	
	popUpWithServerData("/ExtremityProject/deleteProduct.action?product.pid="+$("#pid").val(),"Delete Product",450,550);
}

</script>
			<%-- For Poupup Window--%>

<script type="text/javascript">
			function popUpWithServerData(page, pagetitle,height,width) {
				var $dialog = $("<div></div>").html("<iframe style=\"border: 0px; \" src=\"" + page + "\" width=\"100%\" height=\"100%\"></iframe>")
				.dialog({autoOpen: false,
			            height: height,
			            width: width,
			            title:pagetitle,
			            modal: true,
			            });
				$dialog.dialog("open");
		}
	
	</script>
	</head>

	<body>
		<form name="productForm" style="margin-bottom: -34px;">
			<jmesa:tableModel id="tag" items="${list}" maxRows="8"
				exportTypes="csv,excel" maxRowsIncrements="2,4,8"
				stateAttr="restore" var="bean">
				<jmesa:htmlTable width="100%">
					<jmesa:htmlRow>
						<jmesa:htmlColumn property="cid" title="Customer Id">
							<input type="radio" name="productIdRadio" id="productIdRadio"
			onclick="setId(this)"					value="${bean.cid}" />
							<%--
					  set the bankid to radio button--%>

						</jmesa:htmlColumn>
						<jmesa:htmlColumn property="cname" title="Customer Name" />
						<jmesa:htmlColumn property="addr" title="Addr" />

					</jmesa:htmlRow>
				</jmesa:htmlTable>
			</jmesa:tableModel>
			
<input type="hidden" id="pid" name="pid">

<input type="button" onclick="getValue()" value="getRadiovalue">
<input type="button" onclick="loadProducts()" value="Add Customer">
<input type="button" onclick="updateProducts()" value="Update Product">
<input type="button" onclick="deleteProducts()" value="Delete Product">

</form>

		<script type="text/javascript">
            function onInvokeAction(id) {
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '/ExtremityProject/jmessa.action?' + parameterString;
            }
            function setId(id){
            	$("#cid").val(id.value);
            }
        </script>


	</body>
</html>
