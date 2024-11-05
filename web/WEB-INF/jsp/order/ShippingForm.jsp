<%@ include file="../common/top.jsp"%>

<div id="Catalog"><stripes:form
	beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean">

	<table>
		<tr>
			<th colspan=2>Shipping Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input type="text" name="FirstName" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input type="text" name="LastName" /></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input type="text" name="Address1" /></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input type="text" name="Address2" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="City" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" name="State" /></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input type="text" name="Zip" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" name="Country" /></td>
		</tr>


	</table>

	<input type="submit" name="newOrder" value="Continue" />

</stripes:form></div>

<%@ include file="../common/bottom.jsp"%>