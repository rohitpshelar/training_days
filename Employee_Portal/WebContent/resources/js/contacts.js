function go(url)
{
	window.location = url;
}

function newContact()
{
	window.location = "/admin/deleteContact";
}

function editContact()
{
	window.location = "/admin/editContact";
}


function deleteContact(id)
{
	alert(id);
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		var urlName="${pageContext.request.contextPath}/admin/deleteContact?id="+id;
		go(url);
	}
	
}
function editContact()
{
	alert("hello");
	var isOK = confirm("Are you sure to edit?");
	if(isOK)
	{
		var urlName="${pageContext.request.contextPath}/admin/editContact?id="+id;
		go(url);
	}
	
}