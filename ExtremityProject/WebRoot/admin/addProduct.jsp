<%@taglib uri="/struts-tags" prefix="s"%>  
<script type="text/javascript">

if('<s:property value='navigationFlg'/>'=='success'){	
alert("success");		
		window.parent.location.href='jmessa.action';
}

</script>
<form action="saveProduct">

<s:textfield label="Product Id" name="product.pid"></s:textfield>

<br><br>
<s:textfield label="Product Name" name="product.pname"></s:textfield>

<br>
<br>
<s:textfield label="Product Price" name="product.price"></s:textfield>
<br><br>

<s:submit value="Save" cssStyle="margin-right: 372px;"></s:submit>

</form>