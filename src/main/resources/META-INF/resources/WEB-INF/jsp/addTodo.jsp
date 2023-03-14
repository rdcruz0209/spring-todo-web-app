<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">

    <h1>Enter Todo Details</h1>
    <%--@elvariable id="todo" type="com.webapplicationprojects.springboot.todowebapp.todo.Todo"--%>
    <%--            model attribute that will be passed in to showNewTodo and addNewTodo in TodoController class--%>
    <form:form method="post" modelAttribute="todo" autocomplete="off">

        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required" name="description"/>
                <%--                path = "description" maps the error message if there are errors found in the form--%>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" required="required" name="targetDate"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>
        <input type="submit" class="btn btn-success"/>
        <%--                ${errorMessage}--%>
        <%--                errorMessage from model in addNewTodo Post method--%>
    </form:form>
</div>

<%@include file="common/footer.jspf" %>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
    });
</script>