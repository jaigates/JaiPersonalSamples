<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- A hidden input named public_token will be appended to this form
once the user has completed the Link flow. Link will then submit the
form, sending the public_token to your server. -->

<body>
	<form id="some-id" method="GET" action="plaid/getAccountDetails"></form>

	<script src="https://cdn.plaid.com/link/stable/link-initialize.js"
		data-client-name="Amex" data-form-id="some-id"
		data-key="c09f4b675fb91eaecd8a5cf667c002" data-product="auth"
		data-env="tartan">
</script>
	<br>
	<br>
	<br>
	<br>

</body>
</html>