<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../header.html" %>

<p>検索ワードを入力してください。</p>
<form action="search2" method="post">
	<input type="text" name="keyword">
	<input type="submit" value="検索">
</form>

<%@ include file="../footer.html" %>