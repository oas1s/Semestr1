<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/bootstrap-grid.css">
    <link rel="stylesheet" href="assets/css/bootstrap-reboot.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Staatliches&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Profile</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body style="background: white;">
<nav class="navbar navbar-expand-lg navbar-dark bg-black shadow" style="z-index: 2;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand logo-font" href="/mainPage">UniProj</a>
        </div>

        <ul class="navbar-nav flex-row ml-md-auto">
            <form class="form-inline row">
                <li class="nav-item">
                    <button class="btn btn-outline-warning mr-3" type="button"
                            onclick="document.location='/createProject'">Создать проект
                    </button>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link navbar-toggler-icon" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    </a>
                    <div class="dropdown-menu dropdown-menu-right my-dropdown" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/profile">Профиль</a>
                        <a class="dropdown-item" href="/projects">Проекты</a>
                        <a class="dropdown-item" href="/notes">Заметки</a>
                        <a class="dropdown-item" href="/chats">Чаты</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/logout">Выход</a>
                    </div>
                </li>
            </form>
        </ul>
    </div>

</nav> <!--navbar for user-->

<div class="container-fluid">
    <div class="row no-gutters">
        <div class="col-3" style="margin-top: 15px">
            <div class="list-group" id="list-tab" role="tablist">
                <a class="list-group-item list-group-item-action active" id="list-profile-list" data-toggle="list"
                   href="#list-profile" role="tab" aria-controls="profile">Профиль</a>
                <a class="list-group-item list-group-item-action" id="list-teachers-list" data-toggle="list"
                   href="#list-teachers" role="tab" aria-controls="teachers">Преподаватели</a>
                <a class="list-group-item list-group-item-action" id="list-students-list" data-toggle="list"
                   href="#list-students" role="tab" aria-controls="students">Студенты</a>
                <a class="list-group-item list-group-item-action" href="/profileSettings" role="tab"
                   aria-controls="settings">Настройки профиля</a>
            </div>
        </div>
        <div class="col-8" style=" margin-left: 20px">
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="list-profile" role="tabpanel"
                     aria-labelledby="list-profile-list">
                    <div class="row" style="margin-right: -90px;">
                        <div class="col-3" style="margin-top: 20px;">
                            <img src="<#if photo?has_content>
                                   ${photo}
                                 <#else>
                                assets/img/200.png
                                 </#if>" class="rounded float-left img-fluid" alt="profile img"
                                 width="200px"
                                 height="200px">
                        </div>
                        <div class="col-8" style="margin-top: 20px; margin-bottom: 20px; margin-right: 10px">
                            <form class="form">
                                <div class="form-row">
                                    <div class="row" style="font-weight: bold;">
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label for="Name"> Name </label>
                                                <input type="text" class="form-control" id="Name" placeholder="${name}" disabled>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label for="Surname">Surname</label>
                                                <input type="text" class="form-control" id="Surname"
                                                       placeholder="${surname}">" disabled>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label for="Lastname">Lastname</label>
                                                <input type="text" class="form-control" id="Lastname"
                                                       placeholder="${lastname}"
                                                       disabled>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-group">
                                                <label for="University">University</label>
                                                <input type="text" class="form-control" id="University"
                                                       placeholder="${university}" disabled>
                                            </div>
                                        </div>
                                    </div>
                                </div> <!--ФИО, институт-->

                                <div class="row" style="font-weight: bold;">
                                    <div class="col">
                                        <div class="form-group">
                                            <label for="Addition">Additional info</label>
                                            <textarea style="height: 124px;" type="text" class="form-control"
                                                      id="Addition" disabled
                                                      placeholder="Additional info"></textarea>
                                        </div>
                                    </div>
                                </div> <!--курс, институт, доп-->

                                <div class="row" style="font-weight: bold;">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="Group">Group</label>
                                            <input type="text" class="form-control" id="Group" placeholder="${group}"
                                                   disabled>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="Role">Role</label>
                                            <input name="role" type="role" disabled class="form-control"
                                                   id="Role"
                                                   placeholder="${role}">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="Role">GetMail</label>
                                            <button id="button1" name="button" type="button" onclick="$.ajax({
                                                                url: '/getuseremail',
                                                                    method: 'get',
                                                                             dataType: 'html',
                                                                            success: function(data){
                                                                         alert(data)
                                                             }
                                                                                })">Take</button>
                                        </div>
                                    </div>
                                </div> <!--емаил, пароль, файл-->
                            </form>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="list-teachers" role="tabpanel" aria-labelledby="list-teachers-list">
                    <h3 style="margin-bottom: 15px; margin-top: 15px">Список преподавателей:</h3>
                    <div class="list-group list-group-flush">
                        <a href="/profile?id1" class="list-group-item list-group-item-action">Преподаватель№1</a>
                        <a href="/profile?id2" class="list-group-item list-group-item-action">Преподаватель№2</a>
                        <a href="/profile?id3" class="list-group-item list-group-item-action">Преподаватель№3</a>
                        <a href="/profile?id4" class="list-group-item list-group-item-action">Преподаватель№4</a>
                        <a href="/profile?id5" class="list-group-item list-group-item-action"><#include "/WEB-INF/surnameTag.ftlh"></a>
                    </div>
                </div>
                <div class="tab-pane fade" id="list-students" role="tabpanel" aria-labelledby="list-students-list">
                    <h3 style="margin-bottom: 15px; margin-top: 15px">Список студентов:</h3>
                    <div class="list-group list-group-flush">
                        <a href="/profile?idst1" class="list-group-item list-group-item-action">Студент№1</a>
                        <a href="/profile?idst2" class="list-group-item list-group-item-action">Студент№2</a>
                        <a href="/profile?idst3" class="list-group-item list-group-item-action">Студент№3</a>
                        <a href="/profile?idst4" class="list-group-item list-group-item-action">Студент№4</a>
                        <a href="/profile?idst5" class="list-group-item list-group-item-action">Студент№5</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div>
    <script>
        $(function () {
            $("#mdb-lightbox-ui").load("mdb-addons/mdb-lightbox-ui.html");
        });
    </script>
    <script>
        $("#button1").click(function() {$.ajax({
            url: '/getuseremail',
            method: 'get',
            dataType: 'html',
            success: function(data){
                alert(data)
            }
        })}
        );
    </script>
</div> <!--js-->
</body>
</html>