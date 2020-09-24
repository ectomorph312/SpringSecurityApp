<#import "parts/common.ftlh" as c>

<@c.page>

User editor

    <div class="container">
        <!-- edit form column &ndash;&gt;-->
        <div class="col-lg-12 text-lg-center">
            <h2>Editar Perfil</h2>
            <br>
            <br>
        </div>
        <div class="col-lg-8 push-lg-4 personal-info">
            <form action="/user" method="post">
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label">Username</label>
                    <div class="col-lg-9">
                        <input class="form-control" name="username" type="text" value="${user.username}" />
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label">First name</label>
                    <div class="col-lg-9">
                        <input class="form-control" name="name" type="text" value="${user.name!""}" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label">Surname</label>
                    <div class="col-lg-9">
                        <input class="form-control" name="surname" type="text" value="${user.surname!""}" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label">Patronymic</label>
                    <div class="col-lg-9">
                        <input class="form-control" name="patronymic" type="text" value="${user.patronymic!""}" />
                    </div>
                </div>
                <#list roles as role>
                    <div class="form-check form-check-inline mb-l 5">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
                        <label class="form-check-label" for="inlineCheckbox1"></label>
                    </div>
                </#list>
                <div class="form-check">
                    <input class="form-check-input" name="deactivate" type="checkbox" <#if user.isActive()> checked</#if>>
                    <label class="form-check-label" for="defaultCheck1">
                        Active
                    </label>
                </div>

                <input type="hidden" value="${user.id}" name="userId">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
<#--                <div class="form-group row mb-5">-->
<#--                    <label class="col-lg-3 col-form-label form-control-label"></label>-->
<#--                    <button class="btn btn-dark" type="submit">Save Changes</button>-->
<#--                </div>-->
                <div class="form-group row">
                    <label class="col-lg-3 col-form-label form-control-label"></label>
                    <div class="col-lg-9">
                        <input type="reset" class="btn btn-secondary" value="Reset" />
                        <button type="submit" class="btn btn-dark">Save Changes</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <hr />
</form>
</@c.page>

