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
	var firstname = document.getElementById("firstname").value;
	var lastname = document.getElementById("lastname").value;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var confirmpassword = document.getElementById("confirmpassword").value;
	var email = document.getElementById("email").value;
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

