<#import "parts/common.ftlh" as c>

<@c.page>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title text-uppercase mb-0">Manage Users</h5>
                    </div>
                    <div class="table-responsive">
                        <table class="table no-wrap user-table mb-0">
                            <thead>
                            <tr>
                                <th scope="col" class="border-0 text-uppercase font-medium pl-4">#</th>
                                <th scope="col" class="border-0 text-uppercase font-medium">Name</th>
                                <th scope="col" class="border-0 text-uppercase font-medium">Role</th>
                                <th scope="col" class="border-0 text-uppercase font-medium">Status</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list users as user>
                            <tr>
                                <td class="pl-4">${user.id}</td>
                                <td>
                                    <h5 class="font-medium mb-0">${user.surname!""}  ${user.first_name!""}</h5>
                                    <span class="text-muted">${user.username}</span>
                                </td>
                                <td>
                                    <span class="text-muted"><#list user.roles as role>${role}<#sep>, </#list></span><br>
                                </td>
                                <td>
                                    <h6 class="font-medium mb-0" >${user.active?string("Active", "Deactivate")}</h6>
                                </td>
                                <td>
                                <a href="/user/${user.id}" class="btn btn-dark">Edit</a>
                                </td>
                                <td>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.page>
