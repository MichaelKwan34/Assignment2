var addBtn = document.getElementById("addbtn");
addBtn.addEventListener("click", addStudent);
function addStudent() {
    var newName = document.getElementById("name").value;
    var newHairColor = document.getElementById("haircolor").value;
    var newHeight = document.getElementById("height").value;
    var newWeight = document.getElementById("weight").value;
    var newGpa = document.getElementById("gpa").value;

    if (newName == "") {
        alert("NAME field cannot be EMPTY");
    }

    else if (newHairColor == "") {
        alert("HAIR COLOR field cannot be EMPTY");
    }

    else if (newHeight == "") {
        alert("HEIGHT field cannot be EMPTY");
    }
    else if(parseInt(newHeight) <= 0) {
        alert("HEIGHT cannot be ≤ 0");
    }
    else if(parseInt(newHeight) > 270) {
        alert("HEIGHT max: 270cm (tallest person on Earth)");
    }

    else if (newWeight == "") {
        alert("WEIGHT field cannot be EMPTY");
    }
    else if(parseInt(newWeight) <= 0) {
        alert("WEIGHT cannot be ≤ 0");
    }
    else if(parseInt(newWeight) > 400) {
        alert("WEIGHT max: 400kg (heaviest person on Earth)");
    }

    else if (newGpa == "") {
        alert("GPA field cannot be EMPTY");
    }
    else if (parseFloat(newGpa) < 0 || parseFloat(newGpa) > 4.33) {
        alert("GPA range: [0, 4.33]");
    }   
    else {
        document.getElementById("addStudent").onsubmit = function (event) {
            return true;
        };
    }
}