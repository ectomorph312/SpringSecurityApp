<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="form-group row">
        <a href="/todo/add" class="btn btn-dark">Todo add</a>
    </div>
    <#list todoList as todo>
        <div class="card">
            <div class="card-header">
                Todo
            </div>
            <div class="card-body">
                <h5 class="card-title">${todo.title!""}</h5>
                <h6 class="card-title">Status: ${todo.status!""}</h6>
                <p class="card-text">${todo.description!""}</p>
                <h6 class="card-title">Дата создания: ${todo.created!""}</h6>
                <h6 class="card-title">Дата окончания: ${todo.completed!""}</h6>
                <a href="/todo/${todo.id}/edit" class="btn btn-dark">Редактировать</a>
                <a href="/todo/${todo.id}/delete" class="btn btn-dark">Удалить</a>
            </div>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </div>
    <#else>
        No todo
    </#list>
</@c.page>