<html>
<body>
	<h2>Hello World!</h2>

	<ul>
		<li><a href="WriterServlet">WriterServlet</a></li>
		<li><a href="ForwardToPageServlet">ForwardToPageServlet</a></li>
		<li><a href="ForwardServlet">ForwardServlet</a></li>
		<li><a href="IncludePageServlet">IncludePageServlet</a></li>
		<li><a href="IncludeServlet">IncludeServlet</a></li>
		<li><a href="RediectToPageServlet">RediectToPageServlet</a></li>
		<li><a href="RediectServlet">RediectServlet</a></li>
	</ul>
	<fieldset>
		<legend>Forward</legend>
		<form action="ForwardByParam">
			<button type="submit" name="page" value="WriterServlet">WriterServlet</button>
			<br />
			<button type="submit" name="page" value="ForwardToPageServlet">ForwardToPageServlet</button>
			<br />
			<button type="submit" name="page" value="ForwardServlet">ForwardServlet</button>
			<br />
			<button type="submit" name="page" value="RediectToPageServlet">RediectToPageServlet</button>
			<br />
			<button type="submit" name="page" value="RediectServlet">RediectServlet</button>
			<br />
			<button type="submit" name="page" value="IncludeServlet">IncludeServlet</button>
			<br />
			<button type="submit" name="page" value="IncludePageServlet">IncludePageServlet</button>
		</form>
	</fieldset>

	<fieldset>
		<legend>Redirect</legend>
		<form action="RedirectByParam">
			<button type="submit" name="page" value="WriterServlet">WriterServlet</button>
			<br />
			<button type="submit" name="page" value="ForwardToPageServlet">ForwardToPageServlet</button>
			<br />
			<button type="submit" name="page" value="ForwardServlet">ForwardServlet</button>
			<br />
			<button type="submit" name="page" value="RediectToPageServlet">RediectToPageServlet</button>
			<br />
			<button type="submit" name="page" value="RediectServlet">RediectServlet</button>
			<br />
			<button type="submit" name="page" value="IncludeServlet">IncludeServlet</button>
			<br />
			<button type="submit" name="page" value="IncludePageServlet">IncludePageServlet</button>

		</form>
	</fieldset>

	<jsp:include page="/include/forward.jsp" ></jsp:include>

	<%@ include file="/include/redirect.jsp" %>

	<ul>
		<li><a href="example.jsp">example.jsp</a></li>
		<li><a href="JSTLexample.jsp">JSTLexample.jsp</a></li>
		<li><a href="tagExample.jsp">tagExample.jsp</a></li>
	</ul>
</body>
</html>
