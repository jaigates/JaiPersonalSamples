<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- A hidden input named public_token will be appended to this form
once the user has completed the Link flow. Link will then submit the
form, sending the public_token to your server. -->

<body>
<form id="some-id" method="GET" action="rest/plaid/getAccountDetails"></form>

<script
  src="https://cdn.plaid.com/link/stable/link-initialize.js"
  data-client-name="Amex"
  data-form-id="some-id"
  data-key="81b7db7ca44ef07a30726e2f083891"
  data-product="auth"
  data-env="tartan">
</script>
<br><br><br>
<br>
  <!-- old data-key="de9119f46e78390e838a07fc185499" -->
</body>
</html>