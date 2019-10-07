<%@taglib uri="/struts-tags" prefix="s"%>  
<script type="text/javascript">

if('<s:property value='navigationFlg'/>'=='success'){	
alert("success");		
		window.parent.location.href='jmessa.action';
}

function doNothing(){
		window.parent.location.href='jmessa.action';
		}
</script>
<form action="deleteProductConfirm">


<s:hidden name="product.pid"></s:hidden>
<br/> Do You Want to Delete
	 <br/><br/><br/>

	 <s:submit value="Delete" theme="simple"></s:submit>
	 <input type="button" onclick="doNothing()" value="Cancel"/>

</form>