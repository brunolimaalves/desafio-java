<%@ include file="includes/head.jsp" %>
<body>
    <jsp:include page="includes/menu.jsp" />
    <div class="container">
        <h2>List Projetos</h2>
        <a href="novo"> Novo Projeto</a>
        <div class="alert alert-primary" role="alert" modelA>
          ${message}
        </div>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Editar</th>
              <th scope="col">#ID</th>
              <th scope="col">Nome</th>
              <th scope="col">Início</th>
              <th scope="col">Classificacao</th>
              <th scope="col">Status</th>
              <th scope="col">Deletar</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${projetosList}" var="projeto">
                <tr>
                  <td><a href="atualiza/${projeto.id}"> Editar</a></td>
                  <td>${projeto.id}</td>
                  <td>${projeto.nome}</td>
                  <td>${projeto.inicio}</td>
                  <td>${projeto.classificacao}</td>
                  <td>${projeto.status}</td>
                  <td>
                    <c:if test = "${projeto.permiteExclusao}">
                        <a href="delete/${projeto.id}"> Deletar</a>
                    </c:if>
                  </td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
</body>
<%@ include file="includes/footer.jsp" %>
</html>