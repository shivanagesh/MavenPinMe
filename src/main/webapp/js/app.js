function setLimit() {
    var selected = document.querySelector("#settinglimit").value;
    if (selected === "yes") {
        $("#limit").css("display", "block");
    } else {
        $("#limit").css("display", "none");
    }
}

function checkpsd() {
    var psd = document.getElementById('password').value;
    var cpsd = document.getElementById('confirmpassword').value;
    if (psd !== cpsd) {
        document.getElementById("error").innerHTML = "Confirm Password mismatch";
    }
}

function validateForm() {
    var userName = document.getElementById("userName").value;
    var Password = document.getElementById("Password").value;
    if (((userName == null) || (userName == "")) || ((Password == null) || (Password == ""))) {
        return false;
    }
    return true;
}

function validationSignup() {
    if (((firstname == null) || (firstname == "")) ||
        ((lastname == null) || (lastname == "")) ||
        ((username == null) || (username == "")) ||
        ((password == null) || (password == "")) ||
        ((confirmpassword == null) || (confirmpassword == "")) ||
        ((email == null) || (email == "")) ||
        ((password !== confirmpassword))) {
        return false;
    }
    return true;
}

