<%@taglib prefix="s" uri="/struts-tags" %>

<s:form cssClass="form-inline">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
  </div>
  <br>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
    <br>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
    <br>
  <div class="form-group" w>
  <label class="col-md-4 control-label" for="username">User Namessss</label>  
  <div class="col-md-4">
  <input id="username" name="username" type="text" placeholder="username" class="form-control input-md">
    
  </div>
</div>
<br>
<br>
<div class="form-group" >
  
  <s:label cssClass="col-md-4 control-label" key="" value="User Name" theme="simple"></s:label>
  <div class="col-md-4">
   <s:textfield cssClass="form-control input-md" theme="simple"></s:textfield> 
  </div>
</div>
<br> <br>
<div class="form-group" >
  
  <s:label cssClass="col-md-4 control-label" key="" value="User Name12" theme="simple"></s:label>
  <div class="col-md-4">
   <s:textfield cssClass="form-control input-md" theme="simple"></s:textfield> 
  </div>
</div>
<br>


<s:div cssClass="form-group" theme="simple">
  
  <s:label cssClass="col-md-4 control-label" key="" value="User Name33" theme="simple"></s:label>
  <s:div cssClass="col-md-4"  theme="simple">
   <s:textfield cssClass="form-control input-md" theme="simple"></s:textfield> 
  </s:div>
</s:div>
 <br>
 
 
 <s:div cssClass="form-group" theme="simple">
  
  <s:label cssClass="col-md-4 control-label" key="" value="User Name454" theme="simple"></s:label>
  <s:div cssClass="col-md-4"  theme="simple">
   <s:textfield cssClass="form-control input-md" theme="simple"></s:textfield> 
  </s:div>
</s:div>
 <br>
 
 
 <s:div cssClass="form-group" theme="simple">
  
  <s:label cssClass="col-md-4 control-label" key="" value="User Name" theme="simple"></s:label>
  <s:div cssClass="col-md-4"  theme="simple">
   <s:textfield cssClass="form-control input-md" theme="simple"></s:textfield> 
  </s:div>
</s:div>
 <br>
 
 
  
    <button type="button" class="btn btn-success">Submit</button>
  </s:form>