<#import "parts/common.ftlh" as c>
<@c.page>

    <a class="btn btn-dark" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Todo
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="title" placeholder="Заголовок" />
                </div>
                <div class="form-group">
                    <textarea type="text" class="form-control" name="description" placeholder="Описание"></textarea>
                </div>
                <div class="form-group">
                    <label>Дата оканчание</label>
                    <input type="datetime-local" name="completed" class="form-control">
                </div>
                <div class="form-group">
                    <select class="form-control" name="status" rows="3" >
                        <option value="NEW">новый</option>
                        <option value="PERFORMANCE">на исполнении</option>
                        <option value="DONE">готово</option>
                    </select>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-dark">Добавить</button>
                </div>
            </form>
        </div>
    </div>

</@c.page>