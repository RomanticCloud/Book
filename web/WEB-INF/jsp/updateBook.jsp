<%--
  Created by IntelliJ IDEA.
  User: Wang
  Date: 2021/8/1
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍 </title>
    <%--BootStrap--%>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"/>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%--前端传递隐藏域--%>

        <input type="hidden" name="bookId" value="${queryBooks.bookId}">
        <div class="form-group">
            <label for="bookName">书籍名称:</label>
            <input type="text" class="form-control" id="bookName" value="${queryBooks.bookName}" name="bookName" required>
        </div>
        <div class="form-group">
            <label for="bookCounts">书籍数量:</label>
            <input type="text" class="form-control" id="bookCounts" value="${queryBooks.bookCounts}" name="bookCounts" required>
        </div>
        <div class="form-group">
            <label for="detail">书籍详情:</label>
            <input type="text" class="form-control" id="detail" value="${queryBooks.detail}" name="detail" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="提交">
        </div>
    </form>
</div>

</body>
</html>
