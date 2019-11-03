
<%@include file="./header/logginHeader.jsp" %>


<c:if test="${not empty error}">

<div align="center">${error}</div>

</c:if>

<c:if test="${not empty msg}">

<div align="center">${msg}</div>

</c:if>

<div class="row">
        <div class="col-md-12 center login-header">
            <h2>Welcome to Extremity India Technologies Pvt. Ltd</h2>
        </div>
        
    </div>

    <div class="row">
        <div class="well col-md-5 center login-box">
            <div class="alert alert-info">
                Please login with your Username and Password.
            </div>
            <form class="form-horizontal" name="login.action" action="<c:url value='/j_spring_security_check' />" method="post"  role="form">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" id="username"  name="uname" class="form-control" placeholder="Username">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" id="password" name="upass" class="form-control" placeholder="Password">
                    </div>
                    <div class="clearfix"></div>

                  
                    <div class="clearfix"></div>

                    <p class="center col-md-5">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </p>
                </fieldset>
                <input type="hidden" value="${j_spring_security_check}">
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>
</div>
</div>
		    <%@include file="./footer/logFooter.jsp"%>