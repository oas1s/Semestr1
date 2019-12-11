<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/bootstrap-grid.css">
    <link rel="stylesheet" href="assets/css/bootstrap-reboot.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Staatliches&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <title>project</title>
</head>
<body>
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

<div class="container" style="margin-top: 15px; margin-bottom: 15px; width: 80%">
    <form class="row form" style="background: rgba(0,0,0,0.73); font-weight: bold; color: #d7d7d7"
          action="/createProject" method="get">
        <div class="form-group">
            <div class="row justify-content-between">
                <div class="col-6">
                    <h1 id="projectName" style="color: #fdc330">${aclass}</h1>
                    <div class="form-group row" style="margin-top: 15px">
                        <label for="teacher" class="col-4 col-form-label"
                               style="margin-top: 15px">Преподаватель:</label>
                        <div class="col-8" style="margin-top: 15px">
                            <input type="text" class="form-control" id="teacher" placeholder="${teacher_email}" disabled>
                        </div>
                        <label for="subject" class="col-2 col-form-label" style="margin-top: 15px">Предмет:</label>
                        <div class="col-6" style="margin-top: 15px">
                            <input type="text" class="form-control" id="subject" placeholder="${aclass}"
                                   disabled>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="form-group row" style="margin: 0px">
                        <legend class="col-form-label col-4 pt-0">Статус:</legend>
                        <div class="col-8">
                            <div class="custom-control custom-radio">
                                <input type="radio" id="status" name="customRadio" class="custom-control-input">
                                <label class="custom-control-label" for="status">${status}</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row" style="margin: 0px">
                        <label for="projectType">${type}</label>
                        <select class="form-control form-control-sm" id="projectType" disabled>
                            <option>Домашняя работа</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="row">
                <div class="container-fluid">
                <textarea name="projectDescription" id="projectDescription" type="text" class="form-control"
                          placeholder="${description}" cols="130" disabled></textarea>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="row container">
                <label class="col-5 col-form-label">#{date}</label>
                <div class="col-7" style="margin-top: 10px">
                    <input class="form-control" type="text"  disabled>
                </div>
            </div>
        </div>
        <div class="row">
            <label for="links" class="col-3 col-form-label">Необходимые ссылки:</label>
            <div class="col-9">
                <textarea name="projectDescription" id="links" type="text" class="form-control"
                          placeholder="#{links}" cols="130" rows="1"></textarea>
            </div>
        </div>
    </form>
</div>
<div class="container-fluid form" style="background-color: white; border-top-style: solid; border-radius: 0px;">
    <div class="container" style="margin-top: 10px;">
        <h4>Комментарии</h4>
        <div class="form-group">
            <form action="/project" method="post" class="d-flex d-flex">
                <input type="text" name="text" class="form-control" placeholder="Напишите комментарий"
                       style="margin-right: 10px;">
                <input type="hidden" name="id" value="">
                <button type="submit" class="btn btn-warning" name="send" value="">Отправить
                </button>
            </form>
        </div>
        <div class="card" >
            <div class="row">
                <div class="col" style="margin: 15px">
                    <span><h5>ФИО комментатора</h5></span>
                    <small>
                        дата отправки комментария
                    </small>
                    <div class="col comment-text">
                        <span>содержание комментария</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</div> <!--js-->
</body>
</html>