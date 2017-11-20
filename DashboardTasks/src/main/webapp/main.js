function logado() {
    $.ajax({
        type: 'GET',
        url: 'login.xhtml',
        statusCode: {
            404: function () {
                alert('Página não encontrada');
            },
            500: function () {
                alert('Erro no servidor');
            }
        },
        success: function (dados) {
            window.location.href = "http://localhost:8080/DashboardTasks/faces/login.xhtml";
        }
    });
}
