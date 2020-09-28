<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container">
        <!-- edit form column &ndash;&gt;-->
        <div class="col-lg-12 text-lg-center">
            <h2>Todo Edit</h2>
            <br>
            <br>
        </div>
        <div class="col-lg-8 push-lg-4 personal-info">
            <form action="/todo" method="post">
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label">Заголовок</label>
                    <div class="col-lg-9">
                        <input class="form-control" name="title" type="text" value="${todo.title}" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label">Описание</label>
                    <div class="col-lg-9">
                        <input class="form-control" name="description" type="text" value="${todo.description}" />
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label">Статус</label>
                    <select class="form-control" name="status" rows="3" >
                        <option value="NEW">новый</option>
                        <option value="PERFORMANCE">на исполнении</option>
                        <option value="DONE">готово</option>
                    </select>
                </div>

                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label"></label>
                    <div class="col-lg-9">
                        <input type="reset" class="btn btn-secondary" value="Reset" />
                        <button type="submit" class="btn btn-dark">Save Changes</button>
                    </div>
                </div>
                <input type="hidden" value="${todo.id}" name="todoId">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
            </form>
        </div>
    </div>
</@c.page>