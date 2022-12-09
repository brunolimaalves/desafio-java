<%@ include file="includes/head.jsp" %>
<body>
    <jsp:include page="includes/menu.jsp" />
    <div class="container">
        <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Inicio</a></li>
            <li class="breadcrumb-item active" aria-current="page">Projeto</li>
          </ol>
        </nav>
          <form:form method="post" modelAttribute="projeto">
            <form:hidden path="id" />
            <div class="row">
                <div class="col-12 col-md-12">
                    <fieldset class="form-group mb-3">
                        <form:label path="nome">Nome</form:label>
                        <form:input path="nome" type="text" class="form-control" required="required" />
                        <form:errors path="nome" cssClass="text-warning" />
                    </fieldset>
                </div>
            </div>
            <div class="row">
                <div class="col-4  col-md-4  col-sm-12">
                    <fieldset class="form-group mb-3">
                        <form:label path="inicio">Início</form:label>
                        <form:input path="inicio" maxlength="10" type="date" class="form-control" required="required" />
                    </fieldset>
                </div>
                <div class="col-4  col-md-4  col-sm-12">
                    <fieldset class="form-group mb-3">
                        <form:label path="previsaoTermino">Previsão Término</form:label>
                        <form:input path="previsaoTermino" type="date" class="form-control" required="required" />
                    </fieldset>
                </div>
                <div class="col-4  col-md-4 col-sm-12">
                    <fieldset class="form-group mb-3">
                        <form:label path="termino">Término</form:label>
                        <form:input path="termino" type="date" class="form-control" required="required" />
                    </fieldset>
                </div>
            </div>
            <div class="row">
                <div class="col-6 col-md-6">
                    <fieldset class="form-group mb-3">
                        <form:label path="status">Status</form:label>
                        <form:select class="form-select" path="status">
                             <form:option value="" label="--Please Select"/>
                            <form:options items="${statusList}" itemLabel="descricao" />
                        </form:select>
                    </fieldset>
                </div>
                <div class="col-6 col-md-6">
                    <fieldset class="form-group mb-3">
                        <form:label path="classificacao">Classificacao</form:label>
                        <form:select class="form-select" path="classificacao">
                             <form:option value="" label="--Please Select"/>
                            <form:options items="${classificacaoList}" itemLabel="descricao" />
                        </form:select>
                    </fieldset>
                </div>
            </div>
            <div class="row">
                <div class="col-12 col-md-12">
                    <fieldset class="form-group mb-3">
                        <form:label path="idGerente">Gerente</form:label>
                        <form:select class="form-select" path="idGerente">
                             <form:option value="" label="--Please Select"/>
                            <form:options items="${gerentesList}" itemLabel="nome" itemValue="id" />
                        </form:select>
                    </fieldset>
                </div>
            </div>
            <div class="row">
                <div class="col-12 col-md-12">
                    <fieldset class="form-group mb-3">
                        <form:label path="descricao">Descricao</form:label>
                        <form:textarea class="form-control"  path="descricao" />
                    </fieldset>
                </div>
            </div>
            <button type="submit" class="btn btn-success">Save</button>
        </form:form>
    </div>
</body>
<%@ include file="includes/footer.jsp" %>
</html>