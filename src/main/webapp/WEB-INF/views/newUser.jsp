<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layout/header.jsp" %>
<spring:url var = "action" value='publicAddUser' />
    <f:form modelAttribute="utilisateurForm" method="post" action="${action}">
        <div class="form-group">
            <label>Username</label>
            <f:input cssClass="form-control" required="required" path="username"/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <f:input cssClass="form-control" required="required" path="password"/>
        </div>

        <div class="form-group">
            <label>Role</label>
            <f:select cssClass="form-control"  path="role" items="${roleSelect}" />
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-default" value="S'enregistrer">
        </div>
    </f:form>
<%@include file="/WEB-INF/views/layout/footer.jsp" %>