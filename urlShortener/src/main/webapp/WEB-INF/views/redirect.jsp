
<jsp:include page="../layouts/header.jsp"></jsp:include>
<h1>URL Redirect</h1>
<p>${errorMsg}</p>
<form name="urlRedirect" action="/redirect" method="POST">
		<label>Short url:</label>
		<input type='text' name='url' />
		<label>&nbsp;</label>
		<input type="submit" value="Go to short url" class="btn">
</form>
<jsp:include page="../layouts/footer.jsp"></jsp:include>
