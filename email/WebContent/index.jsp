
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:actionerror />
<s:form action="emails">
	<s:textfield name="emailid" label="TO Email Id"></s:textfield>
	<s:textfield name="subject" label="subject"></s:textfield>
	<s:textarea name="email" label="Message String" cssStyle="width=300"></s:textarea>
	<s:submit value="Send"></s:submit>
</s:form>
