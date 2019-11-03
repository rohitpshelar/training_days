<%@page import="com.extremity.emp.model.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive">
					<thead>
						<tr>
							<!-- <th>Select Here</th> -->
							<th>Emp Id</th>
							<th>Emp Name</th>
							<th>EmployeesTeam</th>
						</tr>
					</thead>
					<tbody>
					<% List li=(List)request.getAttribute("empList1");
					Iterator itr=li.iterator();
					while(itr.hasNext())
					{
						
						
						Employee e=(Employee)itr.next();
						%>
						<tr>
                        <td class="centre"><%=e.getEmpId() %></td>
						<td class="center"><%=e.getEmpName() %></td>
						<td class="center"><%= e.getTeam().getTeamName()%></td>

						
					</tr>
						
					<%}%>
					
					
					
						<%-- <c:forEach items="${empList1}" var="person">
						
							<tr>
                                <td class="centre">${person.empId}</td>
								<td class="center">${person.empName}</td>
								<td class="center">${person.team.teamName}</td>

								
							</tr>
						</c:forEach> --%>

					</tbody>
				</table>
