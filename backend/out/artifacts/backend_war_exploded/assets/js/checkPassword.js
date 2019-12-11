function checkPassword() {
    let password = document.getElementById('inputPassword').value;
    let passwordLengthError = document.getElementById('passwordLengthError');
    let passwordContainUpperCaseLetterError = document.getElementById('passwordContainsUpperCaseLetterError');
    let passwordContainNumberError = document.getElementById('passwordContainsNumberError');
    let cond1 = false;
    let cond2 = false;
    let cond3 = false;
    console.log(password);
    if (password.length < 8) {
        passwordLengthError.style.color = "red";
        cond1 = false;
    } else {
        passwordLengthError.style.color = "green";
        cond1 = true;
    }
    if (password.toString().search(/[A-Z|А-Я]/) === -1) {
        passwordContainUpperCaseLetterError.style.color = "red";
        cond2 = false;
    } else {
        passwordContainUpperCaseLetterError.style.color = "green";
        cond2 = true;
    }
    if (password.toString().search(/\d/) === -1) {
        passwordContainNumberError.style.color = "red";
        cond3 = false;
    } else {
        passwordContainNumberError.style.color = "green";
        cond3 = true;
    }
}